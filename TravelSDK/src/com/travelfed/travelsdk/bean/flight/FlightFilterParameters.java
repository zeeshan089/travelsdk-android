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

import java.util.Arrays;

/**
 * Filter parameters for a flight search.
 * Documentation: http://wiki.travelsdk.com/index.php?title=Flight_requests#Result_Filters
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

	/**
	 *  Results offset used for pagination.
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	public boolean isDirectOnly() {
		return directOnly;
	}

	/**
	 *  Show only direct flights
	 */
	public void setDirectOnly(boolean directOnly) {
		this.directOnly = directOnly;
	}

	public short getMaxStopsOut() {
		return maxStopsOut;
	}

	/**
	 *  Maximum stops for outbound flight.
	 */
	public void setMaxStopsOut(short maxStopsOut) {
		this.maxStopsOut = maxStopsOut;
	}

	public short getMaxStopsIn() {
		return maxStopsIn;
	}

	/**
	 *  Maximum stops for inbound flight.
	 */
	public void setMaxStopsIn(short maxStopsIn) {
		this.maxStopsIn = maxStopsIn;
	}

	public short getMinOutDepartureTime() {
		return minOutDepartureTime;
	}

	/**
	 *  Minimum outbound flight departure time.
	 */
	public void setMinOutDepartureTime(short minOutDepartureTime) {
		this.minOutDepartureTime = minOutDepartureTime;
	}

	public short getMaxOutDepartureTime() {
		return maxOutDepartureTime;
	}

	/**
	 *  Maximum outbound flight departure time.
	 */
	public void setMaxOutDepartureTime(short maxOutDepartureTime) {
		this.maxOutDepartureTime = maxOutDepartureTime;
	}

	public short getMinInDepartureTime() {
		return minInDepartureTime;
	}

	/**
	 *  Minimum inbound flight departure time.
	 */
	public void setMinInDepartureTime(short minInDepartureTime) {
		this.minInDepartureTime = minInDepartureTime;
	}

	public short getMaxInDepartureTime() {
		return maxInDepartureTime;
	}

	/**
	 *  Maximum inbound flight departure time.
	 */
	public void setMaxInDepartureTime(short maxInDepartureTime) {
		this.maxInDepartureTime = maxInDepartureTime;
	}

	public String[] getAirlineCodes() {
		return airlineCodes;
	}

	/**
	 *  Filter by airlines. (airline[]=AA&airline[]=UAÉ)
	 */
	public void setAirlineCodes(String[] airlineCodes) {
		this.airlineCodes = airlineCodes;
	}

	public float getMinPrice() {
		return minPrice;
	}

	/**
	 *  Minimum price.
	 */
	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	/**
	 *  Maximim price.
	 */
	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String[] getCabinClasses() {
		return cabinClasses;
	}

	/**
	 *  Filter by cabin class. (cabin_class []=Y&cabin_class []=FÉ)
	 */
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
