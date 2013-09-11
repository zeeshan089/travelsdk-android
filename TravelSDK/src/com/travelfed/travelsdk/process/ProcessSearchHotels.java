package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.hotel.HotelFilterParameters;
import com.travelfed.travelsdk.bean.hotel.HotelSearchParameters;
import com.travelfed.travelsdk.bean.hotel.HotelsResult;

/**
 * Process search hotels result. Documentation <a href=
 * "http://wiki.travelsdk.com/index.php?title=Main_Page#Search"
 * >http://wiki.travelsdk.com/index.php?title=Main_Page#Search</a>
 */
public abstract class ProcessSearchHotels extends ProcessWS<HotelsResult> {

	private HotelSearchParameters searchParameters;
	private HotelFilterParameters filterParameters;
	
	public ProcessSearchHotels(HotelSearchParameters searchParameters) {
		this.searchParameters = searchParameters;
	}

	public HotelSearchParameters getSearchParameters() {
		return searchParameters;
	}

	public void setSearchParameters(HotelSearchParameters searchParameters) {
		this.searchParameters = searchParameters;
	}

	public HotelFilterParameters getFilterParameters() {
		return filterParameters;
	}

	public void setFilterParameters(HotelFilterParameters filterParameters) {
		this.filterParameters = filterParameters;
	}

}
