/*
 * Copyright (c) 2013, Perennial UG & Co.KG.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * - Neither the name of the Perennial UG & Co.KG nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.travelfed.travelsdk.process;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

import com.travelfed.travelsdk.Logger;
import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.http.HttpConnector;

/**
 * Thread for sending htp client request to the web service. Used by the TravelSDK API.
 * 
 */
public class RequestThread extends AsyncTask<Void, Void, Void> {

	private ProcessWS<? extends Object> processWS;
	private String url;
	private static Logger logger = new Logger(RequestThread.class);
	private boolean compressed;
	private Hashtable<String, String> postParams;
	private boolean processingLogin;
	
	/**
	 * 
	 * @param url - http url
	 * @param processWS
	 */
	public RequestThread(String url, ProcessWS<? extends Object> processWS) {
		this(url, processWS, false);
	}
	
	/**
	 * 
	 * @param url - http url
	 * @param processWS
	 * @param compressed - true for receiving gzip-ed response
	 */
	public RequestThread(String url, final ProcessWS<? extends Object> processWS, boolean compressed) {
		this.url = url;
		this.processWS = processWS;
		// clear old response and error if any
		this.processWS.response = null;
		this.processWS.errorCode = null;
		this.compressed = compressed;

	}


	@Override
	protected Void doInBackground(Void... params) {
		processWS.response = null;
		processWS.errorCode = null;
		String serverResult = null;
		try {			
			HashMap<String, String> headers = new HashMap<String, String>();
			if(compressed) {
				if(logger.isDebug()) {
					logger.debug("Request gziped data");
				}
				
				headers.put("Accept-Encoding", "gzip");
				HttpEntity httpEntity = HttpConnector.get(url, headers);
				GZIPInputStream gInputStream = new GZIPInputStream(httpEntity.getContent());
				ByteArrayBuffer byteVector = new ByteArrayBuffer(10000);
				int readed = gInputStream.read();
				while (readed != -1) {
					byteVector.append(readed);
					readed = gInputStream.read();
				}
				
				try {
					gInputStream.close();
				} catch (IOException e) {
					logger.error(e, "Error closing byteArrayInputStream");
				}
				serverResult = new String(byteVector.toByteArray(), "UTF-8");
			} else {
				if(postParams == null) {
					serverResult = EntityUtils.toString(HttpConnector.get(url, headers));
				} else {
					serverResult = EntityUtils.toString(HttpConnector.post(url, postParams, null));
				}
			}
			
			if(logger.isDebug()) {
				String debugResponse = serverResult;
				logger.debug(debugResponse);
			}
			processWS.parseResponse(serverResult);
		} catch (Exception e) {
			logger.error(e);
			if(e instanceof HttpException) {
				processWS.errorCode = ErrorCodes.ERROR_HTTP_CONNECTION;
			} else {
				processWS.errorCode = ErrorCodes.ERROR_RESPONSE; 
			}
		} 
		
		if(processWS.errorCode != null) {
			logger.error("Error on requesting: " + url);
			if(processWS.errorCode.equals("TOKEN_EXPIRED")) {
				processingLogin = true;
				// login and run again
				ProcessLogin processLogin = new ProcessLogin() {
					public void onComplete() {
						if (TravelSDK.INSTANCE.getLoginResult() != null) {
							int indexOf = url.indexOf("&access_token=");
							if (indexOf != -1) {
								int endIndexOf = url.indexOf('&', indexOf + 12);
								StringBuffer stringBuffer = new StringBuffer(url.substring(0, indexOf));
								stringBuffer.append("&access_token=").append(
										TravelSDK.INSTANCE.getLoginResult().getAccessToken());
								stringBuffer.append(RequestThread.this.url.substring(endIndexOf));
								RequestThread.this.url = stringBuffer.toString();
							} else {
								// this case is not possible
								logger.error("TOKEN_EXPIRED error but no acces_token in url");
								RequestThread.this.url = RequestThread.this.url + "&access_token=" + TravelSDK.INSTANCE.getLoginResult().getAccessToken();
							}		
						}
						processingLogin = false;
					}
				};
				TravelSDK.INSTANCE.login(processLogin);
				// wait task to finish
				while(processingLogin) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// skip
					}
				}
				if (TravelSDK.INSTANCE.getLoginResult() != null) {
					logger.debug("Received new access token. Will request again");
					doInBackground(params);
				}
			}
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		processWS.onComplete();
	}
	

	public void setPostParams(Hashtable<String, String> postParams) {
		this.postParams = postParams;
	}
}
