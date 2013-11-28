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
package com.travelfed.travelsdk.bean;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.Logger;
import com.travelfed.travelsdk.bean.excursion.ExcursionBooking;
import com.travelfed.travelsdk.bean.flight.FlightBooking;
import com.travelfed.travelsdk.bean.hotel.HotelBooking;
import com.travelfed.travelsdk.bean.rentacar.RentacarBooking;
import com.travelfed.travelsdk.util.StringUtil;

/**
 * Base class for a booking. 
 * 
 * @see FlightBooking
 * @see HotelBooking
 * @see RentacarBooking
 * @see ExcursionBooking
 */
public class Booking {

	/**
	 *  Failed booking status
	 */
	public final static String STATUS_FAILED = "failed";
	
	/**
	 *  Confirmed booking status
	 */
	public final static String STATUS_CONFIRMED = "confirmed";
	
	/**
	 *  Canceled booking
	 */
	public final static String STATUS_CANCELLED = "cancelled";
	
	/**
	 *  Pending booking
	 */
	public final static String STATUS_PENDING = "pending";
	
	/**
	 *  Status for canceled booking with cancelation error.
	 */
	public final static String STATUS_CANCELLATION_ERROR = "cancellation_error";
	
	private String id;
	private boolean canceled;
	private Date booktime;
	private String status;
	private String packageId;
	private String bookingCode;
	
	protected final static String REQUEST = "request";
	private final static String ID = "id";
	private final static String CANCELED = "cancelled";
	private final static String BOOKTIME = "booktime";
	private final static String STATUS = "status";
	private final static String PACKAGE_ID = "package_id";
	private final static String BOOKING_CODE = "booking_code";
	
	protected Logger logger = new Logger(this.getClass());
	
	public Booking(JSONObject json) throws JSONException {
		if (json.has(ID)) {
			this.setId(json.getString(ID));
		}
		if (json.has(CANCELED)) {
			this.setCanceled(json.getBoolean(CANCELED));
		}
		if (json.has(BOOKTIME)) {
			this.setBooktime(StringUtil.parseDate(json.getString(BOOKTIME)));
		}
		if (json.has(STATUS)) {
			this.setStatus(json.getString(STATUS));
		}
		if (json.has(PACKAGE_ID)) {
			this.setPackageId(json.getString(PACKAGE_ID));
		}
		if (json.has(BOOKING_CODE)) {
			this.setBookingCode(json.getString(BOOKING_CODE));
		}
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 *  Check booking is canceled
	 *
	 *  @return YES if canceled
	 */
	public boolean isCanceled() {
		return canceled || STATUS_CANCELLED.equals(status); 
	}
	
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public Date getBooktime() {
		return booktime;
	}

	public void setBooktime(Date booktime) {
		this.booktime = booktime;
	}
	
	/**
	 *  Status - pending (STATUS_PENDING), confirmed (STATUS_CONFIRMED), cancelled (STATUS_CANCELLED), failed (STATUS_FAILED), cancellation error (STATUS_CANCELLATION_ERROR)
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 *  Package id
	 */
	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	/**
	 *  Booking code if confirmed
	 */
	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	/**
	 *  Check booking is confirmed
	 *
	 *  @return YES if confirmed
	 */
	public boolean isConfirmed() {
		return  STATUS_CONFIRMED.equals(status);
	}
	
	/**
	 *  Check booking is failed
	 *
	 *  @return YES if failed
	 */
	public boolean isFailed() {
		return STATUS_FAILED.equals(status);
	}
	
	/**
	 *  Check booking is pending
	 *
	 *  @return YES if pending
	 */
	public boolean isPending() {
		return STATUS_PENDING.equals(status);
	}

	
	
}
