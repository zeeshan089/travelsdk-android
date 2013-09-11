package com.travelfed.travelsdk.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Result with  settings 
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
	 * 
	 * @return Agency ID
	 */
	public String getDefaultAgency() {
		return defaultAgency;
	}

	public void setDefaultAgency(String defaultAgency) {
		this.defaultAgency = defaultAgency;
	}

	/**
	 * True the user can change agency id 
	 */
	public boolean isChangeableAgency() {
		return changeableAgency;
	}

	public void setChangeableAgency(boolean changeableAgency) {
		this.changeableAgency = changeableAgency;
	}

	/**
	 * 
	 * @return Travel SKD json WS url
	 */
	public String getWsUrl() {
		return wsUrl;
	}

	public void setWsUrl(String wsUrl) {
		this.wsUrl = wsUrl;
	}

	/**
	 * 
	 * @return Mobile info web page
	 */
	public String getInfoUrl() {
		return infoUrl;
	}

	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}

	/**
	 * 
	 * @return Mobile help web page
	 */
	public String getHelpUrl() {
		return helpUrl;
	}

	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}

	/**
	 * 
	 * @return Mobile about web page.
	 */
	public String getAboutUrl() {
		return aboutUrl;
	}

	public void setAboutUrl(String aboutUrl) {
		this.aboutUrl = aboutUrl;
	}

	/**
	 * 
	 * @return URL for airline icons.
	 */
	public String getAirlineIconsUrl() {
		return airlineIconsUrl;
	}

	public void setAirlineIconsUrl(String airlineIconsUrl) {
		this.airlineIconsUrl = airlineIconsUrl;
	}

	/**
	 * 
	 * @return Mobile news web url.
	 */ 
	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	/**
	 * 
	 * @return Mobile offers web url
	 */
	public String getOffersUrl() {
		return offersUrl;
	}

	public void setOffersUrl(String offersUrl) {
		this.offersUrl = offersUrl;
	}

	/**
	 * 
	 * @return Mobile legal url
	 */
	public String getLegalUrl() {
		return legalUrl;
	}

	public void setLegalUrl(String legalUrl) {
		this.legalUrl = legalUrl;
	}

}
