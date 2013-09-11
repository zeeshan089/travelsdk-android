package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

public class Fee {
	private String Amount;
	private String CurrencyCode;
	private String IncludedInEstTotalInd;
	private String IncludedInRate;
	private String Description;
	private String TaxInclusive;

	public Fee(JSONObject json) throws JSONException {
		if (json.has("Amount")) {
			this.setAmount(json.getString("Amount"));
		}
		if (json.has("CurrencyCode")) {
			this.setCurrencyCode(json.getString("CurrencyCode"));
		}
		if (json.has("IncludedInEstTotalInd")) {
			this.setIncludedInEstTotalInd(json.getString("IncludedInEstTotalInd"));
		}
		if (json.has("IncludedInRate")) {
			this.setIncludedInRate(json.getString("IncludedInRate"));
		}
		if (json.has("Description")) {
			this.setDescription(json.getString("Description"));
		}
		if (json.has("TaxInclusive")) {
			this.setTaxInclusive(json.getString("TaxInclusive"));
		}
	}

	/** @param Amount */
	public void setAmount(String Amount) {
		this.Amount = Amount;
	}

	/** @return Amount */
	public String getAmount() {
		return Amount;
	}

	/** @param CurrencyCode */
	public void setCurrencyCode(String CurrencyCode) {
		this.CurrencyCode = CurrencyCode;
	}

	/** @return CurrencyCode */
	public String getCurrencyCode() {
		return CurrencyCode;
	}

	/** @param IncludedInEstTotalInd */
	public void setIncludedInEstTotalInd(String IncludedInEstTotalInd) {
		this.IncludedInEstTotalInd = IncludedInEstTotalInd;
	}

	/** @return IncludedInEstTotalInd */
	public String getIncludedInEstTotalInd() {
		return IncludedInEstTotalInd;
	}

	/** @param IncludedInRate */
	public void setIncludedInRate(String IncludedInRate) {
		this.IncludedInRate = IncludedInRate;
	}

	/** @return IncludedInRate */
	public String getIncludedInRate() {
		return IncludedInRate;
	}

	/** @param Description */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/** @return Description */
	public String getDescription() {
		return Description;
	}

	/** @param TaxInclusive */
	public void setTaxInclusive(String TaxInclusive) {
		this.TaxInclusive = TaxInclusive;
	}

	/** @return TaxInclusive */
	public String getTaxInclusive() {
		return TaxInclusive;
	}
}