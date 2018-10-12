package com.deloitte;

import java.util.List;

import com.deloitte.bean.UserObj;

public interface MyService {

	boolean authenticate(UserObj userObj);

	List<String> getUserList();

}
