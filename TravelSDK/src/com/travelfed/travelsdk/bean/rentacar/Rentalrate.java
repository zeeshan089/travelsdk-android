package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

public class Rentalrate {
	private VehicleCharges VehicleCharges;
	private RateDistance RateDistance;

	/* constructors */
	public Rentalrate() {
	}

	public Rentalrate(VehicleCharges VehicleCharges, RateDistance RateDistance) {
		this.setVehicleCharges(VehicleCharges);
		this.setRateDistance(RateDistance);
	}

	public Rentalrate(JSONObject json) throws JSONException {
		if (json.has("VehicleCharges")) {
			this.setVehicleCharges(new VehicleCharges(json.getJSONObject("VehicleCharges")));
		}
		if (json.has("RateDistance")) {
			this.setRateDistance(new RateDistance(json.getJSONObject("RateDistance")));
		}
	}

	/** @param VehicleCharges */
	public void setVehicleCharges(VehicleCharges VehicleCharges) {
		this.VehicleCharges = VehicleCharges;
	}

	/** @return VehicleCharges */
	public VehicleCharges getVehicleCharges() {
		return VehicleCharges;
	}

	/** @param RateDistance */
	public void setRateDistance(RateDistance RateDistance) {
		this.RateDistance = RateDistance;
	}

	/** @return RateDistance */
	public RateDistance getRateDistance() {
		return RateDistance;
	}
}