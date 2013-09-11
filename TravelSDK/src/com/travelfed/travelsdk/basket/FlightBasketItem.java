package com.travelfed.travelsdk.basket;

import com.travelfed.travelsdk.bean.VerifyResult;
import com.travelfed.travelsdk.bean.flight.FlightFare;

/**
 * Stores flight info for the basket.
 */
public class FlightBasketItem extends BasketItem {
	
	private FlightFare flightFare;
	
	public FlightBasketItem(FlightFare flightFare, VerifyResult verifyResult) {
		super(flightFare.getFlightsFaresResult().getSession(), verifyResult);
		this.flightFare = flightFare;
	}
	
	public FlightFare getFlightFare() {
		return flightFare;
	}

	protected String getRecordId() {
		return flightFare.getId();
	}

	public long getTotal() {
		return (long) (flightFare.getTotal() * 100);
	}

	public String getCurrency() {
		return flightFare.getCurrency();
	}
	
}
