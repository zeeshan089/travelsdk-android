/*
 * Copyright (c) 2013, Perennial UG & Co.KG.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * - Neither the name of the Perennial UG & Co.KG nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.travelfed.travelsdk.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Result from verify requests.
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
	 *  Check if supplier requires passport number. From flight verify only.
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
	 *  Check if supplier requires passport details (issue date, expire date). From flight verify only.
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
	 * Cancellation policies. From hotel verify only.
	 * @return
	 */
	public List<CancellationPolicy> getCancellationPolicies() {
		return cancellationPolicies;
	}
	

}
