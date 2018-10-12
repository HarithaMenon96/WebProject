package com.deloitte.util;

public class BankingException extends Exception {

	public BankingException(String insufficientBalance) {
		super(insufficientBalance);
	}

}
