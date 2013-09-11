package com.travelfed.travelsdk.bean.hotel;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.bean.Result;
import com.travelfed.travelsdk.process.ProcessHotelInfo;

public class HotelInfoResult extends Result {

	private HotelInfo hotelInfo;
	private int record;
	private ProcessHotelInfo processHotelInfo;

	public HotelInfoResult(JSONObject json, ProcessHotelInfo processHotelInfo) throws JSONException {
		super(json);
		this.processHotelInfo = processHotelInfo;
		if (json.has("info")) {
			HotelInfo hotelInfo = new HotelInfo(json.getJSONObject("info"));
			this.setHotelInfo(hotelInfo);
		}
		if (json.has("record")) {
			this.setRecord(Integer.parseInt(json.getString("record")));
		}
	}

	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}
	
	public ProcessHotelInfo getProcessHotelInfo() {
		return processHotelInfo;
	}


}
