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

import java.util.Hashtable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *  Booking class
 */
public class Bookingclass {
	
	private String status;
	private String clas;
	
	public static Hashtable<String, String> classNames = new Hashtable<String, String>();

	static {
		classNames.put("Y", "Economy");
		classNames.put("W", "Economy");
		classNames.put("E", "Economy");
		classNames.put("B", "Economy");
		classNames.put("H", "Economy");
		classNames.put("K", "Economy");
		classNames.put("L", "Economy");
		classNames.put("M", "Economy");
		classNames.put("N", "Economy");
		classNames.put("Q", "Economy");
		classNames.put("T", "Economy");
		classNames.put("V", "Economy");
		classNames.put("X", "Economy");
		classNames.put("C", "Business");
		classNames.put("J", "Business");
		classNames.put("D", "Business");
		classNames.put("I", "Business");
		classNames.put("Z", "Business");
		classNames.put("F", "First");
		classNames.put("R", "First");
		classNames.put("P", "First");
		classNames.put("A", "First");
		classNames.put("S", "Supperior Economy");
	}

	public Bookingclass(String status, String clas) {
		this.setStatus(status);
		this.setClas(clas);
	}

	public Bookingclass(JSONObject json) throws JSONException {
		if (json.has("status")) {
			this.setStatus(json.getString("status"));
		}
		if (json.has("class")) {
			this.setClas(json.getString("class"));
		}
	}

	/** @param status */
	public void setStatus(String status) {
		this.status = status;
	}

	/** @return status */
	public String getStatus() {
		return status;
	}

	/** @param clas */
	public void setClas(String clas) {
		this.clas = clas;
	}

	/** @return clas */
	public String getClas() {
		return clas;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clas == null) ? 0 : clas.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookingclass other = (Bookingclass) obj;
		if (clas == null) {
			if (other.clas != null)
				return false;
		} else if (!clas.equals(other.clas))
			return false;
		return true;
	}

	public String toString() {
		if(clas == null) {
			return "";
		}
		String result = (String) classNames.get(clas);
		if(result == null) {
			result = clas;
		} 
		return result;
	}
	
}