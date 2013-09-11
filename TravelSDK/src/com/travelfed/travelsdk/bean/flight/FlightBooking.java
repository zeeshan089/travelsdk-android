package com.travelfed.travelsdk.bean.flight;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.Booking;

public class FlightBooking extends Booking {

//	private final static String FARE = "fare";
	//	private final static String TRAVELLERS =  "travellers";
	
	private FlightFare flightFare;

	//	private Vector passengers = new Vector();

	public FlightBooking(JSONObject json) throws JSONException {
		super(json);
		if (json.has(REQUEST)) {
			try {
				JSONArray requestArray = json.getJSONArray(REQUEST);
				JSONObject request = requestArray.getJSONObject(0);
				
//				if(request.has(FARE)) {
//					// This is for compatibility with the old logic which uses flight fare details and flight fare
//					JSONObject fareJson = request.getJSONObject(FARE);
//					setFlightFare(new FlightFare(null, fareJson));			}
//				} else {
					setFlightFare(new FlightFare(null, request));	
//				}
				
			} catch (Exception e) {
				logger.error(e, "flightFare can be null");
			}
		}
	}

	public FlightFare getFlightFare() {
		return flightFare;
	}

	public void setFlightFare(FlightFare flightFare) {
		this.flightFare = flightFare;
	}

	
}
