package com.travelfed.travelsdk.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class for verify result.
 * 
 * @author krumstoilov
 *
 */
public class VerifyResult extends Result {

	// for flight booking
	private boolean requiredPassport = false;
	private boolean requiredPassportDetails = false;
	
	// for hotel booking
	private List<CancellationPolicy> cancellationPolicies = new ArrayList<CancellationPolicy>();
	
	public VerifyResult(JSONObject json) throws JSONException {
		super(json);
		if(json.has("BookingParameter")) {
			JSONObject bookingParameter = json.getJSONObject("BookingParameter");
			if(bookingParameter.has("requirements")) {
				JSONObject requirementsJson = bookingParameter.getJSONObject("requirements");
				if(requirementsJson.has("PassportNoRequired")) { // passport number
					setRequiredPassport(requirementsJson.getBoolean("PassportNoRequired"));
					if(requiredPassport && requirementsJson.has("PassportDetailsRequired")) {
						setRequiredPassportDetails(requirementsJson.getBoolean("PassportDetailsRequired"));
					}
				}				
			}			
		}
		if(json.has("records")) {
			// get cancellation policies for hotel booking
			JSONArray cancellationPolliciesJson = json.getJSONArray("records").getJSONObject(0).optJSONArray("cancelationpolicies");
			if(cancellationPolliciesJson != null && cancellationPolliciesJson.length() > 0) {
				if(cancellationPolliciesJson.optJSONArray(0) != null) { // Bug in some providers ws implementation, so we need to for check array in array 
					cancellationPolliciesJson = cancellationPolliciesJson.optJSONArray(0);
				}
				for(int i=0; i< cancellationPolliciesJson.length(); i++) {
					cancellationPolicies.add(new CancellationPolicy(cancellationPolliciesJson.getJSONObject(i)));
				}
			}
		}
		
	}

	/**
	 * For flight booking only
	 * @return
	 */
	public boolean isRequiredPassport() {
		return requiredPassport;
	}

	/**
	 * For flight booking only
	 * @param requiredPassport
	 */
	public void setRequiredPassport(boolean requiredPassport) {
		this.requiredPassport = requiredPassport;
	}

	/**
	 * For flight booking only
	 * @return
	 */
	public boolean isRequiredPassportDetails() {
		return requiredPassportDetails;
	}

	/**
	 * For flight booking only
	 * @param requiredPassportDetails
	 */
	public void setRequiredPassportDetails(boolean requiredPassportDetails) {
		this.requiredPassportDetails = requiredPassportDetails;
	}

	/**
	 * Cancellation policies for hotel booking 
	 * @return
	 */
	public List<CancellationPolicy> getCancellationPolicies() {
		return cancellationPolicies;
	}
	

}
