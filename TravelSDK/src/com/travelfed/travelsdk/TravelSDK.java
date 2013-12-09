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
package com.travelfed.travelsdk;

import java.util.Hashtable;
import java.util.List;

import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.basket.Basket;
import com.travelfed.travelsdk.basket.BasketItem;
import com.travelfed.travelsdk.basket.ExcursionBasketItem;
import com.travelfed.travelsdk.basket.FlightBasketItem;
import com.travelfed.travelsdk.basket.HotelBasketItem;
import com.travelfed.travelsdk.basket.PersonInfo;
import com.travelfed.travelsdk.basket.RentacarBasketItem;
import com.travelfed.travelsdk.bean.AgencyInfoResult;
import com.travelfed.travelsdk.bean.LoginResult;
import com.travelfed.travelsdk.bean.SettingsResult;
import com.travelfed.travelsdk.bean.excursion.Excursion;
import com.travelfed.travelsdk.bean.flight.Flight;
import com.travelfed.travelsdk.bean.hotel.HotelsResult;
import com.travelfed.travelsdk.http.HttpConnector;
import com.travelfed.travelsdk.process.ErrorCodes;
import com.travelfed.travelsdk.process.ProcessAgencyInfo;
import com.travelfed.travelsdk.process.ProcessBooking;
import com.travelfed.travelsdk.process.ProcessBookingsList;
import com.travelfed.travelsdk.process.ProcessExcursionVerify;
import com.travelfed.travelsdk.process.ProcessFilterExcursions;
import com.travelfed.travelsdk.process.ProcessFilterFlights;
import com.travelfed.travelsdk.process.ProcessFilterHotels;
import com.travelfed.travelsdk.process.ProcessFilterRentacars;
import com.travelfed.travelsdk.process.ProcessFlightVerify;
import com.travelfed.travelsdk.process.ProcessHotelInfo;
import com.travelfed.travelsdk.process.ProcessHotelVerify;
import com.travelfed.travelsdk.process.ProcessInit;
import com.travelfed.travelsdk.process.ProcessLogin;
import com.travelfed.travelsdk.process.ProcessRentacarVerify;
import com.travelfed.travelsdk.process.ProcessSearchAirports;
import com.travelfed.travelsdk.process.ProcessSearchExcursions;
import com.travelfed.travelsdk.process.ProcessSearchFlights;
import com.travelfed.travelsdk.process.ProcessSearchHotels;
import com.travelfed.travelsdk.process.ProcessSearchRentacars;
import com.travelfed.travelsdk.process.ProcessSettingsResult;
import com.travelfed.travelsdk.process.ProcessVerify;
import com.travelfed.travelsdk.process.RequestThread;
import com.travelfed.travelsdk.util.StringUtil;
import com.travelfed.travelsdk.util.URLEncoderUtil;

/**
 * Use the INSTANCE object of this class to make all TravelSDK WS requests. You
 * must call INSTANCE.init(...) and wait for response before using any other WS.
 * If the initialization is not successful you will not be able to call any other ws.
 * 
 * @author krumstoilov
 */
public class TravelSDK {

	/** Use this object instance **/
	public final static TravelSDK INSTANCE = new TravelSDK();

	/** TravelSDK version **/
	public static final String VERSION = "1.1";
	private static final String ADMIN_WS_URL = "http://admin.freedom-rs.com/services/";
	
	private String configurationUrl;

	private SettingsResult settingsResult;
	private AgencyInfoResult agencyInfoResult;
	private LoginResult loginResult;

	private static Logger logger = new Logger(TravelSDK.class);

	// service for receiving payment fields and methods
	protected static String SERVER_AGENCY_SERVICE_URL = ADMIN_WS_URL + "agencyservice.php";
	protected static String SERVER_IBE_BOOKING_URL = ADMIN_WS_URL + "bookingservice.php";

	/** Some identification **/
	private String mobileClient;

	private ProcessInit processInit;
	private String client;
	private String username;
	private String password;
	private String email;
	private String securityToken;
	protected static boolean isDebug;
	private int pageLimit = 20;
	private String currencyCode = "EUR";

	private TravelSDK() {

	};

