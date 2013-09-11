package com.travelfed.travelsdk.bean.flight;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class to store parameters for flight search
 * @author krumstoilov
 *
 */
public class FlightSearchParameters {

	
	public static final String CABIN_CLASS_ECONOMY = "Y";
	public static final String CABIN_CLASS_BUISNESS = "C";
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
	 * Constructs FlightSearchParameters object with required parameters for search
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
	 * Constructs FlightSearchParameters object with required parameters for round trip search
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
	 * 
	 * @return Departure airport IATA code
	 */
	public String getFromAirportId() {
		return fromAirportId;
	}

	/**
	 * 
	 * @param fromAirportId - Departure airport IATA code
	 */
	public void setFromAirportId(String fromAirportId) {
		this.fromAirportId = fromAirportId;
	}

	/**
	 * 
	 * @return Arrival airport IATA code
	 */
	public String getToAirportId() {
		return toAirportId;
	}

	/**
	 * 
	 * @param toAirportId - Arrival airport IATA code
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
	 * Departure date
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
	 * Return date
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
	 * @return true if departure date >= return date
	 */
	public boolean isRoundTrip() {
		return isRoundTrip;
	}
	
	public void setRoundTrip(boolean isRoundTrip) {
		this.isRoundTrip = isRoundTrip;
	}

	/**
	 * 
	 * @return Cabin class code
	 */
	public String getCabinClass() {
		return cabinClass;
	}

	/**
	 * 
	 * @param cabinClass - Optional. Cabin class code
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
	 * @param numberOfAdults - Default is 1
	 */
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public int getNumberOfInfants() {
		return numberOfInfants;
	}

	public void setNumberOfInfants(int numberOfInfants) {
		this.numberOfInfants = numberOfInfants;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

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
