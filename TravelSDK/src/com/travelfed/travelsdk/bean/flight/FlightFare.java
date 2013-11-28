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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

/**
 *  Flight fare from flight search results.
 */
public class FlightFare {
	
	public static final String CONTROLE_RT = "rt";
	public static final String CONTROLE_OW = "ow";

	
	private FlightsResult flightsFaresResult;

	private boolean direct;
	private String cabinName = "-";
	private String cabinClass;
	private String type = "";
	private String currency;
	private Carrier carrier;
	private String supplier;
	private Date departureDate;
	private Date returnDate;
	private String id;
	private String attention;
	private Destination destination;
	private Origin origin;
	private float total;
	private List<Flight> flights;
	
	private List<Passenger> passengers = new ArrayList<Passenger>();

	private final static String DIRECT = "direct";
	private final static String CABINNAME = "cabinName";
	private final static String CABINCLASS = "cabinClass";
	private final static String TYPE = "type";
	private final static String CURRENCY = "currency";
	private final static String CARRIER = "carrier";
	private final static String SUPPLIER = "supplier";
	private final static String FLIGHTS = "flights";
	private final static String DEPARTUREDATE = "departureDate";
	private final static String RETURNDATE = "returnDate";
	private final static String ID = "id";
	private final static String ATTENTION = "attention";
	private final static String DESTINATION = "destination";
	private final static String ORIGIN = "origin";
	private final static String TOTAL = "total";
	private static final String PASSENGER = "passengers";
	
	
	public FlightFare(FlightsResult flightsFaresResult, JSONObject json) throws JSONException {
		this.flightsFaresResult = flightsFaresResult;
		if (json.has(DIRECT) && ! json.isNull(DIRECT)) {
			this.setDirect(json.getString(DIRECT).equals("true"));
		}
		if (json.has(CABINNAME) && !json.isNull(CABINNAME)) {
			this.setCabinName(json.getString(CABINNAME));
		}
		if (json.has(CABINCLASS)) {
			this.setCabinClass(json.getString(CABINCLASS));
		}
		if (json.has(TYPE)) {
			this.setType(json.getString(TYPE));
		}
		if (json.has(CURRENCY)) {
			this.setCurrency(json.getString(CURRENCY));
		}
		if (json.has(CARRIER)) {
			this.setCarrier(new Carrier(json.getJSONObject(CARRIER)));
		}
		if (json.has(SUPPLIER)) {
			this.setSupplier(json.getString(SUPPLIER));
		}
		//It is not needed 
		if (json.has(FLIGHTS)) {
			this.flights = new ArrayList<Flight>();
			JSONArray jsonArray = json.getJSONArray(FLIGHTS);
			for (int i = 0; i < jsonArray.length(); i++) {
				Flight elem = new Flight(jsonArray.getJSONObject(i));
				this.flights.add(elem);
			}
		}
		if (json.has(DEPARTUREDATE)) {
			String sDate = json.getString(DEPARTUREDATE);
			this.setDepartureDate(StringUtil.parseDate(sDate));
		}
		// It is not needed 
//		if (json.has("adtprice")) {
//			this.setAdtprice(json.getString("adtprice"));
//		}
//		if (json.has("infprice")) {
//			this.setInfprice(json.getString("infprice"));
//		}
//		if (json.has("chdprice")) {
//			this.setChdprice(json.getString("chdprice"));
//		}
		if (json.has(RETURNDATE)) {
			String sDate = json.getString(RETURNDATE);
			this.setReturnDate(StringUtil.parseDate(sDate));
		}
		if (json.has(ID)) {
			this.setId(json.getString(ID));
		}
		if (json.has(ATTENTION)) {
			this.setAttention(json.getString(ATTENTION));
		}
		if (json.has(DESTINATION)) {
			this.setDestination(new Destination(json.getJSONObject(DESTINATION)));
		}
		if (json.has(ORIGIN)) {
			this.setOrigin(new Origin(json.getJSONObject(ORIGIN)));
		}
		if (json.has(TOTAL)) {
			this.setTotal(Float.parseFloat(json.getString(TOTAL)));
		}
		if (json.has(PASSENGER)) {
			this.passengers = new ArrayList<Passenger>();
			JSONArray jsonArray = json.getJSONArray(PASSENGER);
			for (int i = 0; i < jsonArray.length(); i++) {
				Passenger elem = new Passenger(jsonArray.getJSONObject(i));
				this.passengers.add(elem);
			}
		}
	}

	/**
	 *  Flights results from search flights request
	 */
	public FlightsResult getFlightsFaresResult() {
		return flightsFaresResult;
	}

	/** @param direct */
	public void setDirect(boolean direct) {
		this.direct = direct;
	}

	/**
	 *  Check flight is direct.
	 */
	public boolean isDirect() {
		return direct;
	}

	/** @param cabin */
	public void setCabinName(String cabin) {
		this.cabinName = cabin;
	}

	/**
	 *  Cabin class name
	 */
	public String getCabinName() {
		return cabinName;
	}
	

	// Instead use getCabinName
//	public String getCabinClass() {
//		return cabinClass;
//	}


	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}


	/** @param type */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 *  One way (ow) or round trip (rt).
	 */
	public String getType() {
		return type;
	}

	/** @param currency */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 *  Currency code
	 */
	public String getCurrency() {
		return currency;
	}

	/** @param carrier */
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	/** @return carrier */
	public Carrier getCarrier() {
		return carrier;
	}

	/** @param supplier */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/** @return supplier */
	public String getSupplier() {
		return supplier;
	}

	/** @param departureDate */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 *  Departure date
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/** @param returnDate */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 *  Return date
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * Array with flights. Maximum 2 flights.
	 * First is departure flight. Second is return flight.
	 * 
	 * @return List with {@link Flight} objects
	 */
	public List<Flight> getFlights() {
		return flights;
	}

	/** @param id */
	public void setId(String id) {
		this.id = id;
	}

	/** @return id */
	public String getId() {
		return id;
	}

	/** @param attention */
	public void setAttention(String attention) {
		this.attention = attention;
	}

	/** @return attention */
	public String getAttention() {
		return attention;
	}

	/** @param destination */
	public void setDestination(Destination destination) {
		this.destination = destination;
	}


	/**
	 *  Destination airport
	 */
	public Destination getDestination() {
		return destination;
	}


	/** @param origin */
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	/**
	 *  Orign airport
	 */
	public Origin getOrigin() {
		return origin;
	}

	/** @param total */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 *  Total price including fees
	 */
	public float getTotal() {
		return total;
	}
	
	/**
	 * 
	 * @return List with {@link Passenger} objects
	 */
	public List<Passenger> getPassengers() {
		return passengers;
	}
	
	/**
	 *  Check flight is round trip
	 *
	 *  @return true for round trip flight
	 */
	public boolean isRoundTrip() {
		return this.type.equals(CONTROLE_RT);
	} 

	/**
	 *  Cabin class code
	 */
	public String getCabinClass() {
		return cabinClass;
	}
	
}