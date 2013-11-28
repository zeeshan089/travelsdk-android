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

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

/**
 * Base class for excursion and altoffers
 * 
 */
public class Offer {

	private String searchingState;
	private String lon;
	private String uid;
	private String optionType;
	private String ar;
	private String cur;
	private String cname;
	private String productType;
	private String cid;
	private String availability;
	private String infantPrice;
	private Date toDate;
	private String minChildAge;
	private String name;
	private String description;
	private String sup;
	private String otam;
	private String childPrice;
	private BookingParameter bookingParameter;
	private String bestValue;
	private String city;
	private String cny;
	private String optionID;
	private String maxUnits;
	private String adultPrice;
	private String searchingCity;
	private String starsLevel;
	private String optionName;
	private String aid;
	private String optionTypeDescr;
	private Date fromDate;
	private String duration;
	private String stateCode;
	private String map;
	private String transaction;
	private String status;
	private String continent;
	private String lat;
	private String reservationId;
	private String id;
	private String countryCode;
	private String pic;
	private String maxChildren;
	private String ws_session;
	private String thumb;
	private String totalPrice;
	private String oid;
	private String maxChildAge;
	private String address;
	private String provider;
	private String unitPrice;
	private String supplier;
	private String maxAdults;
	private String type;

	public Offer(JSONObject json) throws JSONException {
		if (json.has("searchingState")) {
			this.setSearchingState(json.getString("searchingState"));
		}
		if (json.has("lon")) {
			this.setLon(json.getString("lon"));
		}
		if (json.has("uid")) {
			this.setUid(json.getString("uid"));
		}
		if (json.has("optionType")) {
			this.setOptionType(json.getString("optionType"));
		}
		if (json.has("ar")) {
			this.setAr(json.getString("ar"));
		}
		if (json.has("cur")) {
			this.setCur(json.getString("cur"));
		}
		if (json.has("cname")) {
			this.setCname(json.getString("cname"));
		}
		if (json.has("productType")) {
			this.setProductType(json.getString("productType"));
		}
		if (json.has("cid")) {
			this.setCid(json.getString("cid"));
		}
		if (json.has("availability")) {
			this.setAvailability(json.getString("availability"));
		}
		if (json.has("infantPrice")) {
			this.setInfantPrice(json.getString("infantPrice"));
		}
		if (json.has("toDate")) {
			String sDate = json.getString("toDate");
			this.setToDate(StringUtil.parseDate(sDate));
		}
		if (json.has("minChildAge")) {
			this.setMinChildAge(json.getString("minChildAge"));
		}
		if (json.has("name")) {
			this.setName(json.getString("name"));
		}
		if (json.has("description")) {
			this.setDescription(json.getString("description"));
		}
		if (json.has("sup")) {
			this.setSup(json.getString("sup"));
		}
		if (json.has("otam")) {
			this.setOtam(json.getString("otam"));
		}
		if (json.has("childPrice")) {
			this.setChildPrice(json.getString("childPrice"));
		}
		if (json.has("bookingParameter")) {
			this.setBookingParameter(new BookingParameter(json.getJSONObject("bookingParameter")));
		}
		if (json.has("bestValue")) {
			this.setBestValue(json.getString("bestValue"));
		}
		if (json.has("city")) {
			this.setCity(json.getString("city"));
		}
		if (json.has("cny")) {
			this.setCny(json.getString("cny"));
		}
		if (json.has("optionID")) {
			this.setOptionID(json.getString("optionID"));
		}
		if (json.has("maxUnits")) {
			this.setMaxUnits(json.getString("maxUnits"));
		}
		if (json.has("adultPrice")) {
			this.setAdultPrice(json.getString("adultPrice"));
		}
		if (json.has("searchingCity")) {
			this.setSearchingCity(json.getString("searchingCity"));
		}
		if (json.has("starsLevel")) {
			this.setStarsLevel(json.getString("starsLevel"));
		}
		if (json.has("optionName")) {
			this.setOptionName(json.getString("optionName"));
		}
		if (json.has("aid")) {
			this.setAid(json.getString("aid"));
		}
		if (json.has("optionTypeDescr")) {
			this.setOptionTypeDescr(json.getString("optionTypeDescr"));
		}
		if (json.has("fromDate")) {
			String sDate = json.getString("fromDate");
			this.setFromDate(StringUtil.parseDate(sDate));
		}
		if (json.has("duration")) {
			this.setDuration(json.getString("duration"));
		}
		if (json.has("stateCode")) {
			this.setStateCode(json.getString("stateCode"));
		}
		if (json.has("map")) {
			this.setMap(json.getString("map"));
		}
		if (json.has("transaction")) {
			this.setTransaction(json.getString("transaction"));
		}
		if (json.has("status")) {
			this.setStatus(json.getString("status"));
		}
		if (json.has("continent")) {
			this.setContinent(json.getString("continent"));
		}
		if (json.has("lat")) {
			this.setLat(json.getString("lat"));
		}
		if (json.has("reservationId")) {
			this.setReservationId(json.getString("reservationId"));
		}
		if (json.has("id")) {
			this.setId(json.getString("id"));
		}
		if (json.has("countryCode")) {
			this.setCountryCode(json.getString("countryCode"));
		}
		if (json.has("pic")) {
			this.setPic(json.getString("pic"));
		}
		if (json.has("maxChildren")) {
			this.setMaxChildren(json.getString("maxChildren"));
		}
		if (json.has("ws_session")) {
			this.setWs_session(json.getString("ws_session"));
		}
		if (json.has("thumb")) {
			this.setThumb(json.getString("thumb"));
		}
		if (json.has("totalPrice")) {
			this.setTotalPrice(json.getString("totalPrice"));
		}
		if (json.has("oid")) {
			this.setOid(json.getString("oid"));
		}
		if (json.has("maxChildAge")) {
			this.setMaxChildAge(json.getString("maxChildAge"));
		}
		if (json.has("address")) {
			this.setAddress(json.getString("address"));
		}
		if (json.has("provider")) {
			this.setProvider(json.getString("provider"));
		}
		if (json.has("unitPrice")) {
			this.setUnitPrice(json.getString("unitPrice"));
		}
		if (json.has("supplier")) {
			this.setSupplier(json.getString("supplier"));
		}
		if (json.has("maxAdults")) {
			this.setMaxAdults(json.getString("maxAdults"));
		}
		if (json.has("type")) {
			this.setType(json.getString("type"));
		}
	}

