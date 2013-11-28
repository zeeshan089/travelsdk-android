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
package com.travelfed.travelsdk.process;


/**
 * Error codes.
 */
public class ErrorCodes {


	/**
	 * The item currency code is different. Caused by Basket.addBasketItem();
	 */
	public static final String ERROR_DIFERENT_CURRENCY = "ERROR_DIFERENT_CURRENCY";

	/**
	 * prgm parameter is missing/empty. Should never happens.
	 */
	public static final String ERROR_PROGRAM_EMPTY = "PROGRAM_EMPTY";

	/**
	 * prgm is invalid. Should never happens.
	 */
	public static final String ERROR_PROGRAM_UNSUPPORTED = "PROGRAM_UNSUPPORTED";
	
	/**
	 * client parameter is missing/empty. Should never happens.
	 */
	public static final String ERROR_SESSION_CLIENT_EMPTY = "SESSION_CLIENT_EMPTY";

	/**
	 * The request session is created by different client. Should never happens.
	 */
	public static final String ERROR_SESSION_CLIENT_MISMATCH = "SESSION_CLIENT_MISMATCH";

	/**
	 * Session id requested is not found. probably expired.
	 */
	public static final String ERROR_SESSION_ID_MISMATCH = "SESSION_ID_MISMATCH";

	/**
	 * Session expired. Session id is generated on search request 
	 * (flight search, hotel search rentacar search and excursion search). 
	 * Session expire after specified time period in the server
	 * and this error will to occur if you try to verify, 
	 * book an item or make some other request the requires session id.
	 * There is still the case where the session has
	 * expired and considerable time has passed and so it is deleted and
	 * SESSION_ID_MISMATCH is returned
	 */
	public static final String ERROR_SESSION_EXPIRED = "SESSION_EXPIRED";

	/**
	 * Means that some supplier returned unexpected response. needs human
	 * intervention to know what it is
	 */
	public static final String ERROR_SUPPLIER_UNEXPECTED_RESPONSE = "SUPPLIER_UNEXPECTED_RESPONSE";

	/**
	 * This error is returned by different functions when record id is expected
	 * but the provided one is not valid
	 */
	public static final String ERROR_RECORDID_MISMATCH = "RECORDID_MISMATCH";

	/**
	 * The record is not bookable anymore
	 */
	public static final String ERROR_VERIFY_NOTBOOKABLE = "VERIFY_NOTBOOKABLE";

	/**
	 * The record is bookable but the price is changed and greater than original
	 */
	public static final String ERROR_VERIFY_PRICE_GREATER = "VERIFY_PRICE_GREATER";

	/**
	 * The record is bookable but the price is changed and less than original
	 */
	public static final String ERROR_VERIFY_PRICE_LESS = "VERIFY_PRICE_LESS";

	/**
	 * The verify request failed
	 */
	public static final String ERROR_VERIFY_FAILED = "VERIFY_FAILED";

	/**
	 * The out parameter is missing/empty
	 */
	public static final String ERROR_VERIFY_OUTBOUND_ID_EMPTY = "VERIFY_OUTBOUND_ID_EMPTY";

	/**
	 * The detailscc call failed. only when detailscc request is required to be
	 * sent automatically by the service
	 */
	public static final String ERROR_VERIFY_DETAILSCC_FAILED = "VERIFY_DETAILSCC_FAILED";

	/**
	 * The connection id of the out parameter is not found in the detailsscc
	 * response. Only when detailscc request is required to be sent
	 * automatically by the service
	 */
	public static final String ERROR_VERIFY_BAD_OUTBOUND_CONNECTION_ID = "VERIFY_BAD_OUTBOUND_CONNECTION_ID";

	/**
	 * The connection id of the in parameter is not found in the detailsscc
	 * response. Only when detailscc request is required to be sent
	 * automatically by the service
	 */
	public static final String ERROR_VERIFY_BAD_INBOUND_CONNECTION_ID = "VERIFY_BAD_INBOUND_CONNECTION_ID";

	/**
	 * When recorid parameter is not specified then you must run detailsscc by
	 * yourself
	 */
	public static final String ERROR_VERIFY_DETAILSCC_NOT_RUN = "VERIFY_DETAILSCC_NOT_RUN";

	/**
	 * The outbound connection id is not found in the session
	 */
	public static final String ERROR_VERIFY_BAD_OUTBOUND_ID = "VERIFY_BAD_OUTBOUND_ID";

	/**
	 * When the out/inbound flights belong to different fares
	 */
	public static final String ERROR_VERIFY_FLIGHTS_ID_MISMATCH = "VERIFY_FLIGHTS_ID_MISMATCH";

	/**
	 * Booking failed. this means that verify succeeded but the actual booking
	 * failed
	 */
	public static final String ERROR_BOOK_FAILED = "BOOK_FAILED";

	/**
	 * The booking id to be canceled is invalid
	 */
	public static final String ERROR_BOOKID_MISMATCH = "BOOKID_MISMATCH";

	/**
	 * Access token expired. Should never happens.
	 */
	public static final String ERROR_TOKEN_EXPIRED = "TOKEN_EXPIRED";

	/**
	 * Other possible errors: Parse error, IO error, wrong http response code.
	 */
	public static final String ERROR_RESPONSE = "ERROR_RESPONSE";
	
	/**
	 * Connection error.
	 */
	public static final String ERROR_HTTP_CONNECTION = "ERROR_HTTP_CONNECTION";


}
