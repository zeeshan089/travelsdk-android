package com.travelfed.travelsdk.basket;

import com.travelfed.travelsdk.bean.VerifyResult;
import com.travelfed.travelsdk.bean.excursion.Excursion;

/**
 * Stores excursion info for the basket.
 * 
 * @author krumstoilov
 *
 */
public class ExcursionBasketItem extends BasketItem {

	private Excursion excursion;

	public ExcursionBasketItem(Excursion excursion, VerifyResult verifyResult) {
		super(excursion.getExcursionResult().getSession(), verifyResult);
		this.excursion = excursion;
	}

	public long getTotal() {
		return (long) (Float.parseFloat(excursion.getTotalPrice()) * 100);
	}

	public String getCurrency() {
		return excursion.getCur();
	}

	protected String getRecordId() {
		return excursion.getId();
	}

	public Excursion getExcursion() {
		return excursion;
	}

}
