package com.msayem.jms.entity;

public class SampleOrder {

	private int orderId;
	private int customerId;
	private double price;
	private String bankAccountNumber;

	public SampleOrder(int orderId, int customerId, double price, String bankAccountNumber){
		this.orderId = orderId;
		this.customerId = customerId;
		this.price = price;
		this.bankAccountNumber = bankAccountNumber;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
}