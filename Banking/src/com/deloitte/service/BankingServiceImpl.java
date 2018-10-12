package com.deloitte.service;

import com.deloitte.bean.Account;
import com.deloitte.dao.BankingDao;
import com.deloitte.dao.BankingDaoImpl;
import com.deloitte.util.BankingException;

public class BankingServiceImpl implements BankingService {
    private BankingDao bDao;
    public BankingServiceImpl() {
		bDao = new BankingDaoJdbc();//BankingDaoImpl();
	}
	
	@Override
	public boolean deposit(long accNo,double amount) throws BankingException {
		
		return bDao.deposit(accNo,amount);
	}

	@Override
	public double checkBalance() {
		// TODO Auto-generated method stub
		return bDao.checkBalance();
	}

	@Override
	public Account getAccountDetails(long accNo) throws BankingException {
		return bDao.getAccountDetails(accNo);
	}

	@Override
	public boolean createAccount(Account account) throws BankingException {
		return bDao.createAccount(account);
	}

    @Override
	public double withdraw(double acc, double withdraw) throws BankingException {
	
		return bDao.withdraw(acc,withdraw);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}

	


