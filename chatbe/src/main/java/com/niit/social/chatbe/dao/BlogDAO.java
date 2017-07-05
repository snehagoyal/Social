package com.niit.social.chatbe.dao;

import com.niit.social.chatbe.model.Blog;

public interface BlogDAO {
	public boolean addBlog(Blog b);

	public Blog getBlogById(String b_id, String b_status);



	public boolean approveBlog(String b_id, String b_status);

/*	public boolean bloglikes(String b_id);

	public boolean blogdislikes(String b_id);
*/


}
