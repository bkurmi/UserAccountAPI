package com.wipro.usercase.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class AccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private String branch;
	private String Ifsc;
	private String zipCode;
	private String totBalance;

	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDetails(String branch, String ifsc, String zipCode, String totBalance) {
		super();
		this.branch = branch;
		Ifsc = ifsc;
		this.zipCode = zipCode;
		this.totBalance = totBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfsc() {
		return Ifsc;
	}

	public void setIfsc(String ifsc) {
		Ifsc = ifsc;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTotBalance() {
		return totBalance;
	}

	public void setTotBalance(String totBalance) {
		this.totBalance = totBalance;
	}

	

}
