package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.rentacar.RentacarFilterParameters;
import com.travelfed.travelsdk.bean.rentacar.RentacarSearchParameters;
import com.travelfed.travelsdk.bean.rentacar.RentacarsResult;

/**
 * Process search rental cars result. Documentation <a href=
 * "http://wiki.travelsdk.com/index.php?title=Main_Page#Search_3"
 * >http://wiki.travelsdk.com/index.php?title=Main_Page#Search_3</a>
 */
public abstract class ProcessSearchRentacars extends ProcessWS<RentacarsResult> {

	private RentacarSearchParameters searchParameters;
	private RentacarFilterParameters filterParameters;
	
	public ProcessSearchRentacars(RentacarSearchParameters searchParameters) {
		this.searchParameters = searchParameters;
	}

	public RentacarSearchParameters getSearchParameters() {
		return searchParameters;
	}

	public void setSearchParameters(RentacarSearchParameters searchParameters) {
		this.searchParameters = searchParameters;
	}

	public RentacarFilterParameters getFilterParameters() {
		return filterParameters;
	}

	public void setFilterParameters(RentacarFilterParameters filterParameters) {
		this.filterParameters = filterParameters;
	}
	
	
}
