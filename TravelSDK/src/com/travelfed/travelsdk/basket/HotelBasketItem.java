package com.travelfed.travelsdk.basket;

import com.travelfed.travelsdk.bean.VerifyResult;
import com.travelfed.travelsdk.bean.hotel.HotelFare;

/**
 * Stores hotel info for the basket.
 */
public class HotelBasketItem extends BasketItem {

	private HotelFare hotelFare;
	
	public HotelBasketItem(HotelFare hotelFare, VerifyResult verifyResult) {
		super(hotelFare.getHotelsFaresResult().getSession(), verifyResult);
		this.hotelFare = hotelFare;
	}

	public HotelFare getHotelFare() {
		return hotelFare;
	}

	protected String getRecordId() {
		return hotelFare.getId();
	}

	public long getTotal() {
		return (long)(Float.parseFloat(hotelFare.getTotalPrice()) * 100);
	}

	public String getCurrency() {
		return hotelFare.getCurrency();
	}

	public VerifyResult getVerifyResult() {
		return verifyResult;
	}
	
}
