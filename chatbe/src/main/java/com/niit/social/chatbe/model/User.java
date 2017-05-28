package com.niit.social.chatbe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int u_id;
	
	@NotBlank(message= "Enter your firstname please ")
	private String u_firstname;
	
	@NotBlank(message="please enter your last name")
	private String u_lastname;
	@NotBlank(message="please enter your valid password")
	@Length(min=5, message= "password should have minimum 5 characters ")
	private String password;
	
	@NotBlank(message="please enter your contact no.")
	@Pattern(regexp="(^$|[0-9]{10})",message="Enter a 10 digit valid phone no")
	private String u_contact;
	
	
	@NotBlank(message="please enter your email")
	@Email(message= "please enter an email")
	private String u_email;
	private String u_address;
	private char u_accountstatus;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_firstname() {
		return u_firstname;
	}
	public void setU_firstname(String u_firstname) {
		this.u_firstname = u_firstname;
	}
	public String getU_lastname() {
		return u_lastname;
	}
	public void setU_lastname(String u_lastname) {
		this.u_lastname = u_lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getU_contact() {
		return u_contact;
	}
	public void setU_contact(String u_contact) {
		this.u_contact = u_contact;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public char getU_accountstatus() {
		return u_accountstatus;
	}
	public void setU_accountstatus(char u_accountstatus) {
		this.u_accountstatus = u_accountstatus;
	}
	public char getU_approvestatus() {
		return u_approvestatus;
	}
	public void setU_approvestatus(char u_approvestatus) {
		this.u_approvestatus = u_approvestatus;
	}
	public char getIs_online() {
		return is_online;
	}
	public void setIs_online(char is_online) {
		this.is_online = is_online;
	}
	public String getU_userRole() {
		return u_userRole;
	}
	public void setU_userRole(String u_userRole) {
		this.u_userRole = u_userRole;
	}
	private char u_approvestatus;
	private char is_online;
	private String u_userRole;
	
}