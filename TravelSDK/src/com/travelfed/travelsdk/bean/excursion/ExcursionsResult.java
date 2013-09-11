package com.travelfed.travelsdk.bean.excursion;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.SearchListResult;

public class ExcursionsResult extends SearchListResult {

	private List<Excursion> excursions;
	private String expire;

	public ExcursionsResult(JSONObject json) throws JSONException {
		super(json);

		if (json.has("records")) {
			this.excursions = new ArrayList<Excursion>();
			JSONArray jsonArray = json.getJSONArray("records");
			for (int i = 0; i < jsonArray.length(); i++) {
				Excursion elem = new Excursion(this, jsonArray.getJSONObject(i));
				this.excursions.add(elem);
			}
		}
		if (json.has("expire")) {
			this.setExpire(json.getString("expire"));
		}
	}

	/** @return List with {@link Excursion} objects */
	public List<Excursion> getExcursions() {
		return excursions;
	}

	/** @param expire */
	public void setExpire(String expire) {
		this.expire = expire;
	}

	/** @return expire */
	public String getExpire() {
		return expire;
	}


}