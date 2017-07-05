package com.niit.social.chatbe.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.type.SerializableType;

@Table(name="c_job")
@Entity

public class Job  {
	
	@Id
	private String j_id;
	private String j_title;
	private String j_desc;
	private String j_exp;
	private String j_loctn;
	
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
	public String getJ_exp() {
		return j_exp;
	}
	public void setJ_exp(String j_exp) {
		this.j_exp = j_exp;
	}
	

}
