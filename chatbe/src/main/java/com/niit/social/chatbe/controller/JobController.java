package com.niit.social.chatbe.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.social.chatbe.dao.JobDAO;
import com.niit.social.chatbe.model.Job;
import com.niit.social.chatbe.model.User;
@RestController
public class JobController {
	private static final Logger log=LoggerFactory.getLogger("JobController.class");
	
	@Autowired
	JobDAO jobDAO;
	
	@RequestMapping(value="/hello", method= RequestMethod.POST)
	public String test(){
		System.out.println("hello");
		return "test";
	}
	
	@RequestMapping(value="/Addjob/", method= RequestMethod.POST)
	public ResponseEntity<Job> jobadd(@RequestBody Job j, HttpSession session){
		log.debug("trying to add job ");
		jobDAO.jobadd(j);
		 return new ResponseEntity<Job>(j, HttpStatus.OK);

		
	}
}
