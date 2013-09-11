package com.travelfed.travelsdk.bean;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

/**
 * Agency information. 
 * Data is filled in the process of initialization. - TravelSDK.init(..)
 * 
 * @author krumstoilov
 *
 */
public class AgencyInfoResult extends Result{
	
	private boolean exists;
	private boolean active;
	private boolean success = true;

	private boolean isLiveBooking = false;
	private String agencyId; //agency_id
	private String officename; //Officename
	private String address; //address
	private String poBox; //PObox
	private String zip; //Zip
	private String city; //City
	private String country; //Country
	private String email; //Email
	private String telCountryCode; //tel_country_code
	private String telCityCode; //tel_city_code
	private String tel; //tel
	private String faxCountryCode; //fax_country_code
	private String faxCityCode; //fax_city_code
	private String fax; //fax
	private String mobileCountryCode; //mobile_country_code
	private String mobileNetworkCode; //mobile_city_code
	private String mobile; //mobile
	private String respPersonInitials; //resp_person_initials
	private String respPersonFirstName; //resp_person_first_name	
	private String respPersonLastName; //resp_person_last_name
	private String respPersonJobTitle; //resp_person_job_title
	private String respPersonEmail; //resp_person_email  
	private String mobileLogoUrl; 
	private String mobileLogoBgUrl;
	private String mobileBg480x480Url;
	private String mobileBg800x800Url;
	private String supportEmail;
	private boolean mobileLiveBookings;

	public AgencyInfoResult(JSONObject json) throws JSONException {
		super(json);
		if (json.has("exists")) {
			setExists(json.getString("exists").equals("1"));
		}
		if (json.has("active") && json.has("bb_active")) {
			setActive(json.getString("active").equals("1") && json.getString("bb_active").equals("1"));
		}
		if (json.has("live_bookings")) {
			isLiveBooking = json.getString("live_bookings").equals("1");
		}
		if (json.has("agency_id")) {
			setAgencyId(json.getString("agency_id"));
		}
		if (json.has("Officename")) {
			setOfficename(json.getString("Officename"));
		}
		if (json.has("address")) {
			setAddress(json.getString("address"));
		}
		if (json.has("PObox")) {
			setPoBox(json.getString("PObox"));
		}
		if (json.has("Zip")) {
			setZip(json.getString("Zip"));
		}
		if (json.has("City")) {
			setCity(json.getString("City"));
		}
		if (json.has("Country")) {
			setCountry(json.getString("Country"));
		}
		if (json.has("Email")) {
			setEmail(json.getString("Email"));
		}
		if (json.has("tel_country_code")) {
			setTelCountryCode(json.getString("tel_country_code"));
		}
		if (json.has("tel_city_code")) {
			setTelCityCode(json.getString("tel_city_code"));
		}
		if (json.has("tel")) {
			setTel(json.getString("tel"));
		}
		if (json.has("fax_country_code")) {
			setFaxCountryCode(json.getString("fax_country_code"));
		}
		if (json.has("fax_city_code")) {
			setFaxCityCode(json.getString("fax_city_code"));
		}
		if (json.has("fax")) {
			setFax(json.getString("fax"));
		}
		if (json.has("mobile_country_code")) {
			setMobileCountryCode(json.getString("mobile_country_code"));
		}
		if (json.has("mobile_city_code")) {
			setMobileNetworkCode(json.getString("mobile_city_code"));
		}
		if (json.has("mobile")) {
			setMobile(json.getString("mobile"));
		}
		if (json.has("resp_person_initials")) {
			setRespPersonInitials(json.getString("resp_person_initials"));
		}
		if (json.has("resp_person_first_name")) {
			setRespPersonFirstName(json.getString("resp_person_first_name"));
		}
		if (json.has("resp_person_last_name")) {
			setRespPersonLastName(json.getString("resp_person_last_name"));
		}
		if (json.has("resp_person_job_title")) {
			setRespPersonJobTitle(json.getString("resp_person_job_title"));
		}
		if (json.has("resp_person_email")) {
			setRespPersonEmail(json.getString("resp_person_email"));
		}
		if (json.has("mobile_logo_url")) {
			setMobileLogoUrl(json.getString("mobile_logo_url"));
		}
		if (json.has("mobile_logo_bg_url")) {
			setMobileLogoBgUrl(json.getString("mobile_logo_bg_url"));
		}
		if (json.has("mobile_bg_480x480_url")) {
			mobileBg480x480Url = json.getString("mobile_bg_480x480_url");
		}
		if (json.has("mobile_bg_800x800_url")) {
			mobileBg800x800Url = json.getString("mobile_bg_800x800_url");
		}
		if (json.has("support_email")) {
			setSupportEmail(json.getString("support_email"));
		}
		if (json.has("mobile_live_bookings")) {
			setMobileLiveBookings(json.getString("mobile_live_bookings").equals("1"));
		}
		
	}
	
