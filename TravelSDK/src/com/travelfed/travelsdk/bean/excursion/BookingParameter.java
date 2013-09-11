package com.travelfed.travelsdk.bean.excursion;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

public class BookingParameter {

	private String infants;
	private Date date;
	private String adults;
	private String confirmationLogoUrl;
	private String children;
	private String currency;
	private String verifyData;
	private String bookingData;
	private String paymentType;
	private String rGRefNum;
	private String infantPrice;
	private String requestedPrice;
	private String childPrice;
	private String agentRefNumber;
	private String confirmationEmal;
	private String recordLocatorId;
	private String availToken;
	private String adultPrice;
	private String tourId;
	private String optionId;
	private String tax;
	private String value;
	private String basisType;
	private String price;
	private Finance finance;

	public BookingParameter(JSONObject json) throws JSONException {
		if (json.has("infants")) {
			this.setInfants(json.getString("infants"));
		}
		if (json.has("date")) {
			String sDate = json.getString("date");
			this.setDate(StringUtil.parseDate(sDate));
		}
		if (json.has("adults")) {
			this.setAdults(json.getString("adults"));
		}
		if (json.has("confirmationLogoUrl")) {
			this.setConfirmationLogoUrl(json.getString("confirmationLogoUrl"));
		}
		if (json.has("children")) {
			this.setChildren(json.getString("children"));
		}
		if (json.has("currency")) {
			this.setCurrency(json.getString("currency"));
		}
		if (json.has("verifyData")) {
			this.setVerifyData(json.getString("verifyData"));
		}
		if (json.has("bookingData")) {
			this.setBookingData(json.getString("bookingData"));
		}
		if (json.has("paymentType")) {
			this.setPaymentType(json.getString("paymentType"));
		}
		if (json.has("rGRefNum")) {
			this.setRGRefNum(json.getString("rGRefNum"));
		}
		if (json.has("infantPrice")) {
			this.setInfantPrice(json.getString("infantPrice"));
		}
		if (json.has("requestedPrice")) {
			this.setRequestedPrice(json.getString("requestedPrice"));
		}
		if (json.has("childPrice")) {
			this.setChildPrice(json.getString("childPrice"));
		}
		if (json.has("agentRefNumber")) {
			this.setAgentRefNumber(json.getString("agentRefNumber"));
		}
		if (json.has("confirmationEmal")) {
			this.setConfirmationEmal(json.getString("confirmationEmal"));
		}
		if (json.has("recordLocatorId")) {
			this.setRecordLocatorId(json.getString("recordLocatorId"));
		}
		if (json.has("availToken")) {
			this.setAvailToken(json.getString("availToken"));
		}
		if (json.has("adultPrice")) {
			this.setAdultPrice(json.getString("adultPrice"));
		}
		if (json.has("tourId")) {
			this.setTourId(json.getString("tourId"));
		}
		if (json.has("optionId")) {
			this.setOptionId(json.getString("optionId"));
		}
		if (json.has("tax")) {
			this.setTax(json.getString("tax"));
		}
		if (json.has("value")) {
			this.setValue(json.getString("value"));
		}
		if (json.has("basisType")) {
			this.setBasisType(json.getString("basisType"));
		}
		if (json.has("price")) {
			this.setPrice(json.getString("price"));
		}
		if (json.has("finance")) {
			this.setFinance(new Finance(json.getJSONObject("finance")));
		}
	}

	/** @param infants */
	public void setInfants(String infants) {
		this.infants = infants;
	}

	/** @return infants */
	public String getInfants() {
		return infants;
	}

	/** @param date */
	public void setDate(Date date) {
		this.date = date;
	}

	/** @return date */
	public Date getDate() {
		return date;
	}

	/** @param adults */
	public void setAdults(String adults) {
		this.adults = adults;
	}

	/** @return adults */
	public String getAdults() {
		return adults;
	}

	/** @param confirmationLogoUrl */
	public void setConfirmationLogoUrl(String confirmationLogoUrl) {
		this.confirmationLogoUrl = confirmationLogoUrl;
	}

