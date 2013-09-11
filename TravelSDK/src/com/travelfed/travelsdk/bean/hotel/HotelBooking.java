package com.travelfed.travelsdk.bean.hotel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.Booking;

public class HotelBooking extends Booking {
	
	private HotelFare hotelFare;

	public HotelBooking(JSONObject json) throws JSONException {
		super(json);
		if (json.has(REQUEST)) {
			try {
				JSONArray requestArray = json.getJSONArray(REQUEST);
				JSONObject request = requestArray.getJSONObject(0);
				setHotelFare(new HotelFare(null, request));
			} catch (Exception e) {
				logger.error(e, "hotelFare can be null");
			}			
		}
	}

	public HotelFare getHotelFare() {
		return hotelFare;
	}

	public void setHotelFare(HotelFare hotelFare) {
		this.hotelFare = hotelFare;
	}

}
