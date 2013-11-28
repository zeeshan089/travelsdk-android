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
 *  Vehicle 
 */
public class Vehicle {
	private String type;
	private String typename;
	private String currency;
	private String VendorCarType;
	private String referenceid;
	private String Code;
	private String FuelType;
	private String PassengerQuantity;
	private String modelname;
	private String picture;
	private String CodeContext;
	private String modelcode;
	private String TransmissionType;
	private String clas;
	private String DriveType;
	private String RateDistance;
	private String status;
	private String AirConditionInd;
	private String referencetype;
	private String BaggageQuantity;
	private String vendor;
	private String classname;
	private String totalprice;

	public Vehicle(JSONObject json) throws JSONException {
		if (json.has("type")) {
			this.setType(json.getString("type"));
		}
		if (json.has("typename")) {
			this.setTypename(json.getString("typename"));
		}
		if (json.has("currency")) {
			this.setCurrency(json.getString("currency"));
		}
		if (json.has("VendorCarType")) {
			this.setVendorCarType(json.getString("VendorCarType"));
		}
		if (json.has("referenceid")) {
			this.setReferenceid(json.getString("referenceid"));
		}
		if (json.has("Code")) {
			this.setCode(json.getString("Code"));
		}
		if (json.has("FuelType")) {
			this.setFuelType(json.getString("FuelType"));
		}
		if (json.has("PassengerQuantity")) {
			this.setPassengerQuantity(json.getString("PassengerQuantity"));
		}
		if (json.has("modelname")) {
			this.setModelname(json.getString("modelname"));
		}
		if (json.has("picture")) {
			this.setPicture(json.getString("picture"));
		}
		if (json.has("CodeContext")) {
			this.setCodeContext(json.getString("CodeContext"));
		}
		if (json.has("modelcode")) {
			this.setModelcode(json.getString("modelcode"));
		}
		if (json.has("TransmissionType")) {
			this.setTransmissionType(json.getString("TransmissionType"));
		}
		if (json.has("class")) {
			this.setClas(json.getString("class"));
		}
		if (json.has("DriveType")) {
			this.setDriveType(json.getString("DriveType"));
		}
		if (json.has("RateDistance")) {
			this.setRateDistance(json.getString("RateDistance"));
		}
		if (json.has("status")) {
			this.setStatus(json.getString("status"));
		}
		if (json.has("AirConditionInd")) {
			this.setAirConditionInd(json.getString("AirConditionInd"));
		}
		if (json.has("referencetype")) {
			this.setReferencetype(json.getString("referencetype"));
		}
		if (json.has("BaggageQuantity")) {
			this.setBaggageQuantity(json.getString("BaggageQuantity"));
		}
		if (json.has("vendor")) {
			this.setVendor(json.getString("vendor"));
		}
		if (json.has("classname")) {
			this.setClassname(json.getString("classname"));
		}
		if (json.has("totalprice")) {
			this.setTotalprice(json.getString("totalprice"));
		}
	}

	/** @param type */
	public void setType(String type) {
		this.type = type;
	}

	/** @return type */
	public String getType() {
		return type;
	}

	/** @param typename */
	public void setTypename(String typename) {
		this.typename = typename;
	}

	/** @return typename */
	public String getTypename() {
		return typename;
	}

	/** @param currency */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/** @return currency */
	public String getCurrency() {
		return currency;
	}

	/** @param VendorCarType */
	public void setVendorCarType(String VendorCarType) {
		this.VendorCarType = VendorCarType;
	}

	/** @return VendorCarType */
	public String getVendorCarType() {
		return VendorCarType;
	}

	/** @param referenceid */
	public void setReferenceid(String referenceid) {
		this.referenceid = referenceid;
	}

	/** @return referenceid */
	public String getReferenceid() {
		return referenceid;
	}

	/** @param Code */
	public void setCode(String Code) {
		this.Code = Code;
	}

	/** @return Code */
	public String getCode() {
		return Code;
	}

	/** @param FuelType */
	public void setFuelType(String FuelType) {
		this.FuelType = FuelType;
	}

	/** @return FuelType */
	public String getFuelType() {
		return FuelType;
	}

	/** @param PassengerQuantity */
	public void setPassengerQuantity(String PassengerQuantity) {
		this.PassengerQuantity = PassengerQuantity;
	}

	/** @return PassengerQuantity */
	public String getPassengerQuantity() {
		return PassengerQuantity;
	}

	/** @param modelname */
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	/** @return modelname */
	public String getModelname() {
		return modelname;
	}

	/** @param picture */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/** @return picture */
	public String getPicture() {
		return picture;
	}

	/** @param CodeContext */
	public void setCodeContext(String CodeContext) {
		this.CodeContext = CodeContext;
	}

	/** @return CodeContext */
	public String getCodeContext() {
		return CodeContext;
	}

	/** @param modelcode */
	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}

	/** @return modelcode */
	public String getModelcode() {
		return modelcode;
	}

	/** @param TransmissionType */
	public void setTransmissionType(String TransmissionType) {
		this.TransmissionType = TransmissionType;
	}

	/** @return TransmissionType */
	public String getTransmissionType() {
		return TransmissionType;
	}

	/** @param clas */
	public void setClas(String clas) {
		this.clas = clas;
	}

	/** @return clas */
	public String getClas() {
		return clas;
	}

	/** @param DriveType */
	public void setDriveType(String DriveType) {
		this.DriveType = DriveType;
	}

	/** @return DriveType */
	public String getDriveType() {
		return DriveType;
	}

	/** @param RateDistance */
	public void setRateDistance(String RateDistance) {
		this.RateDistance = RateDistance;
	}

	/** @return RateDistance */
	public String getRateDistance() {
		return RateDistance;
	}

	/** @param status */
	public void setStatus(String status) {
		this.status = status;
	}

	/** @return status */
	public String getStatus() {
		return status;
	}

	/** @param AirConditionInd */
	public void setAirConditionInd(String AirConditionInd) {
		this.AirConditionInd = AirConditionInd;
	}

	/** @return AirConditionInd */
	public String getAirConditionInd() {
		return AirConditionInd;
	}

	/** @param referencetype */
	public void setReferencetype(String referencetype) {
		this.referencetype = referencetype;
	}

	/** @return referencetype */
	public String getReferencetype() {
		return referencetype;
	}

	/** @param BaggageQuantity */
	public void setBaggageQuantity(String BaggageQuantity) {
		this.BaggageQuantity = BaggageQuantity;
	}

	/** @return BaggageQuantity */
	public String getBaggageQuantity() {
		return BaggageQuantity;
	}

	/** @param vendor */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/** @return vendor */
	public String getVendor() {
		return vendor;
	}

	/** @param classname */
	public void setClassname(String classname) {
		this.classname = classname;
	}

	/** @return classname */
	public String getClassname() {
		return classname;
	}

	/** @param totalprice */
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	/** @return totalprice */
	public String getTotalprice() {
		return totalprice;
	}
}