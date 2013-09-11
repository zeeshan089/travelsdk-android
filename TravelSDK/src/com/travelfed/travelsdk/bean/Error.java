package com.travelfed.travelsdk.bean;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

public class Error {

	public static final String SERVER_ERROR = "SERVER_ERROR";

	private String code = SERVER_ERROR;

	/* constructors */
	public Error() {
	}

	public Error(String code) {
		this.setCode(code);
	}

	public Error(JSONObject json) throws JSONException {
		if (json.has("code")) {
			this.setCode(json.getString("code"));
		}
	}

	/**
	 * @param code
	 *            - Error code
	 */
	public void setCode(String code) {
		if (StringUtil.isNullOrEmpty(code)) {
			code = SERVER_ERROR;
			return;
		}
		this.code = code;
	}

	/** @return error code */
	public String getCode() {
		return code;
	}
}