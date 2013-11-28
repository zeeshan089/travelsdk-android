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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.Booking;

/**
 *  Rentacar booking from booking list result.
 *
 *  @see BookingListResult
 */
public class RentacarBooking extends Booking {

	private Rentacar rentalcar;
	private BookingParameter bookingParameter;

	public RentacarBooking(JSONObject json) throws JSONException {
		super(json);
		if (json.has(REQUEST)) {
			try {
				JSONArray requestArray = json.getJSONArray(REQUEST);
				JSONObject request = requestArray.getJSONObject(0);
				setRentalcar(new Rentacar(null, request));
				if(request.has("SessionVars")) {
					JSONObject sessionVars = request.getJSONObject("SessionVars");
					if(sessionVars.has("BookingParameter")) {
						this.setBookingParameter(new BookingParameter(sessionVars.getJSONObject("BookingParameter")));
					}
				} else if(request.has("BookingParameter")) {
					this.setBookingParameter(new BookingParameter(request.getJSONObject("BookingParameter")));
				}
			} catch (Exception e) {
				logger.error(e, "rentalcar will be null");
			}			
		}
	}

	/**
	 *  Booked rentacar
	 */
	public Rentacar getRentalcar() {
		return rentalcar;
	}

	public void setRentalcar(Rentacar rentalcar) {
		this.rentalcar = rentalcar;
	}

	public BookingParameter getBookingParameter() {
		return bookingParameter;
	}

	public void setBookingParameter(BookingParameter bookingParameter) {
		this.bookingParameter = bookingParameter;
	}

}
