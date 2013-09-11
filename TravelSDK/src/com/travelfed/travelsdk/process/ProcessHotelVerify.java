package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.hotel.HotelFare;

public abstract class ProcessHotelVerify extends ProcessVerify {
	
	private HotelFare hotelFare;
	
	public ProcessHotelVerify(HotelFare hotelFare) {
		this.hotelFare = hotelFare;
	}

	public HotelFare getHotelFare() {
		return hotelFare;
	}

	public void setHotelFare(HotelFare hotelFare) {
		this.hotelFare = hotelFare;
	}

}
