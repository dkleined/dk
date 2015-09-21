package com.dk.model;

public class CreditCard {
	private String number;
	private int expiryMonth, expiryYear;
	private int cvCode;
	
	public CreditCard() {	
	}
	
	public CreditCard(String number, int expiryMonth, int expiryYear, int cvCode) {
		this.number = number;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvCode = cvCode;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	public int getCvCode() {
		return cvCode;
	}
	public void setCvCode(int cvCode) {
		this.cvCode = cvCode;
	}
	
	
}
