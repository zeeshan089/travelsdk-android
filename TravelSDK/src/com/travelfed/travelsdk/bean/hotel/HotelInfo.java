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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *  Hotel information from hotel info result.
 */
public class HotelInfo {
	
	private String info;
	private double longitude;
	private String street;
	private List<InformationContent> informationContents = new ArrayList<InformationContent>();
	private List<String> images = new ArrayList<String>();
	private double latitude;
	private String hotelID;
	private String hotelName;


	public HotelInfo(JSONObject json) throws JSONException {
		if (json.has("Info")) {
			this.setInfo(json.getString("Info"));
		}
		if (json.has("Longitude") && !json.isNull("Longitude")) {
			this.setLongitude(Double.parseDouble(json.getString("Longitude")));
		}
		if (json.has("Street")) {
			this.setStreet(json.getString("Street"));
		}
		if (json.has("Information")) {
			JSONObject informationJson = json.getJSONObject("Information");
			if (informationJson.has("Content")) {
				JSONArray jsonArray = informationJson.getJSONArray("Content");
				for (int i = 0; i < jsonArray.length(); i++) {
					InformationContent elem = new InformationContent(jsonArray.getJSONObject(i));
					this.informationContents.add(elem);
				}
			}
			if (informationJson.has("Image")) {
				try {
					JSONArray jsonArray = informationJson.getJSONArray("Image");
					for (int i = 0; i < jsonArray.length(); i++) {
						String elem = jsonArray.getString(i);
						this.images.add(elem);
					}
				} catch (Exception e) {
					this.images.add(informationJson.getString("Image"));
				}
			}
		}
		if (json.has("Latitude") && !json.isNull("Latitude")) {
			this.setLatitude(Double.parseDouble(json.getString("Latitude")));
		}
		if (json.has("HotelName")) {
			this.setHotelName(json.getString("HotelName"));
		}
	}
	

	/** @param info */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 *  Text information
	 */
	public String getInfo() {
		return info;
	}

	/** @param Longitude */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/** @return Longitude */
	public double getLongitude() {
		return longitude;
	}

	/** @param street */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 *  Address.
	 */
	public String getStreet() {
		return street;
	}

	/** @return Information contents */
	public List<InformationContent> getInformationContents() {
		return informationContents;
	}

	/** @param Latitude */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/** @return Latitude */
	public double getLatitude() {
		return latitude;
	}

	/** @param hotelName */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/** @return hotel name */
	public String getHotelName() {
		return hotelName;
	}


	/**
	 * List with urls of images
	 * @return
	 */
	public List<String> getImages() {
		return images;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotelID == null) ? 0 : hotelID.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelInfo other = (HotelInfo) obj;
		if (hotelID == null) {
			if (other.hotelID != null)
				return false;
		} else if (!hotelID.equals(other.hotelID))
			return false;
		return true;
	}
	
}