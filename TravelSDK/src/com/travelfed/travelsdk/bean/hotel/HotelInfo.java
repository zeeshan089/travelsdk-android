package com.travelfed.travelsdk.bean.hotel;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


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

	/** @return info */
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

	/** @return street */
	public String getStreet() {
		return street;
	}

	/** @return Information */
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

	/** @return hotelName */
	public String getHotelName() {
		return hotelName;
	}


	/**
	 * List with urls
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