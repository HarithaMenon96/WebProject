package com.deloitte.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.deloitte.bean.Account;
import com.deloitte.dao.BankingDao;
import com.deloitte.ui.DBUtil;
import com.deloitte.util.BankingException;
import com.deloitte.util.BankingMessages;

public class BankingDaoJdbc implements BankingDao {
    private Logger logger;
    
	public BankingDaoJdbc() {
		logger=Logger.getLogger(BankingDaoJdbc.class);
	}

	@Override
	public boolean deposit(long accNo, double amount) throws BankingException {
		boolean success=false;
		Account account = null;
		String query="update account set balance=balance+? where accno=?";
		Connection conn;
		conn = DBUtil.getConnection();
		
		try {	
			logger.info("Updating balance for accNo: "+accNo+", amount: "+amount);
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setLong(2,accNo);
			int rows=ps.executeUpdate();
			if(rows>0)
				success=true;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new BankingException(BankingMessages.DB_ERROR);
		}
		return success;
	}

	@Override
	public double checkBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double withdraw(double acc, double withdraw) throws BankingException {
		double currBal=0;
		String query = "call bank_proc1(?,?,?)";
		Connection conn=DBUtil.getConnection();
		try {
			CallableStatement cs=conn.prepareCall(query);
			cs.setDouble(1,acc);
			cs.setDouble(2,withdraw);
			cs.registerOutParameter(3,Types.DOUBLE);
			cs.executeUpdate();
			currBal=cs.getDouble(3);
			logger.info("Current balance for acc: "+acc+"="+currBal);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new BankingException(BankingMessages.DB_ERROR);
		}
	return currBal;
	}

	@Override
	public boolean createAccount(Account account) throws BankingException {
		boolean success=false;
		String query="insert into account values(?,?,?,?)";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setLong(1,account.getAccNo());
			ps.setString(2,account.getCustName());
			ps.setLong(3,account.getMobile());
			ps.setDouble(4,account.getBalance());
			int rows=ps.executeUpdate();
			if(rows>0) 
				success=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return success;
	}

	@Override
	public Account getAccountDetails(long accNo) throws BankingException {
		Account accn=null;
		String query="select custname,mobile,balance from account where accno=?";
		Connection conn=DBUtil.getConnection();
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(query);
			ps.setLong(1, accNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				accn=new Account(accNo,rs.getString(1),rs.getLong(2),rs.getDouble(3));
			}
		} catch (SQLException e) {
			throw new BankingException(BankingMessages.DB_ERROR);
		}
		return accn;
	}


}



