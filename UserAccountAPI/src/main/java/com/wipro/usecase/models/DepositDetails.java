package com.wipro.usecase.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class DepositDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private int customerId;
	private int accountId;
	private int amountDeposited;
	private String paymentMode;
	@Transient
	private String accountDetailsUri;

	public DepositDetails() {
		super();
	}

	public DepositDetails(int customerId, int accountId, int amountDeposited, String paymentMode) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.amountDeposited = amountDeposited;
		this.paymentMode = paymentMode;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public String getAccountDetailsUri() {
		return accountDetailsUri;
	}

	public void setAccountDetailsUri(String accountDetailsUri) {
		this.accountDetailsUri = accountDetailsUri;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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

	public int getAmountDeposited() {
		return amountDeposited;
	}

	public void setAmountDeposited(int amountDeposited) {
		this.amountDeposited = amountDeposited;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
}
