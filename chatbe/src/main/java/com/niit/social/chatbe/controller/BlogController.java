
package com.niit.social.chatbe.controller;

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

@RestController
public class BlogController {
	 private static Logger log= LoggerFactory.getLogger("BlogController.class");
	 
	 @Autowired
	BlogDAO blogDAO;
	 
	@RequestMapping(value="/h", method= RequestMethod.POST)
	public String hello()
	{
		System.out.println("Start the controller");
		return "hell";
	}
@RequestMapping(value="/enterBlog/", method= RequestMethod.POST)
public ResponseEntity<Blog> addBlog(@RequestBody Blog b){
log.debug("Controller working");
	blogDAO.addBlog(b);
	return new ResponseEntity<Blog>(b,HttpStatus.OK);
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
