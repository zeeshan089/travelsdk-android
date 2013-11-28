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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *  Rentacar search parameters
 *  Documentation: http://wiki.travelsdk.com/index.php?title=Rentacar_requests#Request_Parameters
 */
public class RentacarSearchParameters {
	
	private String fromAirportId;
	private String toAirportId;
	private double lat = Double.NaN;
	private double lon = Double.NaN;
	private int radius = 10;
	private double latDropOf;
	private double lonDropOff;
	private int departureYear;
	private int departureMonth;
	private int departureDayOfMonth;
	private int returnYear;
	private int returnMonth;
	private int returnDayOfMonth;
	private int numberOfPassengers = 1;
	private boolean airConditioned;
	private boolean automaticTransmission;
	private boolean stationWagon;
	private int category;
	
	/**
	 * Constructs RentacarSearchParameters object for search
	 *  with departure next day and return date after 7 days.
	 */
	public RentacarSearchParameters() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, 1);
		departureYear = calendar.get(Calendar.YEAR);
		departureMonth = calendar.get(Calendar.MONTH);
		departureDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, 7);
		returnYear = calendar.get(Calendar.YEAR);
		returnMonth = calendar.get(Calendar.MONTH);
		returnDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Constructs RentacarSearchParameters object with required parameters for search by airport code
	 * 
	 * @param fromAirportId - Airport IATA code
	 * @param toAirportId - Airport IATA code
	 * @param departureDate - Departure time in millisecond. Search is only by date(no hours)
	 * @param returnDate - Return time in millisecond. Search is only by date(no hours)
	 */
	public RentacarSearchParameters(String fromAirportId, String toAirportId, int departureYear, int departureMonth, int departureDayOfMonth,
			int returnYear, int returnMonth, int returnDayOfMonth) {
		this.fromAirportId = fromAirportId;
		this.toAirportId = toAirportId;
		this.departureYear = departureYear;
		this.departureMonth = departureMonth;
		this.departureDayOfMonth = departureDayOfMonth;
		this.returnYear = returnYear;
		this.returnMonth = returnMonth;
		this.returnDayOfMonth = returnDayOfMonth;
	}
	
	/**
	 * Constructs RentacarSearchParameters object with required parameters for search by geolocation.
	 * 
	 * @param latitudeFrom - Latitude of a pick up location point.
	 * @param longitudeFrom - Longitude of a pick up location point.
	 * @param latitudeTo - Latitude of a drop off location point.
	 * @param longitudeTo - Longitude of a drop off location point.
	 * @param departureDate - Departure time in millisecond.
	 * @param returnDate - Return time in millisecond.
	 */
	public RentacarSearchParameters(double latitudeFrom, double longitudeFrom, double latitudeTo, double longitudeTo, int departureYear, int departureMonth, int departureDayOfMonth,
			int returnYear, int returnMonth, int returnDayOfMonth) {
		this.lat = latitudeFrom;
		this.lon = longitudeFrom;
		this.latDropOf = latitudeTo;
		this.lonDropOff = longitudeTo;
		this.departureYear = departureYear;
		this.departureMonth = departureMonth;
		this.departureDayOfMonth = departureDayOfMonth;
		this.returnYear = returnYear;
		this.returnMonth = returnMonth;
		this.returnDayOfMonth = returnDayOfMonth;
	}

	/**
	 * 
	 * @return Pick up airport IATA code. Required on searching by airport.
	 */
	public String getFromAirportId() {
		return fromAirportId;
	}

	/**
	 * 
	 * @param fromAirportId - Pick up airport IATA code. Required on searching by airport.
	 */
	public void setFromAirportId(String fromAirportId) {
		this.fromAirportId = fromAirportId;
	}

	/**
	 * 
	 * @return Drop off airport IATA code. Required on searching by airport.
	 */
	public String getToAirportId() {
		return toAirportId;
	}

	/**
	 * 
	 * @param toAirportId - Drop off airport IATA code. Required on searching by airport.
	 */
	public void setToAirportId(String toAirportId) {
		this.toAirportId = toAirportId;
	}

	/**
	 * 
	 * @return Departure date year
	 */
	public int getDepartureYear() {
		return departureYear;
	}

	/**
	 * 
	 * @return Departure date month
	 */
	public int getDepartureMonth() {
		return departureMonth;
	}

	/**
	 * 
	 * @return Departure date day of month
	 */
	public int getDepartureDayOfMonth() {
		return departureDayOfMonth;
	}
	
	/**
	 * 
	 * @return Departure date
	 */
	public Date getDepartureDate() {
		return new GregorianCalendar(departureYear, departureMonth, departureDayOfMonth).getTime();
	}

	/**
	 * Pick up date
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	public void setDepartureDate(int year, int month, int dayOfMonth) {
		this.departureYear = year;
		this.departureMonth = month;
		this.departureDayOfMonth = dayOfMonth;
	}

	/**
	 * 
	 * @return Return date year
	 */
	public int getReturnYear() {
		return returnYear;
	}

	/**
	 * 
	 * @return Return date month
	 */
	public int getReturnMonth() {
		return returnMonth;
	}

	/**
	 * 
	 * @return Return date day of month
	 */
	public int getReturnDayOfMonth() {
		return returnDayOfMonth;
	}
	
	/**
	 * 
	 * @return Return date
	 */
	public Date getReturnDate() {
		return new GregorianCalendar(returnYear, returnMonth, returnDayOfMonth).getTime();
	}

	/**
	 * Check in date
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	public void setReturnDate(int year, int month, int dayOfMonth) {
		this.returnYear = year;
		this.returnMonth = month;
		this.returnDayOfMonth = dayOfMonth;
	}

	public boolean isAirConditioned() {
		return airConditioned;
	}

	/**
	 *  Air conditioned. Optional
	 * @param airConditioned
	 */
	public void setAirConditioned(boolean airConditioned) {
		this.airConditioned = airConditioned;
	}

	public boolean isAutomaticTransmission() {
		return automaticTransmission;
	}

	/**
	 *  Automatic transmission. Optional
	 */
	public void setAutomaticTransmission(boolean automaticTransmission) {
		this.automaticTransmission = automaticTransmission;
	}

	public boolean isStationWagon() {
		return stationWagon;
	}

	/**
	 *  Station wago. Optional
	 */
	public void setStationWagon(boolean stationWagon) {
		this.stationWagon = stationWagon;
	}

	public int getCategory() {
		return category;
	}

	/**
	 *  Car category: 0 - all, 1 - mini, 2 - sub compact, 3 - economy, 4 - compact, 5 - midsize, 
	 *  6 - intermediate, 7 - standard, 8 - full size, 9 - luxury, 10 - premium, 
	 *  11 - mini van, 23 - unique, 36 - intermediate elite, 32 - special
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * 
	 * @return Latitude of a pick up location point. Nan if not set
	 */
	public double getLat() {
		return lat;
	}

	/**
	 *  Pick up latitude. Required for geolocation search.
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * 
	 * @return Longitude of a pick up location point. Nan if not set
	 */
	public double getLon() {
		return lon;
	}

	/**
	 *  Pick up longitude. Required for geolocation search.
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * 
	 * @return Search area radius in km when searching by geolocation
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius - Search area radius in km when searching by geolocation. Default is 10km.
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * 
	 * @return Drop off latitude. Required for geolocation search.
	 */
	public double getLatDropOf() {
		return latDropOf;
	}

	/**
	 * 
	 * @param latDropOf Drop off latitude. Required for geolocation search.
	 */
	public void setLatDropOf(double latDropOf) {
		this.latDropOf = latDropOf;
	}

	/**
	 * 
	 * @return Drop off longitude. Required for geolocation search.
	 */
	public double getLonDropOff() {
		return lonDropOff;
	}

	/**
	 * 
	 * @param lonDropOff Drop off longitude. Required for geolocation search.
	 */
	public void setLonDropOff(double lonDropOff) {
		this.lonDropOff = lonDropOff;
	}

	/**
	 * 
	 * @return Number of passengers.
	 */
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	/**
	 * 
	 * @param numberOfPassengers - Number of passengers. Default is 1
	 */
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (airConditioned ? 1231 : 1237);
		result = prime * result + (automaticTransmission ? 1231 : 1237);
		result = prime * result + category;
		result = prime * result + departureDayOfMonth;
		result = prime * result + departureMonth;
		result = prime * result + departureYear;
		result = prime * result
				+ ((fromAirportId == null) ? 0 : fromAirportId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(latDropOf);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lonDropOff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfPassengers;
		result = prime * result + radius;
		result = prime * result + returnDayOfMonth;
		result = prime * result + returnMonth;
		result = prime * result + returnYear;
		result = prime * result + (stationWagon ? 1231 : 1237);
		result = prime * result
				+ ((toAirportId == null) ? 0 : toAirportId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentacarSearchParameters other = (RentacarSearchParameters) obj;
		if (airConditioned != other.airConditioned)
			return false;
		if (automaticTransmission != other.automaticTransmission)
			return false;
		if (category != other.category)
			return false;
		if (departureDayOfMonth != other.departureDayOfMonth)
			return false;
		if (departureMonth != other.departureMonth)
			return false;
		if (departureYear != other.departureYear)
			return false;
		if (fromAirportId == null) {
			if (other.fromAirportId != null)
				return false;
		} else if (!fromAirportId.equals(other.fromAirportId))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(latDropOf) != Double
				.doubleToLongBits(other.latDropOf))
			return false;
		if (Double.doubleToLongBits(lon) != Double.doubleToLongBits(other.lon))
			return false;
		if (Double.doubleToLongBits(lonDropOff) != Double
				.doubleToLongBits(other.lonDropOff))
			return false;
		if (numberOfPassengers != other.numberOfPassengers)
			return false;
		if (radius != other.radius)
			return false;
		if (returnDayOfMonth != other.returnDayOfMonth)
			return false;
		if (returnMonth != other.returnMonth)
			return false;
		if (returnYear != other.returnYear)
			return false;
		if (stationWagon != other.stationWagon)
			return false;
		if (toAirportId == null) {
			if (other.toAirportId != null)
				return false;
		} else if (!toAirportId.equals(other.toAirportId))
			return false;
		return true;
	}

}
