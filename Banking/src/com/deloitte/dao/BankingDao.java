package com.deloitte.dao;

import com.deloitte.bean.Account;
import com.deloitte.util.BankingException;

public interface BankingDao {

	boolean deposit(long accNo,double amount) throws BankingException;
	double checkBalance();
	double withdraw(double acc, double withdraw) throws BankingException;
	boolean createAccount(Account account) throws BankingException;
	//double getAccountDetails(long accNo) throws BankingException;
	public Account getAccountDetails(long accNo) throws BankingException;

}
