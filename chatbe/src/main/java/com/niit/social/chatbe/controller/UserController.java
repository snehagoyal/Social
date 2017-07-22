package com.niit.social.chatbe.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

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

import com.niit.social.chatbe.dao.UserDao;
import com.niit.social.chatbe.model.User;

@RestController
public class UserController {
	private static final Logger log=LoggerFactory.getLogger("UserControler.class");
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/hello1" , method= RequestMethod.POST)
	public String test1(){
		System.out.println("test");
		return "test";
	}
	
	
	@RequestMapping(value="/enterUser/",method=RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User u)
	{
		log.debug("trying to add User....");
		u.setIs_online('O');
		u.setU_accountstatus('1');
		u.setU_approvestatus('P');
		
		userDao.addUser(u);
	 return new ResponseEntity<User>(HttpStatus.OK);

	}
	@RequestMapping(value = "/ListAllUsers/", method = RequestMethod.GET)
	public ResponseEntity <List<User>> listAllUsers(){
		log.debug("**********Starting of Method listAllUsers**********");
		List<User> userslist = userDao.getAllUsers();
		if(userslist.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}else{
			log.debug("**********Size found :- "+userslist.size()+"**********");
			log.debug("**********Ending of Method listAllUsers**********");
			return new ResponseEntity<List<User>>(userslist,HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/Logout",method = RequestMethod.GET)
	public ResponseEntity<User> logout(HttpSession session){
		log.debug("Logout method");
		String u_name = (String) session.getAttribute("loggedInUserID");
		userDao.setOffLine(u_name);
		session.invalidate();
		log.debug("You Successfully Loggeddout");
		return new ResponseEntity<User>( HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/PendingUsers/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listPendingUsers(){
		log.debug("**********Starting of Method listPendingUsers**********");
		List<User> userslist = userDao.getForApproval();
		if(userslist.isEmpty()){
			return new ResponseEntity<List<User>>(userslist,HttpStatus.NO_CONTENT);
		}else{
			log.debug("**********Size found :- "+userslist.size()+"**********");
			log.debug("**********Ending of Method listPendingUsers**********");
			return new ResponseEntity<List<User>>(userslist,HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/Authentication/", method = RequestMethod.POST)
	public ResponseEntity<User> authentication(@RequestBody User userDetail,HttpSession session){
		System.out.println("***************************************"+userDetail.getU_email());
		log.debug("**********Calling Method Authentication.**********");
		User user;
		
		user = userDao.isValidUser(userDetail.getU_email(), userDetail.getU_password());
		if(user != null){
			log.debug("**********User Exist With Given Credentials.**********");
			session.setAttribute("loggedInUser",user);
			session.setAttribute("userName",user.getU_name());
			session.setAttribute("loggedInUserID", user.getU_id());
			userDao.setOnLine(user.getU_id());
		}else{
			user = new User();
			user.setErrorCode("404");
			user.setErrorMessage("Invaid Credentials...!!!Please Enter Valid Username OR Password.");
		}
		return new ResponseEntity<User>(user , HttpStatus.OK);
	}		

	@RequestMapping(value = "/ApproveUser/{u_id}/{u_approvestatus}", method = RequestMethod.GET)
	public ResponseEntity<User> approveUser(@PathVariable("u_id") String u_id,@PathVariable("u_approvestatus") String u_approvestatus){
		log.debug("**********Starting of Method approveUser WITH USER_ID :-**********" + u_id);
		System.out.println("try to approve user");
	/*		User user = userDao.userGetById(u_id);
		if(user == null){
			log.debug("**********User Does not Exist with this ID :-"+u_id+"**********");
			System.out.println("In if Approve user");
			user = new User();
			user.setErrorCode("404");
			user.setErrorMessage("User Does not Exist with this ID :-"+u_id);
			return new ResponseEntity<User>(user , HttpStatus.NOT_FOUND);
		}else{
		
			System.out.println("in else approve user");
			user.setU_id(u_id);*/
			userDao.approveUser(u_id, u_approvestatus);
			log.debug("**********User Approved Successfully WITH ID:- "+u_id+"**********");
			return new ResponseEntity<User>(HttpStatus.OK);
		}
	}

			
