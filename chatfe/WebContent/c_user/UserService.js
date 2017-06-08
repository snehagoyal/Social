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
        			   return $http.post(BASE_URL+'ListAllUsersNotFriends')
        			   .then(
        					   function( response){
        						   return response.data;
        					   },
        					   null
        					   );
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
        		
        		
        		
        		
        	}}
        	])
        		

           
           
           
           
