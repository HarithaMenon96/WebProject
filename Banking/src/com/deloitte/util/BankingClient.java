package com.deloitte.util;

import java.util.Scanner;

import com.deloitte.bean.Account;
import com.deloitte.service.BankingService;
import com.deloitte.service.BankingServiceImpl;
import com.deloitte.util.BankingException;

public class BankingClient {
	
    private BankingService bService;
	public BankingClient() {
		bService=new BankingServiceImpl();
		int choice = 0;
		Scanner scan = new Scanner(System.in);
		while (true) {
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Deposit Amount");
				 System.out.println("Enter Account Number");
				 long accNo=scan.nextLong();
                System.out.println("Enter amount to deposit");
                double amount=scan.nextDouble();
                boolean success=false;
				try {
					success = bService.deposit(accNo,amount);
				} catch (BankingException e1) {
					System.out.println(e1.getMessage());
				}
                if(success) {
                	System.out.println("Amount Deposited");
                }
                else {
                	System.out.println("Deposit Failed");
                }
				break;
			case 2:
				System.out.println("Withdraw Amount");
				System.out.println("Enter the account no");
				double acc1=scan.nextDouble();
				System.out.println("Enter the amount to withdraw");
				double withdraw=scan.nextDouble();
				double currbalance=0;
				try {					
					if(currbalance>0) {
						currbalance=bService.withdraw(acc1,withdraw); 
					}
						 System.out.println("Amount withdrawn, curr bal: "+currbalance);									
				} catch (BankingException e) {
					System.out.println(e.getMessage());
					
				}
			//	System.out.println("amount withdrawn "+"Current Balance" +currbalance);
				break;
			case 3:
//				System.out.println("Enter Account no to Check Balance");
//				long accNo2=scan.nextLong();
//				double acc=bService.getAccountDetails(accNo2);
				//double balance=bService.checkBalance();
				System.out.println("Check Account Details");
				System.out.println("Enter the account number");
				accNo=scan.nextLong();
				Account acc;
				try {
					acc=bService.getAccountDetails(accNo);
					System.out.println("Acc No: "+acc.getAccNo());
					System.out.println("Customer Name: "+acc.getCustName());
					System.out.println("Mobile: "+acc.getMobile());
					System.out.println("Balance: "+acc.getBalance());
					
				} catch (BankingException e1) {
					System.out.println(e1.getMessage());
				}
				
				
				break;
			case 4:
				System.out.println("Create Account");
				System.out.println("Enter Account Number");
				accNo=scan.nextLong();
				System.out.println("Enter customer name");
				String custName=scan.next();
				System.out.println("Enter customer mobile");
				long mobile=scan.nextLong();
				System.out.println("Enter Balance");
				double balance=scan.nextDouble();
				boolean success1=false;
				Account account=new Account(accNo,custName,mobile,balance);
				try {
					success1=bService.createAccount(account);
				} catch (BankingException e) {
					e.printStackTrace();
				}
				if(success1) {
					System.out.println("Account added");
				}
				else {
					System.out.println("Account already exists");
				}
//				System.out.println("Existing Application. Thank You.");
//				System.exit(0);
				break;
			case 5:System.out.println("Exit");
			bService.close();

			default:
				System.err.println("Please Enter valid choice");
				break;
			}
		}
	}

	private int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("Online Banking System");
		System.out.println("1.Deposit Amount");
		System.out.println("2.Withdraw Amount");
		System.out.println("3.Check Balance");
		System.out.println("4.Create Account");
		System.out.println("Enter your choice :");
		choice = scan.nextInt();
		return choice;
	}

	public static void main(String[] args) {
		new BankingClient();

	}

}
