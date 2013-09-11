package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

public class PricedCoverage {
	private String CoverageCode;
	private String CoverageChargeAmount;
	private boolean CoverageIncludedInRate;
	private String Coverage;

	public PricedCoverage(JSONObject json) throws JSONException {
		if (json.has("CoverageCode")) {
			this.setCoverageCode(json.getString("CoverageCode"));
		}
		if (json.has("CoverageChargeAmount")) {
			this.setCoverageChargeAmount(json.getString("CoverageChargeAmount"));
		}
		if (json.has("CoverageIncludedInRate")) {
			this.setCoverageIncludedInRate("true".equals(json.getString("CoverageIncludedInRate")));
		}
		if (json.has("Coverage")) {
			this.setCoverage(json.getString("Coverage"));
		}
	}

	/** @param CoverageCode */
	public void setCoverageCode(String CoverageCode) {
		this.CoverageCode = CoverageCode;
	}

	/** @return CoverageCode */
	public String getCoverageCode() {
		return CoverageCode;
	}

	/** @param CoverageChargeAmount */
	public void setCoverageChargeAmount(String CoverageChargeAmount) {
		this.CoverageChargeAmount = CoverageChargeAmount;
	}

	/** @return CoverageChargeAmount */
	public String getCoverageChargeAmount() {
		return CoverageChargeAmount;
	}

	/** @param CoverageIncludedInRate */
	public void setCoverageIncludedInRate(boolean CoverageIncludedInRate) {
		this.CoverageIncludedInRate = CoverageIncludedInRate;
	}

	/** @return CoverageIncludedInRate */
	public boolean isCoverageIncludedInRate() {
		return CoverageIncludedInRate;
	}

	/** @param Coverage */
	public void setCoverage(String Coverage) {
		this.Coverage = Coverage;
	}

	/** @return Coverage */
	public String getCoverage() {
		return Coverage;
	}
}