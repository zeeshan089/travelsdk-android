package com.travelfed.travelsdk.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchListResult extends Result {

	private int limit;
	private int total;
	private String session;
	private int offset;
	
	public SearchListResult(JSONObject json) throws JSONException {
		super(json);
		if (json.has("limit")) {
			this.setLimit(json.getInt("limit"));
		}
		if (json.has("total")) {
			this.setTotal(json.getInt("total"));
		}
		if (json.has("session")) {
			this.setSession(json.getString("session"));
		}
		if (json.has("offset")) {
			this.setOffset(json.getInt("offset"));
		}
	}
	
	/** @param session */
	public void setSession(String session) {
		this.session = session;
	}

	/** @return session */
	public String getSession() {
		return session;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	

}
