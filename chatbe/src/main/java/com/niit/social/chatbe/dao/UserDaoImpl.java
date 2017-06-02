package com.niit.social.chatbe.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.social.chatbe.model.User;


@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
   
	@Autowired
	private SessionFactory sessionFactory;
	
public boolean addUser(User u) {
	try{
		log.debug("Adduser");
		u.setU_id(u.getU_email());
		Session s= sessionFactory.getCurrentSession();
		s.save(u);
		log.debug("user added successfully");
		return true;
	}
	catch(HibernateException e){
		log.debug("user not added successfully");
		e.printStackTrace();
	return false;
	}
	
	
}
}



