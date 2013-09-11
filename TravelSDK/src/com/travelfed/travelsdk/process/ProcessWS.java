package com.travelfed.travelsdk.process;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.travelfed.travelsdk.Logger;
import com.travelfed.travelsdk.bean.Response;
import com.travelfed.travelsdk.bean.Result;

/**
 * Base class for processing WS requests
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
	 *  called from {@link RequestThread}. 
	 *  Parsing make take some time and the user can cancel at this time {@link RequestThread}
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
