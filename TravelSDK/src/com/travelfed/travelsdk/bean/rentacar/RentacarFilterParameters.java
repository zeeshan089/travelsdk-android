package com.travelfed.travelsdk.bean.rentacar;

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

	public void setOffset(int offset) {
		this.offset = offset;
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

	public int getMinPassengers() {
		return minPassengers;
	}

	public void setMinPassengers(int minPassengers) {
		this.minPassengers = minPassengers;
	}

	public int getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public boolean isAutomatic() {
		return automatic;
	}

	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	public boolean isAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(boolean airConditioner) {
		this.airConditioner = airConditioner;
	}

	public boolean isUnlimited() {
		return unlimited;
	}

	public void setUnlimited(boolean unlimited) {
		this.unlimited = unlimited;
	}

	public String[] getStationCodes() {
		return stationCodes;
	}

	public void setStationCodes(String[] stationCodes) {
		this.stationCodes = stationCodes;
	}

	public String[] getVendorCodes() {
		return vendorCodes;
	}

	public void setVendorCodes(String[] vendorCodes) {
		this.vendorCodes = vendorCodes;
	}

	public String[] getCities() {
		return cities;
	}

	public void setCities(String[] cities) {
		this.cities = cities;
	}

}
