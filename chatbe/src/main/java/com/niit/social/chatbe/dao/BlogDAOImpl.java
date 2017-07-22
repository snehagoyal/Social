
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
import com.niit.social.chatbe.model.Comment;

@Transactional
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	private static Logger log= LoggerFactory.getLogger(BlogDAOImpl.class);
	
@Autowired
private SessionFactory sessionFactory;
 
@Transactional
public boolean addBlog(Blog b){
	try{
	log.debug("method working");
	b.setB_id(b.getB_title());
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
/*@Transactional
public List<Blog> blogListByUserId(String u_id) {
	try {
		log.debug("Starting of Method blogListByUserId");
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Blog WHERE u_id = '"+u_id+"'");
		log.debug("Starting of get BlogList");
		@SuppressWarnings("unchecked")
		List<Blog> list = query.list();
		if(list==null || list.isEmpty()){
			log.debug("No Blog's are Availible");
		}
	log.debug("Ending of Method blogListByUserId");
	return list;
	}catch (HibernateException e) {
		log.error("Error Occured in Method blogListByUserId :-"+e.getMessage());
		e.printStackTrace();
		return null;
	}
}*/
/*@Transactional
public boolean updateBlog(Blog blog) {
	try {
		log.debug("Starting Method updateBlog.");
			sessionFactory.getCurrentSession().update(blog);
		log.debug("Ending Method updateBlog");
		return true;
	} catch (HibernateException e) {
		log.error("Error Occured in Method updateBlog:-"+e.getMessage());
		e.printStackTrace();
		return false;
	}
}
*/
@Transactional
public List<Blog> getAllBlogs() {
	try {
		System.out.println("Starting of Method getAllBlogs");
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Blog WHERE b_status = '1'");
		log.debug("Starting of get BlogList");
		@SuppressWarnings("unchecked")
		List<Blog> list = query.list();
		if(list==null || list.isEmpty()){
			log.debug("No Blog's Are Available");
		}
	log.debug("Ending of Method getAllBlogs");
	return list;
	}catch (HibernateException e) {
		log.error("Error Occured in Method getAllBlogs :-"+e.getMessage());
		e.printStackTrace();
		return null;
	}
}

/*
@Transactional
public boolean removeBlog(String b_id) {
	try {
		log.debug("Starting Method removeBlog.");
			sessionFactory.getCurrentSession().createQuery("Update Blog set b_status = 0 where b_id = '"+b_id+"'").executeUpdate();
		log.debug("Blog removed with Id:-"+b_id);
		log.debug("Ending Method removeBlog.");
		return true;
	} catch (HibernateException e) {
		log.error("Error Occured in removeBlog with (id = '"+b_id+"') "+e.getMessage());
		e.printStackTrace();
		return false;
	}
}

@Transactional
public boolean bloglikes(String b_id) {
	try {
		log.debug("Starting Method forumlikes.");
			sessionFactory.getCurrentSession().createQuery("Update Blog set b_Like = b_Like+1 where b_id = '"+b_id+"'").executeUpdate();
		log.debug("Blog removed with Id:-"+b_id);
		log.debug("Ending Method forumlikes.");
		return true;
	} catch (HibernateException e) {
		log.error("Error Occured in forumlikes with (b_id = '"+b_id+"') "+e.getMessage());
		e.printStackTrace();
		return false;
	}
}

@Transactional
public boolean blogdislikes(String b_id) {
	try {
		log.debug("Starting Method forumdislikes.");
			sessionFactory.getCurrentSession().createQuery("Update Blog set blogDislike = blogDislike+1 where b_id = '"+b_id+"'").executeUpdate();
		log.debug("Blog removed with Id:-"+b_id);
		log.debug("Ending Method forumdislikes.");
		return true;
	} catch (HibernateException e) {
		log.error("Error Occured in forumdislikes with (id = '"+b_id+"') "+e.getMessage());
		e.printStackTrace();
		return false;
	}
}*/
public Blog getBlogById(String b_id, String b_status) {
	try {
		log.debug("Staring of Method getBlogById with blogId :- "+b_id);
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Blog WHERE b_id = '"+b_id+"' AND b_status = '"+b_status+"'");
		@SuppressWarnings("unchecked")
		List<Blog> blogList = query.list();
		if(blogList != null && blogList.isEmpty()){
			log.debug("Record Found in method getBlogById with id ="+b_id);
			return blogList.get(0);
		}else{
			log.debug("No Record Found in getBlogById with id ="+b_id);
			return null;
		}
} catch (HibernateException e) {
	log.error("Error Occures in getBlogById Method..!! (b_id = '"+b_id+"')");
	e.printStackTrace();
	return null;
}

}

public boolean approveBlog(String b_id, String b_approvestatus) {
	char b_status;
	try{
		System.out.println(" approve dao");
		if(b_approvestatus.equals("A")){
			b_status = '1';
		}else{
			b_status = '0';
		}
		log.debug("try to aPProve blog");
	Session s=sessionFactory.getCurrentSession();
	s.createQuery("Update Blog Set b_approveStatus='"+b_approvestatus + "',b_status='"+b_status+"' where b_id='"+b_id + "'").executeUpdate();
	log.debug("blog approved successfully");
	return true;
	}
	catch(HibernateException h)
	{
		
		System.out.println("in catch");
		log.error("error during blog approval");
	h.printStackTrace();
	return false;
	}	}


	@Transactional
	public List<Blog> blogListForApproval() {
		try {
			log.debug("Starting of Method blogListForApproval");
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Blog WHERE b_approveStatus = 'P'");
			log.debug("Starting of get BlogList");
			@SuppressWarnings("unchecked")
			List<Blog> list = query.list();
			if(list==null || list.isEmpty()){
				log.debug("No Blog's Approval are Pending");
			}
		log.debug("Ending of Method blogListForApproval");
		return list;
		}catch (HibernateException e) {
			log.error("Error Occured in Method blogListForApproval :-"+e.getMessage());
			e.printStackTrace();
			return null;
		}
}

/*
	@Transactional
	public boolean addComment(Comment comment) {
		try {
			log.debug("Starting Method addComment");
				sessionFactory.getCurrentSession().save(comment);
			log.debug("Ending Method addComment");
			return true;
		} catch (HibernateException e) {
			log.error("Error Occured in Method addComment:-"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Comment> commentsById(String b_id) {
		try {
			log.debug("Starting of Method commentsById");
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE b_id = '"+b_id+"'");
			log.debug("Starting of get CommentList");
			@SuppressWarnings("unchecked")
			List<Comment> list = query.list();
			if(list==null || list.isEmpty()){
				log.debug("No Comment's Are Available");
			}
		log.debug("Ending of Method commentsById");
		return list;
		}catch (HibernateException e) {
			log.error("Error Occured in Method commentsById :-"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	
		@Transactional
		public List<Comment> getAllComments(){
			try {
				log.debug("Starting of Method getAllComments");
				Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment");
				log.debug("Starting of get CommentList");
				@SuppressWarnings("unchecked")
				List<Comment> list = query.list();
				if(list==null || list.isEmpty()){
					log.debug("No Comment's Are Available");
				}
			log.debug("Ending of Method getAllComments");
			return list;
			}catch (HibernateException e) {
				log.error("Error Occured in Method getAllComments :-"+e.getMessage());
				e.printStackTrace();
				return null;
			}
		}


*/

 
}
