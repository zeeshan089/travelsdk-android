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
package com.travelfed.travelsdk.bean.flight;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.SearchListResult;
import com.travelfed.travelsdk.process.ProcessSearchFlights;

/**
 *  Results from searchFlights or getSearchFlightsResults
 */
public class FlightsResult extends SearchListResult {

	
	public static final String CONTROLE_RT = "rt";
	public static final String CONTROLE_OW = "ow";
	
	private ProcessSearchFlights processSearchFlights;
	private List<FlightFare> fares = new ArrayList<FlightFare>();
	
	public FlightsResult(JSONObject json, ProcessSearchFlights processSearchFlights) throws JSONException  {
		super(json);
		this.processSearchFlights = processSearchFlights;
		if (json.has("records")) {
			JSONArray jsonArray = json.getJSONArray("records");
			for (int i = 0; i < jsonArray.length(); i++) {
				FlightFare elem = new FlightFare(this, jsonArray.getJSONObject(i));
				this.fares.add(elem);
			}
		}
	}

	/**
	 * 
	 * @return List with {@link FlightFare} objects
	 */
	public List<FlightFare> getFares() {
		return fares;
	}

	/**
	 *  Check if search is for round trip
	 *
	 *  @return true if round trip.
	 */
	public boolean isRoundTrip() {
		return this.processSearchFlights.getSearchParameters().isRoundTrip();
	}

	/**
	 *  Process search flights object.
	 */
	public ProcessSearchFlights getProcessSearchFlights() {
		return processSearchFlights;
	} 
	
}
