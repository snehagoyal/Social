/**
 * 
 */
'use strict';
app.factory('BlogService',[
           '$http',
           '$q',
           '$rootScope',
           function($http,$q,$rootScope){
        	   console.log("Blog Service");
        	   var BASE_URL='http://localhost:8169/chatbe'
        		   return{
        		   
        	/*	   fetchAllBlogs: function(){
        			   console.log("fetch all users");
        			   return $http.post(BASE_URL+'ListAllUsersNotFriends')
        			   .then(
        					   function( response){
        						   return response.data;
        					   },
        					   null
        					   );
        			 },*/
        			 
        	  
        	   createBlog: function(blog){
        		   console.log(" blog");
        		   return $http.post(BASE_URL+'/enterBlog/',blog)
        				          		   
        		   .then(
        				   function (response){
        					   return response.data;
        					   
        				   },
        				   function(errResponse){
			   					console.error('Error While Creating blog');
			   					return $q.reject(errResponse);
			   				});
		  
        		
        	   
        	   
        	   

        		},
        		
        		
        		
        		
        	}}
        	])
        		

           
           
           
           
