package com.deloitte.dao;

import java.util.HashMap;
import java.util.Map;

import com.deloitte.bean.Account;
import com.deloitte.util.BankingException;
import com.deloitte.util.BankingMessages;

public class BankingDaoImpl implements BankingDao {
	private final double MIN_BALANCE = 5000;
	Map<Long,Account> accMap= new HashMap<>();
    private double balance=10000;
	@Override
	public boolean deposit(long accNo,double amount) {
		Account acc=accMap.get(accNo);
		//balance += amount;
		acc.setBalance(acc.getBalance()+ amount);
		return true;
	}
	@Override
	public double checkBalance() {
		return balance;
	}
	@Override
	public double withdraw(double acc,double withdraw) 
			throws BankingException {
		Account accn=accMap.get(acc);		
		double bal = accn.getBalance()-withdraw;
		if(bal<MIN_BALANCE) {
		//return -1;
			throw new BankingException(BankingMessages.INSUFFICIENT_BALANCE);
	    }
		balance=bal;
		return bal;

     }
	public boolean createAccount(Account account) {
		Account acc=accMap.get(account.getAccNo());
		if(acc==null) {
			accMap.put(account.getAccNo(), account);
			return true;
		}
		else 
			return false;
	}
	@Override
	public Account getAccountDetails(long accNo) {
		Account acc=null;
	return acc=accMap.get(accNo);
		
	}
}
