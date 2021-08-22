package com.greatlearning.models;

public class Customer {

	private String password;
	private int bankAccountNo;
	private int balance;

	public Customer(int bankAccountNo,String password,int balance) {

		this.password = password;
		this.bankAccountNo = bankAccountNo;
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(int bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
