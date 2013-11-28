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

/**
 *  Parameters to filter a rentacar search.
 *  Documentation: http://wiki.travelsdk.com/index.php?title=Rentacar_requests#Result_Filters_and_Sorting
 */
public class RentacarFilterParameters {

	private float minPrice = -1;
	private float maxPrice = -1;
	private int minPassengers = -1;
	private int maxPassengers = -1;
	private boolean automatic;
	private boolean airConditioner;
	private boolean unlimited;
	private String[] stationCodes;
	private String[] vendorCodes;
	private String[] cities;
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

	public int getMinPassengers() {
		return minPassengers;
	}

	/**
	 *  Minimum passengers.
	 */
	public void setMinPassengers(int minPassengers) {
		this.minPassengers = minPassengers;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	/**
	 *  Maximim passengers.
	 */
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public boolean isAutomatic() {
		return automatic;
	}

	/**
	 *  Filter only automatic cars.
	 */
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	public boolean isAirConditioner() {
		return airConditioner;
	}

	/**
	 *  Filter only cars with air conditioner.
	 */
	public void setAirConditioner(boolean airConditioner) {
		this.airConditioner = airConditioner;
	}

	public boolean isUnlimited() {
		return unlimited;
	}

	/**
	 *  Filter only cars with unlimited mileage.
	 */
	public void setUnlimited(boolean unlimited) {
		this.unlimited = unlimited;
	}

	public String[] getStationCodes() {
		return stationCodes;
	}

	/**
	 *  Filter by station code(s). Array of NSString objects.
	 */
	public void setStationCodes(String[] stationCodes) {
		this.stationCodes = stationCodes;
	}

	public String[] getVendorCodes() {
		return vendorCodes;
	}

	/**
	 *  FIlter by vendor code(s). Array of NSString objects.
	 */
	public void setVendorCodes(String[] vendorCodes) {
		this.vendorCodes = vendorCodes;
	}

	public String[] getCities() {
		return cities;
	}

	/**
	 *  Filter by city(es). Array of NSString objects.
	 */
	public void setCities(String[] cities) {
		this.cities = cities;
	}

}
