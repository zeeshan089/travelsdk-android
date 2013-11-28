
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
 */package com.travelfed.travelsdk.bean.flight;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

/**
 *  Flight segment with orign and destination airports.
 */
public class Segment {
	
	private Bookingclass bookingclass;
	private String duration;
	private String flightNumber;
	private String deptime;
	private Date depdate;
	private String destination; 
	private String origin; 
	private String arrtime;
	private Date arrdate;

	private static final String NAME = "name";
	private static final String CITY = "city";
	private static final String COUNTRY = "country";
	private static final String BOOKINGCLASS = "bookingclass";
	private static final String DURATION = "duration";
	private static final String CARRIER = "carrier";
	private static final String IDENT = "ident";
//	private static final String AIRCRAFT = "aircraft";
	private static final String DEPDATE = "depdate";
	private static final String DESTINATION = "destination";
	private static final String ORIGIN = "origin";
	private static final String ARRDATE = "arrival";

	public Segment(JSONObject json) throws JSONException {
		if (json.has(BOOKINGCLASS)) {
			this.setBookingclass(new Bookingclass(json.getJSONObject(BOOKINGCLASS)));
		}
		if (json.has(DURATION)) {
			this.setDuration(json.getString(DURATION));
		}
		if (json.has(CARRIER)) {
			JSONObject carrierObject = json.getJSONObject(CARRIER);
			if(carrierObject.has(IDENT)) {
				flightNumber = carrierObject.getString(IDENT);
			}
		}
		if (json.has(DEPDATE)) {
			String sDate = json.getString(DEPDATE);
			this.setDepdate(StringUtil.parseDate(sDate));
			this.setDeptime(StringUtil.parseTime(sDate));
		}
		if (json.has(DESTINATION)) {
			this.setDestination(parseAirport(json.getJSONObject(DESTINATION)));
		}
		if (json.has(ORIGIN)) {
			this.setOrigin(parseAirport(json.getJSONObject(ORIGIN)));
		}
		if (json.has(ARRDATE)) {
			String sDate = json.getString(ARRDATE);
			this.setArrdate(StringUtil.parseDate(sDate));
			this.setArrtime(StringUtil.parseTime(sDate));
		}		
	}
	
	private String parseAirport(JSONObject airportJson) throws JSONException {
		StringBuffer result = new StringBuffer();
		result.append(airportJson.getString(CITY)).append(" - ").append(airportJson.getString(NAME));
		result.append(StringUtil.COMA_STRING).append(airportJson.getJSONObject(COUNTRY).getString(NAME));
		
		return result.toString();
	}
	
	/** @param bookingclass */
	public void setBookingclass(Bookingclass bookingclass) {
		this.bookingclass = bookingclass;
	}

	/** @return bookingclass */
	public Bookingclass getBookingclass() {
		return bookingclass;
	}

	/** @param duration in minutes */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/** @return duration in minutes */
	public String getDuration() {
		return duration;
	}

	/**
	 *  Flight number
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/** @param deptime */
	public void setDeptime(String deptime) {
		this.deptime = StringUtil.convertTimeToNormalForm(deptime);
	}

	/**
	 *  Departure time
	 */
	public String getDeptime() {
		return deptime;
	}

	/** @param depdate */
	public void setDepdate(Date depdate) {
		this.depdate = depdate;
	}

	/**
	 *  Departure date
	 */
	public Date getDepdate() {
		return depdate;
	}

	/** @param destination */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 *  Destination airport
	 */
	public String getDestination() {
		return destination;
	}

	/** @param origin */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 *  Origin airport
	 */
	public String getOrigin() {
		return origin;
	}

	/** @param arrtime */
	public void setArrtime(String arrtime) {
		this.arrtime = StringUtil.convertTimeToNormalForm(arrtime);
	}

	/**
	 *  Arrival time
	 */
	public String getArrtime() {
		return arrtime;
	}

	/** @param arrdate */
	public void setArrdate(Date arrdate) {
		this.arrdate = arrdate;	
	}

	/**
	 *  Arrival date
	 */
	public Date getArrdate() {
		return arrdate;
	}
	

}