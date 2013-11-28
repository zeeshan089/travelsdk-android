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
package com.travelfed.travelsdk.bean.flight;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.Logger;
import com.travelfed.travelsdk.util.StringUtil;


/**
 *  Flight for flight fare. Flight can be outbound or inbound
 */
public class Flight {
	
	private Logger logger = new Logger(Flight.class);
	
	private List<Segment> segments = new ArrayList<Segment>(); 
	private String type;
	private int connection;
	
	public static final String TYPE_OUTBOUND = "out";
	public static final String TYPE_INBOUND = "in";
	
	private static final String SEGMENTS = "segments";
	private static final String TYPE = "type";
	private static final String CONNECTION = "connection";

	public Flight(JSONObject json) throws JSONException {
		if (json.has(SEGMENTS)) {
			this.segments = new ArrayList<Segment>();
			JSONArray jsonArray = json.getJSONArray(SEGMENTS);
			for (int i = 0; i < jsonArray.length(); i++) {
				Segment elem = new Segment(jsonArray.getJSONObject(i));
				this.segments.add(elem);
			}
		}
		if (json.has(TYPE)) {
			this.setType(json.getString(TYPE));
		}
		
		if (json.has(CONNECTION)) {
			this.setConnection(json.getInt(CONNECTION));
		}
	}

	public int getConnection() {
		return connection;
	}

	public void setConnection(int connection) {
		this.connection = connection;
	}

	/** @return Flight segments (all departure and arrival airports). List with {@link Segment} objects */
	public List<Segment> getSegments() {
		return segments;
	}

	/** @param type */
	public void setType(String type) {
		this.type = type;
	}

	/** @return TYPE_OUTBOUND or TYPE_INBOUND */
	public String getType() {
		return type;
	}

	/**
	 *  Check flight is outbound
	 *
	 *  @return true if outbound. false is inbound.
	 */
	public boolean isOutbound() {
		return TYPE_OUTBOUND.equals(getType());
	}
	
	/**
	 *  @return Duration string with hours and minutes
	 */
	public String getDuration() {
		String duration = "-";
		if(segments != null) {
			long durationMinutes = 0;
			for(int i=0; i< segments.size(); i++) {
				Segment segment = (Segment) segments.get(i);
				if(segment.getDuration() != null) {
					String[] currDuration = StringUtil.split(segment.getDuration(), ":");
					if(currDuration.length == 2) {
						try {
							//parse hours
							durationMinutes += Integer.parseInt(currDuration[0])*60;
							//parse minutes
							durationMinutes += Integer.parseInt(currDuration[1]);
						} catch (NumberFormatException nfe) {
							logger.error(nfe, "Invalid duration: " + segment.getDuration());
						}
					} else {
						logger.error("Invalid duration: " + segment.getDuration());
					}
				} 
			}
			if(durationMinutes>0) {
				duration = durationMinutes/60 + "h ";
				duration = duration + durationMinutes%60 + "m";
			}
		}
		return duration;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		if(segments.size() > 0) {
			Segment segment = (Segment)segments.get(0);
			result.append(segment.getDeptime());
			result.append(" - ");
			segment = (Segment)segments.get(segments.size() -1);
			result.append(segment.getArrtime());
			result.append(" (").append(segment.getDuration()).append(")");
		}
		return result.toString();
	}
		
}