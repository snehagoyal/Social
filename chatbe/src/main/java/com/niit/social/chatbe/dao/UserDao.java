package com.niit.social.chatbe.dao;

import java.util.List;

import com.niit.social.chatbe.model.User;

public interface UserDao {
	public boolean addUser(User u);

	public User isValidUser(String u_email, String u_password);
	
	public List<User>getAllUsers();
	public List<User>getForApproval();
	public boolean approveUser(String id, String status);
	public boolean setOnLine(String id);

	public User userGetById(String u_id);

	public void setOffLine(String u_name);
	public boolean deleteUser(String u_name);
	public boolean updateUser(User user);
}
