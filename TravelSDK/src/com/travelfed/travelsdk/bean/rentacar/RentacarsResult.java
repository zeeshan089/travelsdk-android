package com.travelfed.travelsdk.bean.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.SearchListResult;
import com.travelfed.travelsdk.process.ProcessSearchRentacars;

public class RentacarsResult extends SearchListResult {
	
	private List<Rentacar> rentacars;
	private ProcessSearchRentacars processSearchRentalcars;

	public RentacarsResult(JSONObject json, ProcessSearchRentacars processSearchRentalcars) throws JSONException {
		super(json);
		this.processSearchRentalcars = processSearchRentalcars;
		if (json.has("records")) {
			this.rentacars = new ArrayList<Rentacar>();
			JSONArray jsonArray = json.getJSONArray("records");
			for (int i = 0; i < jsonArray.length(); i++) {
				Rentacar element = new Rentacar(this, jsonArray.getJSONObject(i));
				this.rentacars.add(element);
			}
		}
	}

	/** @return  */
	public List<Rentacar> getRentacars() {
		return rentacars;
	}
	
	/**
	 * @return the processSearchRentalcars
	 */
	public ProcessSearchRentacars getProcessSearchRentalcars() {
		return processSearchRentalcars;
	}
}