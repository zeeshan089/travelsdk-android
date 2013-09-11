package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.flight.FlightFilterParameters;
import com.travelfed.travelsdk.bean.flight.FlightsResult;

public abstract class ProcessFilterFlights extends ProcessSearchFlights {

	private FlightsResult flightsFaresResult;
	
	public ProcessFilterFlights(FlightsResult flightsFaresResult, FlightFilterParameters filterParameters) {
		super(null);
		this.setFilterParameters(filterParameters);
		this.flightsFaresResult = flightsFaresResult;
	}

	public FlightsResult getFlightsFaresResult() {
		return flightsFaresResult;
	}

	public void setFlightsFaresResult(FlightsResult flightsFaresResult) {
		this.flightsFaresResult = flightsFaresResult;
	}

}