	/** @return confirmationLogoUrl */
	public String getConfirmationLogoUrl() {
		return confirmationLogoUrl;
	}

	/** @param children */
	public void setChildren(String children) {
		this.children = children;
	}

	/** @return children */
	public String getChildren() {
		return children;
	}

	/** @param currency */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/** @return currency */
	public String getCurrency() {
		return currency;
	}

	/** @param verifyData */
	public void setVerifyData(String verifyData) {
		this.verifyData = verifyData;
	}

	/** @return verifyData */
	public String getVerifyData() {
		return verifyData;
	}

	/** @param bookingData */
	public void setBookingData(String bookingData) {
		this.bookingData = bookingData;
	}

	/** @return bookingData */
	public String getBookingData() {
		return bookingData;
	}

	/** @param paymentType */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/** @return paymentType */
	public String getPaymentType() {
		return paymentType;
	}

	/** @param rGRefNum */
	public void setRGRefNum(String rGRefNum) {
		this.rGRefNum = rGRefNum;
	}

	/** @return rGRefNum */
	public String getRGRefNum() {
		return rGRefNum;
	}

	/** @param infantPrice */
	public void setInfantPrice(String infantPrice) {
		this.infantPrice = infantPrice;
	}

	/** @return infantPrice */
	public String getInfantPrice() {
		return infantPrice;
	}

	/** @param requestedPrice */
	public void setRequestedPrice(String requestedPrice) {
		this.requestedPrice = requestedPrice;
	}

	/** @return requestedPrice */
	public String getRequestedPrice() {
		return requestedPrice;
	}

	/** @param childPrice */
	public void setChildPrice(String childPrice) {
		this.childPrice = childPrice;
	}

	/** @return childPrice */
	public String getChildPrice() {
		return childPrice;
	}

	/** @param agentRefNumber */
	public void setAgentRefNumber(String agentRefNumber) {
		this.agentRefNumber = agentRefNumber;
	}

	/** @return agentRefNumber */
	public String getAgentRefNumber() {
		return agentRefNumber;
	}

	/** @param confirmationEmal */
	public void setConfirmationEmal(String confirmationEmal) {
		this.confirmationEmal = confirmationEmal;
	}

	/** @return confirmationEmal */
	public String getConfirmationEmal() {
		return confirmationEmal;
	}

	/** @param recordLocatorId */
	public void setRecordLocatorId(String recordLocatorId) {
		this.recordLocatorId = recordLocatorId;
	}

	/** @return recordLocatorId */
	public String getRecordLocatorId() {
		return recordLocatorId;
	}

	/** @param availToken */
	public void setAvailToken(String availToken) {
		this.availToken = availToken;
	}

	/** @return availToken */
	public String getAvailToken() {
		return availToken;
	}

	/** @param adultPrice */
	public void setAdultPrice(String adultPrice) {
		this.adultPrice = adultPrice;
	}

	/** @return adultPrice */
	public String getAdultPrice() {
		return adultPrice;
	}

	/** @param tourId */
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}

	/** @return tourId */
	public String getTourId() {
		return tourId;
	}

	/** @param optionId */
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	/** @return optionId */
	public String getOptionId() {
		return optionId;
	}

	/** @param tax */
	public void setTax(String tax) {
		this.tax = tax;
	}

	/** @return tax */
	public String getTax() {
		return tax;
	}

	/** @param value */
	public void setValue(String value) {
		this.value = value;
	}

	/** @return value */
	public String getValue() {
		return value;
	}

	/** @param basisType */
	public void setBasisType(String basisType) {
		this.basisType = basisType;
	}

	/** @return basisType */
	public String getBasisType() {
		return basisType;
	}

	/** @param price */
	public void setPrice(String price) {
		this.price = price;
	}

	/** @return price */
	public String getPrice() {
		return price;
	}

	/** @param finance */
	public void setFinance(Finance finance) {
		this.finance = finance;
	}

	/** @return finance */
	public Finance getFinance() {
		return finance;
	}
}