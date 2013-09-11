package com.travelfed.travelsdk.bean.flight;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

public class Segment {
	
	private Bookingclass bookingclass;
	private String duration;
	private String flightNumber;
//	private String aircraft;
	private String deptime;
	private Date depdate;
	private String destination; 
	private String origin; 
//	private String stops; not needed
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
//		if (json.has(AIRCRAFT)) {
//			this.setAircraft(json.getString(AIRCRAFT));
//		}
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
//		if (json.has("stops")) {
//			this.setStops(json.getString("stops"));
//		}
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
		this.duration = duration;// protocol changed StringUtil.minutesToDisplayable(duration);
	}

	/** @return duration */
	public String getDuration() {
		return duration;
	}


	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

//	/** @param aircraft */
//	public void setAircraft(String aircraft) {
//		this.aircraft = aircraft;
//	}
//
//	/** @return aircraft */
//	public String getAircraft() {
//		return aircraft;
//	}

	/** @param deptime */
	public void setDeptime(String deptime) {
		this.deptime = StringUtil.convertTimeToNormalForm(deptime);
	}

	/** @return deptime */
	public String getDeptime() {
		return deptime;
	}

	/** @param depdate */
	public void setDepdate(Date depdate) {
		this.depdate = depdate;
	}

	/** @return depdate */
	public Date getDepdate() {
		return depdate;
	}

	/** @param destination */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/** @return destination */
	public String getDestination() {
		return destination;
	}

	/** @param origin */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/** @return origin */
	public String getOrigin() {
		return origin;
	}

//	/** @param stops */
//	public void setStops(String stops) {
//		this.stops = stops;
//	}
//
//	/** @return stops */
//	public String getStops() {
//		return stops;
//	}

	/** @param arrtime */
	public void setArrtime(String arrtime) {
		this.arrtime = StringUtil.convertTimeToNormalForm(arrtime);
	}

	/** @return arrtime */
	public String getArrtime() {
		return arrtime;
	}

	/** @param arrdate */
	public void setArrdate(Date arrdate) {
		this.arrdate = arrdate;	
	}

	/** @return arrdate */
	public Date getArrdate() {
		return arrdate;
	}
	

}