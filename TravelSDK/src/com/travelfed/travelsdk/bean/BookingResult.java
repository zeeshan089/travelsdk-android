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
package com.travelfed.travelsdk.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.excursion.Excursion;
import com.travelfed.travelsdk.bean.flight.FlightFare;
import com.travelfed.travelsdk.bean.hotel.HotelFare;
import com.travelfed.travelsdk.bean.rentacar.Rentacar;

/**
 * Result with successful and failed bookings of TravelSDK.INSTANCE.book request
 */
public class BookingResult extends Result {

	private String packageId;
	private String resultStatus;
	private float totalPrice;
	private String currency;
	private short bookingStatus;
	private String supplierBookingStatus;
	private float serviceFeee;
	private List<Object> successful = new ArrayList<Object>();
	private List<Object> failed = new ArrayList<Object>();
	
	public BookingResult(JSONObject json) throws JSONException  {
		super(json);
		setPackageId(json.getString("package_id"));
		if (json.has("result")) {
			setResultStatus(json.getJSONObject("result").getString("STATUS"));
		}
		setTotalPrice(Float.parseFloat(json.getString("totalprice")));
		setCurrency(json.getString("totalprice_currency"));
		setBookingStatus((short) json.getInt("bookingstatus"));
		setSupplierBookingStatus(json.getString("supplierbookingstatus"));
		try {
			setServiceFeee(Float.parseFloat(json.getString("service_fee")));
		} catch (Exception e) {
			// skip
		}
		if (json.has("failed")) {
			addDataElements(failed, json.getJSONArray("failed"));
		}
		if (json.has("successful")) {
			addDataElements(successful, json.getJSONArray("successful"));
		}
	}

	private void addDataElements(List<Object> list, JSONArray jsonArray) throws JSONException {
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jObject = jsonArray.getJSONObject(i);
			String type = jObject.getString("type");
			if (type == "hotel") {
				HotelFare hotelFare = new HotelFare(null, jObject.getJSONObject("data"));
				list.add(hotelFare);
			} else if (type == "flight") {
				FlightFare fare = new FlightFare(null, jObject.getJSONObject("data"));
				list.add(fare);
			} else if (type == "rentacar") {
				Rentacar rentalcar = new Rentacar(null, jObject.getJSONObject("data"));
				list.add(rentalcar);
			}
		}
	}

	/**
	 *  Generated package id for this booking.
	 */
	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	/**
	 *  Result status (OK, NOK).
	 */
	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	/**
	 *  Total price
	 */
	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 *  Currency code
	 */
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 *  Booking status
	 */
	public short getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(short bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	/**
	 *  Returned status from the supplier.
	 */
	public String getSupplierBookingStatus() {
		return supplierBookingStatus;
	}

	public void setSupplierBookingStatus(String supplierBookingStatus) {
		this.supplierBookingStatus = supplierBookingStatus;
	}

	/**
	 *  Fee
	 */
	public float getServiceFeee() {
		return serviceFeee;
	}

	public void setServiceFeee(float serviceFeee) {
		this.serviceFeee = serviceFeee;
	}

	/**
	 * 
	 * @return List with all successful records - {@link HotelFare},
	 *         {@link FlightFare}, {@link Rentacar}, {@link Excursion}
	 */
	public List<Object> getSuccessful() {
		return successful;
	}

	/**
	 * 
	 * @return List with all failed records - {@link HotelFare},
	 *         {@link FlightFare}, {@link Rentacar}, {@link Excursion}
	 */
	public List<Object> getFailed() {
		return failed;
	}

}
