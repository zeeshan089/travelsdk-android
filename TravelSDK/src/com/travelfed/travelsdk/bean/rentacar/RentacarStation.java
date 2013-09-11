package com.travelfed.travelsdk.bean.rentacar;

import org.json.JSONException;
import org.json.JSONObject;

public class RentacarStation {
	
//	private String fr_cl2;
//	private String fr_cl1;
	private String location_telephone;
	private String location_name_de;
	private String city_iata;
	private String location_longitude;
//	private String th_op3;
//	private String th_op2;
//	private String th_op1;
	private String location_id;
//	private String th_cl3;
//	private String th_cl2;
//	private String we_op3;
//	private String th_cl1;
//	private String we_op2;
//	private String we_op1;
//	private String we_cl3;
//	private String we_cl2;
//	private String we_cl1;
	private String country_iso;
	private String city_name_en;
	private String location_city;
//	private String sa_op3;
//	private String sa_op2;
//	private String sa_op1;
//	private String sa_cl3;
//	private String sa_cl2;
//	private String sa_cl1;
	private String location_address2;
	private String location_address1;
	private String location_pobox;
	private String location_areacode;
	private String airport_name_en;
	private String location_descriptionfr;
	private String airport_iata;
	private String country_name_en;
	private String location_fax;
	private String location_email;
//	private String su_op3;
	private String city_id;
//	private String su_op2;
//	private String su_op1;
//	private String su_cl3;
//	private String su_cl2;
//	private String su_cl1;
	private String supplier_gdscode;
	private String location_statecode;
	private String location_descriptiones;
	private String supplier_id;
	private String location_descriptionen;
	private String location_address_extra;
//	private String tu_op3;
//	private String tu_op2;
//	private String tu_op1;
	private String location_latitude;
//	private String tu_cl3;
//	private String mo_op3;
//	private String tu_cl2;
	private String location_name_fr;
//	private String mo_op2;
//	private String tu_cl1;
//	private String mo_op1;
//	private String mo_cl3;
//	private String mo_cl2;
//	private String mo_cl1;
	private String location_code;
	private String location_descriptionde;
	private String location_name_es;
	private String location_countrycode;
	private String location_name_en;
	private String location_zipcode;
	private String region_name_en;
//	private String fr_op3;
//	private String fr_op2;
//	private String fr_op1;
	private String airport_id;
//	private String fr_cl3;