	/**
	 * Init TravelSDK. Call this method first.
	 * This will login and get configuration and agency information.
	 * If the initialization is not successful you will not be able to call any other ws.
	 * <br>
	 * Required android.permission.INTERNET in AndroidManifest.xml file 
	 * 
	 * @param processInit - Implement {@link ProcessInit} to handle complete
	 *            processing and errors
	 * 
	 * @throws TravelSDKException - if previous init call is still processing.
	 */
	public void init(ProcessInit processInit) throws TravelSDKException {
		if (this.processInit != null) {
			throw new TravelSDKException("Previous init process is active");
		}
		
		this.username = processInit.getUsername();
		this.password = processInit.getPassword();
		this.client = processInit.getClient();
		this.email = processInit.getEmail();
		this.mobileClient = StringUtil.md5(email).substring(0, 6).toUpperCase();
		this.securityToken = processInit.getSecurityToken();
		this.processInit = processInit;
		configurationUrl = ADMIN_WS_URL + "mobile.php?prgm=get_config&id=" + client;

		initSettings();
	}

	/**
	 * Init settings.  <b>THIS METHOD IS NOT THREAD SAVE. </b>
	 */
	private void initSettings() {
		settingsResult = null;
		ProcessSettingsResult processSettingsResult = new ProcessSettingsResult() {
			public void onComplete() {
				if(getErrorCode() != null) {
					TravelSDK.INSTANCE.processInit.setErrorCode(getErrorCode());
					TravelSDK.INSTANCE.processInit.onComplete();
				} else {
					TravelSDK.INSTANCE.settingsResult = getResult();
					// Process Login
					login(null);
				}
			}

		};

		StringBuffer stringBuffer = new StringBuffer(configurationUrl);
		stringBuffer.append("&version=").append(VERSION);
		stringBuffer.append("&userId=").append(mobileClient);
		stringBuffer.append("&agencyId=").append(client);

		new RequestThread(stringBuffer.toString(), processSettingsResult).execute();
	}

	/**
	 * Init agency. 
	 */
	private void initAgencyInformation() {
		agencyInfoResult = null;
		ProcessAgencyInfo processAgencyInfo = new ProcessAgencyInfo() {
			public void onComplete() {
				if(getErrorCode() != null) {
					TravelSDK.INSTANCE.processInit.setErrorCode(getErrorCode());
					if (response != null && !response.isSuccess()) {
						// Agency ID or security token is invalid;
						try {
							agencyInfoResult = new AgencyInfoResult(new JSONObject());
							agencyInfoResult.setSuccess(false);
						} catch (JSONException e) {
							TravelSDK.logger.error(e, "agency info creation");
						}
					}
					
				} else {
					TravelSDK.INSTANCE.agencyInfoResult = getResult();
				}
				processInit.onComplete();
				processInit = null;
			}
		};
		StringBuffer stringBuffer = new StringBuffer(SERVER_AGENCY_SERVICE_URL);
		stringBuffer.append("?prgm=check&version=mobile");
		stringBuffer.append("&agency_id=").append(client);
		stringBuffer.append("&security_token=").append(URLEncoderUtil.encodeUTF8(securityToken));
		stringBuffer.append("&user_name=").append(URLEncoderUtil.encodeUTF8(email));
		stringBuffer.append("&ver=").append(VERSION);
		new RequestThread(stringBuffer.toString(), processAgencyInfo).execute();
	}

	/**
	 * Login to get access token. Normally TravelSDK will do it automatically
	 * for you when it is needed.
	 * 
	 */
	public void login(final ProcessLogin processLogin) {
		try {
			// Process Login
			loginResult = null;
			ProcessLogin processLoginLocal = new ProcessLogin() {
				public void onComplete() {
					if(getErrorCode() != null) {
						if(processInit != null) {
							processInit.setErrorCode(getErrorCode());
							processInit.onComplete();
						}
					} else {
						TravelSDK.INSTANCE.loginResult = getResult();
						if (TravelSDK.logger.isDebug()) {
							TravelSDK.logger.debug("Login access token: " + loginResult.getAccessToken());
						}
						if(processInit != null) {
							// Receive Agency information
							initAgencyInformation();
						}
					}
					if(processLogin != null) {
						processLogin.onComplete();
					}
				}
			};
			

			StringBuffer stringBuffer = new StringBuffer(settingsResult.getWsUrl());
			stringBuffer.append("?prgm=auth.login");
			stringBuffer.append("&client=").append(client);
			stringBuffer.append("&username=").append(username);
			stringBuffer.append("&password=").append(password);
			stringBuffer.append("&app=and&ver=").append(TravelSDK.VERSION);
			stringBuffer.append("&user_id=").append(mobileClient);

			new RequestThread(stringBuffer.toString(), processLoginLocal).execute();
		} catch (Exception e) {
			logger.error(e, "Error on Login");
			if(processInit != null) {
				processInit.setErrorCode(ErrorCodes.ERROR_RESPONSE);
			}
		}
	}

