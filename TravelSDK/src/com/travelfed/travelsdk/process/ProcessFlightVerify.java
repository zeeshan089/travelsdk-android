package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.flight.FlightFare;

public abstract class ProcessFlightVerify extends ProcessVerify {

	private FlightFare flightFare;
	
	public ProcessFlightVerify(FlightFare flightFare) {
		this.flightFare = flightFare;
	}
	
	public FlightFare getFlightFare() {
		return flightFare;
	}
	public void setFlightFare(FlightFare flightFare) {
		this.flightFare = flightFare;
	}


}
