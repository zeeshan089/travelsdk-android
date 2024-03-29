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

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.Logger;
import com.travelfed.travelsdk.util.StringUtil;

/**
 *  Hotel fare from hotel search results
 */
public class HotelFare {
	
	private HotelsResult hotelsFaresResult;
	
	private String currency;
	private int hotelCategory;
	private double longitude;
	private String distance;
	private double latitude;
	private String boardTypeDescription;
	private String adultPrice;
	private String boardType;
	private String childrenPrice;
	private Date checkin;
	private String picture;
	private String area;
	private String id;
	private String roomName;
	private String country;
	private String roomLocationCode;
	private int duration;
	private String roomType;
	private String info;
	private String totalPrice;
	private Date checkout;
	private String roomLocationDescription;
	private String hotelName;
	private String supplier;

	private final static String CUR = "cur";
	private final static String HCA = "hca";
	private final static String LON = "lon";
	private final static String DISTANCE = "Distance";
	private final static String LAT = "lat";
	private final static String CCA_DESC = "cca_desc";
	private final static String AAM = "aam";
	private final static String CCA = "cca";
	private final static String CAM = "cam";
	private final static String CHECKIN = "checkin";
	private final static String PIC = "pic";
	private final static String AR = "ar";
	private final static String ID = "id";
	private final static String R_NAME = "r_name";
	private final static String CNY = "cny";
	private final static String RLC = "rlc";
	private final static String DUR = "dur";
	private final static String R_TYPE = "r_type";
	private final static String INFO = "info";
	private final static String TAM = "tam";
	private final static String CHECKOUT = "checkout";
	private final static String RLC_DESC = "rlc_desc";
	private final static String HON = "hon";
	private final static String SUPPLIER = "supplier";
	
	private Logger logger = new Logger(HotelFare.class);
	
	
	public HotelFare(HotelsResult hotelsFaresResult, JSONObject json) throws JSONException {
		this.hotelsFaresResult = hotelsFaresResult;
		if (json.has(CUR)) {
			this.setCurrency(json.getString(CUR));
		}
		if (json.has(HCA)) {
			try {
				this.setHotelCategory((int) Float.parseFloat(json.getString(HCA)));
			} catch (NumberFormatException e) {
				logger.error(e);
				logger.error("test boolean " + json.optBoolean(HCA));
			}
		}
		if (json.has(LON)  && !json.isNull(LON)) {
			this.setLongtitude(Double.parseDouble(json.getString(LON)));
		}
		if (json.has(DISTANCE)) {
			this.setDistance(json.getString(DISTANCE));
		}
		if (json.has(LAT) && !json.isNull(LAT)) {
			this.setLatitude(Double.parseDouble(json.getString(LAT)));
		}
		if (json.has(CCA_DESC)) {
			this.setBoardTypeDescription(json.getString(CCA_DESC));
		}
		if (json.has(AAM)) {
			this.setAdultPrice(json.getString(AAM));
		}
		if (json.has(CCA)) {
			this.setBoardType(json.getString(CCA));
		}
		if (json.has(CAM)) {
			this.setChildrenPrice(json.getString(CAM));
		}
		if (json.has(CHECKIN)) {
			this.setCheckin(StringUtil.parseDate(json.getString(CHECKIN)));
		}
		if (json.has(PIC)) {
			this.setPicture(json.getString(PIC));
		}
		if (json.has(AR) && !json.isNull(AR)) {
			this.setArea(json.getString(AR));
		}
		if (json.has(ID)) {
			this.setId(json.getString(ID));
		}
		if (json.has(R_NAME)) {
			this.setRoomName(json.getString(R_NAME));
		}
		if (json.has(CNY)) {
			this.setCountry(json.getString(CNY));
		}
		if (json.has(RLC) && !json.isNull(RLC)) {
			this.setRoomLocationCode(json.getString(RLC));
		}
		if (json.has(DUR) && !json.isNull(DUR) ) {
			this.setDuration(json.getInt(DUR));
		}
		if (json.has(R_TYPE)) {
			this.setRoomType(json.getString(R_TYPE));
		}
		if (json.has(INFO)) {
			this.setInfo(json.getString(INFO));
		}
		if (json.has(TAM)) {
			this.setTotalPrice(json.getString(TAM));
		}
		if (json.has(CHECKOUT)) {
			this.setCheckout(StringUtil.parseDate(json.getString(CHECKOUT)));
		}
		if (json.has(RLC_DESC) && !json.isNull(RLC_DESC)) {
			this.setRoomLocationDescription(json.getString(RLC_DESC));
		}
		if (json.has(HON)) {
			this.setHotelName(json.getString(HON));
		}
		if (json.has(SUPPLIER)) {
			this.setSupplier(json.getString(SUPPLIER));
		}
	}

	/**
	 *  Hotel results from hotel search request
	 */
	public HotelsResult getHotelsFaresResult() {
		return hotelsFaresResult;
	}

	/**
	 *  Currency code
	 */
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 *  Hotel category 0-6
	 */
	public int getHotelCategory() {
		return hotelCategory;
	}

	public void setHotelCategory(int hotelCategory) {
		this.hotelCategory = hotelCategory;
	}

	/**
	 *  Longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	public void setLongtitude(double longtitude) {
		this.longitude = longtitude;
	}

	/**
	 *  Distance in km.
	 */
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		if(distance == null || distance.equals("null")) {
			this.distance = "-";
		} else {
			this.distance = distance;
		}
		this.distance += "km";
	}

	/**
	 *  Latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 *  Board type description
	 */
	public String getBoardTypeDescription() {
		return boardTypeDescription;
	}

	public void setBoardTypeDescription(String boardTypeDescription) {
		if(boardTypeDescription == null || boardTypeDescription.equals("null")) {
			boardTypeDescription = "-";
		}
		this.boardTypeDescription = boardTypeDescription;
	}

	/**
	 *  Price per adult.
	 */
	public String getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(String adultPrice) {
		this.adultPrice = adultPrice;
	}

	/**
	 *  Board type code.
	 */
	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	/**
	 *  Price per child
	 */
	public String getChildrenPrice() {
		return childrenPrice;
	}

	public void setChildrenPrice(String childrenPrice) {
		this.childrenPrice = childrenPrice;
	}

	/**
	 *  Check in date
	 */
	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	/**
	 *  Picture url
	 */
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 *  Room name
	 */
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	/**
	 *  Country code
	 */
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRoomLocationCode() {
		return roomLocationCode;
	}

	public void setRoomLocationCode(String roomLocationCode) {
		this.roomLocationCode = roomLocationCode;
	}

	/**
	 *  Nights.
	 */
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 *  Short information.
	 */
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 *  Total price.
	 */
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public String getRoomLocationDescription() {
		return roomLocationDescription;
	}

	public void setRoomLocationDescription(String roomLocationDescription) {
		this.roomLocationDescription = roomLocationDescription;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelFare other = (HotelFare) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}