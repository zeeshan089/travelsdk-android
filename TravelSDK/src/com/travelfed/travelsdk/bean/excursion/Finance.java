package com.travelfed.travelsdk.bean.excursion;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.travelfed.travelsdk.util.StringUtil;

public class Finance {

	private String supplierCurrency;
	private String id;
	private String vatRate;
	private String strIdentifier;
	private PriceValue supplierValue;
	private PriceValue operatorValue;
	private String vatAmount;
	private Date sellExchangeDate;
	private String sellCurrency;
	private String operatorCurrency;
	private String sellExchangeRisk;
	private String query;
	private String vatId;
	private OperatorMargins operatorMargins;
	private String sellExchangeRate;
	private PriceValue sellPrice;

	public Finance(JSONObject json) throws JSONException {
		if (json.has("supplierCurrency")) {
			this.setSupplierCurrency(json.getString("supplierCurrency"));
		}
		if (json.has("id")) {
			this.setId(json.getString("id"));
		}
		if (json.has("vatRate")) {
			this.setVatRate(json.getString("vatRate"));
		}
		if (json.has("strIdentifier")) {
			this.setStrIdentifier(json.getString("strIdentifier"));
		}
		if (json.has("supplierValue")) {
			this.setSupplierValue(new PriceValue(json.getJSONObject("supplierValue")));
		}
		if (json.has("operatorValue")) {
			this.setOperatorValue(new PriceValue(json.getJSONObject("operatorValue")));
		}
		if (json.has("vatAmount")) {
			this.setVatAmount(json.getString("vatAmount"));
		}
		if (json.has("sellExchangeDate")) {
			String sDate = json.getString("sellExchangeDate");
			this.setSellExchangeDate(StringUtil.parseDate(sDate));
		}
		if (json.has("sellCurrency")) {
			this.setSellCurrency(json.getString("sellCurrency"));
		}
		if (json.has("operatorCurrency")) {
			this.setOperatorCurrency(json.getString("operatorCurrency"));
		}
		if (json.has("sellExchangeRisk")) {
			this.setSellExchangeRisk(json.getString("sellExchangeRisk"));
		}
		if (json.has("query")) {
			this.setQuery(json.getString("query"));
		}
		if (json.has("vatId")) {
			this.setVatId(json.getString("vatId"));
		}
		if (json.has("operatorMargins")) {
			this.setOperatorMargins(new OperatorMargins(json.getJSONObject("operatorMargins")));
		}
		if (json.has("sellExchangeRate")) {
			this.setSellExchangeRate(json.getString("sellExchangeRate"));
		}
		if (json.has("sellPrice")) {
			this.setSellPrice(new PriceValue(json.getJSONObject("sellPrice")));
		}
	}

	/** @param supplierCurrency */
	public void setSupplierCurrency(String supplierCurrency) {
		this.supplierCurrency = supplierCurrency;
	}

	/** @return supplierCurrency */
	public String getSupplierCurrency() {
		return supplierCurrency;
	}

	/** @param id */
	public void setId(String id) {
		this.id = id;
	}

	/** @return id */
	public String getId() {
		return id;
	}

	/** @param vatRate */
	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}

	/** @return vatRate */
	public String getVatRate() {
		return vatRate;
	}

	/** @param strIdentifier */
	public void setStrIdentifier(String strIdentifier) {
		this.strIdentifier = strIdentifier;
	}

	/** @return strIdentifier */
	public String getStrIdentifier() {
		return strIdentifier;
	}

	/** @param supplierValue */
	public void setSupplierValue(PriceValue supplierValue) {
		this.supplierValue = supplierValue;
	}

	/** @return supplierValue */
	public PriceValue getSupplierValue() {
		return supplierValue;
	}

	/** @param operatorValue */
	public void setOperatorValue(PriceValue operatorValue) {
		this.operatorValue = operatorValue;
	}

	/** @return operatorValue */
	public PriceValue getOperatorValue() {
		return operatorValue;
	}

	/** @param vatAmount */
	public void setVatAmount(String vatAmount) {
		this.vatAmount = vatAmount;
	}

	/** @return vatAmount */
	public String getVatAmount() {
		return vatAmount;
	}

	/** @param sellExchangeDate */
	public void setSellExchangeDate(Date sellExchangeDate) {
		this.sellExchangeDate = sellExchangeDate;
	}

	/** @return sellExchangeDate */
	public Date getSellExchangeDate() {
		return sellExchangeDate;
	}

	/** @param sellCurrency */
	public void setSellCurrency(String sellCurrency) {
		this.sellCurrency = sellCurrency;
	}

	/** @return sellCurrency */
	public String getSellCurrency() {
		return sellCurrency;
	}

	/** @param operatorCurrency */
	public void setOperatorCurrency(String operatorCurrency) {
		this.operatorCurrency = operatorCurrency;
	}

	/** @return operatorCurrency */
	public String getOperatorCurrency() {
		return operatorCurrency;
	}

	/** @param sellExchangeRisk */
	public void setSellExchangeRisk(String sellExchangeRisk) {
		this.sellExchangeRisk = sellExchangeRisk;
	}

	/** @return sellExchangeRisk */
	public String getSellExchangeRisk() {
		return sellExchangeRisk;
	}

	/** @param query */
	public void setQuery(String query) {
		this.query = query;
	}

	/** @return query */
	public String getQuery() {
		return query;
	}

	/** @param vatId */
	public void setVatId(String vatId) {
		this.vatId = vatId;
	}

	/** @return vatId */
	public String getVatId() {
		return vatId;
	}

	/** @param operatorMargins */
	public void setOperatorMargins(OperatorMargins operatorMargins) {
		this.operatorMargins = operatorMargins;
	}

	/** @return operatorMargins */
	public OperatorMargins getOperatorMargins() {
		return operatorMargins;
	}

	/** @param sellExchangeRate */
	public void setSellExchangeRate(String sellExchangeRate) {
		this.sellExchangeRate = sellExchangeRate;
	}

	/** @return sellExchangeRate */
	public String getSellExchangeRate() {
		return sellExchangeRate;
	}

	/** @param sellPrice */
	public void setSellPrice(PriceValue sellPrice) {
		this.sellPrice = sellPrice;
	}

	/** @return sellPrice */
	public PriceValue getSellPrice() {
		return sellPrice;
	}
}