package com.travelfed.travelsdk.bean.excursion;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Class to store parameters for excursion search.
 * Documentation <a href=
 * "http://wiki.travelsdk.com/index.php?title=Excursion_requests"
 * >http://wiki.travelsdk.com/index.php?title=Excursion_requests"</a>
 * 
 * @author krumstoilov
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
	 * @param airportId - Airport IATA code
	 * @param fromDate - Time in millisecond. Search is only by date(no hours) 
	 * @param toDate -  Time in millisecond. Search is only by date(no hours) 
	 * @param numberOfAdults
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
	 * 
	 * @param latitude - Latitude of a center search point.
	 * @param longitude - Longitude of a center search point.
	 * @param fromDate - Time in millisecond. Search is only by date(no hours) 
	 * @param toDate - Time in millisecond. Search is only by date(no hours) 
	 * @param numberOfAdults
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
	 * @param airportId - Airport IATA code
	 */
	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	/**
	 * 
	 * @return Latitude of a center search point.
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
	 * @return - Longitude of a center search point.
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
	 * @return from date year
	 */
	public int getFromDateYear() {
		return fromDateYear;
	}

	/**
	 * 
	 * @return from date month
	 */
	public int getFromDateMonth() {
		return fromDateMonth;
	}

	/**
	 * 
	 * @return fromDate date day of month
	 */
	public int getFromDateDayOfMonth() {
		return fromDateDayOfMonth;
	}
	
	/**
	 * 
	 * @return From date
	 */
	public Date getFromDate() {
		return new GregorianCalendar(fromDateYear, fromDateMonth, fromDateDayOfMonth).getTime();
	}

	/**
	 * From date
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
	 * To date
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
	 * @return Search area radius in km when searching by geolocation. Default is 10km.
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius - Search area radius in km when searching by geolocation.
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
	 * @return Array of all children ages
	 */
	public int[] getChildrenAges() {
		return childrenAges;
	}

	/**
	 * 
	 * @param childrenAges - Array of all children ages
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
