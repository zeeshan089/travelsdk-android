package com.travelfed.travelsdk.bean.excursion;

import org.json.JSONException;
import org.json.JSONObject;

public class OperatorMargins {
	private String generalFee;
	private String globalMargin;
	private String globalFee;
	private String generalMargin;

	public OperatorMargins(JSONObject json) throws JSONException {
		if (json.has("generalFee")) {
			this.setGeneralFee(json.getString("generalFee"));
		}
		if (json.has("globalMargin")) {
			this.setGlobalMargin(json.getString("globalMargin"));
		}
		if (json.has("globalFee")) {
			this.setGlobalFee(json.getString("globalFee"));
		}
		if (json.has("generalMargin")) {
			this.setGeneralMargin(json.getString("generalMargin"));
		}
	}

	/** @param generalFee */
	public void setGeneralFee(String generalFee) {
		this.generalFee = generalFee;
	}

	/** @return generalFee */
	public String getGeneralFee() {
		return generalFee;
	}

	/** @param globalMargin */
	public void setGlobalMargin(String globalMargin) {
		this.globalMargin = globalMargin;
	}

	/** @return globalMargin */
	public String getGlobalMargin() {
		return globalMargin;
	}

	/** @param globalFee */
	public void setGlobalFee(String globalFee) {
		this.globalFee = globalFee;
	}

	/** @return globalFee */
	public String getGlobalFee() {
		return globalFee;
	}

	/** @param generalMargin */
	public void setGeneralMargin(String generalMargin) {
		this.generalMargin = generalMargin;
	}

	/** @return generalMargin */
	public String getGeneralMargin() {
		return generalMargin;
	}
}