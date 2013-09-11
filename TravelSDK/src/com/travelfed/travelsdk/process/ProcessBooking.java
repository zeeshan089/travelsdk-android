package com.travelfed.travelsdk.process;

import com.travelfed.travelsdk.TravelSDK;
import com.travelfed.travelsdk.basket.Basket;
import com.travelfed.travelsdk.basket.PersonInfo;
import com.travelfed.travelsdk.bean.BookingResult;

/**
 * Process book. See documentation <a
 * href="http://wiki.travelsdk.com/index.php?title=Main_Page#Booking_Service"
 * >http://wiki.travelsdk.com/index.php?title=Main_Page#Booking_Service</a>
 * 
 * @author krumstoilov
 * 
 */
public abstract class ProcessBooking extends ProcessWS<BookingResult> {
	
	private PersonInfo customerInfo;
	private String packageId;
	private boolean onRequest = true; // current mobile api version supports only onRequest
	
	public ProcessBooking(PersonInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	void parseResponse(String serverResponse) {
		Basket.removeAll();
		super.parseResponse(serverResponse);
	}

	public PersonInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(PersonInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * It is generated value <b>agency_id|0|current_time_ms</b>
	 * 
	 * @return package id
	 */
	public String getPackageId() {
		if(packageId == null) {
			packageId = generatePackageId();
		}
		return packageId;
	}

	/**
	 * Generate unique package id.
	 * 
	 * @return generated package id
	 */
	public static String generatePackageId() {
		StringBuffer buffer = new StringBuffer();
		
		String unique = TravelSDK.INSTANCE.getLoginResult().getAccessToken();
		unique = unique.substring(unique.length() - 5, unique.length());
		
		buffer.append(TravelSDK.INSTANCE.getAgencyInfoResult().getAgencyId()).append("|")
				.
		append("and").append(unique).append("|").
		append(System.currentTimeMillis());
		return buffer.toString();
	}

	public void setPackageId(String pakcageId) {
		this.packageId = pakcageId;
	}

	public boolean isOnRequest() {
		return onRequest;
	}

}