	protected static void appendStandartServiceParameters(StringBuffer stringBuffer) {
		stringBuffer.append("&access_token=").append(TravelSDK.INSTANCE.getLoginResult().getAccessToken());
		stringBuffer.append("&client=").append(TravelSDK.INSTANCE.getAgencyInfoResult().getAgencyId());
		stringBuffer.append("&app=and&ver=").append(TravelSDK.VERSION);
		stringBuffer.append("&user_id=").append(TravelSDK.INSTANCE.mobileClient);
	}

	/**
	 * Search for hotels by given criteria. Set search parameters before call
	 * this method.
	 * 
	 * @param processSearchHotels - Implement {@link ProcessSearchHotels} to
	 *            handle response. Must contains required and optional search
	 *            parameters
	 * 
	 * @see ProcessSearchHotels
	 */
	public void searchHotels(ProcessSearchHotels processSearchHotels) {
		HotelWS.search(processSearchHotels);
	}

	/**
	 * Browse hotel search results by filters
	 * 
	 * @param processFilterHotels - Implement {@link ProcessFilterHotels} to
	 *            handle response.
	 */
	public void getSearchHotelsResults(ProcessFilterHotels processFilterHotels) {
		HotelWS.getSearchResults(processFilterHotels);
	}

	/**
	 * Get more information about hotel
	 * 
	 * @param processHotelInfo - Implement {@link ProcessHotelInfo} to handle
	 *            response.
	 * 
	 * @see HotelsResult
	 */
	public void hotelInfo(ProcessHotelInfo processHotelInfo) {
		HotelWS.hotelInfo(processHotelInfo);
	}

	/**
	 * Verify that hotel fare is bookable
	 * 
	 * @param processVerify - Implement {@link ProcessVerify} to handle
	 *            response. 
	 */
	public void verifyHotel(ProcessHotelVerify processVerify) {
		HotelWS.verify(processVerify);
	}

	/**
	 * Search for flights by given criteria. Set search parameters before call
	 * this method.
	 * 
	 * @param processSearchFlights - Implement {@link ProcessSearchFlights} to
	 *            handle response. Must contains required and optional search
	 *            parameters.
	 */
	public void searchFlights(ProcessSearchFlights processSearchFlights) {
		FlightWS.search(processSearchFlights);
	}

	/**
	 * Browse flight search results by filters
	 * 
	 * @param processFilterFlights - Implement {@link ProcessFilterFlights} to
	 *            handle response. 
	 * 
	 * @see ProcessFilterFlights
	 */
	public void getSearchFlightsResults(ProcessFilterFlights processFilterFlights) {
		FlightWS.getSearchResults(processFilterFlights);
	}

	/**
	 * Verify that flight fare is bookable
	 * 
	 * @param processVerify - Implement {@link ProcessVerify} to handle
	 *            response.
	 */
	public void verifyFlight(ProcessFlightVerify processVerify) {
		FlightWS.verify(processVerify);
	}

	/**
	 * This method will return airline image for given airline code. <b>Not
	 * thread-safe, thread will be blocked until receive all bytes</b>
	 * 
	 * 
	 * @param airlineCode
	 * @return bytes data or null on error
	 */
	public byte[] getAirlineImage(String airlineCode) {
		return FlightWS.getAirlineImage(airlineCode);
	}

	/**
	 * Search for rentacars by given criteria. Set search parameters before call
	 * this method.
	 * 
	 * @param processSearchRentalcars - Implement
	 *            {@link ProcessSearchRentacars} to handle response. Must
	 *            contains required and optional search parameters.
	 */
	public void searchRentacars(ProcessSearchRentacars processSearchRentalcars) {
		RentacarWS.search(processSearchRentalcars);
	}

