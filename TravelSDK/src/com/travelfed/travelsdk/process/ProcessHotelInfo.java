package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.bean.hotel.HotelFare;
import com.travelfed.travelsdk.bean.hotel.HotelInfoResult;

/**
 * Process hotel information result. See documentation <a href=
 * "http://wiki.travelsdk.com/index.php?title=Main_Page#Information"
 * >http://wiki.travelsdk.com/index.php?title=Main_Page#Information</a>
 */
public abstract class ProcessHotelInfo extends ProcessWS<HotelInfoResult> {
	
	private HotelFare hotelFare;
	
	public ProcessHotelInfo(HotelFare hotelFare) {
		this.hotelFare = hotelFare;
	}

	public HotelFare getHotelFare() {
		return hotelFare;
	}

	public void setHotelFare(HotelFare hotelFare) {
		this.hotelFare = hotelFare;
	}

}
