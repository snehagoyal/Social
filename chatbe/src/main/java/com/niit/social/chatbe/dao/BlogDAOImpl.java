package com.niit.social.chatbe.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.social.chatbe.model.Blog;

@Transactional
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	private static Logger log= LoggerFactory.getLogger(BlogDAOImpl.class);
	
@Autowired
private SessionFactory sessionFactory;
 
public boolean addBlog(Blog b){
	try{
	log.debug("method working");
	Session ss= sessionFactory.getCurrentSession();
	ss.save(b);
	log.debug("blog added");
	return true;
	} 
	catch(Exception e){
		log.debug("blog not saved");
		e.printStackTrace();
		return false;
	}
}
 
}
