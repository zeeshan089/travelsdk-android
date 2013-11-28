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

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.travelfed.travelsdk.Logger;
import com.travelfed.travelsdk.bean.Response;
import com.travelfed.travelsdk.bean.Result;

/**
 * Base class for processing WS requests. Used by the TSDK API as base class for all Process WS classes.
 */
public abstract class ProcessWS<T extends Result> {

	protected Logger logger = new Logger(ProcessWS.class);
	
	/**
	 * result String from server request.
	 */
	protected Response response;

	/**
	 * Error code. It is null if there isn't an error.
	 * 
	 * @see ErrorCodes
	 */
	protected String errorCode;

	/**
	 * 
	 * @return Error code string or null if there isn't an error.
	 * 
	 * @see ErrorCodes
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Called by the API. You must implement this method to get the results. 
	 * In your code check for errors first using getErrorCode() method.
	 */
	public abstract void onComplete();
	
	/**
	 * 
	 * @return The result object
	 */
	@SuppressWarnings("unchecked")
	public T getResult() {
		return (T) response.getResult();
	}
	
	/**
	 *  Parses server response json string.
	 *  Called from {@link RequestThread}.
	 *  
	 * @param serverResponse response json string from server
	 */
	void parseResponse(String serverResponse) {
		errorCode = null;
		response = null;
		try {
			if (logger.isDebug()) {
				logger.debug("Start parsing");
			}			
			JSONTokener tokener = new JSONTokener(serverResponse);
			JSONObject resultObject = new JSONObject(tokener);
			if (logger.isDebug()) {
				logger.debug("Result json created");
			}
			response = new Response(resultObject, this);
			if (logger.isDebug()) {
				logger.debug("End parsing");
			}
			// Check for errors
			if (!response.isSuccess()) {
				logger.error(response.getError().getCode());
				errorCode = response.getError().getCode();
			}	
		} catch (JSONException je) {
			logger.error(je);
			if (logger.isDebug()) {
				logger.error(serverResponse);
			}
			errorCode = ErrorCodes.ERROR_RESPONSE;
		}
	}	
	
}
