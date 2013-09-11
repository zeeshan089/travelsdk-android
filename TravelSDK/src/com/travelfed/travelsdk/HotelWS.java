package com.travelfed.travelsdk;

import com.travelfed.travelsdk.bean.hotel.HotelFilterParameters;
import com.travelfed.travelsdk.bean.hotel.HotelSearchParameters;
import com.travelfed.travelsdk.process.ProcessFilterHotels;
import com.travelfed.travelsdk.process.ProcessHotelInfo;
import com.travelfed.travelsdk.process.ProcessHotelVerify;
import com.travelfed.travelsdk.process.ProcessSearchHotels;
import com.travelfed.travelsdk.process.RequestThread;
import com.travelfed.travelsdk.util.StringUtil;
import com.travelfed.travelsdk.util.URLEncoderUtil;

/**
 * 
 * @author krumstoilov
 *
 */
class HotelWS {

	/**
	 * hotel.search
	 * 
	 * @param processSearchHotels
	 */
	protected static void search(ProcessSearchHotels processSearchHotels) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=hotel.search");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&offset=0&limit=").append(TravelSDK.INSTANCE.getPageLimit());
		HotelSearchParameters searchParameters = processSearchHotels.getSearchParameters();
		stringBuffer.append("&lat=").append(searchParameters.getLat());
		stringBuffer.append("&lon=").append(searchParameters.getLon());
		stringBuffer.append("&rad=").append(searchParameters.getRadius());
		stringBuffer.append("&dep=").append(StringUtil.toDateString(searchParameters.getDepartureYear(), 
				searchParameters.getDepartureMonth(), searchParameters.getDepartureDayOfMonth()));
		stringBuffer.append("&ret=").append(StringUtil.toDateString(searchParameters.getReturnYear(), 
				searchParameters.getReturnMonth(), searchParameters.getReturnDayOfMonth()));
//		if (searchParameters.getRoomsPersons() != null) {
//			for (int iR = 0; iR < searchParameters.getRoomsPersons().length; iR++) {
//				stringBuffer.append("&room").append((iR + 1)).append("-adt=")
//						.append(searchParameters.getRoomsPersons()[iR].getNumberOfAdults());
//				if (searchParameters.getRoomsPersons()[iR].getChildrenAges() != null) {
//					for (int i = 0; i < searchParameters.getRoomsPersons()[iR].getChildrenAges().length; i++) {
//						if (searchParameters.getRoomsPersons()[iR].getChildrenAges()[i] == 0) {
//							break;
//						}
//						stringBuffer.append("&room").append((iR + 1)).append("-chd").append(i + 1).append("=")
//								.append(searchParameters.getRoomsPersons()[iR].getChildrenAges()[i]);
//					}
//				}
//			}
//		}
		stringBuffer.append("&room1").append("-adt=").append(searchParameters.getRoomPersons().getNumberOfAdults());
		if (searchParameters.getRoomPersons().getChildrenAges() != null) {
			for (int i = 0; i < searchParameters.getRoomPersons().getChildrenAges().length; i++) {
				if (searchParameters.getRoomPersons().getChildrenAges()[i] == 0) {
					break;
				}
				stringBuffer.append("&room1").append("-chd").append(i + 1).append("=")
						.append(searchParameters.getRoomPersons().getChildrenAges()[i]);
			}
		}
		if (searchParameters.getMinHotelCategory() > 0) {
			stringBuffer.append("&hcat=").append(searchParameters.getMinHotelCategory());
		}
		if (searchParameters.getBoardType() != null) {
			stringBuffer.append("&bt=").append(searchParameters.getBoardType());
		}
		if (TravelSDK.INSTANCE.getCurrencyCode() != null) {
			stringBuffer.append("&currency=").append(TravelSDK.INSTANCE.getCurrencyCode());
		}
		// Result filters
		appendFilterParameters(stringBuffer, processSearchHotels.getFilterParameters());

		new RequestThread(stringBuffer.toString(), processSearchHotels, true).execute();
	}

	/**
	 * page results from hotel.search
	 * 
	 * @param session
	 * @param offset
	 * @param processSearchHotels
	 */
	protected static void getSearchResults(ProcessFilterHotels processFilterHotels) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=hotel.search");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&limit=").append(TravelSDK.INSTANCE.getPageLimit());
		stringBuffer.append("&session=").append(processFilterHotels.getHotelsFaresResult().getSession());
		// Result filters
		appendFilterParameters(stringBuffer, processFilterHotels.getFilterParameters());

		new RequestThread(stringBuffer.toString(), processFilterHotels, true).execute();
	}

	/**
	 * WS will filter search result by specified parameters
	 * 
	 * @param stringBuffer
	 * @param filterParameters
	 */
	private static void appendFilterParameters(StringBuffer stringBuffer, HotelFilterParameters filterParameters) {
		if (filterParameters == null) {
			return;
		}
		stringBuffer.append("&offset=").append(filterParameters.getOffset());
		if (filterParameters.getMinStars() != -1) {
			stringBuffer.append("&hotel_stars[0]=").append(filterParameters.getMinStars());
		}
		if (filterParameters.getMaxStars() != -1) {
			stringBuffer.append("&hotel_stars[1]=").append(filterParameters.getMaxStars());
		}
		if (filterParameters.getMinPrice() != -1) {
			stringBuffer.append("&price[0]=").append(filterParameters.getMinPrice());
		}
		if (filterParameters.getMaxPrice() != -1) {
			stringBuffer.append("&price[1]=").append(filterParameters.getMaxPrice());
		}
		String[] boardTypes = filterParameters.getBoardTypes();
		if (boardTypes != null) {
			for (int i = 0; i < boardTypes.length; i++) {
				stringBuffer.append("&b_type[]=").append(boardTypes[i]);
			}
		}
		String[] roomTypes = filterParameters.getRoomTypes();
		if (roomTypes != null) {
			for (int i = 0; i < roomTypes.length; i++) {
				stringBuffer.append("&r_type[]=").append(roomTypes[i]);
			}
		}

		if (filterParameters.getHotelName() != null) {
			stringBuffer.append("&hotel_name=").append(URLEncoderUtil.encodeUTF8(filterParameters.getHotelName()));
		}
	}

	/**
	 * receive detail hotel information
	 * 
	 * @param session
	 * @param recordId
	 * @param processHotelInfo
	 */
	protected static void hotelInfo(ProcessHotelInfo processHotelInfo) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=hotel.information");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&session=").append(processHotelInfo.getHotelFare().getHotelsFaresResult().getSession());
		stringBuffer.append("&recordid=").append(processHotelInfo.getHotelFare().getId());
		new RequestThread(stringBuffer.toString(), processHotelInfo, true).execute();
	}

	/**
	 * 
	 * @param processVerify
	 */
	protected static void verify(ProcessHotelVerify processVerify) {
		StringBuffer stringBuffer = new StringBuffer(TravelSDK.INSTANCE.getSettingsResult().getWsUrl());
		stringBuffer.append("?prgm=hotel.verify");
		TravelSDK.appendStandartServiceParameters(stringBuffer);
		stringBuffer.append("&session=").append(processVerify.getHotelFare().getHotelsFaresResult().getSession());
		stringBuffer.append("&recordid[]=").append(processVerify.getHotelFare().getId());
		new RequestThread(stringBuffer.toString(), processVerify).execute();
	}

}
