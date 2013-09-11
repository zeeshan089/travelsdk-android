package com.travelfed.travelsdk;

import com.travelfed.travelsdk.bean.rentacar.RentacarFilterParameters;
import com.travelfed.travelsdk.bean.rentacar.RentacarSearchParameters;
import com.travelfed.travelsdk.process.ProcessFilterRentacars;
import com.travelfed.travelsdk.process.ProcessRentacarVerify;
import com.travelfed.travelsdk.process.ProcessSearchRentacars;
import com.travelfed.travelsdk.process.RequestThread;
import com.travelfed.travelsdk.util.StringUtil;

/**
 * 
 * @author krumstoilov
 *
 */
class RentacarWS {


	/**
	 * rentacar.search
	 * 
	 * @param processSearchRentalcars
	 */
	protected static void search(ProcessSearchRentacars processSearchRentalcars) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=rentacar.search");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&limit=").append(TravelSDK.INSTANCE.getPageLimit());
		RentacarSearchParameters searchParameters = processSearchRentalcars.getSearchParameters();
		if(searchParameters.getFromAirportId() != null) {
			// Search by airport code
			stringBuffer.append("&rac-from=").append(searchParameters.getFromAirportId());
			stringBuffer.append("&rac-to=").append(searchParameters.getToAirportId());
		} else {
			// Search by geolocation
			stringBuffer.append("&lat=").append(searchParameters.getLat());
			stringBuffer.append("&lon=").append(searchParameters.getLon());
			stringBuffer.append("&lat-dropoff=").append(searchParameters.getLatDropOf());
			stringBuffer.append("&lon-dropoff=").append(searchParameters.getLonDropOff());
			stringBuffer.append("&rad=").append(searchParameters.getRadius());
		}

		stringBuffer.append("&rac-dep-date=").append(
				StringUtil.toDateSting_YYYY_MM_DD(searchParameters.getDepartureYear(),
						searchParameters.getDepartureMonth(), searchParameters.getDepartureDayOfMonth()));
		// time is not working correctly
		stringBuffer.append("&rac-dep-time=1200");//.append(StringUtil.toTimeString(searchParameters.getDepartureTime()));

		stringBuffer.append("&rac-rt-date=")
				.append(StringUtil.toDateSting_YYYY_MM_DD(searchParameters.getReturnYear(), 
						searchParameters.getReturnMonth(), searchParameters.getReturnDayOfMonth()));
		// time is not working correctly
		stringBuffer.append("&rac-rt-time=1300");//.append(StringUtil.toTimeString(searchParameters.getReturnTime()));

		stringBuffer.append("&rac-size=").append(searchParameters.getCategory());
		if (searchParameters.isAirConditioned()) {
			stringBuffer.append("&rac-ac=1");
		}
		if (searchParameters.isAutomaticTransmission()) {
			stringBuffer.append("&rac-aut=1");
		}
		if (searchParameters.isStationWagon()) {
			stringBuffer.append("&rac-stw=1");
		}
		if (TravelSDK.INSTANCE.getCurrencyCode() != null) {
			stringBuffer.append("&currency=").append(TravelSDK.INSTANCE.getCurrencyCode());
		}
		// Result filters
		appendFilters(stringBuffer, processSearchRentalcars.getFilterParameters());

		new RequestThread(stringBuffer.toString(), processSearchRentalcars, true).execute();
	}

	/**
	 * rentacar.search results with page offset
	 * 
	 * @param session
	 * @param offset
	 * @param processSearchRentalcars
	 */
	protected static void getSearchResults(ProcessFilterRentacars processFilterRentacars) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=rentacar.search");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&limit=").append(TravelSDK.INSTANCE.getPageLimit());
		stringBuffer.append("&session=").append(processFilterRentacars.getRentacarsResult().getSession());
		// Result filters
		appendFilters(stringBuffer, processFilterRentacars.getFilterParameters());

		RequestThread requestThread = new RequestThread(stringBuffer.toString(), processFilterRentacars, true);
		requestThread.execute();
	}

	/**
	 * WS will filter search result by specified parameters
	 * 
	 * @param stringBuffer
	 * @param rentacarFilterParameters
	 */
	private static void appendFilters(StringBuffer stringBuffer, RentacarFilterParameters rentacarFilterParameters) {
		if (rentacarFilterParameters == null) {
			return;
		}
		stringBuffer.append("&offset=").append(rentacarFilterParameters.getOffset());
		if (rentacarFilterParameters.getMinPrice() != -1) {
			stringBuffer.append("price[0]=").append(rentacarFilterParameters.getMinPrice());
		}
		if (rentacarFilterParameters.getMaxPrice() != -1) {
			stringBuffer.append("price[1]=").append(rentacarFilterParameters.getMaxPrice());
		}
		if (rentacarFilterParameters.getMinPassengers() != -1) {
			stringBuffer.append("passengers[0]=").append(rentacarFilterParameters.getMinPassengers());
		}
		if (rentacarFilterParameters.getMaxPassengers() != -1) {
			stringBuffer.append("passengers[1]=").append(rentacarFilterParameters.getMaxPassengers());
		}
		if (rentacarFilterParameters.isAutomatic()) {
			stringBuffer.append("automatic=1");
		}
		if (rentacarFilterParameters.isAirConditioner()) {
			stringBuffer.append("ac=1");
		}
		if (rentacarFilterParameters.isUnlimited()) {
			stringBuffer.append("unlimited=1");
		}
		if (rentacarFilterParameters.getStationCodes() != null) {
			for (int i = 0; i < rentacarFilterParameters.getStationCodes().length; i++) {
				stringBuffer.append("station[]=").append(rentacarFilterParameters.getStationCodes()[i]);
			}
		}
		if (rentacarFilterParameters.getVendorCodes() != null) {
			for (int i = 0; i < rentacarFilterParameters.getVendorCodes().length; i++) {
				stringBuffer.append("vendor[]=").append(rentacarFilterParameters.getVendorCodes()[i]);
			}
		}
		if (rentacarFilterParameters.getCities() != null) {
			for (int i = 0; i < rentacarFilterParameters.getCities().length; i++) {
				stringBuffer.append("city[]=").append(rentacarFilterParameters.getCities()[i]);
			}
		}
	}

	protected static void verify(ProcessRentacarVerify processVerify) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=rentacar.verify");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&session=").append(processVerify.getRentacar().getRentacarsResult().getSession());
		stringBuffer.append("&recordid=").append(processVerify.getRentacar().getId());
		new RequestThread(stringBuffer.toString(), processVerify).execute();
	}
}
