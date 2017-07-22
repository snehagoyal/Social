package com.niit.social.chatbe.dao;

import java.util.List;

import com.niit.social.chatbe.model.Blog;
import com.niit.social.chatbe.model.Comment;

public interface BlogDAO {
	public boolean addBlog(Blog b);

	public Blog getBlogById(String b_id, String b_status);



	public boolean approveBlog(String b_id, String b_status);

	public List<Blog> blogListForApproval();

	//public List<Blog> blogListByUserId(String u_id);

	//public boolean blogdislikes(String b_id);

	//public boolean bloglikes(String b_id);

	//public boolean updateBlog(Blog blog);

	//public boolean removeBlog(String blogId);

	

	public List<Blog> getAllBlogs();

//	public boolean addComment(Comment com);
	// public List<Comment> commentsById(String b_id);

//	public List<Comment> getAllComments();




}
