package com.deloitte.bean;

/**
 * @author nexwave
 *
 */
public class UserObj {
	private String login;
	private String password;
	public UserObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserObj(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	
	

}
