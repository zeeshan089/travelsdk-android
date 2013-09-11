package com.travelfed.travelsdk.bean.excursion;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Excursion extends Offer {

	private List<Offer> altoffers;
	private ExcursionsResult excursionResult;

	public Excursion(ExcursionsResult excursionResult, JSONObject json) throws JSONException {
		super(json);

		this.excursionResult = excursionResult;
		if (json.has("altoffers")) {
			this.altoffers = new ArrayList<Offer>();
			JSONArray jsonArray = json.getJSONArray("altoffers");
			for (int i = 0; i < jsonArray.length(); i++) {
				Offer elem = new Offer(jsonArray.getJSONObject(i));
				this.altoffers.add(elem);
			}
		}

	}
	
	public ExcursionsResult getExcursionResult() {
		return excursionResult;
	}

	/** @return List with {@link Offer} objects */
	public List<Offer> getAltoffers() {
		return altoffers;
	}

}