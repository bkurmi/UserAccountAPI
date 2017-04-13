package com.wipro.usercase.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class PersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String name;
	private String address;
	private Date dob;
	private String city;
	private String state;
	private String country;
	private int accountId;
	private String userName;
	private String password;
	private String priviledge;
	
	@Transient
	private List<Link> links = new ArrayList<>();

	public PersonalDetails() {
		super();
	}

	public PersonalDetails(String name, String address, Date dob, String city, String state, String country,
			int accountId, String userName, String password, String priviledge) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.city = city;
		this.state = state;
		this.country = country;
		this.accountId = accountId;
		this.userName = userName;
		this.password = password;
		this.priviledge = priviledge;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}

	@Override
	public String toString() {
		return "PersonalDetails [customerId=" + customerId + ", name=" + name + ", address=" + address + ", dob=" + dob
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", accountId=" + accountId
				+ ", userName=" + userName + ", password=" + password + ", priviledge=" + priviledge + "]";
	}

	public void addLink(String uri, String rel) {
		Link link = new Link();
		link.setLink(uri);
		link.setRel(rel);
		links.add(link);
	}

}
