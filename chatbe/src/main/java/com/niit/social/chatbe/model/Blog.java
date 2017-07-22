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
private String u_id;
public String getU_id() {
	return u_id;
}
public void setU_id(String u_id) {
	this.u_id = u_id;
}
//A= approve, p=pending , r=reject
private char b_approvestatus;
private String b_ModifiedAt;
private int b_dislike;
private String b_CreatedAt;
private int b_like;
//private String u_name;


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
public char getB_status() {
	return b_status;
}
public void setB_status(char b_status) {
	this.b_status = b_status;
}
	private String b_title;
	private String b_desc;


	
	public char getB_approvestatus() {
		return b_approvestatus;
	}
	public void setB_approvestatus(char b_approvestatus) {
		this.b_approvestatus = b_approvestatus;
	}
	public String getB_ModifiedAt() {
		return b_ModifiedAt;
	}
	public void setB_ModifiedAt(String b_ModifiedAt) {
		this.b_ModifiedAt = b_ModifiedAt;
	}
	public int getB_dislike() {
		return b_dislike;
	}
	public void setB_dislike(int b_dislike) {
		this.b_dislike = b_dislike;
	}
	public String getB_CreatedAt() {
		return b_CreatedAt;
	}
	public void setB_CreatedAt(String b_CreatedAt) {
		this.b_CreatedAt = b_CreatedAt;
	}
	public int getB_like() {
		return b_like;
	}
	public void setB_like(int b_like) {
		this.b_like = b_like;
	}
	
private char b_status;
	
	
	
		
	

}
