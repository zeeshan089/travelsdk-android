package com.travelfed.travelsdk.bean.flight;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

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

	/** @return lat */
	public String getLat() {
		return lat;
	}

	/** @param lon */
	public void setLon(String lon) {
		this.lon = lon;
	}

	/** @return lon */
	public String getLon() {
		return lon;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

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

	/** @return id */
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
