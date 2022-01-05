package com.logic.app;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.logic.dao.userDetailDao;
import com.logic.model.userDetail;

public class userTesting {
    
    	static userDetailDao userDao;

    	@BeforeClass
	public static void testing() 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.logic");
		context.refresh();
		
		userDao = (userDetailDao)context.getBean("userDao");
	}
    
    	@Ignore
    	@Test
	public void addUserdetail()
	{
		userDetail userDetails = new userDetail();
		userDetails.setUsername("thulasi");
		userDetails.setPassword("123");
		
		assertTrue("Problem in Adding Userdetail",userDao.addUserdetail(userDetails));	
	}
    	@Ignore
    	@Test
    	public void deleteCartTest()
    	{
    	userDetail userDetails=userDao.getuserId(2);
    		assertTrue("Problem in Deleting Cart",userDao.deleteuserDetail(userDetails));
    	}

}
