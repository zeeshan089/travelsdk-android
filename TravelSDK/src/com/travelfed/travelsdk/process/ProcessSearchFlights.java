package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.flight.FlightFilterParameters;
import com.travelfed.travelsdk.bean.flight.FlightSearchParameters;
import com.travelfed.travelsdk.bean.flight.FlightsResult;

/**
 * Process search flight fares result. Documentation <a href=
 * "http://wiki.travelsdk.com/index.php?title=Main_Page#Search_2"
 * >http://wiki.travelsdk.com/index.php?title=Main_Page#Search_2</a>
 */
public abstract class ProcessSearchFlights extends ProcessWS<FlightsResult> {
	
	private FlightSearchParameters searchParameters;
	private FlightFilterParameters filterParameters;
	
	public ProcessSearchFlights(FlightSearchParameters searchParameters) {
		this.searchParameters = searchParameters;
	}

	/**
	 * 
	 * @return
	 */
	public FlightSearchParameters getSearchParameters() {
		return searchParameters;
	}

	/**
	 * Set search parameters here or in the constructor before processing
	 * searchFlights
	 * 
	 * @param searchParameters
	 */
	public void setSearchParameters(FlightSearchParameters searchParameters) {
		this.searchParameters = searchParameters;
	}

	/**
	 * @return
	 */
	public FlightFilterParameters getFilterParameters() {
		return filterParameters;
	}

	/**
	 * If you want to filter the results by some parameters set them here before
	 * processing searchFlights or getFlightSeachResults. The WS will filter the
	 * results for you.
	 * 
	 * @param filterParameters
	 */
	public void setFilterParameters(FlightFilterParameters filterParameters) {
		this.filterParameters = filterParameters;
	}
	
}
