package com.travelfed.travelsdk;

import java.util.Hashtable;

import org.apache.http.util.EntityUtils;

import com.travelfed.travelsdk.bean.flight.Flight;
import com.travelfed.travelsdk.bean.flight.FlightFilterParameters;
import com.travelfed.travelsdk.bean.flight.FlightSearchParameters;
import com.travelfed.travelsdk.http.HttpConnector;
import com.travelfed.travelsdk.process.ProcessFilterFlights;
import com.travelfed.travelsdk.process.ProcessFlightVerify;
import com.travelfed.travelsdk.process.ProcessSearchFlights;
import com.travelfed.travelsdk.process.RequestThread;
import com.travelfed.travelsdk.util.StringUtil;

/**
 * All flight ws requests
 * 
 * @author krumstoilov
 */
class FlightWS {

	/** Cache downloaded airline images **/
	private static Hashtable<String, byte[]> airlinesIcons = new Hashtable<String, byte[]>();

	/**
	 * flight.search
	 * 
	 * @param processSearchFlights
	 */
	protected static void search(ProcessSearchFlights processSearchFlights) {
		airlinesIcons.clear();
		
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=flight.search");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&offset=0&limit=").append(TravelSDK.INSTANCE.getPageLimit());
		FlightSearchParameters searchParameters = processSearchFlights.getSearchParameters();
		stringBuffer.append("&flight-from=").append(searchParameters.getFromAirportId());
		stringBuffer.append("&flight-to=").append(searchParameters.getToAirportId());
		stringBuffer.append("&flight-dep-date=").append(
				StringUtil.toDateString(searchParameters.getDepartureYear(), 
						searchParameters.getDepartureMonth(), searchParameters.getDepartureDayOfMonth()));
		if (searchParameters.isRoundTrip()) {
			stringBuffer.append("&flight-rt-date=").append(
					StringUtil.toDateString(searchParameters.getReturnYear(), 
							searchParameters.getReturnMonth(), searchParameters.getReturnDayOfMonth()));
		}
		stringBuffer.append("&flight-type=").append(searchParameters.isRoundTrip() ? "rt" : "ow");
		stringBuffer.append("&pax=").append(searchParameters.getNumberOfAdults());
		stringBuffer.append("&chpax=").append(searchParameters.getNumberOfChildren());
		stringBuffer.append("&infpax=").append(searchParameters.getNumberOfInfants());
		if (searchParameters.getCabinClass() != null) {
			stringBuffer.append("&cabinclass=").append(searchParameters.getCabinClass());
		}
		if (searchParameters.getCarrierCode() != null) {
			stringBuffer.append("&carrier-code=").append(searchParameters.getCarrierCode());
		}
		if (searchParameters.isDirect()) {
			stringBuffer.append("&directflights=true");
		}
		if (TravelSDK.INSTANCE.getCurrencyCode() != null) {
			stringBuffer.append("&currency=").append(TravelSDK.INSTANCE.getCurrencyCode());
		}
		// Result filters
		appendFilterParameters(stringBuffer, processSearchFlights.getFilterParameters());

