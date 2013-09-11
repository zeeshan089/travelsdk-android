package com.travelfed.travelsdk.bean.hotel;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.SearchListResult;
import com.travelfed.travelsdk.process.ProcessSearchHotels;

public class HotelsResult extends SearchListResult {
	
	private final static String RECORDS = "records";
	
	private ProcessSearchHotels processSearchHotels;
	private List<HotelFare> hotelsFares = new ArrayList<HotelFare>();
	
	public HotelsResult(JSONObject json, ProcessSearchHotels processSearchHotels) throws JSONException  {
		super(json);
		this.processSearchHotels = processSearchHotels;
		if (json.has(RECORDS)) {
			JSONArray jsonArray = json.getJSONArray(RECORDS);
			for (int i = 0; i < jsonArray.length(); i++) {
				HotelFare elem = new HotelFare(this, jsonArray.getJSONObject(i));
				this.hotelsFares.add(elem);
			}
		}
	}

	/**
	 * 
	 * @return List with {@link HotelFare} objects
	 */
	public List<HotelFare> getHotelsFares() {
		return hotelsFares;
	}

	public ProcessSearchHotels getProcessSearchHotels() {
		return processSearchHotels;
	}
	
}
