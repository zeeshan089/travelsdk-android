package com.travelfed.travelsdk.bean.flight;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.SearchListResult;
import com.travelfed.travelsdk.process.ProcessSearchFlights;

public class FlightsResult extends SearchListResult {

	
	public static final String CONTROLE_RT = "rt";
	public static final String CONTROLE_OW = "ow";
	
	private ProcessSearchFlights processSearchFlights;
	private List<FlightFare> fares = new ArrayList<FlightFare>();
	
	public FlightsResult(JSONObject json, ProcessSearchFlights processSearchFlights) throws JSONException  {
		super(json);
		this.processSearchFlights = processSearchFlights;
		if (json.has("records")) {
			JSONArray jsonArray = json.getJSONArray("records");
			for (int i = 0; i < jsonArray.length(); i++) {
				FlightFare elem = new FlightFare(this, jsonArray.getJSONObject(i));
				this.fares.add(elem);
			}
		}
	}

	/**
	 * 
	 * @return List with {@link FlightFare} objects
	 */
	public List<FlightFare> getFares() {
		return fares;
	}

	public boolean isRoundTrip() {
		return this.processSearchFlights.getSearchParameters().isRoundTrip();
	}

	public ProcessSearchFlights getProcessSearchFlights() {
		return processSearchFlights;
	} 
	
}
