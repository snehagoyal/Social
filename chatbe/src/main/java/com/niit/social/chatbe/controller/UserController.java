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
	
	@RequestMapping(value="/hello" , method= RequestMethod.POST)
	public String test(){
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
	@RequestMapping(value="/userlogin/",method=RequestMethod.POST)
	public ResponseEntity<User>login(@RequestBody User u, HttpSession session){
		log.debug("trying to login");
User user;
user = userDao.isValidUser(u.getU_email(), u.getU_password());
if(user != null){
	log.debug("**********User Exist With Given Credentials.**********");
	
	session.setAttribute("loggedInUser",user);
	session.setAttribute("userName",user.getU_firstname()+' '+user.getU_lastname());
	session.setAttribute("loggedInUserID", user.getU_id());
	userDao.setOnLine(user.getU_id());
}else{
	user = new User();
	user.setErrorCode("404");
	user.setErrorMessage("Invaid Credentials...!!!Please Enter Valid Username OR Password.");
}
return new ResponseEntity<User>(user , HttpStatus.OK);
}		

	@RequestMapping(value = "/ApproveUser/{id}/{status}", method = RequestMethod.POST)
	public ResponseEntity<User> approveUser(@PathVariable("id") String id,@PathVariable("status") String status){
		log.debug("**********Starting of Method approveUser WITH USER_ID :-**********" + id);
		System.out.println("try to approve user");
/*			UserDetail user = userDetailDao.userGetById(userId);
		if(user == null){
			log.debug("**********User Does not Exist with this ID :-"+userId+"**********");
			user = new UserDetail();
			user.setErrorCode("404");
			user.setErrorMessage("User Does not Exist with this ID :-"+userId);
			return new ResponseEntity<UserDetail>(user , HttpStatus.NOT_FOUND);
		}else{
			user.setUserId(userId);*/
			userDao.approveUser(id, status);
			log.debug("**********Blog Approved Successfully WITH ID:- "+id+"**********");
			return new ResponseEntity<User>(HttpStatus.OK);
	//	}
	}

			
}