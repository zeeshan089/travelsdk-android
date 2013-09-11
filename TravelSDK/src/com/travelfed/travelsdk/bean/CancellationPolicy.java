package com.travelfed.travelsdk.bean;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

public class CancellationPolicy {

	private Date releaseDate;
//	private String feeCurrency;
//	private float feeValue;
	private String fee;
	
	private static final String RELEASE_DATE = "ReleaseDate";
//	private static final String CANCELLATION_FEE_CURRENCY = "CancellationFeeCurrency";
	private static final String CANCELLATION_FEE = "CancellationFee";
	
	public CancellationPolicy(JSONObject json) throws JSONException {
		if(json.has(RELEASE_DATE)) {
			setReleaseDate(StringUtil.parseDate(json.getString(RELEASE_DATE)));
		}
//		setFeeCurrency(json.optString(CANCELLATION_FEE_CURRENCY));
//		if(json.has(CANCELLATION_FEE_VALUE)) {
//			setFeeValue(Float.parseFloat(json.getString(CANCELLATION_FEE_VALUE)));
//		}
		setFee(json.optString(CANCELLATION_FEE));
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	
	
	
}
