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
        			   return $http.get(BASE_URL+'/ListAllUsers/')
        			   .then(
        					   function( response){
        						   return response.data;
        					   },
        					   null
        					   );
        			 },
        			 
        			 authenticate : function(user){
          			   console.log("authemticate in service controller");
          			   return $http.post(BASE_URL+'/Authentication/',user)
          			   		.then(function(response){
      			   				return response.data;
              			   	},
              			   	function(errResponse){
              			   		console.error('Error While Authentication User.');
              			   		return $q.reject(errResponse);
              			   	});

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
        	   
        					  
           	fetchAllPendingUsers:function(){
           		console.log("user not approved");
           		return $http.get(BASE_URL+'/PendingUsers/')
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
        	   
            logout : function(){
     		   return $http.get(BASE_URL+'/Logout')
     		   	.then(function(response){
     		   				return response.data;
     		   	},
     		   	function(errResponse){
     		   		console.error('Error While Logging Out');
     		   		return $q.reject(errResponse);
     		   	});
     	   },
        		
        	}}
        	])
        		

           
           
           
           
