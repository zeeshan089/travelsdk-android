package com.travelfed.travelsdk.bean.flight;

import java.util.Arrays;

/**
 * Filter parameters for a flight search results
 * 
 * @author krumstoilov
 *
 */
public class FlightFilterParameters {

	private boolean directOnly;
	private short maxStopsOut = -1;
	private short maxStopsIn = -1;
	private short minOutDepartureTime = -1;
	private short maxOutDepartureTime = -1;
	private short minInDepartureTime = -1;
	private short maxInDepartureTime = -1;
	private String[] airlineCodes;
	private float minPrice = -1;
	private float maxPrice = -1;
	private String[] cabinClasses;
	private int offset;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public boolean isDirectOnly() {
		return directOnly;
	}

	public void setDirectOnly(boolean directOnly) {
		this.directOnly = directOnly;
	}

	public short getMaxStopsOut() {
		return maxStopsOut;
	}

	public void setMaxStopsOut(short maxStopsOut) {
		this.maxStopsOut = maxStopsOut;
	}

	public short getMaxStopsIn() {
		return maxStopsIn;
	}

	public void setMaxStopsIn(short maxStopsIn) {
		this.maxStopsIn = maxStopsIn;
	}

	public short getMinOutDepartureTime() {
		return minOutDepartureTime;
	}

	public void setMinOutDepartureTime(short minOutDepartureTime) {
		this.minOutDepartureTime = minOutDepartureTime;
	}

	public short getMaxOutDepartureTime() {
		return maxOutDepartureTime;
	}

	public void setMaxOutDepartureTime(short maxOutDepartureTime) {
		this.maxOutDepartureTime = maxOutDepartureTime;
	}

	public short getMinInDepartureTime() {
		return minInDepartureTime;
	}

	public void setMinInDepartureTime(short minInDepartureTime) {
		this.minInDepartureTime = minInDepartureTime;
	}

	public short getMaxInDepartureTime() {
		return maxInDepartureTime;
	}

	public void setMaxInDepartureTime(short maxInDepartureTime) {
		this.maxInDepartureTime = maxInDepartureTime;
	}

	public String[] getAirlineCodes() {
		return airlineCodes;
	}

	public void setAirlineCodes(String[] airlineCodes) {
		this.airlineCodes = airlineCodes;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String[] getCabinClasses() {
		return cabinClasses;
	}

	public void setCabinClasses(String[] cabinClasses) {
		this.cabinClasses = cabinClasses;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + FlightFilterParameters.hashCode(airlineCodes);
		result = prime * result + FlightFilterParameters.hashCode(cabinClasses);
		result = prime * result + (directOnly ? 1231 : 1237);
		result = prime * result + maxInDepartureTime;
		result = prime * result + maxOutDepartureTime;
		result = prime * result + Float.floatToIntBits(maxPrice);
		result = prime * result + maxStopsIn;
		result = prime * result + maxStopsOut;
		result = prime * result + minInDepartureTime;
		result = prime * result + minOutDepartureTime;
		result = prime * result + Float.floatToIntBits(minPrice);
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightFilterParameters other = (FlightFilterParameters) obj;
		if (!Arrays.equals(airlineCodes, other.airlineCodes))
			return false;
		if (!Arrays.equals(cabinClasses, other.cabinClasses))
			return false;
		if (directOnly != other.directOnly)
			return false;
		if (maxInDepartureTime != other.maxInDepartureTime)
			return false;
		if (maxOutDepartureTime != other.maxOutDepartureTime)
			return false;
		if (Float.floatToIntBits(maxPrice) != Float.floatToIntBits(other.maxPrice))
			return false;
		if (maxStopsIn != other.maxStopsIn)
			return false;
		if (maxStopsOut != other.maxStopsOut)
			return false;
		if (minInDepartureTime != other.minInDepartureTime)
			return false;
		if (minOutDepartureTime != other.minOutDepartureTime)
			return false;
		if (Float.floatToIntBits(minPrice) != Float.floatToIntBits(other.minPrice))
			return false;
		return true;
	}

	private static int hashCode(Object[] array) {
		int prime = 31;
		if (array == null)
			return 0;
		int result = 1;
		for (int index = 0; index < array.length; index++) {
			result = prime * result + (array[index] == null ? 0 : array[index].hashCode());
		}
		return result;
	}

}
