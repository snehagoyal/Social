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

import com.niit.social.chatbe.dao.UserDao;
import com.niit.social.chatbe.model.User;

@RestController
public class UserController {
	private static final Logger logger=LoggerFactory.getLogger("UserControler.class");
	@Autowired
	UserDao userDao;
	
	
	
	@RequestMapping(value="/createUser/",method=RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User u)
	{
		logger.debug("trying to add User....");
		userDao.addUser(u);
	 return new ResponseEntity<User>(u,HttpStatus.OK);

	}
}