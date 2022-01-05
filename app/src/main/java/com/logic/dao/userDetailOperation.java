package com.logic.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.logic.model.userDetail;

@Transactional							
@Repository("userDao")

public class userDetailOperation implements userDetailDao{

    @Autowired
	SessionFactory sessionFactory;
    
    @Override
    public boolean addUserdetail(userDetail user) {
	try {
	    sessionFactory.getCurrentSession().save(user);
	    System.out.println("*****Registration Success*****");
	    return true;
	}catch(Exception e){
	    System.out.println("*****Registration Failed*****");
	    return false;
	}
    }

    @Override
    public boolean updateUserdetail(userDetail user) {
	try{
	    sessionFactory.getCurrentSession().save(user);
	    System.out.println("*****Registration Updated*****");
	    return true;
	}catch(Exception e)
	{
	    System.out.println("*****Registration Update Failed*****");
	    return false;
	}
    }

    @Override
    public userDetail getUserdetail(String user) {
	Session session=sessionFactory.openSession();
	userDetail userdetail=session.get(userDetail.class,user);
	session.close();
	return userdetail;
    }

    @Override
    public userDetail getuserId(int userId) {
	Session session=sessionFactory.openSession();
	userDetail userdetail=session.get(userDetail.class,userId);
	session.close();
	return userdetail;
    }

    @Override
    public List<userDetail> listusers() {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from userDetail");
	
	List<userDetail> userlist=query.list();
	session.close();
	return userlist;
    }

    @Override
    public boolean deleteuserDetail(userDetail user) {
	try
	{
		sessionFactory.getCurrentSession().delete(user);
		System.out.println("*****Deleted Success*****");
		return true;
	}
	catch(Exception e)
	{
	    	System.out.println("*****Deleted Failed*****");
		return false;
	}
    }

}
