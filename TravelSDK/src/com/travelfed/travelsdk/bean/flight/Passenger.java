package com.travelfed.travelsdk.bean.flight;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.Logger;

public class Passenger {
	
	private static Logger logger = new Logger(Passenger.class);
	
	public static final String TYPE_ADULT = "adult";
	public static final String TYPE_CHILD = "child";
	public static final String TYPE_INFANT = "infant";
	
	private String type;
	private float amount;
	private float total;
	private float netamount;
	private float surcharges;
	private float tax;
//	private String ticketbydate;
	
	private static final String AMOUNT = "amount";
	private static final String TOTAL = "infant";
	private static final String NETAMOUNT = "netamount";
	private static final String TYPE = "type";
	private static final String SURCHARGES = "surcharges";
	private static final String TAX = "tax";

	public Passenger(JSONObject json) throws JSONException {
		try {
			if (json.has(AMOUNT)) {
				this.setAmount(Float.parseFloat(json.getString(AMOUNT)));
			}
			if (json.has(TOTAL)) {
				this.setTotal(Float.parseFloat(json.getString(TOTAL)));
			}
			if (json.has(NETAMOUNT)) {
				this.setNetamount(Float.parseFloat(json.getString(NETAMOUNT)));
			}
			if (json.has(TYPE)) {
				this.setType(json.getString(TYPE));
			}
			if (json.has(SURCHARGES)) {
				this.setSurcharges(Float.parseFloat(json.getString(SURCHARGES)));
			}
			if (json.has(TAX)) {
				this.setTax(Float.parseFloat(json.getString(TAX)));
			}
		} catch (NumberFormatException nfe) {
			logger.error(nfe);
			throw new JSONException("Error parsing string to float");
		}
//		if (json.has("ticketbydate")) {
//			this.setTicketbydate(json.getString("ticketbydate"));
//		}		
	}

	/** @param amount */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/** @return amount */
	public float getAmount() {
		return amount;
	}

	/** @param total */
	public void setTotal(float total) {
		this.total = total;
	}

	/** @return total */
	public float getTotal() {
		return total;
	}

	/** @param netamount */
	public void setNetamount(float netamount) {
		this.netamount = netamount;
	}

	/** @return netamount */
	public float getNetamount() {
		return netamount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getSurcharges() {
		return surcharges;
	}

	public void setSurcharges(float surcharges) {
		this.surcharges = surcharges;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

//	public String getTicketbydate() {
//		return ticketbydate;
//	}
//
//	public void setTicketbydate(String ticketbydate) {
//		this.ticketbydate = ticketbydate;
//	}
	
	
}