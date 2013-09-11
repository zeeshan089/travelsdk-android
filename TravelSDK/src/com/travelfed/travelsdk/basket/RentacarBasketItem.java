package com.travelfed.travelsdk.basket;

import com.travelfed.travelsdk.bean.VerifyResult;
import com.travelfed.travelsdk.bean.rentacar.Rentacar;

/**
 * Stores rentacar info for the basket.
 */
public class RentacarBasketItem extends BasketItem {

	private Rentacar rentacar;
	
	public RentacarBasketItem(Rentacar rentacar, VerifyResult verifyResult) {
		super(rentacar.getRentacarsResult().getSession(), verifyResult);
		this.rentacar = rentacar;
	}

	public Rentacar getRentacar() {
		return rentacar;
	}
	
	protected String getRecordId() {
		return rentacar.getId();
	}

	public long getTotal() {
		return (long)(Float.parseFloat(rentacar.getTotalprice()) * 100);
	}

	public String getCurrency() {
		return rentacar.getCurrency();
	}
	
}
