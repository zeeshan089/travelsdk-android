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
package com.travelfed.travelsdk.basket;

import com.travelfed.travelsdk.bean.VerifyResult;
import com.travelfed.travelsdk.bean.hotel.HotelFare;

/**
 * Stores hotel fare record and verify result to add it into the basket.
 */
public class HotelBasketItem extends BasketItem {

	private HotelFare hotelFare;
	
	/**
	 * Construct HotelBasketItem with hotel fare and verify result
	 * 
	 * @param hotelFare Hotel fare record from the search result
	 * @param verifyResult Verify result for the given hotel fare record
	 */
	public HotelBasketItem(HotelFare hotelFare, VerifyResult verifyResult) {
		super(hotelFare.getHotelsFaresResult().getSession(), verifyResult);
		this.hotelFare = hotelFare;
	}

	public HotelFare getHotelFare() {
		return hotelFare;
	}

	protected String getRecordId() {
		return hotelFare.getId();
	}

	public long getTotal() {
		return (long)(Float.parseFloat(hotelFare.getTotalPrice()) * 100);
	}

	public String getCurrency() {
		return hotelFare.getCurrency();
	}

	public VerifyResult getVerifyResult() {
		return verifyResult;
	}
	
}
