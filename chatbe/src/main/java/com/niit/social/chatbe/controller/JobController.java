package com.niit.social.chatbe.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.niit.social.chatbe.dao.JobDAO;
import com.niit.social.chatbe.model.AppliedJobs;
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
	//http://localhost:8080/CollabrationBackEnd/JobPages/JobList/
		@RequestMapping(value = "/JobPages/JobList/", method = RequestMethod.GET)
		public ResponseEntity<List<Job>> listAllJob(){
			log.debug("**********Starting of Method listAllJobOpportunitiess**********");
			List<Job> jobList = jobDAO.getAllJobList();
			if(jobList.isEmpty()){
				return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
			}else{
				log.debug("**********Size found :- "+jobList.size()+"**********");
				log.debug("**********Ending of Method listAllJobOpportunitiess**********");
				return new ResponseEntity<List<Job>>(jobList,HttpStatus.OK);
			}
		}
			
		//http://localhost:8080/CollabrationBackEnd/JobPages/CreateJob/
		@RequestMapping(value = "/JobPages/CreateJob/", method = RequestMethod.POST)
		public ResponseEntity<Job> createJobOpportunities(@RequestBody Job job){
			log.debug("**********Starting of Method createUser**********");
			if(jobDAO.getJobById(job.getJ_id()) == null){
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            Date date = new Date();
	            String jobPostedOn = (dateFormat.format(date));
	            job.setPostedOn(jobPostedOn);
	            job.setJ_status('1');
				jobDAO.saveJob(job);
				log.debug("**********New JobOpportunities Created Successfully**********");
				job = new Job();
				job.setErrorMessage("New Job Posted Successfully....!!!");
				return new ResponseEntity<Job>(job , HttpStatus.OK);
			}
			log.debug("**********JobOpportunities already Exist with ID :-"+job.getJ_id()+" **********");
			job.setErrorMessage("JobOpportunities Already Exist With ID:-"+job.getJ_id());
			return new ResponseEntity<Job>(job , HttpStatus.OK);
		}
		
		//http://localhost:8080/CollabrationBackEnd/JobPages/UpdateJob/{id}
		@RequestMapping(value = "/JobPages/UpdateJob/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Job> updateJob(@PathVariable("j_id") String j_id,@RequestBody Job job){
			log.debug("**********Starting of Method updateJobOpportunities**********" + j_id);
			if(jobDAO.getJobById(job.getJ_id()) == null){
				log.debug("**********JobOpportunities Does not Exist with this ID :-"+j_id+"**********");
				job = new Job();
				job.setErrorCode("404");
				job.setErrorMessage("JobOpportunities Does not Exist with this ID :-"+j_id);
				return new ResponseEntity<Job>(job , HttpStatus.NOT_FOUND);
			}else{
				job.setJ_id(j_id);
				jobDAO.updateJob(job);
				log.debug("**********JobOpportunities Updated Successfully WITH ID:- "+j_id+"**********");
				return new ResponseEntity<Job>(job , HttpStatus.OK);
			}
		}
		
		//http://localhost:8080/CollabrationBackEnd/JobPages/RemoveJob/{id}
		@RequestMapping(value = "/JobPages/RemoveJob/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Job> removeJob(@PathVariable("id") String j_id){
			log.debug("**********Starting of Method removeUser**********");
			Job job = jobDAO.getJobById(j_id);
			if(job == null){
				log.debug("**********JobOpportunities Does not Exist with this ID :-"+j_id+"**********");
				job = new Job();
				job.setErrorCode("404");
				job.setErrorMessage("JobOpportunities Does not Exist with this ID :-"+ j_id);
				return new ResponseEntity<Job>(job , HttpStatus.NOT_FOUND);
			}else{
				jobDAO.removeJob(j_id);
				log.debug("**********JobOpportunities Deleted Successfully WITH ID:- "+j_id+"**********");
				return new ResponseEntity<Job>(job , HttpStatus.OK);
			}
		}
		
		//http://localhost:8080/CollabrationBackEnd/JobPages/ApplyForJob/{id}
			@RequestMapping(value = "/JobPages/ApplyForJob/{id}", method = RequestMethod.GET)
			public ResponseEntity<AppliedJobs> applyforjob(@PathVariable("id") String j_id,HttpSession session){
				log.debug("**********Starting of Method applyforjob**********");
				User loggedInUser = (User) session.getAttribute("loggedInUser");
				AppliedJobs job = new AppliedJobs();
				job.setJ_id(j_id);
				job.setU_id(loggedInUser.getU_id());
				job.setJ_status('1');
				jobDAO.applyJob(job);
				return new ResponseEntity<AppliedJobs>(job , HttpStatus.OK);
			}
		
			//http://localhost:8080/CollabrationBackEnd/JobPages/MyJobList/
			@RequestMapping(value = "/JobPages/MyJobList/", method = RequestMethod.GET)
			public ResponseEntity<List<AppliedJobs>> myJobList(HttpSession session){
				try {
					log.debug("**********Starting of Method listAllJobOpportunitiess**********");
					User loggedInUser = (User) session.getAttribute("loggedInUser");
					List<AppliedJobs> jobList = jobDAO.getMyAppliedJobs(loggedInUser.getU_id());
					if(jobList.isEmpty()  ){
						return new ResponseEntity<List<AppliedJobs>>(jobList,HttpStatus.NO_CONTENT);
					}else{
						log.debug("**********Size found :- "+jobList.size()+"**********");
						log.debug("**********Ending of Method listAllJobOpportunitiess**********");
						return new ResponseEntity<List<AppliedJobs>>(jobList,HttpStatus.OK);
					}
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<List<AppliedJobs>>(HttpStatus.NO_CONTENT);
				}
			}
	
	}
