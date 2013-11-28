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
package com.travelfed.travelsdk.bean.hotel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *  Hotel search parameters.
 *  Documentation: http://wiki.travelsdk.com/index.php?title=Hotel_requests#Request_Parameters
 * 
 */
public class HotelSearchParameters implements BoardTypes {

	private int departureYear;
	private int departureMonth;
	private int departureDayOfMonth;
	private int returnYear;
	private int returnMonth;
	private int returnDayOfMonth;
	private RoomPersons roomPersons;
	private int radius = 10;
	private double lat = Double.NaN;
	private double lon = Double.NaN;
	private String provider;
	private short minHotelCategory = 0;
	private String boardType;

	/**
	 * Constructs HotelSearchParameters object for search
	 *  with departure next day and return date after 7 days.
	 */
	public HotelSearchParameters() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, 1);
		departureYear = calendar.get(Calendar.YEAR);
		departureMonth = calendar.get(Calendar.MONTH);
		departureDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, 7);
		returnYear = calendar.get(Calendar.YEAR);
		returnMonth = calendar.get(Calendar.MONTH);
		returnDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		roomPersons = new RoomPersons();
	}
	
	/**
	 * Constructs HotelSearchParameters object with required parameters for geolocation search
	 * 
	 * @param latitude - Latitude of a center search point.
	 * @param longitude - Longitude of a center search point.
	 * @param departureDate - Departure time in millisecond.  
	 * @param returnDate - Return time in millisecond.
	 * @param roomsPersons - Distribution of the guests in room
	 */
	public HotelSearchParameters(double latitude, double longitude, int departureYear, int departureMonth, int departureDayOfMonth,
			int returnYear, int returnMonth, int returnDayOfMonth, RoomPersons roomPersons) {
		this.lat = latitude;
		this.lon = longitude;
		this.departureYear = departureYear;
		this.departureMonth = departureMonth;
		this.departureDayOfMonth = departureDayOfMonth;
		this.returnYear = returnYear;
		this.returnMonth = returnMonth;
		this.returnDayOfMonth = returnDayOfMonth;
		this.roomPersons = roomPersons;
	}

	/**
	 * 
	 * @return Search area radius in km. For geolocation search only.
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius - Search area radius in km. Default is 10km. For geolocation search only.
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * 
	 * @return Latitude of a center search point. Nan if not set
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * 
	 * @param lat - Latitude of a center search point.
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * 
	 * @return Longitude of a center search point. Nan if not set
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * 
	 * @param lon - Longitude of a center search point.
	 */
	public void setLon(double lon) {
		this.lon = lon;
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
	 * Check in date. Required.
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
	 * Check out date. Required.
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	public void setReturnDate(int year, int month, int dayOfMonth) {
		this.returnYear = year;
		this.returnMonth = month;
		this.returnDayOfMonth = dayOfMonth;
	}
	
	/**
	 * 
	 * @return Distribution of the guests in the room.
	 */
	public RoomPersons getRoomPersons() {
		return roomPersons;
	}

	/**
	 * 
	 * @param roomPersons - Distribution of the guests in room
	 */
	public void setRoomPersons(RoomPersons roomPersons) {
		this.roomPersons = roomPersons;
	}

	public String getProvider() {
		return provider;
	}

	/**
	 * Comma separated providers list. Make requests only to these providers. Optional.
	 * @param provider
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	public short getMinHotelCategory() {
		return minHotelCategory;
	}

	/**
	 * 
	 * @param minHotelCategory - Set from 0 to 5. Optional.
	 */
	public void setMinHotelCategory(short minHotelCategory) {
		this.minHotelCategory = minHotelCategory;
	}

	/**
	 * 
	 * @return Board type code
	 */
	public String getBoardType() {
		return boardType;
	}

	/**
	 * 
	 * @param boardType - Board type code. Optional.
	 */
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((boardType == null) ? 0 : boardType.hashCode());
		result = prime * result + departureDayOfMonth;
		result = prime * result + departureMonth;
		result = prime * result + departureYear;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + minHotelCategory;
		result = prime * result
				+ ((provider == null) ? 0 : provider.hashCode());
		result = prime * result + radius;
		result = prime * result + returnDayOfMonth;
		result = prime * result + returnMonth;
		result = prime * result + returnYear;
		result = prime * result
				+ ((roomPersons == null) ? 0 : roomPersons.hashCode());
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
		HotelSearchParameters other = (HotelSearchParameters) obj;
		if (boardType == null) {
			if (other.boardType != null)
				return false;
		} else if (!boardType.equals(other.boardType))
			return false;
		if (departureDayOfMonth != other.departureDayOfMonth)
			return false;
		if (departureMonth != other.departureMonth)
			return false;
		if (departureYear != other.departureYear)
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lon) != Double.doubleToLongBits(other.lon))
			return false;
		if (minHotelCategory != other.minHotelCategory)
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (radius != other.radius)
			return false;
		if (returnDayOfMonth != other.returnDayOfMonth)
			return false;
		if (returnMonth != other.returnMonth)
			return false;
		if (returnYear != other.returnYear)
			return false;
		if (roomPersons == null) {
			if (other.roomPersons != null)
				return false;
		} else if (!roomPersons.equals(other.roomPersons))
			return false;
		return true;
	}


}
