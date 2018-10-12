package com.deloitte.dao;

import java.util.List;

import com.deloitte.bean.UserObj;

public interface MyDao {

	boolean authenticate(UserObj userObj);

	List<String> getUserList();

}
