package com.niit.social.chatbe.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.type.SerializableType;

@Table(name="c_job")
@Entity

public class Job extends basedomain  {
	
	@Id
	private String j_id;
	private String j_title;
	private String j_desc;
	private String j_Role;
	private String j_loctn;
	private char j_status;
	private String contact;
	public String getJ_Role() {
		return j_Role;
	}
	public void setJ_Role(String j_Role) {
		this.j_Role = j_Role;
	}
	public char getJ_status() {
		return j_status;
	}
	public void setJ_status(char j_status) {
		this.j_status = j_status;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String postedOn;
	private String email;
	
	
	public String getJ_loctn() {
		return j_loctn;
	}
	public void setJ_loctn(String j_loctn) {
		this.j_loctn = j_loctn;
	}
	public String getJ_id() {
		return j_id;
	}
	public void setJ_id(String j_id) {
		this.j_id = j_id;
	}
	public String getJ_title() {
		return j_title;
	}
	public void setJ_title(String j_title) {
		this.j_title = j_title;
	}
	public String getJ_desc() {
		return j_desc;
	}
	public void setJ_desc(String j_desc) {
		this.j_desc = j_desc;
	}
	

}
