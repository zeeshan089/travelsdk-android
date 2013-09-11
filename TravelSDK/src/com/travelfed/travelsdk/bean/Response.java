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
 * Contains server response
 */
public class Response {

	private Error error;
	private boolean success = true;
	private String protocol;
	private Result result;
	private String resultMessage;
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

	/** @param error */
	public void setError(Error error) {
		this.error = error;
	}

	/** @return error */
	public Error getError() {
		return error;
	}

	/** @param success */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/** @return success */
	public boolean isSuccess() {
		return success;
	}

	/** @param protocol */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/** @return protocol */
	public String getProtocol() {
		return protocol;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public JSONObject getJson() {
		return json;
	}

}