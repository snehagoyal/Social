
package com.niit.social.chatbe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.social.chatbe.dao.BlogDAO;
import com.niit.social.chatbe.model.Blog;

@RestController
public class BlogController {
	 private static Logger logger= LoggerFactory.getLogger("BlogController.class");
	 
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
logger.debug("Controller working");
	blogDAO.addBlog(b);
	return new ResponseEntity<Blog>(b,HttpStatus.OK);
}
}
