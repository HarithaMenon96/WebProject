package com.deloitte.service;

import java.util.ArrayList;
import java.util.List;

import com.deloitte.MyService;
import com.deloitte.bean.UserObj;
import com.deloitte.dao.MyDao;
import com.deloitte.dao.MyDaoImpl;

public class MyServiceImpl implements MyService {
	
    private MyDao mDao;
    
	public MyServiceImpl() {
		mDao=new MyDaoImpl();
	}

	@Override
	public boolean authenticate(UserObj userObj) {
		return mDao.authenticate(userObj);
	}

	@Override
	public List<String> getUserList() {
		return mDao.getUserList();
	}

}
