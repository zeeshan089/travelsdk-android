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
package com.travelfed.travelsdk.bean.hotel;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.SearchListResult;
import com.travelfed.travelsdk.process.ProcessSearchHotels;

/**
 *  Result from searchHotels or getSearchHotelsResults.
 */
public class HotelsResult extends SearchListResult {
	
	private final static String RECORDS = "records";
	
	private ProcessSearchHotels processSearchHotels;
	private List<HotelFare> hotelsFares = new ArrayList<HotelFare>();
	
	public HotelsResult(JSONObject json, ProcessSearchHotels processSearchHotels) throws JSONException  {
		super(json);
		this.processSearchHotels = processSearchHotels;
		if (json.has(RECORDS)) {
			JSONArray jsonArray = json.getJSONArray(RECORDS);
			for (int i = 0; i < jsonArray.length(); i++) {
				HotelFare elem = new HotelFare(this, jsonArray.getJSONObject(i));
				this.hotelsFares.add(elem);
			}
		}
	}

	/**
	 * 
	 * @return List with {@link HotelFare} objects
	 */
	public List<HotelFare> getHotelsFares() {
		return hotelsFares;
	}

	public ProcessSearchHotels getProcessSearchHotels() {
		return processSearchHotels;
	}
	
}
