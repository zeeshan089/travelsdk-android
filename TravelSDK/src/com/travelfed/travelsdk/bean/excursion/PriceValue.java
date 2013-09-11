package com.travelfed.travelsdk.bean.excursion;

import org.json.JSONException;
import org.json.JSONObject;

public class PriceValue {
	private String totalPrice;
	private String infantPrice;
	private String childPrice;
	private String adultPrice;
	private String unitPrice;

	public PriceValue(JSONObject json) throws JSONException {
		if (json.has("totalPrice")) {
			this.setTotalPrice(json.getString("totalPrice"));
		}
		if (json.has("infantPrice")) {
			this.setInfantPrice(json.getString("infantPrice"));
		}
		if (json.has("childPrice")) {
			this.setChildPrice(json.getString("childPrice"));
		}
		if (json.has("adultPrice")) {
			this.setAdultPrice(json.getString("adultPrice"));
		}
		if (json.has("unitPrice")) {
			this.setUnitPrice(json.getString("unitPrice"));
		}
	}

	/** @param totalPrice */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	/** @return totalPrice */
	public String getTotalPrice() {
		return totalPrice;
	}

	/** @param infantPrice */
	public void setInfantPrice(String infantPrice) {
		this.infantPrice = infantPrice;
	}

	/** @return infantPrice */
	public String getInfantPrice() {
		return infantPrice;
	}

	/** @param childPrice */
	public void setChildPrice(String childPrice) {
		this.childPrice = childPrice;
	}

	/** @return childPrice */
	public String getChildPrice() {
		return childPrice;
	}

	/** @param adultPrice */
	public void setAdultPrice(String adultPrice) {
		this.adultPrice = adultPrice;
	}

	/** @return adultPrice */
	public String getAdultPrice() {
		return adultPrice;
	}

	/** @param unitPrice */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/** @return unitPrice */
	public String getUnitPrice() {
		return unitPrice;
	}
}