

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
import com.niit.social.chatbe.model.Comment;
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
    
    User loggedInUser = (User) session.getAttribute("loggedInUser");
    b.setU_id(loggedInUser.getU_id());
   
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
    
@RequestMapping(value = "/BlogList/", method = RequestMethod.GET)
public ResponseEntity<List<Blog>> listAllBlogs(){
	System.out.println("**********Starting of Method listAllBlogs**********");
	List<Blog> blogList = blogDAO.getAllBlogs();
	if(blogList.isEmpty() || blogList == null){
		return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
	}else{
		log.debug("**********Size found :- "+blogList.size()+"**********");
		log.debug("**********Ending of Method listAllBlogs**********");
		return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
	}
} 
/*@RequestMapping(value = "/BlogPages/Comments/{comment}/{id}", method = RequestMethod.GET)
public ResponseEntity<Comment> addComment(@PathVariable("comment") String c_com,@PathVariable("id") String b_id,HttpSession session){
	log.debug("**********Starting of ADDING Comment**********" +c_com+ b_id);
	Comment com=new Comment();
	com.setB_id(b_id);
	com.setC_com(c_com);
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    String commented = (dateFormat.format(date));
    com.setC_date(commented);
    User loggedInUser = (User) session.getAttribute("loggedInUser");
    com.setU_name(loggedInUser.getU_name());
    blogDAO.addComment(com);

		log.debug("**********Comment ADDED Successfully WITH ID:- "+c_com+b_id+"**********");
		return new ResponseEntity<Comment>(HttpStatus.OK);
}

@RequestMapping(value = "/BlogPages/getComments/", method = RequestMethod.GET)
public ResponseEntity<List<Comment>> getComments(){
	log.debug("**********Starting of Method getComments**********");
	List<Comment> commentList=blogDAO.getAllComments();
		if(commentList.isEmpty() || commentList == null){
			return new ResponseEntity<List<Comment>>(HttpStatus.NO_CONTENT);
		}else{
			log.debug("**********Comments Shown Successfully **********");
			return new ResponseEntity<List<Comment>>(commentList,HttpStatus.OK);
		}
	}*/


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
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
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
/*@RequestMapping(value = "/getMyBlogList/", method = RequestMethod.POST)
public ResponseEntity<List<Blog>> getMyBlogList(HttpSession session){
	try {
		log.debug("**********Starting of Method getMyBlogList**********");
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		List<Blog> blogList = blogDAO.blogListByUserId(loggedInUser.getU_id());
		if(blogList.isEmpty()){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}else{
			log.debug("**********Size found :- "+blogList.size()+"**********");
			log.debug("**********Ending of Method getMyBlogList**********");
			return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
	}
}
//http://localhost:8080/CollabrationBackEnd/BlogPages/UpdateBlog/{id}
	@RequestMapping(value = "/UpdateBlog/{b_id}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> updateBlog(@PathVariable("b_id") String b_id,@RequestBody Blog blog){
		log.debug("**********Starting of Method updateBlog**********" + b_id);
		if(blogDAO.getBlogById(b_id,"1") == null){
			log.debug("**********Blog Does not Exist with this ID :-"+b_id+"**********");
			blog = new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Does not Exist with this b_id :-"+b_id);
			return new ResponseEntity<Blog>(blog , HttpStatus.NOT_FOUND);
		}else{
			blog.setB_id(b_id);
			blogDAO.updateBlog(blog);
			log.debug("**********Blog Updated Successfully WITH ID:- "+b_id+"**********");
			return new ResponseEntity<Blog>(blog , HttpStatus.OK);
		}
	}
	
	//http://localhost:8080/CollabrationBackEnd/BlogPages/RemoveBlog/{id}
	@RequestMapping(value = "/RemoveBlog/{b_id}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> removeBlog(@PathVariable("b_id") String b_id){
		log.debug("**********Starting of Method removeUser**********");
		Blog blog = blogDAO.getBlogById(b_id,"1");
		if(blog == null){
			log.debug("**********Blog Does not Exist with this b_id :-"+b_id+"**********");
			blog = new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Does not Exist with this b_id :-"+ b_id);
			return new ResponseEntity<Blog>(blog , HttpStatus.NOT_FOUND);
		}else{
			blogDAO.removeBlog(b_id);
			log.debug("**********Blog Deleted Successfully WITH b_id:- "+b_id+"**********");
			return new ResponseEntity<Blog>(blog , HttpStatus.OK);
		}
	}

	//http://localhost:8080/CollabrationBackEnd/Blog/RemoveBlog/{id}
	@RequestMapping(value = "/GetBlogById/{b_id}/{b_status}",method = RequestMethod.GET)
	public ResponseEntity<Blog> getBlogById(@PathVariable("b_id") String b_id,@PathVariable("b_status") String b_status){
		log.debug("**********Starting of Method getBlogById**********");
		Blog blog = blogDAO.getBlogById(b_id,b_status); //Send Status in URL .***
		if(blog == null){
			log.debug("**********Blog Does not Exist with this ID :-"+b_id+"**********");
			blog = new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("Blog Does not Exist with this ID :-"+ b_id);
			return new ResponseEntity<Blog>(blog , HttpStatus.NOT_FOUND);
		}else{
			log.debug("**********Blog Found Successfully WITH ID:- "+b_id+"**********");
			return new ResponseEntity<Blog>(blog , HttpStatus.OK);
		}
	}
	
	//http://localhost:8080/CollabrationBackEnd/BlogPages/UpdateBlog/{id}
	
@RequestMapping(value = "/Like/{b_id}", method = RequestMethod.PUT)
public ResponseEntity<Blog> likeBlog(@PathVariable("b_id") String b_id){
	log.debug("**********Starting of Method updateBlog**********" + b_id);
	
		blogDAO.bloglikes(b_id);
		log.debug("**********Blog Updated Successfully WITH ID:- "+b_id+"**********");
		return new ResponseEntity<Blog>(HttpStatus.OK);
}


@RequestMapping(value = "/DisLike/{b_id}", method = RequestMethod.PUT)
public ResponseEntity<Blog> disLikeBlog(@PathVariable("b_id") String b_id){
	log.debug("**********Starting of Method updateBlog**********" + b_id);
		blogDAO.blogdislikes(b_id);
		log.debug("**********Blog Updated Successfully WITH ID:- "+b_id+"**********");
		return new ResponseEntity<Blog>(HttpStatus.OK);
}
*/

}
