package com.wipro.usercase.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonalDetails {
	private String name;
	private String address;
	private Date dob;
	private String city;
	private String state;
	private String country;

	public PersonalDetails() {
		super();
	}

	public PersonalDetails(String name, String address, Date dob, String city, String state, String country) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
