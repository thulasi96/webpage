package com.logic.dao;

import java.util.List;

import com.logic.model.userDetail;

public interface userDetailDao {

    	public boolean addUserdetail(userDetail user);
	
	public boolean updateUserdetail(userDetail user);
	
	public userDetail getUserdetail(String alluser);
	
	public userDetail getuserId(int userId);
	
	public List<userDetail> listusers();
	
	public boolean deleteuserDetail(userDetail user);
}
