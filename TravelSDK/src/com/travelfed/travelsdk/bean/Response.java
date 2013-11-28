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

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.excursion.ExcursionsResult;
import com.travelfed.travelsdk.bean.flight.AirportsResult;
import com.travelfed.travelsdk.bean.flight.FlightsResult;
import com.travelfed.travelsdk.bean.hotel.HotelInfoResult;
import com.travelfed.travelsdk.bean.hotel.HotelsResult;
import com.travelfed.travelsdk.bean.rentacar.RentacarsResult;
import com.travelfed.travelsdk.process.ProcessAgencyInfo;
import com.travelfed.travelsdk.process.ProcessBooking;
import com.travelfed.travelsdk.process.ProcessBookingsList;
import com.travelfed.travelsdk.process.ProcessHotelInfo;
import com.travelfed.travelsdk.process.ProcessLogin;
import com.travelfed.travelsdk.process.ProcessSearchAirports;
import com.travelfed.travelsdk.process.ProcessSearchExcursions;
import com.travelfed.travelsdk.process.ProcessSearchFlights;
import com.travelfed.travelsdk.process.ProcessSearchHotels;
import com.travelfed.travelsdk.process.ProcessSearchRentacars;
import com.travelfed.travelsdk.process.ProcessSettingsResult;
import com.travelfed.travelsdk.process.ProcessVerify;
import com.travelfed.travelsdk.process.ProcessWS;

/**
 * Response from WS request.
 */
public class Response {

	private Error error;
	private boolean success = true;
	private String protocol;
	private Result result;
	private JSONObject json;

	public Response(JSONObject json, ProcessWS<? extends Result> processResult) throws JSONException {
		this.json = json;
		if (json.has("protocol")) {
			this.setProtocol(json.getString("protocol"));
		}
		if (json.has("success")) {
			this.setSuccess(json.getBoolean("success"));
		}
		if (!success) {
			if (json.has("error")) {
				try {
					this.setError(new Error(json.getJSONObject("error")));
				} catch (JSONException je) {
					setError(new Error(json.getString("error")));
				}
			} else {
				setError(new Error());
			}
			return;
		}
		if (processResult instanceof ProcessBooking) {
			this.setResult(new BookingResult(json));
		} else if (json.has("result")) {
			if (processResult instanceof ProcessSearchFlights) {
				ProcessSearchFlights processSearchFlights = (ProcessSearchFlights) processResult;
				this.setResult(new FlightsResult(json.getJSONObject("result"), processSearchFlights));
			} else if (processResult instanceof ProcessSearchHotels) {
				ProcessSearchHotels processSearchHotels = (ProcessSearchHotels) processResult;
				this.setResult(new HotelsResult(json.getJSONObject("result"), processSearchHotels));
			} else if (processResult instanceof ProcessHotelInfo) {
				ProcessHotelInfo processHotelInfo = (ProcessHotelInfo) processResult;
				this.setResult(new HotelInfoResult(json.getJSONObject("result"), processHotelInfo));
			} else if (processResult instanceof ProcessSearchRentacars) {
				ProcessSearchRentacars processSearchRentalcars = (ProcessSearchRentacars) processResult;
				this.setResult(new RentacarsResult(json.getJSONObject("result"), processSearchRentalcars));
			} else if (processResult instanceof ProcessBookingsList) {
				this.setResult(new BookingListResult(json));
			} else if (processResult instanceof ProcessAgencyInfo) {
				this.setResult(new AgencyInfoResult(json.getJSONObject("result")));
			} else if (processResult instanceof ProcessSettingsResult) {
				this.setResult(new SettingsResult(json.getJSONObject("result")));
			} else if (processResult instanceof ProcessVerify) {
				this.setResult(new VerifyResult(json.getJSONObject("result")));
			} else if (processResult instanceof ProcessLogin) {
				this.setResult(new LoginResult(json.getJSONObject("result")));
			} else if (processResult instanceof ProcessSearchExcursions) {
				this.setResult(new ExcursionsResult(json.getJSONObject("result")));
			} else if(processResult instanceof ProcessSearchAirports) {
				this.setResult(new AirportsResult(json.getJSONObject("result")));
			}
		}
	}

	public void setError(Error error) {
		this.error = error;
	}

	/**
	 *  Error object if response isn't successful.
	 */
	public Error getError() {
		return error;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 *  Check for successful response.
	 */
	public boolean isSuccess() {
		return success;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 *  Protocol version
	 */
	public String getProtocol() {
		return protocol;
	}

	/**
	 *  Result object parsed from JSON response.
	 */
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	/**
	 *  Result JSON.
	 */
	public JSONObject getJson() {
		return json;
	}

}