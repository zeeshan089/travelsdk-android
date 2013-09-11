package com.travelfed.travelsdk.bean.flight;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.Logger;
import com.travelfed.travelsdk.util.StringUtil;



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

	/** @return List with {@link Segment} objects */
	public List<Segment> getSegments() {
		return segments;
	}

	/** @param type */
	public void setType(String type) {
		this.type = type;
	}

	/** @return type */
	public String getType() {
		return type;
	}

	public boolean isOutbound() {
		return TYPE_OUTBOUND.equals(getType());
	}
	
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