		new RequestThread(stringBuffer.toString(), processSearchFlights, true).execute();
	}

	/**
	 * flight.search results with page offset
	 * 
	 * @param session
	 * @param offset
	 * @param processSearchFlights
	 */
	protected static void getSearchResults(ProcessFilterFlights processFilterFlights) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=flight.search");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&limit=").append(TravelSDK.INSTANCE.getPageLimit());
		stringBuffer.append("&session=").append(processFilterFlights.getFlightsFaresResult().getSession());
		// Result filters
		appendFilterParameters(stringBuffer, processFilterFlights.getFilterParameters());
		new RequestThread(stringBuffer.toString(), processFilterFlights, true).execute();
	}

	/**
	 * WS will filter search result by specified parameters
	 * 
	 * @param stringBuffer
	 * @param filterParameters
	 */
	private static void appendFilterParameters(StringBuffer stringBuffer, FlightFilterParameters filterParameters) {
		if (filterParameters == null) {
			return;
		}
		stringBuffer.append("&offset=").append(filterParameters.getOffset());
		
		if (filterParameters.isDirectOnly()) {
			stringBuffer.append("&direct=1");
		}
		if (filterParameters.getMaxStopsOut() != -1) {
			stringBuffer.append("&stops[out]=").append(filterParameters.getMaxStopsOut());
		}
		if (filterParameters.getMaxStopsIn() != -1) {
			stringBuffer.append("&stops[in]=").append(filterParameters.getMaxStopsIn());
		}
		if (filterParameters.getMinOutDepartureTime() != -1) {
			stringBuffer.append("&out_time[0]=").append(filterParameters.getMinOutDepartureTime());
		}
		if (filterParameters.getMaxOutDepartureTime() != -1) {
			stringBuffer.append("&out_time[1]=").append(filterParameters.getMaxOutDepartureTime());
		}
		if (filterParameters.getMinInDepartureTime() != -1) {
			stringBuffer.append("&in_time[0]=").append(filterParameters.getMinInDepartureTime());
		}
		if (filterParameters.getMaxInDepartureTime() != -1) {
			stringBuffer.append("&in_time[1]=").append(filterParameters.getMaxInDepartureTime());
		}
		String[] airlineCodes = filterParameters.getAirlineCodes();
		if (airlineCodes != null) {
			for (int i = 0; i < airlineCodes.length; i++) {
				stringBuffer.append("&airline[]=").append(airlineCodes[i]);
			}
		}
		String[] cabbinClasses = filterParameters.getCabinClasses();
		if (cabbinClasses != null) {
			for (int i = 0; i < cabbinClasses.length; i++) {
				stringBuffer.append("&cabin_class[]=").append(cabbinClasses[i]);
			}
		}
		if (filterParameters.getMinPrice() != -1) {
			stringBuffer.append("&price[0]=").append(filterParameters.getMinPrice());
		}
		if (filterParameters.getMaxPrice() != -1) {
			stringBuffer.append("&price[1]=").append(filterParameters.getMaxPrice());
		}
	}

	protected static void verify(ProcessFlightVerify processVerify) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=flight.verify");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&session=").append(processVerify.getFlightFare().getFlightsFaresResult().getSession());
		stringBuffer.append("&recordid=").append(processVerify.getFlightFare().getId());
		Flight outFlight = (Flight) processVerify.getFlightFare().getFlights().get(0);

		stringBuffer.append("&out=").append(outFlight.getConnection());
		if (processVerify.getFlightFare().isRoundTrip()) {
			Flight inFlight = (Flight) processVerify.getFlightFare().getFlights().get(1);
			stringBuffer.append("&in=").append(inFlight.getConnection());
		}

		new RequestThread(stringBuffer.toString(), processVerify).execute();
	}

	/**
	 * Not thread-safe, thread will be blocked until receive all bytes
	 * 
	 * @param airlineCode
	 * @return bytes data or null on error
	 */
	protected static byte[] getAirlineImage(String airlineCode) {
		return getAirlineImage(airlineCode, true);
	}

	/**
	 * Not thread-safe, thread will be blocked if requestOnNull and not stored
	 * until receive all bytes
	 * 
	 * @param airlineCode
	 * @param requestOnNull
	 */
	protected static byte[] getAirlineImage(String airlineCode, boolean requestOnNull) {
		Object dataObject = airlinesIcons.get(airlineCode);
		if (dataObject != null) {
			return (byte[]) dataObject;
		}
		if (!requestOnNull) {
			return null;
		}
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getAirlineIconsUrl());
		stringBuffer.append("logo-").append(airlineCode).append(".gif");
		try {
			byte[] data = EntityUtils.toByteArray(HttpConnector.get(stringBuffer.toString(), null));
			airlinesIcons.put(airlineCode, data);
			return data;
		} catch (Exception e) {
			return null;
		}
	}
}
