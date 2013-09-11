package com.travelfed.travelsdk.bean.rentacar;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Rentacar {
	
	private RentacarsResult rentacarsResult;
	
	private int duration;
	private List<PricedCoverage> pricedCoverage = new ArrayList<PricedCoverage>();
	private String passenger;
	private String type;
	private String typename;
	private String currency;
	private String referenceid;
	private String termsConditions;
	private String supplier;
	private String modelname;
	private String picture;
	private List<PricedEquip> pricedEquip = new ArrayList<PricedEquip>();
	private String modelcode;
	private Vehicle vehicle;
	private String clas;
	private String identifier;
	private Rentalrate rentalrate;
	private String id;
	private String status;
	private String referencetype;
	private String vendor;
	private String classname;
	private List<Fee> fees = new ArrayList<Fee>();
	private String totalprice;
	private String baggage;
	private String doors;
	
	private JSONObject json;

	private final static String DURATION = "duration";
	private final static String PRICEDCOVERAGE = "PricedCoverage";
	private final static String PASSENGER = "passenger";
	private final static String TYPE = "type";
	private final static String TYPENAME = "typename";
	private final static String CURRENCY = "currency";
	private final static String REFERENCEID = "referenceid";
	private final static String TERMSCONDITIONS = "TermsConditions";
	private final static String SUPPLIER = "supplier";
	private final static String MODELNAME = "modelname";
	private final static String PICTURE = "picture";
	private final static String PRICEDEQUIP = "PricedEquip";
	private final static String MODELCODE = "modelcode";
	private final static String VEHICLE = "Vehicle";
	private final static String CLASS = "class";
	private final static String IDENTIFIER = "Identifier";
	private final static String RENTALRATE = "rentalrate";
	private final static String ID = "id";
	private final static String STATUS = "status";
	private final static String REFERENCETYPE = "referencetype";
	private final static String VENDOR = "vendor";
	private final static String CLASSNAME = "classname";
	private final static String FEE = "Fee";
	private final static String TOTALPRICE = "totalprice";
	private final static String BAGGAGE = "baggage";
	private final static String DOORS = "doors";

	public Rentacar(RentacarsResult rentacarsResult, JSONObject json) throws JSONException {
		this.json = json;
		this.rentacarsResult = rentacarsResult;
		if (json.has(DURATION) && !json.isNull(DURATION)) {
			this.setDuration(json.getInt(DURATION));
		}
		if (json.has(PRICEDCOVERAGE)) {
			JSONArray jsonArray = json.getJSONArray(PRICEDCOVERAGE);
			for (int i = 0; i < jsonArray.length(); i++) {
				PricedCoverage elem = new PricedCoverage(jsonArray.getJSONObject(i));
				this.pricedCoverage.add(elem);
			}
		}
		if (json.has(PASSENGER)) {
			this.setPassenger(json.getString(PASSENGER));
		}
		if (json.has(TYPE)) {
			this.setType(json.getString(TYPE));
		}
		if (json.has(TYPENAME)) {
			this.setTypename(json.getString(TYPENAME));
		}
		if (json.has(CURRENCY)) {
			this.setCurrency(json.getString(CURRENCY));
		}
		if (json.has(REFERENCEID)) {
			this.setReferenceid(json.getString(REFERENCEID));
		}
		if (json.has(TERMSCONDITIONS)) {
			this.setTermsConditions(json.getString(TERMSCONDITIONS));
		}
		if (json.has(SUPPLIER)) {
			this.setSupplier(json.getString(SUPPLIER));
		}
		if (json.has(MODELNAME)) {
			this.setModelname(json.getString(MODELNAME));
		}
		if (json.has(PICTURE)) {
			this.setPicture(json.getString(PICTURE));
		}
		if (json.has(PRICEDEQUIP)) {
			JSONArray jsonArray = json.getJSONArray(PRICEDEQUIP);
			for (int i = 0; i < jsonArray.length(); i++) {
				PricedEquip elem = new PricedEquip(jsonArray.getJSONObject(i));
				this.pricedEquip.add(elem);
			}
		}
		if (json.has(MODELCODE)) {
			this.setModelcode(json.getString(MODELCODE));
		}
		if (json.has(VEHICLE)) {
			this.setVehicle(new Vehicle(json.getJSONObject(VEHICLE)));
		}
		if (json.has(CLASS)) {
			this.setClas(json.getString(CLASS));
		}
		if (json.has(IDENTIFIER)) {
			this.setIdentifier(json.getString(IDENTIFIER));
		}
		if (json.has(RENTALRATE)) {
			this.setRentalrate(new Rentalrate(json.getJSONObject(RENTALRATE)));
		}
		if (json.has(ID)) {
			this.setId(json.getString(ID));
		}
		if (json.has(STATUS)) {
			this.setStatus(json.getString(STATUS));
		}
		if (json.has(REFERENCETYPE)) {
			this.setReferencetype(json.getString(REFERENCETYPE));
		}
		if (json.has(VENDOR)) {
			this.setVendor(json.getString(VENDOR));
		}
		if (json.has(CLASSNAME)) {
			this.setClassname(json.getString(CLASSNAME));
		}
		if (json.has(FEE)) {
			JSONArray jsonArray = json.getJSONArray(FEE);
			for (int i = 0; i < jsonArray.length(); i++) {
				Fee elem = new Fee(jsonArray.getJSONObject(i));
				this.fees.add(elem);
			}
		}
		if (json.has(TOTALPRICE)) {
			this.setTotalprice(json.getString(TOTALPRICE));
		}
		if (json.has(BAGGAGE)) {
			this.setBaggage(json.getString(BAGGAGE));
		}
		if (json.has(DOORS)) {
			this.setDoors(json.getString(DOORS));
		}
	}

	public RentacarsResult getRentacarsResult() {
		return rentacarsResult;
	}

	/** @param duration */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/** @return duration */
	public int getDuration() {
		return duration;
	}

	/** @return pricedCoverage */
	public List<PricedCoverage> getPricedCoverages() {
		return pricedCoverage;
	}

	/** @param passenger */
	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}

	/** @return passenger */
	public String getPassenger() {
		return passenger;
	}

	/** @param type */
	public void setType(String type) {
		this.type = type;
	}

	/** @return type */
	public String getType() {
		return type;
	}

	/** @param typename */
	public void setTypename(String typename) {
		this.typename = typename;
	}

	/** @return typename */
	public String getTypename() {
		return typename;
	}

	/** @param currency */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/** @return currency */
	public String getCurrency() {
		return currency;
	}

	/** @param referenceid */
	public void setReferenceid(String referenceid) {
		this.referenceid = referenceid;
	}

	/** @return referenceid */
	public String getReferenceid() {
		return referenceid;
	}

	/** @param TermsConditions */
	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}

	/** @return TermsConditions */
	public String getTermsConditions() {
		return termsConditions;
	}

	/** @param supplier */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/** @return supplier */
	public String getSupplier() {
		return supplier;
	}

	/** @param modelname */
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	/** @return modelname */
	public String getModelname() {
		return modelname;
	}

	/** @param picture */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/** @return picture */
	public String getPicture() {
		return picture;
	}

	/** @return PricedEquip */
	public List<PricedEquip> getPricedEquip() {
		return pricedEquip;
	}

	/** @param modelcode */
	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}

	/** @return modelcode */
	public String getModelcode() {
		return modelcode;
	}

	/** @param Vehicle */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/** @return Vehicle */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/** @param clas */
	public void setClas(String clas) {
		this.clas = clas;
	}

	/** @return clas */
	public String getClas() {
		return clas;
	}

	/** @param Identifier */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/** @return Identifier */
	public String getIdentifier() {
		return identifier;
	}

	/** @param rentalrate */
	public void setRentalrate(Rentalrate rentalrate) {
		this.rentalrate = rentalrate;
	}

	/** @return rentalrate */
	public Rentalrate getRentalrate() {
		return rentalrate;
	}

	/** @param id */
	public void setId(String id) {
		this.id = id;
	}

	/** @return id */
	public String getId() {
		return id;
	}

	/** @param status */
	public void setStatus(String status) {
		this.status = status;
	}

	/** @return status */
	public String getStatus() {
		return status;
	}

	/** @param referencetype */
	public void setReferencetype(String referencetype) {
		this.referencetype = referencetype;
	}

	/** @return referencetype */
	public String getReferencetype() {
		return referencetype;
	}

	/** @param vendor */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/** @return vendor */
	public String getVendor() {
		return vendor;
	}

	/** @param classname */
	public void setClassname(String classname) {
		this.classname = classname;
	}

	/** @return classname */
	public String getClassname() {
		return classname;
	}

	/** @return Fee */
	public List<Fee> getFees() {
		return fees;
	}

	/** @param totalprice */
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	/** @return totalprice */
	public String getTotalprice() {
		return totalprice;
	}

	/** @param baggage */
	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}

	/** @return baggage */
	public String getBaggage() {
		return baggage;
	}

	/** @param doors */
	public void setDoors(String doors) {
		this.doors = doors;
	}

	/** @return doors */
	public String getDoors() {
		return doors;
	}
	
	public JSONObject getJson() {
		return json;
	}

}