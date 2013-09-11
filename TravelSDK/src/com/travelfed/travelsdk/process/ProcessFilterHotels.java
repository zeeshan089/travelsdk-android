package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.hotel.HotelFilterParameters;
import com.travelfed.travelsdk.bean.hotel.HotelsResult;

public abstract class ProcessFilterHotels extends ProcessSearchHotels {

	private HotelsResult hotelsFaresResult;
	
	public ProcessFilterHotels(HotelsResult hotelsFaresResult, HotelFilterParameters filterParameters) {
		super(null);
		this.setFilterParameters(filterParameters);
		this.hotelsFaresResult = hotelsFaresResult;
	}

	public HotelsResult getHotelsFaresResult() {
		return hotelsFaresResult;
	}

	public void setHotelsFaresResult(HotelsResult hotelsFaresResult) {
		this.hotelsFaresResult = hotelsFaresResult;
	}
}
