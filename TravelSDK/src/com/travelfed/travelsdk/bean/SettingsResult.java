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
package com.travelfed.travelsdk.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *  Settings result from TravelSDK initialization
 */
public class SettingsResult extends Result {

	private final static String DEFAULT_AGENCY = "default_agency";
	private final static String CHANGEABLE_AGENCY = "changeable_agency";
	private final static String WS_URL = "ws_url";
	private final static String INFO_URL = "info_url";
	private final static String HELP_URL = "help_url";
	private final static String ABOUT_URL = "about_url";
	private final static String AIRLINE_ICONS_URL = "airline_icons_url";
	private final static String NEWS_URL = "news_url";
	private final static String OFFERS_URL = "offers_url";
	private final static String LEGAL_URL = "legal_url";
	
	private String defaultAgency;
	private boolean changeableAgency;
	private String wsUrl;
	private String infoUrl;
	private String helpUrl;
	private String aboutUrl;	
	private String airlineIconsUrl;
	private String newsUrl;
	private String offersUrl;
	private String legalUrl;
	
	public SettingsResult(JSONObject json) throws JSONException {
		super(json);
		if (json.has(DEFAULT_AGENCY)) {
			this.setDefaultAgency(json.getString(DEFAULT_AGENCY));
		}
		if (json.has(CHANGEABLE_AGENCY)) {
			this.setChangeableAgency(json.getBoolean(CHANGEABLE_AGENCY));
		}
		if (json.has(WS_URL)) {
			this.setWsUrl(json.getString(WS_URL));
		}
		if (json.has(INFO_URL)) {
			this.setInfoUrl(json.getString(INFO_URL));
		}
		if (json.has(HELP_URL)) {
			this.setHelpUrl(json.getString(HELP_URL));
		}
		if (json.has(ABOUT_URL)) {
			this.setAboutUrl(json.getString(ABOUT_URL));
		}
		if (json.has(AIRLINE_ICONS_URL)) {
			this.setAirlineIconsUrl(json.getString(AIRLINE_ICONS_URL));
		}
		if (json.has(NEWS_URL)) {
			this.setNewsUrl(json.getString(NEWS_URL));
		}
		if (json.has(OFFERS_URL)) {
			this.setOffersUrl(json.getString(OFFERS_URL));
		}
		if (json.has(LEGAL_URL)) {
			this.setLegalUrl(json.getString(LEGAL_URL));
		}
	}

	/**
	 *  Default agency ID
	 */
	public String getDefaultAgency() {
		return defaultAgency;
	}

	public void setDefaultAgency(String defaultAgency) {
		this.defaultAgency = defaultAgency;
	}

	/**
	 *  Does the user possibility to work with other agency.
	 */
	public boolean isChangeableAgency() {
		return changeableAgency;
	}

	public void setChangeableAgency(boolean changeableAgency) {
		this.changeableAgency = changeableAgency;
	}

	/**
	 *  WS url. Used by TSDK API.
	 */
	public String getWsUrl() {
		return wsUrl;
	}

	public void setWsUrl(String wsUrl) {
		this.wsUrl = wsUrl;
	}

	/**
	 *  Agency Information page url.
	 */
	public String getInfoUrl() {
		return infoUrl;
	}

	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}

	/**
	 *  Agency Help page url.
	 */
	public String getHelpUrl() {
		return helpUrl;
	}

	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}

	/**
	 *  Agency About page url.
	 */
	public String getAboutUrl() {
		return aboutUrl;
	}

	public void setAboutUrl(String aboutUrl) {
		this.aboutUrl = aboutUrl;
	}

	/**
	 *  Airline icons url.
	 */
	public String getAirlineIconsUrl() {
		return airlineIconsUrl;
	}

	public void setAirlineIconsUrl(String airlineIconsUrl) {
		this.airlineIconsUrl = airlineIconsUrl;
	}

	/**
	 *  Agency News page url.
	 */ 
	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	/**
	 *  Agency Offers page url;
	 */
	public String getOffersUrl() {
		return offersUrl;
	}

	public void setOffersUrl(String offersUrl) {
		this.offersUrl = offersUrl;
	}

	/**
	 *  Agency Legal page url.
	 */
	public String getLegalUrl() {
		return legalUrl;
	}

	public void setLegalUrl(String legalUrl) {
		this.legalUrl = legalUrl;
	}

}