	/**
	 * Browse rentacar search results by filters.
	 * 
	 * @param processFilterRentacars - Implement
	 *            {@link ProcessFilterRentacars} to handle response.
	 * 
	 * @see ProcessFilterRentacars
	 */
	public void getSearchRentacarsResults(ProcessFilterRentacars processFilterRentacars) {
		RentacarWS.getSearchResults(processFilterRentacars);
	}

	/**
	 * Verify that rentacar is bookable
	 * 
	 * @param processVerify - Implement {@link ProcessVerify} to handle
	 *            response.
	 */
	public void verifyRentacar(ProcessRentacarVerify processVerify) {
		RentacarWS.verify(processVerify);
	}

	/**
	 * Search for esxursions by given criteria. Set search parameters before
	 * call this method.
	 * 
	 * @param processSearchExcursions - Implement
	 *            {@link ProcessSearchExcursions} to handle response. Must
	 *            contains required and optional search parameters.
	 */
	public void searchExcursions(ProcessSearchExcursions processSearchExcursions) {
		ExcursionWS.search(processSearchExcursions);
	}

	/**
	 * Browse excursions search results by filters.
	 * 
	 * @param processFilterExcursions - Implement
	 *            {@link ProcessFilterExcursions} to handle response.
	 * 
	 * @see ProcessFilterExcursions
	 */
	public void getSearchExcursionsResults(ProcessFilterExcursions processFilterExcursions) {
		ExcursionWS.getSearchResults(processFilterExcursions);
	}

	/**
	 * Verify that {@link Excursion} is bookable
	 * 
	 * @param processVerify - Implement {@link ProcessVerify} to handle
	 *            response.
	 */
	public void verifyExcursion(ProcessExcursionVerify processVerify) {
		ExcursionWS.verify(processVerify);
	}

	/**
	 * 
	 * @return true if initialization is successful. 
	 * (setingsResult, agencyInfoResult and loginResult are not null)
	 */
	public boolean isInitialized() {
		return settingsResult != null && agencyInfoResult != null && agencyInfoResult.isSuccess() && loginResult != null;
	}

	/**
	 * @return settings result. <i>null</i> if not initialized
	 */
	public SettingsResult getSettingsResult() {
		return settingsResult;
	}

	/**
	 * 
	 * @return agency information. <i>null</i> if not initialized
	 */
	public AgencyInfoResult getAgencyInfoResult() {
		return agencyInfoResult;
	}

	/**
	 * 
	 * @return login result. <i>null</i> if not initialized
	 */
	public LoginResult getLoginResult() {
		return loginResult;
	}

	/**
	 * 
	 * @return Client (Agency) ID
	 */
	protected String getClient() {
		return client;
	}

	protected String getEmail() {
		return email;
	}

	/**
	 * Search airpiorts by given criteria
	 * 
	 * @param query
	 * @param processSearchAirports
	 */
	public void searchAirports(ProcessSearchAirports processSearchAirports) {
		StringBuffer stringBuffer = new StringBuffer(settingsResult.getWsUrl());
		stringBuffer.append("?prgm=airport.search");
		stringBuffer.append("&airp=").append(URLEncoderUtil.encodeUTF8(processSearchAirports.getQuery()));
		appendStandartServiceParameters(stringBuffer);
		new RequestThread(stringBuffer.toString(), processSearchAirports).execute();
	}

	/**
	 * <b>Not thread-safe, thread will be blocked until receive all bytes</b>
	 * 
	 * @param url
	 * @param width
	 * @param height
	 * @return
	 */
	public byte[] getImage(String url, int width, int height) {
		StringBuffer stringBuffer = new StringBuffer(settingsResult.getWsUrl());
		stringBuffer.append("?prgm=image.download");
		appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&url=").append(URLEncoderUtil.encodeUTF8(url));
		stringBuffer.append("&width=").append(width);
		stringBuffer.append("&height=").append(height);
		stringBuffer.append("&mode=fit");
		try {
			return EntityUtils.toByteArray(HttpConnector.get(stringBuffer.toString(), null));
		} catch (Exception e) {
			return null;
		}
	}


