package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.flight.AirportsResult;


/**
 * Process receive airports result. Documentation <a href=
 * "http://wiki.travelsdk.com/index.php?title=Main_Page#Airport_search"
 * >http://wiki.travelsdk.com/index.php?title=Main_Page#Airport_search</a>
 */
public abstract class ProcessSearchAirports extends ProcessWS<AirportsResult> {
	
	private String query;
	
	public ProcessSearchAirports(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}


}
