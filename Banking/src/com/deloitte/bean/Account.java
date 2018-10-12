package com.deloitte.bean;

public class Account {
	private Long accNo;
	private String custName;
	private long mobile;
	private double balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getAccNo() {
		return accNo;
	}
	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", custName=" + custName + ", mobile=" + mobile + ", balance=" + balance
				+ "]";
	}
	public Account(Long accNo, String custName, long mobile, double balance) {
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.mobile = mobile;
		this.balance = balance;
	}
	

}
