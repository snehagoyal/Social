/**
 * 
 */
'use strict';

app.controller('AdminController',[
	'$scope',
	'AdminService',
	'BlogService',
	'UserService',
	'$location',
	'$rootScope',
    '$http',
	function($scope,AdminService,BlogService,UserService,$location,$rootScope,$http){
    	console.log("Admin Controller")
    	var self = this; 
    	self.users = [];
    	self.pendingUsers = [];
    	self.pendingBlogs = [];
    	
    	self.fetchAllUsers = function(){
    		console.log("FetchAllUsers");
    		UserService.fetchAllUsers()
    			.then(function(d){
    				self.users = d;
    			},function(errResponse){
    				console.error('Error while fetching Users');
    			});
    	};
    	
  	self.fetchAllPendingBlogs = function()
    	{
    		UserService.fetchAllPendingBlogs()
    			.then(
    					function(d){
    						self.pendingBlogs = d;
    					},
    					function(errResponse){
    						console.error('Error While Fatching Pending Blogs.');
    			});
    	};
    	
    	self.fetchAllPendingUsers = function(){
    		console.log("FetchAll Pending Users List.");
    		UserService.fetchAllPendingUsers()
    			.then(function(d){
    				self.pendingUsers = d;
    				self.nop = d.length / $rootScope.pageSize;// doudts
    			},function(errResponse){
    				console.error('Error while fetching Users');
    			});
    	};
    	
    	self.fetchAllUsers();
    	self.fetchAllPendingUsers();
    	self.fetchAllPendingBlogs();
    	
self.SelectedapproveBlog = approveBlog
    	
    	function approveBlog(blogId,status){
    		console.log("->->approveBlog Blog with ID :-"+blogId+" "+status);
    		AdminService.approveBlog(blogId,status)
    			.then(
    					self.fetchAllPendingBlogs,
    					function(errResponse){
    						console.error('Error While approve Blogs.');
    					});
    	};
    	
self.SelectedapproveUser = approveUser
    	
    	function approveUser(userId,status){
    		console.log("->->approveUser User with ID :-"+userId+" "+status);
    		AdminService.approveUser(userId,status)
    			.then(
    					self.fetchAllPendingUsers,
    					function(errResponse){
    						console.error('Error While approve Users.');
    					});
    	};

}]);
