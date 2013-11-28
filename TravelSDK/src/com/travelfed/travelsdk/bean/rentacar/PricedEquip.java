/*
 * Copyright (c) 2013, Perennial UG & Co.KG.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * - Neither the name of the Perennial UG & Co.KG nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *  Not documented.
 */
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