package com.travelfed.travelsdk.bean.rentacar;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

/**
 * 
 * @author krumstoilov
 *
 */
public class BookingParameter {

	private Date pickUpDate;
	private Date returnDate;
	private String pickUpLocationCode;
	private String returnLocationCode;
//	private int combinationType;

	public BookingParameter(JSONObject json) throws JSONException {
		if(json.has("PickUpDateTime")) {
			this.setPickUpDate(StringUtil.parseDate(json.getString("PickUpDateTime")));
		}
		if(json.has("ReturnDateTime")) {
			this.setReturnDate(StringUtil.parseDate(json.getString("ReturnDateTime")));
		}
//		if(json.has("QueryParameterType")) {
//			this.setCombinationType(json.getInt("QueryParameterType"));
//		}
		if(json.has("PickUpLocationCode")) {
			this.setPickUpLocationCode(json.getString("PickUpLocationCode"));
		}
		if(json.has("ReturnLocationCode")) {
			this.setReturnLocationCode(json.getString("ReturnLocationCode"));
		}
	}
	
	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getPickUpLocationCode() {
		return pickUpLocationCode;
	}

	public void setPickUpLocationCode(String pickUpLocationCode) {
		this.pickUpLocationCode = pickUpLocationCode;
	}

	public String getReturnLocationCode() {
		return returnLocationCode;
	}

	public void setReturnLocationCode(String returnLocationCode) {
		this.returnLocationCode = returnLocationCode;
	}
	
	
}
