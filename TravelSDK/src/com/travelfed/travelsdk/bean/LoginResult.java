package com.travelfed.travelsdk.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginResult extends Result {

	private String accessToken;
	private long expire;
	private int lifeTime;

	private final static String ACCESS_TOKEN = "access_token";
	private final static String EXPIRE = "expire";
	private final static String LIFETIME = "lifetime";
	
	public LoginResult() throws JSONException {
		super(new JSONObject());
		accessToken = "1";
	}
	
	public LoginResult(JSONObject json) throws JSONException {
		super(json);
		this.setAccessToken(json.getString(ACCESS_TOKEN));
		
		if (json.has(LIFETIME) && ! json.isNull(LIFETIME)) {
			this.setLifeTime(json.getInt(LIFETIME));
		}
		if (json.has(EXPIRE) && ! json.isNull(EXPIRE)) {
			this.setExpire(json.getLong(EXPIRE));
		}
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpire() {
		return expire;
	}

	public void setExpire(long expire) {
		this.expire = expire;
	}

	public int getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(int lifeTime) {
		this.lifeTime = lifeTime;
	}

}
