package com.niit.social.chatbe.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.social.chatbe.model.Event;

@Transactional
@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {
	private static final Logger log = LoggerFactory.getLogger(EventDAOImpl.class);
	   
	@Autowired
	private SessionFactory sessionFactory;

	public boolean createevent(Event e) {
		try{log.debug("start event");
		e.setE_id(e.getE_title());
		Session s= sessionFactory.getCurrentSession();
		s.save(e);
		return true;
		}
		catch(HibernateException h){
			log.debug("catch the exception in event");
			h.printStackTrace();
		return false;
		}
	}
	
	

}
