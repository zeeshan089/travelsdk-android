package com.travelfed.travelsdk.basket;

import java.util.List;
import java.util.Vector;

import com.travelfed.travelsdk.TravelSDKException;

/**
 * Basket class is for static store all {@link BasketItem}.
 * TravelSDK.book(...) method books all items stored in the basket.<br>
 * The Basket has logic for containing only one item of a same type. 
 * Only one {@link FlightBasketItem}, {@link HotelBasketItem}, {@link RentacarBasketItem} and {@link ExcursionBasketItem}
 * If you try to add second item of a same type, the first added item will be removed.<br>
 * After a booking the basket will be cleared by the API.
 */
public class Basket {
	
	private static long totalPrice;
	private static String currency;

	private static Vector<BasketItem> items = new Vector<BasketItem>();
	
	private static List<PersonInfo> persons;
	
	/**
	 * @return Array with all basket items
	 */
	public static BasketItem[] getBasketItems() {
		BasketItem[] result = new BasketItem[items.size()];
		items.copyInto(result);
		return result;
	}

	/**
	 * 
	 * @param basketItem - {@link HotelBasketItem}, {@link FlightBasketItem}, {@link RentacarBasketItem} or {@link ExcursionBasketItem}
	 * @throws TravelSDKException when currency of given basket item differs from currency of previous added items
	 */
	public static void addBasketItem(BasketItem basketItem) throws TravelSDKException {
		if (currency != null && !currency.equals(basketItem.getCurrency())) {
			throw new TravelSDKException("ERROR_DIFERENT_CURRENCY");
		}
		// Allow only one item of a type
		for(int i=0; i< items.size(); i++) {
			if(items.elementAt(i).getClass().isInstance(basketItem)) {
				removeBasketItem((BasketItem)items.elementAt(i));
				break;
			}
		}
		
		items.addElement(basketItem);
		totalPrice = totalPrice + basketItem.getTotal();
		currency = basketItem.getCurrency();
	}
	
	public static void removeBasketItem(BasketItem basketItem) {
		items.removeElement(basketItem);
		totalPrice = totalPrice - basketItem.getTotal();
		if(items.size() == 0) {
			currency = null;
			totalPrice = 0;
		}
	}
	
	public static boolean hasItems() {
		return (items.size()) > 0;
	}
	
	/**
	 * Removes all items from the basket
	 */
	public static void removeAll() {
		for(int i =0; i< items.size(); i++) {
			BasketItem basketItem = (BasketItem) items.elementAt(i);
//			if(basketItem.isBookable()) {
				removeBasketItem(basketItem);
				i--;
//			}			
		}
	}
	
	public static long getTotalPrice() {
		return totalPrice;
	}

	public static String getCurrency() {
		return currency;
	}

	/**
	 * 
	 * @return  All travelers (hotel quests, flight passengers).
	 */
	public static List<PersonInfo> getPersons() {
		return persons;
	}

	/**
	 * 
	 * @param persons - all travelers (hotel quests, flight passengers).
	 */
	public static void setPersons(List<PersonInfo> persons) {
		Basket.persons = persons;
	}

	
}
