package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

public class VehicleCharges {
	private VehicleCharge VehicleCharge;

	/* constructors */
	public VehicleCharges() {
	}

	public VehicleCharges(VehicleCharge VehicleCharge) {
		this.setVehicleCharge(VehicleCharge);
	}

	public VehicleCharges(JSONObject json) throws JSONException {
		if (json.has("VehicleCharge")) {
			this.setVehicleCharge(new VehicleCharge(json.getJSONObject("VehicleCharge")));
		}
	}

	/** @param VehicleCharge */
	public void setVehicleCharge(VehicleCharge VehicleCharge) {
		this.VehicleCharge = VehicleCharge;
	}

	/** @return VehicleCharge */
	public VehicleCharge getVehicleCharge() {
		return VehicleCharge;
	}
}