	/**
	 * Book package. This will book all items added to the {@link Basket} in one package.
	 * 
	 * @param processBooking - implement {@link ProcessBooking} to handle
	 *            response.
	 */
	public void book(ProcessBooking processBooking) {
		if (!Basket.hasItems()) {
			processBooking.onComplete();
			return;
		}
		Hashtable<String, String> postParams = new Hashtable<String, String>();
		
		postParams.put("service", "book");
		postParams.put("access_token", TravelSDK.INSTANCE.getLoginResult().getAccessToken());
		postParams.put("client", agencyInfoResult.getAgencyId());
		postParams.put("user_id", mobileClient);
		postParams.put("user_name", email);
		postParams.put("app", "and");
		postParams.put("ver", TravelSDK.VERSION);
		postParams.put("security_token", securityToken);

		postParams.put("package_id", processBooking.getPackageId());
		postParams.put("onrequest", processBooking.isOnRequest() ? "2" : "1");
		postParams.put("totalprice", String.valueOf((float) Basket.getTotalPrice() / 100));
		postParams.put("totalprice_currency", Basket.getCurrency());

		appendCustomer(postParams, processBooking.getCustomerInfo());

		BasketItem[] basketItems = Basket.getBasketItems();
		int hotelCount = 0, flightCount = 0, rentacarCount = 0, excursionCount = 0;
		List<PersonInfo> persons = Basket.getPersons();
		for (int i = 0; i < basketItems.length; i++) {
			BasketItem basketItem = basketItems[i];			
			if (basketItem instanceof HotelBasketItem) {
				String hotelPrefix = "hotel[" + hotelCount + "]";
				postParams.put(hotelPrefix + "[session]", basketItem.getSession());
				postParams.put(hotelPrefix + "[recordid][]", ((HotelBasketItem) basketItem).getHotelFare()
						.getId());
				for (int p = 0; p < persons.size(); p++) {
					String hotelPaxPrefix = hotelPrefix + "[pax][" + p + "]";
					appendPax(postParams, (PersonInfo) persons.get(p), hotelPaxPrefix, String.valueOf(p + 1));
					postParams.put(hotelPaxPrefix + "[room]", "1");
				}
				hotelCount++;
			} else if (basketItem instanceof FlightBasketItem) {
				String flightPrefix = "flight[" + flightCount + "]";
				postParams.put(flightPrefix + "[session]", basketItem.getSession());
				postParams.put(flightPrefix + "[recordid]", ((FlightBasketItem) basketItem).getFlightFare().getId());
				Flight outFlight = (Flight) ((FlightBasketItem) basketItem).getFlightFare().getFlights().get(0);
				postParams.put(flightPrefix + "[out]", String.valueOf(outFlight.getConnection()));
				if (((FlightBasketItem) basketItem).getFlightFare().isRoundTrip()) {
					Flight inFlight = (Flight) ((FlightBasketItem) basketItem).getFlightFare().getFlights()
							.get(1);
					postParams.put(flightPrefix + "[in]", String.valueOf(inFlight.getConnection()));
				}
				for (int p = 0; p < persons.size(); p++) {
					appendPax(postParams, (PersonInfo) persons.get(p), flightPrefix + "[pax][" + p + "]",  String.valueOf(p + 1));
				}
				flightCount++;
			} else if (basketItem instanceof RentacarBasketItem) {
				String rentacarPrefix = "rentacar[" + rentacarCount + "]";
				postParams.put(rentacarPrefix + "[session]", basketItem.getSession());
				postParams
						.put(rentacarPrefix + "[recordid]", ((RentacarBasketItem) basketItem).getRentacar().getId());
				for (int p = 0; p < persons.size(); p++) {
					appendPax(postParams, (PersonInfo) persons.get(p), rentacarPrefix + "[pax][" + p + "]",  String.valueOf(p + 1));
				}
				rentacarCount++;
			} else if (basketItem instanceof ExcursionBasketItem) {
				String excursionPrefix = "excursion[" + excursionCount + "]";
				postParams.put(excursionPrefix + "[session]", basketItem.getSession());
				postParams.put(excursionPrefix + "[recordid]", ((ExcursionBasketItem) basketItem).getExcursion()
						.getId());
				for (int p = 0; p < persons.size(); p++) {
					appendPax(postParams, (PersonInfo) persons.get(p), excursionPrefix + "[pax][" + p + "]",  String.valueOf(p + 1));
				}
				excursionCount++;
			}
		}

		RequestThread requestThread = new RequestThread(settingsResult.getWsUrl(), processBooking);
		requestThread.setPostParams(postParams);

		requestThread.execute();
	}

