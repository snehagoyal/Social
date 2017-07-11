package com.niit.social.chatbe.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.social.chatbe.model.Job;

@Transactional
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {
	private static final Logger log = LoggerFactory.getLogger(JobDAOImpl.class);
	   
	@Autowired
	private SessionFactory sessionFactory;

	public boolean jobadd(Job j) {
		try{
		log.debug("Save job");
		j.setJ_id(j.getJ_title());
		Session s= sessionFactory.getCurrentSession();
		s.save(j);
		log.debug("job added");
		return true;
		}
		catch(HibernateException e){
			log.debug("Error while adding job");
			e.printStackTrace();
			return false;
			
		}
	}
	

}
