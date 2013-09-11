package com.travelfed.travelsdk.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Base class for the response result
 * 
 * @author krumstoilov
 */
public class Result {
	
	private JSONObject json;

	public Result(JSONObject json) throws JSONException {
		this.json = json;
	}

	public JSONObject getJson() {
		return json;
	}
	

}