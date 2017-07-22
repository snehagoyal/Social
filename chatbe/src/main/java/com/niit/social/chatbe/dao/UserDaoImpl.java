
package com.niit.social.chatbe.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.social.chatbe.model.Blog;
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
		u.setU_id(u.getU_name());
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

@Transactional
public User isValidUser(String u_email, String u_password) {
	try {
		log.debug("**********Starting of Method isValidUser.**********");
			Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE u_email = '"+u_email+"' AND u_password = '"+u_password+"' AND u_accountStatus = 1");
			log.debug("**********Starting of get UsersList.**********");
			@SuppressWarnings("unchecked")
			List<User> list = query.list();
			if(list != null && !list.isEmpty()){
				log.debug("**********Ending of Method isValidUser.**********");
				return list.get(0);
			}else{
				log.debug("**********No User's are Availible.**********");
				log.debug("**********Ending of Method isValidUser.**********");
				return null;
			}
	}catch (HibernateException e) {
		log.error("**********Error Occured in Method isValidUser :-"+e.getMessage()+".**********");
		e.printStackTrace();
		return null;
	}
	
}
public List<User>getAllUsers(){
	return	sessionFactory.getCurrentSession().createQuery("from User ").list();	

}

public boolean approveUser( String u_id, String u_approvestatus) {
	char accountStatus;
	try{
		System.out.println("in approve dao");
		if(u_approvestatus.equals("A")){
			accountStatus = '1';
		}else{
			accountStatus = '0';
		}
		log.debug("try to aPProve user");
	Session s=sessionFactory.getCurrentSession();
	s.createQuery("Update User Set u_approveStatus='"+u_approvestatus + "',u_accountStatus='"+accountStatus+"' where u_id='"+u_id + "'").executeUpdate();
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

public boolean setOnLine(String u_id) {
	try{
		log.debug("try set online .....");
	Session s=sessionFactory.getCurrentSession();
	s.createQuery("Update User Set is_Online='O' where id='"+u_id + "'").executeUpdate();
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
	
	return sessionFactory.getCurrentSession().createQuery("from User where u_approvestatus= 'P'").list();

}
public User userGetById(String u_id) {
	
		System.out.println("Staring of Method getUserById with b_id :- "+u_id);
		return (User) sessionFactory.getCurrentSession().createQuery("FROM User WHERE u_id = '"+u_id+"'");
	

}


	public void setOffLine(String u_name) {
		try {
			log.debug("Starting of Method setOnLine. with Id : **********"+u_name);
				sessionFactory.getCurrentSession().createQuery("UPDATE User SET is_Online = 'N' WHERE u_name = '"+u_name+"'").executeUpdate();
				log.debug("**********Ending of Method setOnLine.**********");
		} catch (Exception e) {
				e.printStackTrace();
				log.debug("**********Error Occuring while SetOnline Finction..**********");
		}
		
	}
	public boolean updateUser(User user) {
		try {
			log.debug("Starting Method updateUser.");
				sessionFactory.getCurrentSession().update(user);
				sessionFactory.getCurrentSession().flush();
			log.debug("Ending Method updateUser");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in Method updateUser:-"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(String u_name) {
		try {
			log.debug("Starting Method deleteUser.");
				sessionFactory.getCurrentSession().createQuery("Update User set u_accountstatus = 0 where u_name = '"+u_name+"'").executeUpdate();
			log.debug("UserDetail removed with Id:-"+u_name);
			log.debug("Ending Method deleteUser.");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in deleteUser with (id = '"+u_name+"') "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
}




