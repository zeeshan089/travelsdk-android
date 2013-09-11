package com.travelfed.travelsdk.bean.flight;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.Result;

public class AirportsResult extends Result {

	private List<Airport> airports = new ArrayList<Airport>();

	public AirportsResult(JSONObject json) throws JSONException {
		super(json);
		if (json.has("records")) {
			JSONArray recordsArray = json.getJSONArray("records");
			for (int i = 0; i < recordsArray.length(); i++) {
				airports.add(new Airport(recordsArray.getJSONObject(i)));
			}
		}
	}

	/**
	 * 
	 * @return founded airports
	 */
	public List<Airport> getAirports() {
		return airports;
	}

}
