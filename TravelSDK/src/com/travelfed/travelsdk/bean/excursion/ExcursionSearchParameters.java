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
package com.travelfed.travelsdk.bean.excursion;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Excursion search parameters.
 * Documentation http://wiki.travelsdk.com/index.php?title=Excursion_requests
 *
 */
public class ExcursionSearchParameters {

	private String airportId;
	private double lat = Double.NaN;
	private double lon = Double.NaN;
	private int fromDateYear;
	private int fromDateMonth;
	private int fromDateDayOfMonth;
	private int toDateYear;
	private int toDateMonth;
	private int toDateDayOfMonth;
	private float radius = 10;
	private int numberOfAdults = 2;
	private int[] childrenAges = new int[0];

	/**
	 * Constructs HotelSearchParameters object for search
	 *   from date next day and return date after 7 days.
	 */
	public ExcursionSearchParameters() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, 1);
		fromDateYear = calendar.get(Calendar.YEAR);
		fromDateMonth = calendar.get(Calendar.MONTH);
		fromDateDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, 7);
		toDateYear = calendar.get(Calendar.YEAR);
		toDateMonth = calendar.get(Calendar.MONTH);
		toDateDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Constructs HotelSearchParameters object with required parameters for search by airport code
	 * 
	 * @param airportId Airport IATA code
	 * @param fromDate Time in millisecond. Search is only by date(will ignore hours and minutes) 
	 * @param toDate Time in millisecond. Search is only by date(will ignore hours and minutes) 
	 * @param numberOfAdults Number of adults.
	 */
	public ExcursionSearchParameters(String airportId, int fromDateYear, int fromDateMonth, int fromDateDayOfMonth,
			int toDateYear, int toDateMonth, int toDateDayOfMonth, int numberOfAdults) {
		this.airportId = airportId;
		this.fromDateYear = fromDateYear;
		this.fromDateMonth = fromDateMonth;
		this.fromDateDayOfMonth = fromDateDayOfMonth;
		this.toDateYear = toDateYear;
		this.toDateMonth = toDateMonth;
		this.toDateDayOfMonth = toDateDayOfMonth;
		this.numberOfAdults = numberOfAdults;
	}
	
	/**
	 * Constructs ExcursionSearchParameters object with required parameters for geolocation search.
	 * 
	 * @param latitude Latitude of a center search point.
	 * @param longitude Longitude of a center search point.
	 * @param fromDate Time in millisecond. Search is only by date(will ignore hours and minutes) 
	 * @param toDate Time in millisecond. Search is only by date(will ignore hours and minutes) 
	 * @param numberOfAdults Number of adults.
	 */
	public ExcursionSearchParameters(double latitude, double longitude, int fromDateYear, int fromDateMonth, int fromDateDayOfMonth,
			int toDateYear, int toDateMonth, int toDateDayOfMonth, int numberOfAdults) {
		this.lat = latitude;
		this.lon = longitude;
		this.fromDateYear = fromDateYear;
		this.fromDateMonth = fromDateMonth;
		this.fromDateDayOfMonth = fromDateDayOfMonth;
		this.toDateYear = toDateYear;
		this.toDateMonth = toDateMonth;
		this.toDateDayOfMonth = toDateDayOfMonth;
		this.numberOfAdults = numberOfAdults;
	}

	/**
	 * 
	 * @return Airport IATA code
	 */
	public String getAirportId() {
		return airportId;
	}

	/**
	 * 
	 * @param airportId - Airport IATA code. Required for geo location search.
	 */
	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	/**
	 * 
	 * @return Latitude of a center search point. Required for geolocation search.
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 
	 * @param lat - Latitude of a center search point. Required for geo location search.
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * 
	 * @return - Longitude of a center search point. Required for geo location search.
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * 
	 * @param lon - Longitude of a center search point. Required for geo location search.
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * 
	 * @return from date year. Required
	 */
	public int getFromDateYear() {
		return fromDateYear;
	}

	/**
	 * 
	 * @return from date month. Required
	 */
	public int getFromDateMonth() {
		return fromDateMonth;
	}

	/**
	 * 
	 * @return fromDate date day of month. Required
	 */
	public int getFromDateDayOfMonth() {
		return fromDateDayOfMonth;
	}
	
	/**
	 * 
	 * @return From date. Required
	 */
	public Date getFromDate() {
		return new GregorianCalendar(fromDateYear, fromDateMonth, fromDateDayOfMonth).getTime();
	}

	/**
	 * From date. Required
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	public void setFromDate(int year, int month, int dayOfMonth) {
		this.fromDateYear = year;
		this.fromDateMonth = month;
		this.fromDateDayOfMonth = dayOfMonth;
	}
	/**
	 * 
	 * @return to date year
	 */
	public int getToDateYear() {
		return toDateYear;
	}

	/**
	 * 
	 * @return to date month
	 */
	public int getToDateMonth() {
		return toDateMonth;
	}

	/**
	 * 
	 * @return to date day of month
	 */
	public int getToDateDayOfMonth() {
		return toDateDayOfMonth;
	}

	/**
	 * 
	 * @return To date
	 */
	public Date getToDate() {
		return new GregorianCalendar(toDateYear, toDateMonth, toDateDayOfMonth).getTime();
	}
	
	/**
	 * To date. Required
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	public void setToDate(int year, int month, int dayOfMonth) {
		this.toDateYear = year;
		this.toDateMonth = month;
		this.toDateDayOfMonth = dayOfMonth;
	}

	/**
	 * 
	 * @return Search area radius in km. Note: If airport search is requested, the radius parameter is ignored. Default is 10km
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius - Search area radius in km. Note: If airport search is requested, the radius parameter is ignored.
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}

	/**
	 * 
	 * @return Number of adults. Default is 2.
	 */
	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	/**
	 * 
	 * @param numberOfAdults - number of adults
	 */
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	/**
	 * 
	 * @return Array of all children ages. Maximum 3 children.
	 */
	public int[] getChildrenAges() {
		return childrenAges;
	}

	/**
	 * 
	 * @param childrenAges - Array of all children ages. Maximum 3 children.
	 */
	public void setChildrenAges(int[] childrenAges) {
		this.childrenAges = childrenAges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((airportId == null) ? 0 : airportId.hashCode());
		result = prime * result + Arrays.hashCode(childrenAges);
		result = prime * result + fromDateDayOfMonth;
		result = prime * result + fromDateMonth;
		result = prime * result + fromDateYear;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numberOfAdults;
		result = prime * result + Float.floatToIntBits(radius);
		result = prime * result + toDateDayOfMonth;
		result = prime * result + toDateMonth;
		result = prime * result + toDateYear;
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
		ExcursionSearchParameters other = (ExcursionSearchParameters) obj;
		if (airportId == null) {
			if (other.airportId != null)
				return false;
		} else if (!airportId.equals(other.airportId))
			return false;
		if (!Arrays.equals(childrenAges, other.childrenAges))
			return false;
		if (fromDateDayOfMonth != other.fromDateDayOfMonth)
			return false;
		if (fromDateMonth != other.fromDateMonth)
			return false;
		if (fromDateYear != other.fromDateYear)
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lon) != Double.doubleToLongBits(other.lon))
			return false;
		if (numberOfAdults != other.numberOfAdults)
			return false;
		if (Float.floatToIntBits(radius) != Float.floatToIntBits(other.radius))
			return false;
		if (toDateDayOfMonth != other.toDateDayOfMonth)
			return false;
		if (toDateMonth != other.toDateMonth)
			return false;
		if (toDateYear != other.toDateYear)
			return false;
		return true;
	}

}
