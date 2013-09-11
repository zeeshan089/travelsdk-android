package com.travelfed.travelsdk.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.flight.FlightFare;
import com.travelfed.travelsdk.bean.hotel.HotelFare;
import com.travelfed.travelsdk.bean.rentacar.Rentacar;

/**
 * Result with successful and failed bookings
 * 
 * @author krumstoilov
 *
 */
public class BookingResult extends Result {

	private String packageId;
	private String resultStatus;
	private float totalPrice;
	private String currency;
	private short bookingStatus;
	private String supplierBookingStatus;
	private float serviceFeee;
	private List<Object> successful = new ArrayList<Object>();
	private List<Object> failed = new ArrayList<Object>();
	
	public BookingResult(JSONObject json) throws JSONException  {
		super(json);
		setPackageId(json.getString("package_id"));
		if (json.has("result")) {
			setResultStatus(json.getJSONObject("result").getString("STATUS"));
		}
		setTotalPrice(Float.parseFloat(json.getString("totalprice")));
		setCurrency(json.getString("totalprice_currency"));
		setBookingStatus((short) json.getInt("bookingstatus"));
		setSupplierBookingStatus(json.getString("supplierbookingstatus"));
		try {
			setServiceFeee(Float.parseFloat(json.getString("service_fee")));
		} catch (Exception e) {
			// skip
		}
		if (json.has("failed")) {
			addDataElements(failed, json.getJSONArray("failed"));
		}
		if (json.has("successful")) {
			addDataElements(successful, json.getJSONArray("successful"));
		}
	}

	private void addDataElements(List<Object> list, JSONArray jsonArray) throws JSONException {
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jObject = jsonArray.getJSONObject(i);
			String type = jObject.getString("type");
			if (type == "hotel") {
				HotelFare hotelFare = new HotelFare(null, jObject.getJSONObject("data"));
				list.add(hotelFare);
			} else if (type == "flight") {
				FlightFare fare = new FlightFare(null, jObject.getJSONObject("data"));
				list.add(fare);
			} else if (type == "rentacar") {
				Rentacar rentalcar = new Rentacar(null, jObject.getJSONObject("data"));
				list.add(rentalcar);
			}
		}
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public short getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(short bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getSupplierBookingStatus() {
		return supplierBookingStatus;
	}

	public void setSupplierBookingStatus(String supplierBookingStatus) {
		this.supplierBookingStatus = supplierBookingStatus;
	}

	public float getServiceFeee() {
		return serviceFeee;
	}

	public void setServiceFeee(float serviceFeee) {
		this.serviceFeee = serviceFeee;
	}

	/**
	 * 
	 * @return List with all successful records - {@link HotelFare},
	 *         {@link FlightFare}, {@link Rentacar}, ...
	 */
	public List<Object> getSuccessful() {
		return successful;
	}

	/**
	 * 
	 * @return List with all failed records - {@link HotelFare},
	 *         {@link FlightFare}, {@link Rentacar}, ...
	 */
	public List<Object> getFailed() {
		return failed;
	}

}
