package com.travelfed.travelsdk.basket;

import java.util.Locale;

import com.travelfed.travelsdk.util.StringUtil;

/**
 * Class for store person(contact person or traveler) information
 */
public class PersonInfo {

	public final static String TYPE_ADULT = "adt";
	public final static String TYPE_CHILD = "chd";
	public final static String TYPE_INFANT = "inf";
	
	
	private String firstName;
	private String lastName;
	private String type;
	private String age;
	private String salutation;
	private String country;
	private String countryCode;
	private String city;
	private String street;
	private String zip;
	private String phoneCountryCode;
	private String phoneAreaCode;
	private String phone;
	private String email;
	private String company;
	private String companyVat;
	private boolean isMale = true;
	private String passport;
	private int passportIssueYear;
	private int passportIssueMonth;
	private int passportIssueDayOfMonth;
	private int passportExpireYear;
	private int passportExpireMonth;
	private int passportExpireDayOfMonth;

	public PersonInfo() {
	}

	public PersonInfo(String firstName, String lastname, String type) {
		this.firstName = firstName;
		this.lastName = lastname;
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return date of birth dd.MM.yyyy
	 */
	public String getAge() {
		return age;
	}

	/**
	 * 
	 * @param age - date of birth dd.MM.yyyy
	 */
	public void setAge(String age) {
		this.age = age;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyVat() {
		return companyVat;
	}

	public void setCompanyVat(String companyVat) {
		this.companyVat = companyVat;
	}

	public String getCountryCode() {
		if (StringUtil.isNullOrEmpty(countryCode)) {
			this.countryCode = Locale.getDefault().getCountry();
		}
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		if (StringUtil.isNullOrEmpty(countryCode)) {
			this.countryCode = Locale.getDefault().getCountry();
			return;
		}
		this.countryCode = countryCode;
	}
	
	public boolean isAdult() {
		return TYPE_ADULT.equals(getType());
	}
	
	public boolean isChild() {
		return TYPE_CHILD.equals(getType());
	}
	
	public boolean isInfant() {
		return TYPE_INFANT.equals(getType());
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String pasport) {
		this.passport = pasport;
	}

	public int getPassportIssueYear() {
		return passportIssueYear;
	}

	public void setPassportIssueYear(int passportIssueYear) {
		this.passportIssueYear = passportIssueYear;
	}

	public int getPassportIssueMonth() {
		return passportIssueMonth;
	}

	public void setPassportIssueMonth(int passportIssueMonth) {
		this.passportIssueMonth = passportIssueMonth;
	}

	public int getPassportIssueDayOfMonth() {
		return passportIssueDayOfMonth;
	}

	public void setPassportIssueDayOfMonth(int passportIssueDayOfMonth) {
		this.passportIssueDayOfMonth = passportIssueDayOfMonth;
	}

	public int getPassportExpireYear() {
		return passportExpireYear;
	}

	public void setPassportExpireYear(int passportExpireYear) {
		this.passportExpireYear = passportExpireYear;
	}

	public int getPassportExpireMonth() {
		return passportExpireMonth;
	}

	public void setPassportExpireMonth(int passportExpireMonth) {
		this.passportExpireMonth = passportExpireMonth;
	}

	public int getPassportExpireDayOfMonth() {
		return passportExpireDayOfMonth;
	}

	public void setPassportExpireDayOfMonth(int passportExpireDayOfMonth) {
		this.passportExpireDayOfMonth = passportExpireDayOfMonth;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonInfo other = (PersonInfo) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public String toString() {
		return firstName + StringUtil.SPACE_STRING + lastName;
	}

	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}

	public String getPhoneAreaCode() {
		return phoneAreaCode;
	}

	public void setPhoneAreaCode(String phoneAreaCode) {
		this.phoneAreaCode = phoneAreaCode;
	}

}