	/** @param searchingState */
	public void setSearchingState(String searchingState) {
		this.searchingState = searchingState;
	}

	/** @return searchingState */
	public String getSearchingState() {
		return searchingState;
	}

	/** @param longitude */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/**
	 *  Longitude
	 */
	public String getLon() {
		return lon;
	}

	/** @param uid */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/** @return uid */
	public String getUid() {
		return uid;
	}

	/** @param optionType */
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	/** @return optionType */
	public String getOptionType() {
		return optionType;
	}

	/** @param ar */
	public void setAr(String ar) {
		this.ar = ar;
	}

	/** @return ar */
	public String getAr() {
		return ar;
	}

	/** @param cur */
	public void setCur(String cur) {
		this.cur = cur;
	}

	/**
	 *  Currency code
	 */
	public String getCur() {
		return cur;
	}

	/** @param cname */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 *  Same as productType(sightseeing, museum, attraction, ...)
	 */
	public String getCname() {
		return cname;
	}

	/** @param productType */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 *  Product type (sightseeing, museum, attraction, ...)
	 */
	public String getProductType() {
		return productType;
	}

	/** @param cid */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/** @return cid */
	public String getCid() {
		return cid;
	}

	/** @param availability */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/** @return availability */
	public String getAvailability() {
		return availability;
	}

	/** @param infantPrice */
	public void setInfantPrice(String infantPrice) {
		this.infantPrice = infantPrice;
	}

	/** @return infantPrice */
	public String getInfantPrice() {
		return infantPrice;
	}

	/** @param toDate */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/** @return toDate */
	public Date getToDate() {
		return toDate;
	}

	/** @param minChildAge */
	public void setMinChildAge(String minChildAge) {
		this.minChildAge = minChildAge;
	}

	/** @return minChildAge */
	public String getMinChildAge() {
		return minChildAge;
	}

	/** @param name */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  Short excursion name
	 */
	public String getName() {
		return name;
	}

	/** @param description */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 *  Full excursion description.
	 */
	public String getDescription() {
		return description;
	}

	/** @param sup */
	public void setSup(String sup) {
		this.sup = sup;
	}

	/** @return sup */
	public String getSup() {
		return sup;
	}

	/** @param otam */
	public void setOtam(String otam) {
		this.otam = otam;
	}

	/** @return otam */
	public String getOtam() {
		return otam;
	}

	/**
	 *  Price per child
	 */
	public void setChildPrice(String childPrice) {
		this.childPrice = childPrice;
	}

	/** @return childPrice */
	public String getChildPrice() {
		return childPrice;
	}

	/** @param bookingParameter */
	public void setBookingParameter(BookingParameter bookingParameter) {
		this.bookingParameter = bookingParameter;
	}

	/** @return bookingParameter */
	public BookingParameter getBookingParameter() {
		return bookingParameter;
	}

	/** @param bestValue */
	public void setBestValue(String bestValue) {
		this.bestValue = bestValue;
	}

	/** @return bestValue */
	public String getBestValue() {
		return bestValue;
	}

	/** @param city */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 *  City
	 */
	public String getCity() {
		return city;
	}

	/** @param cny */
	public void setCny(String cny) {
		this.cny = cny;
	}

	/** @return cny */
	public String getCny() {
		return cny;
	}

