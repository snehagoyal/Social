package com.niit.social.chatbe.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="c_appliedJobs")

public class AppliedJobs {
	
	private String id;
	
	private String j_id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJ_id() {
		return j_id;
	}

	public void setJ_id(String j_id) {
		this.j_id = j_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public char getJ_status() {
		return j_status;
	}

	public void setJ_status(char c) {
		this.j_status = c;
	}

	private String u_id;
	
	private char j_status;
}
