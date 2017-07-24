package com.niit.social.chatbe.dao;

import java.util.List;

import com.niit.social.chatbe.model.AppliedJobs;
import com.niit.social.chatbe.model.Job;

public interface JobDAO {

public boolean saveJob(Job job);
	
	public boolean updateJob(Job job);
	
	public boolean removeJob(String j_id);
	
	public List<Job> getAllJobList();
	
	public boolean applyJob(AppliedJobs job);
	
	public Job getJobById(String j_id);
	
	public List<AppliedJobs> getMyAppliedJobs(String u_id);

}
