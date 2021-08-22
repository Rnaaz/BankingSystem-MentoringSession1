package com.greatlearning.main;

import com.greatlearning.models.Customer;
import com.greatlearning.services.BankingService;

import java.util.*;

public class Driver {

	public static void main(String[] args) {

		BankingService bankingService = new BankingService();
		Customer customer1 = new Customer(123456, "password", 1000);
		Customer customer2 = new Customer(45678, "customer2", 4000);
		Scanner in = new Scanner(System.in);
		int bankAccountNo;
		String password;
		int balance;

		System.out.println("Welcome to the login page");
		System.out.println("-------------------------");
		System.out.println("Enter your account no:");
		bankAccountNo = in.nextInt();
		System.out.println("Enter the password");
		password = in.next();
		balance = customer1.getBalance();
		Customer loggedInCustomer = new Customer(bankAccountNo, password, balance);

		if (validateCustomer(loggedInCustomer, customer1)) {
			int option = 0;
			do {
				System.out.println("Enter the service:");
				System.out.println("..............................");
				System.out.println("1. Deposit");
				System.out.println("2. withdrawal");
				System.out.println("3. Transfer");
				System.out.println("0. Logout");
				System.out.println("..............................");
				option = in.nextInt();
				switch (option) {
				case 0:
					bankingService.logout();
					break;
				case 1:
					bankingService.deposit(loggedInCustomer);
					break;
				case 2:
					bankingService.withdrawal(loggedInCustomer, "withdrawn");
					break;
				case 3:
					bankingService.transfer(loggedInCustomer, customer2);
					break;
				default:
					System.out.println("Invalid input");
				}
			} while (option != 0);
		} else {
			System.out.println("Please enter valid credentials");
		
		}
		in.close();
	}

	private static boolean validateCustomer(Customer loggedInCustomer, Customer customer1) {
		return loggedInCustomer.getBankAccountNo() == customer1.getBankAccountNo()
				&& loggedInCustomer.getPassword().equals(customer1.getPassword());
	}

}
