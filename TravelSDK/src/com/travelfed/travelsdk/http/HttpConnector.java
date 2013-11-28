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
package com.travelfed.travelsdk.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.util.Log;

import com.travelfed.travelsdk.Logger;

public class HttpConnector {
	
	private static Logger logger = new Logger(HttpConnector.class);
	
	public static HttpEntity get(String url, HashMap<String, String> headers) throws HttpException {
		HttpEntity resEntityGet = null;
		try {
			logger.debug("GET URL: " + url);
			
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			if(headers != null) {
				Set<String> headersSet = headers.keySet();
				for (String key : headersSet) {
					get.setHeader(key, headers.get(key));
				}
			}
			
			HttpResponse responseGet = client.execute(get);
			resEntityGet = responseGet.getEntity();
		} catch (Exception e) {
			Log.e("GET RESPONSE", e.getMessage(), e);
			throw new HttpException(e.getMessage());
		} 
		
		return resEntityGet;
	}

	public static HttpEntity post(String url, Hashtable<String, String> params, HashMap<String, String> headers) throws HttpException {
		HttpEntity resEntityPost = null;
		try {
			logger.debug("POST URL: " + url);
			
			ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
			if(headers != null) {
				Set<String> headersSet = headers.keySet();
				for (String key : headersSet) {
					nameValuePairs.add(new BasicNameValuePair(key, headers.get(key)));
				}
			}
			
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url);
			UrlEncodedFormEntity ent = new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8);
			post.setEntity(ent);
			
			// Set Params
			ArrayList<BasicNameValuePair> paramsArrayList = new ArrayList<BasicNameValuePair>();
			Set<String> keys = params.keySet();
			Iterator<String> iterator = keys.iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				paramsArrayList.add(new BasicNameValuePair(key, params.get(key)));
			}
			post.setEntity(new UrlEncodedFormEntity(paramsArrayList));
			
			if(headers != null) {
				Set<String> headersSet = headers.keySet();
				for (String key : headersSet) {
					post.setHeader(key, headers.get(key));
				}
			}
			
			HttpResponse responsePOST = client.execute(post);
			resEntityPost = responsePOST.getEntity();
		} catch (Exception e) {
			Log.e("POST RESPONSE", e.getMessage(), e);
			throw new HttpException(e.getMessage());
		} 
		
		return resEntityPost;
	}
}
