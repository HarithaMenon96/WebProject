package com.deloitte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.bean.UserObj;
import com.deloitte.util.DBUtil;

public class MyDaoImpl implements MyDao {

	@Override
	public boolean authenticate(UserObj userObj) {
		boolean success=false;
		String query="select password from user_details where login=?";
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,userObj.getLogin());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String password=rs.getString(1);
				System.out.println(userObj);
				System.out.println(password);
				if(password!=null && password.equals(userObj.getPassword())) {
					success=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<String> getUserList() {
		List<String> uList=new ArrayList<>();
	    uList.add("Nidhi");
	    uList.add("Priyanka");
	    uList.add("Souvik");
	    uList.add("Sooraj");
	    uList.add("ABC");
		return uList;
	}

}