	public RentacarStation(JSONObject json) throws JSONException {
//		if (json.has("fr_cl2")) {
//			this.setFr_cl2(json.getString("fr_cl2"));
//		}
//		if (json.has("fr_cl1")) {
//			this.setFr_cl1(json.getString("fr_cl1"));
//		}
		if (json.has("location_telephone")) {
			this.setLocation_telephone(json.getString("location_telephone"));
		}
		if (json.has("location_name_de")) {
			this.setLocation_name_de(json.getString("location_name_de"));
		}
		if (json.has("city_iata")) {
			this.setCity_iata(json.getString("city_iata"));
		}
		if (json.has("location_longitude")) {
			this.setLocation_longitude(json.getString("location_longitude"));
		}
//		if (json.has("th_op3")) {
//			this.setTh_op3(json.getString("th_op3"));
//		}
//		if (json.has("th_op2")) {
//			this.setTh_op2(json.getString("th_op2"));
//		}
//		if (json.has("th_op1")) {
//			this.setTh_op1(json.getString("th_op1"));
//		}
		if (json.has("location_id")) {
			this.setLocation_id(json.getString("location_id"));
		}
//		if (json.has("th_cl3")) {
//			this.setTh_cl3(json.getString("th_cl3"));
//		}
//		if (json.has("th_cl2")) {
//			this.setTh_cl2(json.getString("th_cl2"));
//		}
//		if (json.has("we_op3")) {
//			this.setWe_op3(json.getString("we_op3"));
//		}
//		if (json.has("th_cl1")) {
//			this.setTh_cl1(json.getString("th_cl1"));
//		}
//		if (json.has("we_op2")) {
//			this.setWe_op2(json.getString("we_op2"));
//		}
//		if (json.has("we_op1")) {
//			this.setWe_op1(json.getString("we_op1"));
//		}
//		if (json.has("we_cl3")) {
//			this.setWe_cl3(json.getString("we_cl3"));
//		}
//		if (json.has("we_cl2")) {
//			this.setWe_cl2(json.getString("we_cl2"));
//		}
//		if (json.has("we_cl1")) {
//			this.setWe_cl1(json.getString("we_cl1"));
//		}
		if (json.has("country_iso")) {
			this.setCountry_iso(json.getString("country_iso"));
		}
		if (json.has("city_name_en")) {
			this.setCity_name_en(json.getString("city_name_en"));
		}
		if (json.has("location_city")) {
			this.setLocation_city(json.getString("location_city"));
		}
//		if (json.has("sa_op3")) {
//			this.setSa_op3(json.getString("sa_op3"));
//		}
//		if (json.has("sa_op2")) {
//			this.setSa_op2(json.getString("sa_op2"));
//		}
//		if (json.has("sa_op1")) {
//			this.setSa_op1(json.getString("sa_op1"));
//		}
//		if (json.has("sa_cl3")) {
//			this.setSa_cl3(json.getString("sa_cl3"));
//		}
//		if (json.has("sa_cl2")) {
//			this.setSa_cl2(json.getString("sa_cl2"));
//		}
//		if (json.has("sa_cl1")) {
//			this.setSa_cl1(json.getString("sa_cl1"));
//		}
		if (json.has("location_address2")) {
			this.setLocation_address2(json.getString("location_address2"));
		}
		if (json.has("location_address1")) {
			this.setLocation_address1(json.getString("location_address1"));
		}
		if (json.has("location_pobox")) {
			this.setLocation_pobox(json.getString("location_pobox"));
		}
		if (json.has("location_areacode")) {
			this.setLocation_areacode(json.getString("location_areacode"));
		}
		if (json.has("airport_name_en")) {
			this.setAirport_name_en(json.getString("airport_name_en"));
		}
		if (json.has("location_descriptionfr")) {
			this.setLocation_descriptionfr(json
					.getString("location_descriptionfr"));
		}
		if (json.has("airport_iata")) {
			this.setAirport_iata(json.getString("airport_iata"));
		}
		if (json.has("country_name_en")) {
			this.setCountry_name_en(json.getString("country_name_en"));
		}
		if (json.has("location_fax")) {
			this.setLocation_fax(json.getString("location_fax"));
		}
		if (json.has("location_email")) {
			this.setLocation_email(json.getString("location_email"));
		}
//		if (json.has("su_op3")) {
//			this.setSu_op3(json.getString("su_op3"));
//		}
		if (json.has("city_id")) {
			this.setCity_id(json.getString("city_id"));
		}
//		if (json.has("su_op2")) {
//			this.setSu_op2(json.getString("su_op2"));
//		}
//		if (json.has("su_op1")) {
//			this.setSu_op1(json.getString("su_op1"));
//		}
//		if (json.has("su_cl3")) {
//			this.setSu_cl3(json.getString("su_cl3"));
//		}
//		if (json.has("su_cl2")) {
//			this.setSu_cl2(json.getString("su_cl2"));
//		}
//		if (json.has("su_cl1")) {
//			this.setSu_cl1(json.getString("su_cl1"));
//		}
		if (json.has("supplier_gdscode")) {
			this.setSupplier_gdscode(json.getString("supplier_gdscode"));
		}
		if (json.has("location_statecode")) {
			this.setLocation_statecode(json.getString("location_statecode"));
		}
		if (json.has("location_descriptiones")) {
			this.setLocation_descriptiones(json
					.getString("location_descriptiones"));
		}
		if (json.has("supplier_id")) {
			this.setSupplier_id(json.getString("supplier_id"));
		}
		if (json.has("location_descriptionen")) {
			this.setLocation_descriptionen(json
					.getString("location_descriptionen"));
		}
		if (json.has("location_address_extra")) {
			this.setLocation_address_extra(json
					.getString("location_address_extra"));
		}
//		if (json.has("tu_op3")) {
//			this.setTu_op3(json.getString("tu_op3"));
//		}
//		if (json.has("tu_op2")) {
//			this.setTu_op2(json.getString("tu_op2"));
//		}
//		if (json.has("tu_op1")) {
//			this.setTu_op1(json.getString("tu_op1"));
//		}
		if (json.has("location_latitude")) {
			this.setLocation_latitude(json.getString("location_latitude"));
		}
//		if (json.has("tu_cl3")) {
//			this.setTu_cl3(json.getString("tu_cl3"));
//		}
//		if (json.has("mo_op3")) {
//			this.setMo_op3(json.getString("mo_op3"));
//		}
//		if (json.has("tu_cl2")) {
//			this.setTu_cl2(json.getString("tu_cl2"));
//		}
		if (json.has("location_name_fr")) {
			this.setLocation_name_fr(json.getString("location_name_fr"));
		}
//		if (json.has("mo_op2")) {
//			this.setMo_op2(json.getString("mo_op2"));
//		}
//		if (json.has("tu_cl1")) {
//			this.setTu_cl1(json.getString("tu_cl1"));
//		}
//		if (json.has("mo_op1")) {
//			this.setMo_op1(json.getString("mo_op1"));
//		}
//		if (json.has("mo_cl3")) {
//			this.setMo_cl3(json.getString("mo_cl3"));
//		}
//		if (json.has("mo_cl2")) {
//			this.setMo_cl2(json.getString("mo_cl2"));
//		}
//		if (json.has("mo_cl1")) {
//			this.setMo_cl1(json.getString("mo_cl1"));
//		}
		if (json.has("location_code")) {
			this.setLocation_code(json.getString("location_code"));
		}
		if (json.has("location_descriptionde")) {
			this.setLocation_descriptionde(json
					.getString("location_descriptionde"));
		}
		if (json.has("location_name_es")) {
			this.setLocation_name_es(json.getString("location_name_es"));
		}
		if (json.has("location_countrycode")) {
			this.setLocation_countrycode(json.getString("location_countrycode"));
		}
		if (json.has("location_name_en")) {
			this.setLocation_name_en(json.getString("location_name_en"));
		}
		if (json.has("location_zipcode")) {
			this.setLocation_zipcode(json.getString("location_zipcode"));
		}
		if (json.has("region_name_en")) {
			this.setRegion_name_en(json.getString("region_name_en"));
		}
//		if (json.has("fr_op3")) {
//			this.setFr_op3(json.getString("fr_op3"));
//		}
//		if (json.has("fr_op2")) {
//			this.setFr_op2(json.getString("fr_op2"));
//		}
//		if (json.has("fr_op1")) {
//			this.setFr_op1(json.getString("fr_op1"));
//		}
		if (json.has("airport_id")) {
			this.setAirport_id(json.getString("airport_id"));
		}
//		if (json.has("fr_cl3")) {
//			this.setFr_cl3(json.getString("fr_cl3"));
//		}
	}

