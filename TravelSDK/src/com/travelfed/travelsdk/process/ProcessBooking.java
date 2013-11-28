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
package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.basket.Basket;
import com.travelfed.travelsdk.basket.PersonInfo;
import com.travelfed.travelsdk.bean.BookingResult;

/**
 * Process booking.
 *  Documentation http://wiki.travelsdk.com/index.php?title=Booking_service
 * 
 */
public abstract class ProcessBooking extends ProcessWS<BookingResult> {
	
	private PersonInfo customerInfo;
	private String packageId;
	private boolean onRequest = true; // current mobile api version supports only onRequest
	
	public ProcessBooking(PersonInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	void parseResponse(String serverResponse) {
		Basket.removeAll();
		super.parseResponse(serverResponse);
	}

	/**
	 *  Customer information
	 */
	public PersonInfo getCustomerInfo() {
		return customerInfo;
	}
	
	/**
	 *  Customer information
	 */
	public void setCustomerInfo(PersonInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * It is generated value <b>agency_id|0|current_time_ms</b>
	 * 
	 * @return package id
	 */
	public String getPackageId() {
		if(packageId == null) {
			packageId = generatePackageId();
		}
		return packageId;
	}

	/**
	 * Generate unique package id. Used by the TSDK API.
	 * 
	 * @return generated package id
	 */
	public static String generatePackageId() {
		StringBuffer buffer = new StringBuffer();
		
		String unique = TravelSDK.INSTANCE.getLoginResult().getAccessToken();
		unique = unique.substring(unique.length() - 5, unique.length());
		
		buffer.append(TravelSDK.INSTANCE.getAgencyInfoResult().getAgencyId()).append("|")
				.
		append("and").append(unique).append("|").
		append(System.currentTimeMillis());
		return buffer.toString();
	}

	public void setPackageId(String pakcageId) {
		this.packageId = pakcageId;
	}

	public boolean isOnRequest() {
		return onRequest;
	}

}
