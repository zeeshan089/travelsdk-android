package com.travelfed.travelsdk.basket;

import com.travelfed.travelsdk.bean.VerifyResult;


/**
 * Abstract class for different basket items 
 */
public abstract class BasketItem {

	protected String session;
	protected VerifyResult verifyResult;
	
	protected BasketItem(String session, VerifyResult verifyResult) {
		this.session = session;
		this.verifyResult = verifyResult;
	}

	/**
	 * 
	 * @return the session id given from the web service
	 */
	public String getSession() {
		return session;
	}

	/**
	 * 
	 * @param seession - the session id given from the web service
	 */
	public void setSession(String seession) {
		this.session = seession;
	}

	/**
	 * 
	 * @return total price for this basket item in cents
	 */
	public abstract long getTotal();

	/**
	 * 
	 * @return Currency code of total price for this {@link BasketItem}
	 */
	public abstract String getCurrency();

	
	/**
	 * 
	 * @return record id
	 */
	protected abstract String getRecordId();

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getRecordId() == null) ? 0 : getRecordId().hashCode());
		result = prime * result
				+ ((session == null) ? 0 : session.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasketItem other = (BasketItem) obj;
		if (getRecordId() == null) {
			if (other.getRecordId() != null)
				return false;
		} else if (!getRecordId().equals(other.getRecordId()))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;

		return true;
	}	

}
