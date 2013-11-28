/*
 * Copyright (c) 2013, Perennial UG & Co.KG.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * - Neither the name of the Perennial UG & Co.KG nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.travelfed.travelsdk.basket;

import com.travelfed.travelsdk.bean.VerifyResult;


/**
 * Abstract class for different basket items.
 * 
 * @see FlightBasketItem
 * @see HotelBasketItem
 * @see RentacarBasketItem
 * @see ExcursionBasketItem
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
	 * @return Session id of the search result. Used by the API when booking.
	 */
	public String getSession() {
		return session;
	}

	/**
	 * 
	 * @return total price for this basket item in cents.
	 */
	public abstract long getTotal();

	/**
	 * 
	 * @return Currency code
	 */
	public abstract String getCurrency();

	
	/**
	 * Record id. Used by the API when booking.
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
