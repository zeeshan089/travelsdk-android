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
package com.travelfed.travelsdk.basket;

import java.util.Locale;

import com.travelfed.travelsdk.util.StringUtil;

/**
 * Class for person(contact person or traveler, quest) data.
 */
public class PersonInfo {

	/**
	 *  Person Adult type
	 */
	public final static String TYPE_ADULT = "adt";
	/**
	 *  Person Child type
	 */
	public final static String TYPE_CHILD = "chd";
	/**
	 *  Person Infant type
	 */
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

	/**
	 *  First name. Required
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	/**
	 *  Last name. Required
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return type;
	}

	/**
	 *  Type (adult - TYPE_ADULT, child - TYPE_CHILD, infant - TYPE_INFANT). Required.
	 */
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

	/**
	 *  Salutation. Mr ot Mrs
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getCountry() {
		return country;
	}

	/**
	 *  Country name. Required
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	/**
	 *  City name. Required for contact person.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}
	
	/**
	 *  Street address. Required for contact person.
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	/**
	 *  Zip code. Required for contact person.
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	/**
	 *  Phone number. Required for contact person.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	/**
	 *  Email. Required for contact person.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	/**
	 *  Company name. For contact person only. Optional.
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyVat() {
		return companyVat;
	}

	/**
	 *  Company vat. For contact person only. Optional.
	 */
	public void setCompanyVat(String companyVat) {
		this.companyVat = companyVat;
	}

	public String getCountryCode() {
		if (StringUtil.isNullOrEmpty(countryCode)) {
			this.countryCode = Locale.getDefault().getCountry();
		}
		return countryCode;
	}

	/**
	 *  Country code. Required for contact person.
	 */
	public void setCountryCode(String countryCode) {
		if (StringUtil.isNullOrEmpty(countryCode)) {
			this.countryCode = Locale.getDefault().getCountry();
			return;
		}
		this.countryCode = countryCode;
	}
	
	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}

	/**
	 *  Phone country code. Required for contact person.
	 */
	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}

	public String getPhoneAreaCode() {
		return phoneAreaCode;
	}

	/**
	 *  Phone area code. Required for contact person.
	 */
	public void setPhoneAreaCode(String phoneAreaCode) {
		this.phoneAreaCode = phoneAreaCode;
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

	/**
	 *  Passport number. Only for flight bookings. For required check flight verify result.
	 */
	public void setPassport(String pasport) {
		this.passport = pasport;
	}

	public int getPassportIssueYear() {
		return passportIssueYear;
	}

	/**
	 *  Passport issue year. Only for flight bookings. For required check flight verify result.
	 */
	public void setPassportIssueYear(int passportIssueYear) {
		this.passportIssueYear = passportIssueYear;
	}

	public int getPassportIssueMonth() {
		return passportIssueMonth;
	}

	/**
	 *  Passport issue month. Only for flight bookings. For required check flight verify result.
	 */
	public void setPassportIssueMonth(int passportIssueMonth) {
		this.passportIssueMonth = passportIssueMonth;
	}

	public int getPassportIssueDayOfMonth() {
		return passportIssueDayOfMonth;
	}

	/**
	 *  Passport issue day of month. Only for flight bookings. For required check flight verify result.
	 */
	public void setPassportIssueDayOfMonth(int passportIssueDayOfMonth) {
		this.passportIssueDayOfMonth = passportIssueDayOfMonth;
	}

	public int getPassportExpireYear() {
		return passportExpireYear;
	}

	/**
	 *  Passport expire year. Only for flight bookings. For required check flight verify result.
	 */
	public void setPassportExpireYear(int passportExpireYear) {
		this.passportExpireYear = passportExpireYear;
	}

	public int getPassportExpireMonth() {
		return passportExpireMonth;
	}

	/**
	 *  Passport expire month. Only for flight bookings. For required check flight verify result.
	 */
	public void setPassportExpireMonth(int passportExpireMonth) {
		this.passportExpireMonth = passportExpireMonth;
	}

	
	public int getPassportExpireDayOfMonth() {
		return passportExpireDayOfMonth;
	}

	/**
	 *  Passport expire day of month. Only for flight bookings. For required check flight verify result.
	 */
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

}
