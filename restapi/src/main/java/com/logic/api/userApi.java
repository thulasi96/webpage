package com.logic.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logic.dao.userDetailDao;
import com.logic.model.userDetail;

@RestController
public class userApi {
    
    	@Autowired
	userDetailDao userDao;
	
	@GetMapping("/showAllUser")
	public ResponseEntity<List<userDetail>> showAllUser()
	{
		List<userDetail> listUserDetail=userDao.listusers();
		
		if(listUserDetail.size()>0)
		{
			return new ResponseEntity<List<userDetail>>(listUserDetail,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<userDetail>>(listUserDetail,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