	/**
	 * @return true If agency id and security token exists
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success - true if agency id and security token exists
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}
	
	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelCountryCode() {
		return telCountryCode;
	}

	public void setTelCountryCode(String telCountryCode) {
		this.telCountryCode = telCountryCode;
	}

	public String getTelCityCode() {
		return telCityCode;
	}

	public void setTelCityCode(String telCityCode) {
		this.telCityCode = telCityCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFaxCountryCode() {
		return faxCountryCode;
	}

	public void setFaxCountryCode(String faxCountryCode) {
		this.faxCountryCode = faxCountryCode;
	}

	public String getFaxCityCode() {
		return faxCityCode;
	}

	public void setFaxCityCode(String faxCityCode) {
		this.faxCityCode = faxCityCode;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobileCountryCode() {
		return mobileCountryCode;
	}

	public void setMobileCountryCode(String mobileCountryCode) {
		this.mobileCountryCode = mobileCountryCode;
	}

	public String getMobileNetworkCode() {
		return mobileNetworkCode;
	}

	public void setMobileNetworkCode(String mobileNetworkCode) {
		this.mobileNetworkCode = mobileNetworkCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRespPersonFirstName() {
		return respPersonFirstName;
	}

	public void setRespPersonFirstName(String respPersonFirstName) {
		this.respPersonFirstName = respPersonFirstName;
	}

	public String getRespPersonInitials() {
		return respPersonInitials;
	}

	public void setRespPersonInitials(String respPersonInitials) {
		this.respPersonInitials = respPersonInitials;
	}

	public String getRespPersonLastName() {
		return respPersonLastName;
	}

	public void setRespPersonLastName(String respPersonLastName) {
		this.respPersonLastName = respPersonLastName;
	}

	public String getRespPersonJobTitle() {
		return respPersonJobTitle;
	}

	public void setRespPersonJobTitle(String respPersonJobTitle) {
		this.respPersonJobTitle = respPersonJobTitle;
	}

	public String getRespPersonEmail() {
		return respPersonEmail;
	}

	public void setRespPersonEmail(String respPersonEmail) {
		this.respPersonEmail = respPersonEmail;
	}

	public boolean isLiveBooking() {
		return isLiveBooking;
	}

	public void setLiveBooking(boolean isLiveBooking) {
		this.isLiveBooking = isLiveBooking;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getMobileLogoUrl() {
		return mobileLogoUrl;
	}

	public void setMobileLogoUrl(String mobileLogoUrl) {
		if(!StringUtil.isNullOrEmpty(mobileLogoUrl)) {
			this.mobileLogoUrl = mobileLogoUrl;
		}
	}

	public String getMobileLogoBgUrl() {
		return mobileLogoBgUrl;
	}

	public void setMobileLogoBgUrl(String mobileBgrUrl) {
		if(!StringUtil.isNullOrEmpty(mobileBgrUrl)) {
			this.mobileLogoBgUrl = mobileBgrUrl;
		}
	}
	
	public String getMobileBg480x480Url() {
		return mobileBg480x480Url;
	}

	public void setMobileBg480x480Url(String mobileBg480x480Url) {
		this.mobileBg480x480Url = mobileBg480x480Url;
	}

	public String getMobileBg800x800Url() {
		return mobileBg800x800Url;
	}

	public void setMobileBg800x800Url(String mobileBg800x800Url) {
		this.mobileBg800x800Url = mobileBg800x800Url;
	}
	
	public String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(String supportEmail) {
		if(!StringUtil.isNullOrEmpty(supportEmail)) {
			this.supportEmail = supportEmail;
		}
	}

	public boolean isMobileLiveBookings() {
		return mobileLiveBookings;
	}

	public void setMobileLiveBookings(boolean mobileLiveBookings) {
		this.mobileLiveBookings = mobileLiveBookings;
	}

}
