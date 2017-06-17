/**
 * 
 */
'use strict';
app.factory('UserService',[
           '$http',
           '$q',
           '$rootScope',
           function($http,$q,$rootScope){
        	   console.log("User Service");
        	   var BASE_URL='http://localhost:8169/chatbe'
        		   return{
        		   
        		   fetchAllUsers: function(){
        			   console.log("fetch all users");
        			   return $http.post(BASE_URL+'/ListAllUsers/')
        			   .then(
        					   function( response){
        						   return response.data;
        					   },
        					   null
        					   );
        			 },
        			 
        			 authenticate: function(user){
        				 console.log("user logged in");
        				 return $http.post(BASE_URL+'/userlogin/',user)
        				 .then(
        						 function(response){
        							 return response.data;
        						 },
        						 function(errResponse){
        							 console.error("Error while logged in");
        							 return $q.reject(errResponse);
        						 }
        						 )
        				 
        			 },
        			 
        	  
        	   createUser: function(user){
        		   console.log("register");
        		   return $http.post(BASE_URL+'/enterUser/',user)
        				          		   
        		   .then(
        				   function (response){
        					   return response.data;
        					   
        				   },
        				   function(errResponse){
			   					console.error('Error While Creating User');
			   					return $q.reject(errResponse);
			   				});
        	   },
        	   
        		   fetchAllPendingBlogs:function(){
        			   console.log("Blogs not approved");
        			   return $http.post(BASE_URL+'/PendingBlogs/') 
        			   .then(
        					   function(response){
        						   return response.data;
        					   },
        					   function(errResponse){
   			   					console.error('Error While Creating Blog');
   			   					return $q.reject(errResponse);
   			   				});
           	   },
        					  
           	fetchAllPendingUsers:function(){
           		console.log("user not approved");
           		return $http.post(BASE_URL+'/PendingUsers/')
           		.then(
           				function(response){
           					return response.data;
           					
           				},
           				function(errResponse){
           					console.error('Errorwhile creating user ');
           					return $q.reject(errResponse);
           					
           				}
           				)
           	}	,   
        	   
           	
        		
        	}}
        	])
        		

           
           
           
           
