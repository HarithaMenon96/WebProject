package com.deloitte.service;

import com.deloitte.bean.Account;
import com.deloitte.util.BankingException;

public interface BankingService {

	boolean deposit(long accNo, double amount) throws BankingException;

	double checkBalance();

	double withdraw(double acc1, double withdraw) throws BankingException;

	Account getAccountDetails(long accNo2) throws BankingException;

	boolean createAccount(Account account) throws BankingException;

	void close();

}
