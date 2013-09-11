package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

public class PricedEquip {
	private String Amount;
	private String CurrencyCode;
	private String IncludedInEstTotalInd;
	private String Description;
	private String EquipType;

	/* constructors */
	public PricedEquip() {
	}

	public PricedEquip(String Amount, String CurrencyCode, String IncludedInEstTotalInd, String Description,
			String EquipType) {
		this.setAmount(Amount);
		this.setCurrencyCode(CurrencyCode);
		this.setIncludedInEstTotalInd(IncludedInEstTotalInd);
		this.setDescription(Description);
		this.setEquipType(EquipType);
	}

	public PricedEquip(JSONObject json) throws JSONException {
		if (json.has("Amount")) {
			this.setAmount(json.getString("Amount"));
		}
		if (json.has("CurrencyCode")) {
			this.setCurrencyCode(json.getString("CurrencyCode"));
		}
		if (json.has("IncludedInEstTotalInd")) {
			this.setIncludedInEstTotalInd(json.getString("IncludedInEstTotalInd"));
		}
		if (json.has("Description")) {
			this.setDescription(json.getString("Description"));
		}
		if (json.has("EquipType")) {
			this.setEquipType(json.getString("EquipType"));
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

	/** @param Description */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/** @return Description */
	public String getDescription() {
		return Description;
	}

	/** @param EquipType */
	public void setEquipType(String EquipType) {
		this.EquipType = EquipType;
	}

	/** @return EquipType */
	public String getEquipType() {
		return EquipType;
	}
}