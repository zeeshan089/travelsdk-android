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
package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.flight.FlightFilterParameters;
import com.travelfed.travelsdk.bean.flight.FlightSearchParameters;
import com.travelfed.travelsdk.bean.flight.FlightsResult;

/**
 *  Process flight search. Additional you can set filter parameters.
 *  Documentation: http://wiki.travelsdk.com/index.php?title=Flight_requests#Search
 */
public abstract class ProcessSearchFlights extends ProcessWS<FlightsResult> {
	
	private FlightSearchParameters searchParameters;
	private FlightFilterParameters filterParameters;
	
	/**
	 * 
	 * @param searchParameters Flight search parameters.
	 */
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
