
package com.niit.social.chatbe.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.social.chatbe.dao.BlogDAO;
import com.niit.social.chatbe.model.Blog;
import com.niit.social.chatbe.model.User;

@RestController
public class BlogController {
	 private static Logger log= LoggerFactory.getLogger("BlogController.class");
	 
	 @Autowired
	BlogDAO blogDAO;

	Session session;
	 
	@RequestMapping(value="/h", method= RequestMethod.POST)
	public String hello()
	{
		System.out.println("Start the controller");
		return "hell";
	}
@RequestMapping(value="/enterBlog/", method= RequestMethod.POST)
public ResponseEntity<Blog> addBlog(@RequestBody Blog b, HttpSession session){
log.debug("Controller working");
if(blogDAO.getBlogById(b.getB_id(),"0") == null){

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String blogCreatedAt = (dateFormat.format(date));
    
	DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date2 = new Date();
    String blogModifiedAt = (dateFormat2.format(date2));
    

	User userName = (User) session.getAttribute("userName");
  //  b.setU_name(userName.getU_name());
	b.setU_name(userName.getU_name());
    b.setB_dislike(0);
    b.setB_like(0);
    b.setB_CreatedAt(blogCreatedAt);
    b.setB_ModifiedAt(blogModifiedAt);
    b.setB_approvestatus('P');
    b.setB_status('0');
    
    blogDAO.addBlog(b);
	log.debug("**********New Blog Created Successfully**********");
	b = new Blog();
	b.setErrorMessage("Blog Created Successfully..!!!Wait for the Admin Approval.");
	return new ResponseEntity<Blog>(b , HttpStatus.OK);
}
log.debug("**********Blog already Exist with ID :-"+b.getB_id()+" **********");
b.setErrorMessage("Blog Already Exist With ID:-"+b.getB_id());
return new ResponseEntity<Blog>(b , HttpStatus.OK);
}

@RequestMapping(value = "/ApproveBlog/{b_id}/{b_approvestatus}", method = RequestMethod.GET)
public ResponseEntity<Blog> approveBlog(@PathVariable("b_id") String b_id,@PathVariable("b_approvestatus") String b_approvestatus){
	log.debug("**********Starting of Method approveBlog WITH b_id:-**********" + b_id);
	Blog blog = blogDAO.getBlogById(b_id,"0");
	if(blog == null){
		log.debug("**********Blog Does not Exist with this ID :-"+b_id+"**********");
		blog = new Blog();
		blog.setErrorCode("404");
		blog.setErrorMessage("Blog Does not Exist with this ID :-"+b_id);
		return new ResponseEntity<Blog>(blog , HttpStatus.NOT_FOUND);
	}else{
		//blog.setB_id(b_id);
		blogDAO.approveBlog(b_id,b_approvestatus);
		log.debug("**********Blog Approved Successfully WITH ID:- "+b_id+"**********");
		return new ResponseEntity<Blog>( HttpStatus.OK);
	}
}
@RequestMapping(value = "/PendingBlogList/", method = RequestMethod.GET)
public ResponseEntity<List<Blog>> listPendingBlogs(){
	log.debug("**********Starting of Method listPendingBlogs**********");
	List<Blog> blogList = blogDAO.blogListForApproval();
	if(blogList.isEmpty()){
		return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
	}else{
		log.debug("**********Size found :- "+blogList.size()+"**********");
		log.debug("**********Ending of Method listPendingBlogs**********");
		return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
		}
}
/*@RequestMapping(value = "/BlogPages/Like/{id}", method = RequestMethod.PUT)
public ResponseEntity<Blog> likeBlog(@PathVariable("b_id") String b_id){
	log.debug("**********Starting of Method updateBlog**********" + b_id);
	
		blogDAO.bloglikes(b_id);
		log.debug("**********Blog Updated Successfully WITH ID:- "+b_id+"**********");
		return new ResponseEntity<Blog>(HttpStatus.OK);
}


@RequestMapping(value = "/BlogPages/DisLike/{id}", method = RequestMethod.PUT)
public ResponseEntity<Blog> disLikeBlog(@PathVariable("b_id") String b_id){
	log.debug("**********Starting of Method updateBlog**********" + b_id);
		blogDAO.blogdislikes(b_id);
		log.debug("**********Blog Updated Successfully WITH ID:- "+b_id+"**********");
		return new ResponseEntity<Blog>(HttpStatus.OK);
}
*/

}
