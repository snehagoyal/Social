package com.niit.social.chatbe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.br.CNPJ;

@Table(name="c_blog")
@Entity
public class Blog extends basedomain {

@Id
	private String b_id;
	public String getB_id() {
	return b_id;
}
public void setB_id(String b_id) {
	this.b_id = b_id;
}
public String getB_title() {
	return b_title;
}
public void setB_title(String b_title) {
	this.b_title = b_title;
}
public String getB_desc() {
	return b_desc;
}
public void setB_desc(String b_desc) {
	this.b_desc = b_desc;
}
/*public Date getDateTime() {
	return dateTime;
}
public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
}
public String getB_reason() {
	return b_reason;
}
public void setB_reason(String b_reason) {
	this.b_reason = b_reason;
}
public char getB_status() {
	return b_status;
}
public void setB_status(char b_status) {
	this.b_status = b_status;
}*/
	private String b_title;
	private String b_desc;


	
//	@Transient
//	@Column(name=" Date_time")
//	private Date dateTime;
//	private String b_reason;
	//private char b_status;
	
	
	
		
	

}
