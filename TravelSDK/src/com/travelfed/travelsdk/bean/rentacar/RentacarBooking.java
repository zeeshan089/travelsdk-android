package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.Booking;

public class RentacarBooking extends Booking {

	private Rentacar rentalcar;
	private BookingParameter bookingParameter;

	public RentacarBooking(JSONObject json) throws JSONException {
		super(json);
		if (json.has(REQUEST)) {
			try {
				JSONArray requestArray = json.getJSONArray(REQUEST);
				JSONObject request = requestArray.getJSONObject(0);
				setRentalcar(new Rentacar(null, request));
				if(request.has("SessionVars")) {
					JSONObject sessionVars = request.getJSONObject("SessionVars");
					if(sessionVars.has("BookingParameter")) {
						this.setBookingParameter(new BookingParameter(sessionVars.getJSONObject("BookingParameter")));
					}
				} else if(request.has("BookingParameter")) {
					this.setBookingParameter(new BookingParameter(request.getJSONObject("BookingParameter")));
				}
			} catch (Exception e) {
				logger.error(e, "rentalcar will be null");
			}			
		}
	}

	public Rentacar getRentalcar() {
		return rentalcar;
	}

	public void setRentalcar(Rentacar rentalcar) {
		this.rentalcar = rentalcar;
	}

	public BookingParameter getBookingParameter() {
		return bookingParameter;
	}

	public void setBookingParameter(BookingParameter bookingParameter) {
		this.bookingParameter = bookingParameter;
	}

}
