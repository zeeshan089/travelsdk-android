package com.travelfed.travelsdk;

import com.travelfed.travelsdk.bean.excursion.ExcursionFilterParameters;
import com.travelfed.travelsdk.bean.excursion.ExcursionSearchParameters;
import com.travelfed.travelsdk.process.ProcessExcursionVerify;
import com.travelfed.travelsdk.process.ProcessFilterExcursions;
import com.travelfed.travelsdk.process.ProcessSearchExcursions;
import com.travelfed.travelsdk.process.RequestThread;
import com.travelfed.travelsdk.util.StringUtil;
import com.travelfed.travelsdk.util.URLEncoderUtil;

/**
 * 
 * @author krumstoilov
 */
class ExcursionWS {

	/**
	 * excursion.search
	 * 
	 * @param processSearchExcursions
	 */
	protected static void search(ProcessSearchExcursions processSearchExcursions) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=excursion.search");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&offset=0&limit=").append(TravelSDK.INSTANCE.getPageLimit());
		ExcursionSearchParameters searchParameters = processSearchExcursions.getSearchParameters();
		if (searchParameters.getAirportId() != null) {
			// search by airpot IATA code
			stringBuffer.append("&airp=").append(searchParameters.getAirportId());
		} else {
			// search by location
			stringBuffer.append("&lat=").append(searchParameters.getLat());
			stringBuffer.append("&lon=").append(searchParameters.getLon());
		}
		stringBuffer.append("&rad=").append(searchParameters.getRadius());
		stringBuffer.append("&fromdate=").append(StringUtil.toDateString(searchParameters.getFromDateYear(), 
				searchParameters.getFromDateMonth(), searchParameters.getFromDateDayOfMonth()));
		stringBuffer.append("&todate=").append(StringUtil.toDateString(searchParameters.getToDateYear(), 
				searchParameters.getToDateMonth(), searchParameters.getToDateDayOfMonth()));
		stringBuffer.append("&adt=").append(searchParameters.getNumberOfAdults());
		if (searchParameters.getChildrenAges() != null) {
			for (int i = 0; i < searchParameters.getChildrenAges().length; i++) {
				stringBuffer.append("&chd" + (i + 1) + "=");
				stringBuffer.append(searchParameters.getChildrenAges()[i]);
			}
		}

		if (TravelSDK.INSTANCE.getCurrencyCode() != null) {
			stringBuffer.append("&currency=").append(TravelSDK.INSTANCE.getCurrencyCode());
		}
		// Result filters
		appendFilterParameters(stringBuffer, processSearchExcursions.getFilterParameters());

		new RequestThread(stringBuffer.toString(), processSearchExcursions, true).execute();
	}

	/**
	 * page results from excursion.search
	 * 
	 * @param session
	 * @param offset
	 * @param processSearchExcursions
	 */
	protected static void getSearchResults(ProcessFilterExcursions processFilterExcursions) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=excursion.search");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&limit=").append(TravelSDK.INSTANCE.getPageLimit());
		stringBuffer.append("&session=").append(processFilterExcursions.getExcursionResult().getSession());
		// Result filters
		appendFilterParameters(stringBuffer, processFilterExcursions.getFilterParameters());

		new RequestThread(stringBuffer.toString(), processFilterExcursions, true).execute();
	}

	/**
	 * WS will filter search result by specified parameters
	 * 
	 * @param stringBuffer
	 * @param filterParameters
	 */
	private static void appendFilterParameters(StringBuffer stringBuffer, ExcursionFilterParameters filterParameters) {
		if (filterParameters == null) {
			return;
		}
		stringBuffer.append("&offset=").append(filterParameters.getOffset());
		if (filterParameters.getMinPrice() != -1) {
			stringBuffer.append("&price[0]=").append(filterParameters.getMinPrice());
		}
		if (filterParameters.getMaxPrice() != -1) {
			stringBuffer.append("&price[1]=").append(filterParameters.getMaxPrice());
		}
		if (filterParameters.getName() != null) {
			stringBuffer.append("&name=").append(URLEncoderUtil.encodeUTF8(filterParameters.getName()));
		}

		String[] productTypes = filterParameters.getProductTypes();
		if (productTypes != null) {
			for (int i = 0; i < productTypes.length; i++) {
				stringBuffer.append("&p_type[]=").append(productTypes[i]);
			}
		}
		String[] cities = filterParameters.getCities();
		if (cities != null) {
			for (int i = 0; i < cities.length; i++) {
				stringBuffer.append("&city[]=").append(cities[i]);
			}
		}

		String[] suppliers = filterParameters.getSuppliers();
		if (suppliers != null) {
			for (int i = 0; i < suppliers.length; i++) {
				stringBuffer.append("&supplier[]=").append(suppliers[i]);
			}
		}
	}

	/**
	 * 
	 * @param processVerify
	 */
	protected static void verify(ProcessExcursionVerify processVerify) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=excursion.verify");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&session=").append(processVerify.getExcursion().getExcursionResult().getSession());
		stringBuffer.append("&recordid=").append(processVerify.getExcursion().getId());
		new RequestThread(stringBuffer.toString(), processVerify).execute();
	}

}
