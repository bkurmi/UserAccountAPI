package com.wipro.usecase.models;

import java.util.ArrayList;
import java.util.List;

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
	private List<Link> links = new ArrayList<>();

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

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
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

	public void addLink(String uri, String rel) {
		Link link = new Link();
		link.setLink(uri);
		link.setRel(rel);
		links.add(link);
	}

}
