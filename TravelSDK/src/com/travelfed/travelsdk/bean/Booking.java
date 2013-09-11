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
 * @author krumstoilov
 * @see FlightBooking
 * @see HotelBooking
 * @see RentacarBooking
 * @see ExcursionBooking
 */
public class Booking {

	
	public final static String STATUS_FAILED = "failed";
	public final static String STATUS_CONFIRMED = "confirmed";
	public final static String STATUS_CANCELLED = "cancelled";
	public final static String STATUS_PENDING = "pending";
	public final static String STATUS_CANCELLATION_ERROR = "cancellation_error";
	
	private String id;
	private boolean canceled;
	private Date booktime;
	private String status;
	private String packageId;
	private String bookingCode;
//	private Date canceltime;
	
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
//		if (json.has("canceltime")) {
//			this.setCanceltime(StringUtil.parseDate(json.getString("canceltime")));
//		}
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public boolean isConfirmed() {
		return  STATUS_CONFIRMED.equals(status);
	}
	
	public boolean isFailed() {
		return STATUS_FAILED.equals(status);
	}
	
	public boolean isPending() {
		return STATUS_PENDING.equals(status);
	}

	
	
}
