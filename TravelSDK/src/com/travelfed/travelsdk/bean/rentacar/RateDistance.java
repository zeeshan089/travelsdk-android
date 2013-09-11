package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

public class RateDistance {
	private Values values;

	/* constructors */
	public RateDistance() {
	}

	public RateDistance(Values values) {
		this.setValues(values);
	}

	public RateDistance(JSONObject json) throws JSONException {
		if (json.has("values")) {
			this.setValues(new Values(json.getJSONObject("values")));
		}
	}

	/** @param values */
	public void setValues(Values values) {
		this.values = values;
	}

	/** @return values */
	public Values getValues() {
		return values;
	}
}