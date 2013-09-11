package com.travelfed.travelsdk.bean.flight;

import org.json.JSONException;
import org.json.JSONObject;

public class Carrier {
	
	private String ident;
	private String declaration;

	public Carrier(JSONObject json) throws JSONException {
		if (json.has("ident")) {
			this.setIdent(json.getString("ident"));
		}
		if (json.has("declaration")) {
			this.setDeclaration(json.getString("declaration"));
		}
	}


	/** @param ident */
	public void setIdent(String ident) {
		this.ident = ident;
	}

	/** @return ident */
	public String getIdent() {
		return ident;
	}

	/** @param declaration */
	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

	/** @return declaration */
	public String getDeclaration() {
		return declaration;
	}
}