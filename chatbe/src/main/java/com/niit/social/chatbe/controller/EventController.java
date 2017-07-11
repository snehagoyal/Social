package com.niit.social.chatbe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.social.chatbe.dao.EventDAO;
import com.niit.social.chatbe.dao.UserDaoImpl;
import com.niit.social.chatbe.model.Event;

@RestController
public class EventController {
	private static final Logger log = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	EventDAO eventDAO;
	
	@RequestMapping(value="/AnEvent/", method =RequestMethod.POST)
	public ResponseEntity<Event> createEvent(@RequestBody Event e){
		eventDAO.createevent(e);
		return new ResponseEntity<Event>(e, HttpStatus.OK);
		
	}

}
