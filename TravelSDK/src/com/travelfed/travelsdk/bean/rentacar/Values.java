package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

public class Values {
	private Values values;

	/* constructors */
	public Values() {
	}

	public Values(Values values) {
		this.setValues(values);
	}

	public Values(JSONObject json) throws JSONException {
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