package com.travelfed.travelsdk.bean.flight;

import org.json.JSONException;
import org.json.JSONObject;

public class Origin {
	private String name;
	private String tlc;

	/* constructors */
	public Origin() {
	}

	public Origin(String name, String tlc) {
		this.setName(name);
		this.setTlc(tlc);
	}

	public Origin(JSONObject json) throws JSONException {
		if (json.has("name")) {
			this.setName(json.getString("name"));
		}
		if (json.has("tlc")) {
			this.setTlc(json.getString("tlc"));
		}
	}

	/** @param name */
	public void setName(String name) {
		this.name = name;
	}

	/** @return name */
	public String getName() {
		return name;
	}

	/** @param tlc */
	public void setTlc(String tlc) {
		this.tlc = tlc;
	}

	/** @return tlc */
	public String getTlc() {
		return tlc;
	}
}