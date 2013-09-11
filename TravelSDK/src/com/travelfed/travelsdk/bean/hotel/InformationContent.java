package com.travelfed.travelsdk.bean.hotel;

import org.json.JSONException;
import org.json.JSONObject;

public class InformationContent {
	private String element;
	private String node;

	/* constructors */
	public InformationContent(String element, String node) {
		this.element = element;
		this.node = node;
	}

	public InformationContent(JSONObject json) throws JSONException {
		if (json.has("Element")) {
			this.setElement(json.getString("Element"));
		}
		if (json.has("Node")) {
			this.setNode(json.getString("Node"));
		}
	}

	/** @param Element */
	public void setElement(String element) {
		this.element = element;
	}

	/** @return Element */
	public String getElement() {
		return element;
	}

	/** @param Node */
	public void setNode(String node) {
		this.node = node;
	}

	/** @return Node */
	public String getNode() {
		return node;
	}
	
	public String toString() {
		if(this.node == null) {
			return "";
		}
		return this.node;
	}
}