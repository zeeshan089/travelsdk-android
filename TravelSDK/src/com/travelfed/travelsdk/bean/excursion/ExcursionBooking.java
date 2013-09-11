package com.travelfed.travelsdk.bean.excursion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.Booking;

public class ExcursionBooking extends Booking {
	
	private Excursion excursion;

	public ExcursionBooking(JSONObject json) throws JSONException {
		super(json);
		if (json.has(REQUEST)) {
			try {
				JSONArray requestArray = json.getJSONArray(REQUEST);
				JSONObject request = requestArray.getJSONObject(0);
				setExcursion(new Excursion(null, request));
			} catch (Exception e) {
				logger.error(e, "flightFare can be null");
			}
		}
	}
	

	public Excursion getExcursion() {
		return excursion;
	}

	public void setExcursion(Excursion excursion) {
		this.excursion = excursion;
	}
}
