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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Flight search parameters.
 * Documentation: http://wiki.travelsdk.com/index.php?title=Flight_requests#Request_Parameters
 */
public class FlightSearchParameters {

	/**
	 *  Economy cabin class code
	 */
	public static final String CABIN_CLASS_ECONOMY = "Y";
	
	/**
	 *  Business cabin class code
	 */
	public static final String CABIN_CLASS_BUSINESS = "C";
	
	/**
	 *  First cabin class code
	 */
	public static final String CABIN_CLASS_FIRST = "F";
	
	private String fromAirportId;
	private String toAirportId;
	private int departureYear;
	private int departureMonth;
	private int departureDayOfMonth;
	private int returnYear;
	private int returnMonth;
	private int returnDayOfMonth;
	private boolean isRoundTrip;
	private int numberOfAdults = 1;
	private int numberOfChildren;
	private int numberOfInfants;
	private String cabinClass;
	private boolean direct;
	private String carrierCode;


	/**
	 * Constructs FlightSearchParameters object for round trip search
	 *  with departure date next day and return date 7 days.
	 */
	public FlightSearchParameters() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, 1);
		departureYear = calendar.get(Calendar.YEAR);
		departureMonth = calendar.get(Calendar.MONTH);
		departureDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DATE, 7);
		returnYear = calendar.get(Calendar.YEAR);
		returnMonth = calendar.get(Calendar.MONTH);
		returnDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		isRoundTrip = true;
	}
	
	/**
	 * Constructs FlightSearchParameters object with required parameters for one way flight search
	 * 
	 * @param fromAirportId - Departure airport IATA code
	 * @param toAirportId - Arrival airport IATA code
	 * @param departureYear -  Departure year
	 * @param departureMonth - Departure month
	 * @param departureDayOfMonth - departure day of month
	 */
	public FlightSearchParameters(String fromAirportId, String toAirportId, int departureYear, int departureMonth, int departureDayOfMonth) {
		this(fromAirportId, toAirportId, departureYear, departureMonth, departureDayOfMonth, 0, 0, 0, 1);
	}
	
	/**
	 * Constructs FlightSearchParameters object with required parameters for round trip flight search
	 * 
	 * @param fromAirportId - Departure airport IATA code
	 * @param toAirportId - Arrival airport IATA code
	 * @param departureYear -  Departure date year
	 * @param departureMonth - Departure date month
	 * @param departureDayOfMonth - Departure date day of month
	 * @param returnYear - Return date year
	 * @param returnMonth - Return date month
	 * @param returnDayOfMonth - Return date day of month
	 * @param numberOfAdults
	 */
	public FlightSearchParameters(String fromAirportId, String toAirportId, int departureYear, int departureMonth, int departureDayOfMonth,
			int returnYear, int returnMonth, int returnDayOfMonth, int numberOfAdults) {
		this.fromAirportId = fromAirportId;
		this.toAirportId = toAirportId;
		this.departureYear = departureYear;
		this.departureMonth = departureMonth;
		this.departureDayOfMonth = departureDayOfMonth;
		this.returnYear = returnYear;
		this.returnMonth = returnMonth;
		this.returnDayOfMonth = returnDayOfMonth;
		isRoundTrip = (returnYear >= departureYear && returnMonth >= departureMonth && returnDayOfMonth >= departureDayOfMonth);
		this.numberOfAdults = numberOfAdults;
	}

	/**
	 *  Departure airport IATA code. Required
	 */
	public String getFromAirportId() {
		return fromAirportId;
	}

	/**
	 * 
	 * @param fromAirportId - Departure airport IATA code. Required
	 */
	public void setFromAirportId(String fromAirportId) {
		this.fromAirportId = fromAirportId;
	}

	/**
	 * 
	 * @return Arrival airport IATA code. Required.
	 */
	public String getToAirportId() {
		return toAirportId;
	}

	/**
	 * 
	 * @param toAirportId - Arrival airport IATA code. Required.
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
	 * Departure date. Local airport date. Required
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
	 * Return date. Local airport date. Required
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
	 * @return true for round trip search.
	 */
	public boolean isRoundTrip() {
		return isRoundTrip;
	}
	
	/**
	 * 
	 * @param isRoundTrip Set to true for round trip search. Required
	 */
	public void setRoundTrip(boolean isRoundTrip) {
		this.isRoundTrip = isRoundTrip;
	}

	/**
	 * 
	 * @return Cabin class code. CABIN_CLASS_ECONOMY, CABIN_CLASS_BUSINESS or CABIN_CLASS_FIRST
	 */
	public String getCabinClass() {
		return cabinClass;
	}

	/**
	 * 
	 * @param cabinClass - Optional. Cabin class code. CABIN_CLASS_ECONOMY, CABIN_CLASS_BUSINESS or CABIN_CLASS_FIRST
	 */
	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}

	/**
	 * 
	 * @return is direct flight. Default is false
	 */
	public boolean isDirect() {
		return direct;
	}

	/**
	 * 
	 * @param direct - Set to true to search direct flights only.
	 */
	public void setDirect(boolean direct) {
		this.direct = direct;
	}

	/**
	 * 
	 * @return Number of adults. Default is 1
	 */
	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	/**
	 * 
	 * @param numberOfAdults Number of adults. Default is 1
	 */
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	/**
	 * 
	 * @param numberOfChildren Number of children. Optional.
	 */
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public int getNumberOfInfants() {
		return numberOfInfants;
	}

	/**
	 * 
	 * @param numberOfInfants  Number of infants. Optional.
	 */
	public void setNumberOfInfants(int numberOfInfants) {
		this.numberOfInfants = numberOfInfants;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	/**
	 * Optional. Carrier preference.
	 * @param carrierCode
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cabinClass == null) ? 0 : cabinClass.hashCode());
		result = prime * result
				+ ((carrierCode == null) ? 0 : carrierCode.hashCode());
		result = prime * result + departureDayOfMonth;
		result = prime * result + departureMonth;
		result = prime * result + departureYear;
		result = prime * result + (direct ? 1231 : 1237);
		result = prime * result
				+ ((fromAirportId == null) ? 0 : fromAirportId.hashCode());
		result = prime * result + (isRoundTrip ? 1231 : 1237);
		result = prime * result + numberOfAdults;
		result = prime * result + numberOfChildren;
		result = prime * result + numberOfInfants;
		result = prime * result + returnDayOfMonth;
		result = prime * result + returnMonth;
		result = prime * result + returnYear;
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
		FlightSearchParameters other = (FlightSearchParameters) obj;
		if (cabinClass == null) {
			if (other.cabinClass != null)
				return false;
		} else if (!cabinClass.equals(other.cabinClass))
			return false;
		if (carrierCode == null) {
			if (other.carrierCode != null)
				return false;
		} else if (!carrierCode.equals(other.carrierCode))
			return false;
		if (departureDayOfMonth != other.departureDayOfMonth)
			return false;
		if (departureMonth != other.departureMonth)
			return false;
		if (departureYear != other.departureYear)
			return false;
		if (direct != other.direct)
			return false;
		if (fromAirportId == null) {
			if (other.fromAirportId != null)
				return false;
		} else if (!fromAirportId.equals(other.fromAirportId))
			return false;
		if (isRoundTrip != other.isRoundTrip)
			return false;
		if (numberOfAdults != other.numberOfAdults)
			return false;
		if (numberOfChildren != other.numberOfChildren)
			return false;
		if (numberOfInfants != other.numberOfInfants)
			return false;
		if (returnDayOfMonth != other.returnDayOfMonth)
			return false;
		if (returnMonth != other.returnMonth)
			return false;
		if (returnYear != other.returnYear)
			return false;
		if (toAirportId == null) {
			if (other.toAirportId != null)
				return false;
		} else if (!toAirportId.equals(other.toAirportId))
			return false;
		return true;
	}

}
