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

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

/**
 *  Rentacar booking parameter.
 */
public class BookingParameter {

	private Date pickUpDate;
	private Date returnDate;
	private String pickUpLocationCode;
	private String returnLocationCode;

	public BookingParameter(JSONObject json) throws JSONException {
		if(json.has("PickUpDateTime")) {
			this.setPickUpDate(StringUtil.parseDate(json.getString("PickUpDateTime")));
		}
		if(json.has("ReturnDateTime")) {
			this.setReturnDate(StringUtil.parseDate(json.getString("ReturnDateTime")));
		}
		if(json.has("PickUpLocationCode")) {
			this.setPickUpLocationCode(json.getString("PickUpLocationCode"));
		}
		if(json.has("ReturnLocationCode")) {
			this.setReturnLocationCode(json.getString("ReturnLocationCode"));
		}
	}
	
	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getPickUpLocationCode() {
		return pickUpLocationCode;
	}

	public void setPickUpLocationCode(String pickUpLocationCode) {
		this.pickUpLocationCode = pickUpLocationCode;
	}

	public String getReturnLocationCode() {
		return returnLocationCode;
	}

	public void setReturnLocationCode(String returnLocationCode) {
		this.returnLocationCode = returnLocationCode;
	}
	
}
