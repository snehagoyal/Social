package com.niit.social.chatbe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="c_comment")
public class comment {
	
	@Id
	private String c_id;
	private String c_com;
	
	private String b_id;
	private String c_date;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_com() {
		return c_com;
	}
	public void setC_com(String c_com) {
		this.c_com = c_com;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	

	

}
