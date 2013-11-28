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
package com.travelfed.travelsdk.basket;

import java.util.List;
import java.util.Vector;

import com.travelfed.travelsdk.TravelSDKException;

/**
 * Basket class is for static store basket items {@link BasketItem}.
 * TravelSDK.book(...) method books all items stored in the basket.<br>
 * The Basket has logic for containing only one item of a same type. 
 * Only one {@link FlightBasketItem}, {@link HotelBasketItem}, {@link RentacarBasketItem} and {@link ExcursionBasketItem}
 * If you try to add second item of a same type, the first added item will be removed.<br>
 * After the booking the basket will be cleared automatically by the API.
 */
public class Basket {
	
	private static long totalPrice;
	private static String currency;

	private static Vector<BasketItem> items = new Vector<BasketItem>();
	
	private static List<PersonInfo> persons;
	
	/**
	 * @return Array with all items added to the basket.
	 */
	public static BasketItem[] getBasketItems() {
		BasketItem[] result = new BasketItem[items.size()];
		items.copyInto(result);
		return result;
	}

	/**
	 * Adds basket item to the basket. The basket can contain only one item of a same type.
	 * Only one {@link HotelBasketItem}, one {@link FlightBasketItem}, one {@link RentacarBasketItem} and one {@link ExcursionBasketItem}.
	 * If you try to add second item of a same type, the previous item will be removed.
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
	
	/**
	 * Removes given item from the basket.
	 * 
	 * @param basketItem The basket item to remove.
	 */
	public static void removeBasketItem(BasketItem basketItem) {
		items.removeElement(basketItem);
		totalPrice = totalPrice - basketItem.getTotal();
		if(items.size() == 0) {
			currency = null;
			totalPrice = 0;
		}
	}
	
	/**
	 * Check the basket is empty.
	 * 
	 * @return true if the basket is not empty.
	 */
	public static boolean hasItems() {
		return (items.size()) > 0;
	}
	
	/**
	 * This method is requested automatically by the API after completion of the booking process.
	 * Removes all basket items.
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
	
	/**
	 * 
	 * @return Total price of all items added to the basket.
	 */
	public static long getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 
	 * @return Currency code.
	 */
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
