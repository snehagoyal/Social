
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

public User isValidUser(String u_email, String u_password) {
	try{
		return	(User) sessionFactory.getCurrentSession().createQuery("from User where email='"+u_email+"' and password='"+ u_password+"' and approveStatus='A' and accountStatus='1'").uniqueResult();	
		}
		catch(HibernateException h)
		{
			log.error("error occured during user validation...");
		h.printStackTrace();
		return null;
		}
}

public List<User>getAllUsers(){
	return	sessionFactory.getCurrentSession().createQuery("from User ").list();	

}
/*public List<User>getForAproval(){
	return sessionFactory.getCurrentSession().createQuery("from User").list();
}*/

public boolean approveUser( String id, String status) {
	char accountStatus;
	try{
		System.out.println("in approve dao");
		if(status.equals("A")){
			accountStatus = '1';
		}else{
			accountStatus = '0';
		}
		log.debug("try to aPProve user");
	Session s=sessionFactory.getCurrentSession();
	s.createQuery("Update User Set approveStatus='"+status + "',accountStatus='"+accountStatus+"' where id='"+id + "'").executeUpdate();
	log.debug("user approved successfully");
	return true;
	}
	catch(HibernateException h)
	{
		System.out.println("in catch");
		log.error("error during user approval");
	h.printStackTrace();
	return false;
	}	}

public boolean setOnLine(String id) {
	try{
		log.debug("try set online .....");
	Session s=sessionFactory.getCurrentSession();
	s.createQuery("Update User Set is_Online='O' where id='"+id + "'").executeUpdate();
	log.debug("user is online ");
	return true;
	}
	catch(HibernateException h)
	{
		log.error("error occured during user online...");
	h.printStackTrace();
	return false;
	}
}

public List<User> getForApproval() {
	
	return sessionFactory.getCurrentSession().createQuery("from User").list();

}


}



