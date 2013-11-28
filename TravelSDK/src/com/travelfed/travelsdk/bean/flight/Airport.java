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

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Airport from airport search result.
 */
public class Airport implements Serializable {
	
	private static final long serialVersionUID = 1848328345976113304L;
	
	private String city;
	private String lat;
	private String lon;
	private String country;
	private String airportName;
	private String id;

	public Airport() {
	}

	public Airport(JSONObject json) throws JSONException {
		if (json.has("city")) {
			this.setCity(json.getString("city"));
		}
		if (json.has("lat")) {
			this.setLat(json.getString("lat"));
		}
		if (json.has("lon")) {
			this.setLon(json.getString("lon"));
		}
		if (json.has("country")) {
			this.setCountry(json.getString("country"));
		}
		if (json.has("airport_name")) {
			this.setAirportName(json.getString("airport_name"));
		}
		if (json.has("id")) {
			this.setId(json.getString("id"));
		}
	}

	/**
	 *  City name
	 */
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	/** @param lat */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 *  Latitude
	 */
	public String getLat() {
		return lat;
	}

	/** @param lon */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/**
	 *  Longitude
	 */
	public String getLon() {
		return lon;
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

	/**
	 *  Airport name
	 */
	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	/** @param id */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 *  Airport code (3-letter)
	 */
	public String getId() {
		return id;
	}

	public String toString() {
		if (this.airportName == null) {
			return this.id;
		}
		return this.airportName + " (" + this.id + ")";
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
		Airport other = (Airport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
