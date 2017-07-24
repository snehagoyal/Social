package com.niit.social.chatbe.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.social.chatbe.model.AppliedJobs;
import com.niit.social.chatbe.model.Job;

@Transactional
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {
	private static final Logger log = LoggerFactory.getLogger(JobDAOImpl.class);
	   
	@Autowired
	private SessionFactory sessionFactory;


	@Transactional
	public boolean saveJob(Job job) {
		try {
			log.debug("Starting Method saveJob.");
				sessionFactory.getCurrentSession().save(job);
			log.debug("Ending Method saveJob");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in Method saveJob:-"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Transactional
	public boolean updateJob(Job job) {
		try {
			log.debug("Starting Method updateJob.");
				sessionFactory.getCurrentSession().update(job);
			log.debug("Ending Method updateJob");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in Method updateJob:-"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public boolean removeJob(String j_id) {
		try {
			log.debug("Starting Method removeJob.");
				sessionFactory.getCurrentSession().createQuery("Update JobOpportunities set j_status = 0 where j_id = '"+j_id+"'").executeUpdate();
			log.debug("Job removed with Id:-"+j_id);
			log.debug("Ending Method removeJob.");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in removeJob with (id = '"+j_id+"') "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public List<Job> getAllJobList() {
		try {
			log.debug("Starting of Method getAllJobList");
			Query query = sessionFactory.getCurrentSession().createQuery("FROM JobOpportunities");
			log.debug("Starting of get Job List");
			@SuppressWarnings("unchecked")
			List<Job> list = query.list();
			if(list==null || list.isEmpty()){
				log.debug("No Job's are Availible");
			}
		log.debug("Ending of Method getAllJobList");
		return list;
		}catch (HibernateException e) {
			log.error("Error Occured in Method getAllJobList :-"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	
	@Transactional
	public Job getJobById(String j_id) {
		try {
			log.debug("Staring of Method getJobById with j_id :- "+j_id);
			Query query = sessionFactory.getCurrentSession().createQuery("FROM JobOpportunities WHERE j_id = '"+j_id+"' AND j_status = 1");
			@SuppressWarnings("unchecked")
			List<Job> jobList = query.list();
			if(jobList != null && !jobList.isEmpty()){
				log.debug("Record Found in method getJobById with eventId ="+j_id);
				return jobList.get(0);
			}else{
				log.debug("No Record Found in getJobById with eventId ="+j_id);
				return null;
			}
	} catch (HibernateException e) {
		log.error("Error Occures in getJobById Method..!! (eventId = '"+j_id+"')");
		e.printStackTrace();
		return null;
	}
	}

	
	@Transactional
	public boolean applyJob(AppliedJobs job) {
		try {
			log.debug("Starting Method applyJob.");
				sessionFactory.getCurrentSession().save(job);
			log.debug("Ending Method applyJob");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in Method applyJob:-"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public List<AppliedJobs> getMyAppliedJobs(String u_id) {
		try {
			log.debug("Starting of Method getMyAppliedJobs");
			Query query = sessionFactory.getCurrentSession().createQuery("FROM AppliedJobs WHERE u_id = '"+u_id+"'");
			log.debug("Starting of getMyAppliedJob List");
			@SuppressWarnings("unchecked")
			List<AppliedJobs> list = query.list();
			if(list==null || list.isEmpty()){
				log.debug("No Job's are Availible");
			}
		log.debug("Ending of Method getMyAppliedJobs");
		return list;
		}catch (HibernateException e) {
			log.error("Error Occured in Method getMyAppliedJobs :-"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	

	
}
