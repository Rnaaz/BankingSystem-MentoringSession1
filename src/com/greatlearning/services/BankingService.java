package com.greatlearning.services;

import java.util.Scanner;
import com.greatlearning.models.Customer;

public class BankingService {

	Scanner sc = new Scanner(System.in);
	int bankBalance = 1000;
	int amt;

	public void logout() {
		System.out.println("------Thanking for banking with us---------");
	}

	public void deposit(Customer customer) {
		System.out.println("Enter the deposit amount");
		amt = sc.nextInt();

		if (amt > 0) {
			System.out.println("Amount deposited successfully");
			customer.setBalance(customer.getBalance() + amt);
			System.out.println("Remaining balance is: " + customer.getBalance());
		} else {
			System.out.println("Please provide valid input");
		}

	}

	public void withdrawal(Customer customer, String operation) {

		System.out.println("Enter the amount " + operation);
		amt = sc.nextInt();
		if (customer.getBalance() >= amt) {
			System.out.println("Amount " + operation + " successfully");
			customer.setBalance(customer.getBalance() - amt);
			System.out.println("Remaining balance is: " + customer.getBalance());
		} else {
			System.out.println("Insufficient Balance. Please check your balance.");
		}

	}

	public void transfer(Customer customer, Customer customer2) {
		int otp;
		int otpGenerated;
		int toBeTransferredAccountNo = customer2.getBankAccountNo();
		System.out.println("Enter The OTP");
		OTPService otpService = new OTPService();
		otpGenerated = otpService.generateOTP();
		System.out.println("-----Generated OTP is-------");
		System.out.println(otpGenerated);
		System.out.println("Enter the OTP generated");
		otp = sc.nextInt();

		if (otp == otpGenerated) {
			System.out.println("Otp validation successful");
			System.out.println("Enter the account no. to be transferred");
			toBeTransferredAccountNo = sc.nextInt();
			withdrawal(customer, "to transfer");
			if (customer2.getBankAccountNo() == toBeTransferredAccountNo) {
				customer2.setBalance(customer2.getBalance() + amt);
				System.out.println("The balance available for customer2 is: " + customer2.getBalance());
			}
		}

	}

}
