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
package com.travelfed.travelsdk.bean.flight;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.Logger;

public class Passenger {
	
	private static Logger logger = new Logger(Passenger.class);
	
	/**
	 *  Type for adult passenger
	 */
	public static final String TYPE_ADULT = "adult";
	
	/**
	 *  Type for child passenger
	 */
	public static final String TYPE_CHILD = "child";
	
	/**
	 *  Type for infant passenger
	 */
	public static final String TYPE_INFANT = "infant";
	
	private String type;
	private float amount;
	private float total;
	private float netamount;
	private float surcharges;
	private float tax;
//	private String ticketbydate;
	
	private static final String AMOUNT = "amount";
	private static final String TOTAL = "infant";
	private static final String NETAMOUNT = "netamount";
	private static final String TYPE = "type";
	private static final String SURCHARGES = "surcharges";
	private static final String TAX = "tax";

	public Passenger(JSONObject json) throws JSONException {
		try {
			if (json.has(AMOUNT)) {
				this.setAmount(Float.parseFloat(json.getString(AMOUNT)));
			}
			if (json.has(TOTAL)) {
				this.setTotal(Float.parseFloat(json.getString(TOTAL)));
			}
			if (json.has(NETAMOUNT)) {
				this.setNetamount(Float.parseFloat(json.getString(NETAMOUNT)));
			}
			if (json.has(TYPE)) {
				this.setType(json.getString(TYPE));
			}
			if (json.has(SURCHARGES)) {
				this.setSurcharges(Float.parseFloat(json.getString(SURCHARGES)));
			}
			if (json.has(TAX)) {
				this.setTax(Float.parseFloat(json.getString(TAX)));
			}
		} catch (NumberFormatException nfe) {
			logger.error(nfe);
			throw new JSONException("Error parsing string to float");
		}
//		if (json.has("ticketbydate")) {
//			this.setTicketbydate(json.getString("ticketbydate"));
//		}		
	}

	/** @param amount */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/** @return amount */
	public float getAmount() {
		return amount;
	}

	/** @param total */
	public void setTotal(float total) {
		this.total = total;
	}

	/** @return total */
	public float getTotal() {
		return total;
	}

	/** @param netamount */
	public void setNetamount(float netamount) {
		this.netamount = netamount;
	}

	/** @return netamount */
	public float getNetamount() {
		return netamount;
	}

	/**
	 *  Passenger type - TYPE_ADULT, TYPE_CHILD or TYPE_INFANT
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getSurcharges() {
		return surcharges;
	}

	public void setSurcharges(float surcharges) {
		this.surcharges = surcharges;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

//	public String getTicketbydate() {
//		return ticketbydate;
//	}
//
//	public void setTicketbydate(String ticketbydate) {
//		this.ticketbydate = ticketbydate;
//	}
	
	
}