	/** @param location_telephone */
	public void setLocation_telephone(String location_telephone) {
		this.location_telephone = location_telephone;
	}

	/** @return location_telephone */
	public String getLocation_telephone() {
		return location_telephone;
	}

	/** @param location_name_de */
	public void setLocation_name_de(String location_name_de) {
		this.location_name_de = location_name_de;
	}

	/** @return location_name_de */
	public String getLocation_name_de() {
		return location_name_de;
	}

	/** @param city_iata */
	public void setCity_iata(String city_iata) {
		this.city_iata = city_iata;
	}

	/** @return city_iata */
	public String getCity_iata() {
		return city_iata;
	}

	/** @param location_longitude */
	public void setLocation_longitude(String location_longitude) {
		this.location_longitude = location_longitude;
	}

	/** @return location_longitude */
	public String getLocation_longitude() {
		return location_longitude;
	}

	/** @param location_id */
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	/** @return location_id */
	public String getLocation_id() {
		return location_id;
	}

	/** @param country_iso */
	public void setCountry_iso(String country_iso) {
		this.country_iso = country_iso;
	}

	/** @return country_iso */
	public String getCountry_iso() {
		return country_iso;
	}

	/** @param city_name_en */
	public void setCity_name_en(String city_name_en) {
		this.city_name_en = city_name_en;
	}

	/** @return city_name_en */
	public String getCity_name_en() {
		return city_name_en;
	}

	/** @param location_city */
	public void setLocation_city(String location_city) {
		this.location_city = location_city;
	}

	/** @return location_city */
	public String getLocation_city() {
		return location_city;
	}

	/** @param location_address2 */
	public void setLocation_address2(String location_address2) {
		this.location_address2 = location_address2;
	}

	/** @return location_address2 */
	public String getLocation_address2() {
		return location_address2;
	}

	/** @param location_address1 */
	public void setLocation_address1(String location_address1) {
		this.location_address1 = location_address1;
	}

	/** @return location_address1 */
	public String getLocation_address1() {
		return location_address1;
	}

	/** @param location_pobox */
	public void setLocation_pobox(String location_pobox) {
		this.location_pobox = location_pobox;
	}

	/** @return location_pobox */
	public String getLocation_pobox() {
		return location_pobox;
	}

	/** @param location_areacode */
	public void setLocation_areacode(String location_areacode) {
		this.location_areacode = location_areacode;
	}

	/** @return location_areacode */
	public String getLocation_areacode() {
		return location_areacode;
	}

	/** @param airport_name_en */
	public void setAirport_name_en(String airport_name_en) {
		this.airport_name_en = airport_name_en;
	}

	/** @return airport_name_en */
	public String getAirport_name_en() {
		return airport_name_en;
	}

	/** @param location_descriptionfr */
	public void setLocation_descriptionfr(String location_descriptionfr) {
		this.location_descriptionfr = location_descriptionfr;
	}

	/** @return location_descriptionfr */
	public String getLocation_descriptionfr() {
		return location_descriptionfr;
	}