	/** @param optionID */
	public void setOptionID(String optionID) {
		this.optionID = optionID;
	}

	/** @return optionID */
	public String getOptionID() {
		return optionID;
	}

	/** @param maxUnits */
	public void setMaxUnits(String maxUnits) {
		this.maxUnits = maxUnits;
	}

	/** @return maxUnits */
	public String getMaxUnits() {
		return maxUnits;
	}

	/** @param adultPrice */
	public void setAdultPrice(String adultPrice) {
		this.adultPrice = adultPrice;
	}

	/**
	 *  Price per adult
	 */
	public String getAdultPrice() {
		return adultPrice;
	}

	/** @param searchingCity */
	public void setSearchingCity(String searchingCity) {
		this.searchingCity = searchingCity;
	}

	/** @return searchingCity */
	public String getSearchingCity() {
		return searchingCity;
	}

	/** @param starsLevel */
	public void setStarsLevel(String starsLevel) {
		this.starsLevel = starsLevel;
	}

	/** @return starsLevel */
	public String getStarsLevel() {
		return starsLevel;
	}

	/** @param optionName */
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	/** @return optionName */
	public String getOptionName() {
		return optionName;
	}

	/** @param aid */
	public void setAid(String aid) {
		this.aid = aid;
	}

	/** @return aid */
	public String getAid() {
		return aid;
	}

	/** @param optionTypeDescr */
	public void setOptionTypeDescr(String optionTypeDescr) {
		this.optionTypeDescr = optionTypeDescr;
	}

	/** @return optionTypeDescr */
	public String getOptionTypeDescr() {
		return optionTypeDescr;
	}

	/** @param fromDate */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/** @return fromDate */
	public Date getFromDate() {
		return fromDate;
	}

	/** @param duration */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/** @return duration */
	public String getDuration() {
		return duration;
	}

	/** @param stateCode */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/** @return stateCode */
	public String getStateCode() {
		return stateCode;
	}

	/** @param map */
	public void setMap(String map) {
		this.map = map;
	}

	/** @return map */
	public String getMap() {
		return map;
	}

	/** @param transaction */
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	/** @return transaction */
	public String getTransaction() {
		return transaction;
	}

	/** @param status */
	public void setStatus(String status) {
		this.status = status;
	}

	/** @return status */
	public String getStatus() {
		return status;
	}

	/** @param continent */
	public void setContinent(String continent) {
		this.continent = continent;
	}

	/** @return continent */
	public String getContinent() {
		return continent;
	}

	/** @param lat */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/** @return lat */
	public String getLat() {
		return lat;
	}

	/** @param reservationId */
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	/** @return reservationId */
	public String getReservationId() {
		return reservationId;
	}

	/** @param id */
	public void setId(String id) {
		this.id = id;
	}

	/** @return id */
	public String getId() {
		return id;
	}

	/** @param countryCode */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/** @return countryCode */
	public String getCountryCode() {
		return countryCode;
	}

	/** @param pic */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/** @return pic */
	public String getPic() {
		return pic;
	}

	/** @param maxChildren */
	public void setMaxChildren(String maxChildren) {
		this.maxChildren = maxChildren;
	}

	/** @return maxChildren */
	public String getMaxChildren() {
		return maxChildren;
	}

	/** @param ws_session */
	public void setWs_session(String ws_session) {
		this.ws_session = ws_session;
	}

	/** @return ws_session */
	public String getWs_session() {
		return ws_session;
	}

	/** @param thumb */
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	/**
	 *  Thumb image url
	 */
	public String getThumb() {
		return thumb;
	}

	/** @param totalPrice */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	/** @return totalPrice */
	public String getTotalPrice() {
		return totalPrice;
	}

	/** @param oid */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/** @return oid */
	public String getOid() {
		return oid;
	}

	/** @param maxChildAge */
	public void setMaxChildAge(String maxChildAge) {
		this.maxChildAge = maxChildAge;
	}

	/** @return maxChildAge */
	public String getMaxChildAge() {
		return maxChildAge;
	}

	/** @param address */
	public void setAddress(String address) {
		this.address = address;
	}

	/** @return address */
	public String getAddress() {
		return address;
	}

	/** @param provider */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/** @return provider */
	public String getProvider() {
		return provider;
	}

	/** @param unitPrice */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/** @return unitPrice */
	public String getUnitPrice() {
		return unitPrice;
	}

	/** @param supplier */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/** @return supplier */
	public String getSupplier() {
		return supplier;
	}

	/** @param maxAdults */
	public void setMaxAdults(String maxAdults) {
		this.maxAdults = maxAdults;
	}

	/** @return maxAdults */
	public String getMaxAdults() {
		return maxAdults;
	}

	/** @param type */
	public void setType(String type) {
		this.type = type;
	}

	/** @return type */
	public String getType() {
		return type;
	}
}