	/**
	 * Receive list with bookings
	 * 
	 * @param processBookingsList
	 */
	public void receiveBookings(ProcessBookingsList processBookingsList) {
		StringBuffer stringBuffer = new StringBuffer(SERVER_IBE_BOOKING_URL);
		stringBuffer.append("?prgm=list_request");
		stringBuffer.append("&agency_id=").append(getAgencyInfoResult().getAgencyId());
		stringBuffer.append("&security_token=").append(securityToken);
		stringBuffer.append("&user_id=").append(mobileClient);
		stringBuffer.append("&source=4"); // Mobile(Blackberry)
		stringBuffer.append("&ver=").append(VERSION);
		stringBuffer.append("&user_name=").append(URLEncoderUtil.encodeUTF8(email));

		new RequestThread(stringBuffer.toString(), processBookingsList).execute();
	}

	private void appendCustomer(Hashtable<String, String> postParams, PersonInfo contactPerson) {
		postParams.put("customer[type]", contactPerson.getType());
		postParams.put("customer[age]", contactPerson.getAge());
		postParams.put("customer[salutation]", contactPerson.isMale() ? "Mr" : "Mrs");
		postParams.put("customer[lastname]", contactPerson.getLastName());
		postParams.put("customer[firstname]", contactPerson.getFirstName());
		postParams.put("customer[gender]", contactPerson.isMale() ? "M" : "F");
		postParams.put("customer[country]", contactPerson.getCountryCode());
		postParams.put("customer[street]", contactPerson.getStreet());
		postParams.put("customer[phone-country]", contactPerson.getPhoneCountryCode());
		postParams.put("customer[phone-area]", contactPerson.getPhoneAreaCode());
		postParams.put("customer[phone]", contactPerson.getPhone());
		postParams.put("customer[email]", contactPerson.getEmail());
		postParams.put("customer[zip]", contactPerson.getZip());
		postParams.put("customer[city]", contactPerson.getCity());
		postParams.put("customer[company]", contactPerson.getCompany());

	}

	private static void appendPax(Hashtable<String, String> postParams, PersonInfo personInfo, String prefix, String id) {
		postParams.put(prefix + "[firstname]", personInfo.getFirstName());
		postParams.put(prefix + "[lastname]", personInfo.getLastName());
		postParams.put(prefix + "[type]", personInfo.getType());
		postParams.put(prefix + "[age]", personInfo.getAge());
		postParams.put(prefix + "[salutation]", (personInfo.isMale() ? "Mr" : "Mrs"));
		if (!StringUtil.isNullOrEmpty(personInfo.getPassport())) {
			postParams.put(prefix + "[passport]", personInfo.getPassport());
			if (personInfo.getPassportExpireYear() > 0) {
				postParams.put(prefix + "[passportdate]",
						StringUtil.toDateSting_YYYY_MM_DD(personInfo.getPassportIssueYear(), 
								personInfo.getPassportIssueMonth(), personInfo.getPassportIssueDayOfMonth()));
				postParams.put(prefix + "[passportexp]",
						StringUtil.toDateSting_YYYY_MM_DD(personInfo.getPassportExpireYear(), 
								personInfo.getPassportExpireMonth(), personInfo.getPassportExpireDayOfMonth()));
				postParams.put(prefix + "[passportcountry]", personInfo.getCountryCode());
				postParams.put(prefix + "[passportcity]", personInfo.getCity());
			}
		}
		postParams.put(prefix + "[country]", personInfo.getCountryCode());
		postParams.put(prefix + "[gender]", (personInfo.isMale() ? "M" : "F"));
		postParams.put(prefix + "[id]", id);
	}

	/**
	 * Set true to enable debug log
	 * 
	 * @param isDebug
	 */
	public static void setDebug(boolean isDebug) {
		TravelSDK.isDebug = isDebug;
	}

	/**
	 * 
	 * @return Page limit for search results. Default is 20 results
	 */
	public int getPageLimit() {
		return pageLimit;
	}

	/**
	 * Set page limit for search results. Default is 20 results.
	 * 
	 * @param pageLimit
	 */
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	/**
	 * 
	 * @return Preferred currency code to use in search results
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Set preferred currency code to use in search results
	 * 
	 * @param currencyCode
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	
	/**
	 * 
	 * @return Mobile client identificator. Used by the TSDK API.
	 */
	public String getMobileClient() {
		return mobileClient;
	}
}