	/** @param airport_iata */
	public void setAirport_iata(String airport_iata) {
		this.airport_iata = airport_iata;
	}

	/** @return airport_iata */
	public String getAirport_iata() {
		return airport_iata;
	}

	/** @param country_name_en */
	public void setCountry_name_en(String country_name_en) {
		this.country_name_en = country_name_en;
	}

	/** @return country_name_en */
	public String getCountry_name_en() {
		return country_name_en;
	}

	/** @param location_fax */
	public void setLocation_fax(String location_fax) {
		this.location_fax = location_fax;
	}

	/** @return location_fax */
	public String getLocation_fax() {
		return location_fax;
	}

	/** @param location_email */
	public void setLocation_email(String location_email) {
		this.location_email = location_email;
	}

	/** @return location_email */
	public String getLocation_email() {
		if(this.location_email == null || this.location_email.equals("null")) {
			return "";
		}
		return location_email;
	}

	/** @param city_id */
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	/** @return city_id */
	public String getCity_id() {
		return city_id;
	}

	/** @param supplier_gdscode */
	public void setSupplier_gdscode(String supplier_gdscode) {
		this.supplier_gdscode = supplier_gdscode;
	}

	/** @return supplier_gdscode */
	public String getSupplier_gdscode() {
		return supplier_gdscode;
	}

	/** @param location_statecode */
	public void setLocation_statecode(String location_statecode) {
		this.location_statecode = location_statecode;
	}

	/** @return location_statecode */
	public String getLocation_statecode() {
		return location_statecode;
	}

	/** @param location_descriptiones */
	public void setLocation_descriptiones(String location_descriptiones) {
		this.location_descriptiones = location_descriptiones;
	}

	/** @return location_descriptiones */
	public String getLocation_descriptiones() {
		return location_descriptiones;
	}

	/** @param supplier_id */
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	/** @return supplier_id */
	public String getSupplier_id() {
		return supplier_id;
	}

	/** @param location_descriptionen */
	public void setLocation_descriptionen(String location_descriptionen) {
		this.location_descriptionen = location_descriptionen;
	}

	/** @return location_descriptionen */
	public String getLocation_descriptionen() {
		return location_descriptionen;
	}

	/** @param location_address_extra */
	public void setLocation_address_extra(String location_address_extra) {
		this.location_address_extra = location_address_extra;
	}

	/** @return location_address_extra */
	public String getLocation_address_extra() {
		return location_address_extra;
	}

	/** @param location_latitude */
	public void setLocation_latitude(String location_latitude) {
		this.location_latitude = location_latitude;
	}

	/** @return location_latitude */
	public String getLocation_latitude() {
		return location_latitude;
	}

	/** @param location_name_fr */
	public void setLocation_name_fr(String location_name_fr) {
		this.location_name_fr = location_name_fr;
	}

	/** @return location_name_fr */
	public String getLocation_name_fr() {
		return location_name_fr;
	}

	/** @param location_code */
	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}

	/** @return location_code */
	public String getLocation_code() {
		return location_code;
	}

	/** @param location_descriptionde */
	public void setLocation_descriptionde(String location_descriptionde) {
		this.location_descriptionde = location_descriptionde;
	}

	/** @return location_descriptionde */
	public String getLocation_descriptionde() {
		return location_descriptionde;
	}

	/** @param location_name_es */
	public void setLocation_name_es(String location_name_es) {
		this.location_name_es = location_name_es;
	}

	/** @return location_name_es */
	public String getLocation_name_es() {
		return location_name_es;
	}

	/** @param location_countrycode */
	public void setLocation_countrycode(String location_countrycode) {
		this.location_countrycode = location_countrycode;
	}

	/** @return location_countrycode */
	public String getLocation_countrycode() {
		return location_countrycode;
	}

	/** @param location_name_en */
	public void setLocation_name_en(String location_name_en) {
		this.location_name_en = location_name_en;
	}

	/** @return location_name_en */
	public String getLocation_name_en() {
		return location_name_en;
	}

	/** @param location_zipcode */
	public void setLocation_zipcode(String location_zipcode) {
		this.location_zipcode = location_zipcode;
	}

	/** @return location_zipcode */
	public String getLocation_zipcode() {
		return location_zipcode;
	}

	/** @param region_name_en */
	public void setRegion_name_en(String region_name_en) {
		this.region_name_en = region_name_en;
	}

	/** @return region_name_en */
	public String getRegion_name_en() {
		return region_name_en;
	}

	/** @param airport_id */
	public void setAirport_id(String airport_id) {
		this.airport_id = airport_id;
	}

	/** @return airport_id */
	public String getAirport_id() {
		return airport_id;
	}
}