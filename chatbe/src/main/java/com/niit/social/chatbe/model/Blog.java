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
	private String b_title;
	private String b_desc;


	
	@Transient
	@Column(name=" Date_time")
	private Date dateTime;
	private String reason;
	private char status;
	
	
	
		
	

}
