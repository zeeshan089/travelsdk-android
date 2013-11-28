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

import com.travelfed.travelsdk.bean.excursion.ExcursionBooking;
import com.travelfed.travelsdk.bean.flight.FlightBooking;
import com.travelfed.travelsdk.bean.hotel.HotelBooking;
import com.travelfed.travelsdk.bean.rentacar.RentacarBooking;

/**
 *  Result list with bookings from TravelSDK.INSTANCE.receiveBookings request
 */
public class BookingListResult extends Result {

	private final static String TYPE = "type";
	private final static String PACKAGE_ID = "package_id";
	
	private final static String TYPE_FLIGHT = "flight";
	private final static String TYPE_HOTEL = "hotel";
	private final static String TYPE_RENTACAR = "rentacar";
	private final static String TYPE_EXCURSION = "excursion";
	
	private List<FlightBooking> flightBookings = new ArrayList<FlightBooking>();
	private List<HotelBooking> hotelBookings = new ArrayList<HotelBooking>();
	private List<RentacarBooking> rentacarBookings = new ArrayList<RentacarBooking>();
	private List<ExcursionBooking> excursionBookings = new ArrayList<ExcursionBooking>();
	
	private List<List<Booking>> bookingPackages = new ArrayList<List<Booking>>();
	
	
	public BookingListResult(JSONObject json) throws JSONException {
		super(json);
		
		if (json.has("result")) {
			JSONArray jsonArray = json.getJSONArray("result");
			String packageId = null;
			List<Booking> packetItems = null;
			
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject bookingJson = jsonArray.getJSONObject(i);
				Booking elem = null;
				if(bookingJson.has(TYPE)) {
					String type = bookingJson.getString(TYPE);
					if(type.equals(TYPE_FLIGHT)) {
						elem = new FlightBooking(bookingJson);
						this.flightBookings.add((FlightBooking)elem);
					} else if(type.equals(TYPE_HOTEL)) {
						elem = new HotelBooking(bookingJson);
						this.hotelBookings.add((HotelBooking)elem);
					} else if(type.equals(TYPE_RENTACAR)) {
						elem = new RentacarBooking(bookingJson);
						this.rentacarBookings.add((RentacarBooking)elem);
					} else if(type.equals(TYPE_EXCURSION)) {
						elem = new ExcursionBooking(bookingJson);
						this.excursionBookings.add((ExcursionBooking)elem);
					}
				}
				
				// Build package
				if(bookingJson.has(PACKAGE_ID)) {
					String packId = bookingJson.getString(PACKAGE_ID);
					if(!packId.equals(packageId)) {
						packageId = packId;
						packetItems = new ArrayList<Booking>();
						bookingPackages.add(packetItems);
					}
					packetItems.add(elem);
				}
				
			}
		}
	}

	/**
	 * 
	 * @return List with {@link FlightBooking} objects
	 */
	public List<FlightBooking> getFlightBookings() {
		return flightBookings;
	}

	/**
	 * 
	 * @return List with {@link HotelBooking} objects
	 */
	public List<HotelBooking> getHotelBookings() {
		return hotelBookings;
	}

	/**
	 * 
	 * @return List with {@link RentacarBooking} objects
	 */
	public List<RentacarBooking> getRentacarBookings() {
		return rentacarBookings;
	}
	

	/**
	 * 
	 * @return List with {@link ExcursionBooking} elements
	 */
	public List<ExcursionBooking> getExcursionBookings() {
		return excursionBookings;
	}

	/**
	 * 
	 * @return List with packages with {@link Booking} objects. 
	 * Each package contains all bookings of that package.
	 */
	public List<List<Booking>> getBookingPackages() {
		return bookingPackages;
	}

	
}
