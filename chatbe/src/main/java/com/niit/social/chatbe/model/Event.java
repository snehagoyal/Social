package com.niit.social.chatbe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="c_event")
@Entity
public class Event {
	
	@Id
	private String e_id;
	private String e_title;
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getE_title() {
		return e_title;
	}
	public void setE_title(String e_title) {
		this.e_title = e_title;
	}
	public String getE_desc() {
		return e_desc;
	}
	public void setE_desc(String e_desc) {
		this.e_desc = e_desc;
	}
	private String e_desc;
	
	
	

}
