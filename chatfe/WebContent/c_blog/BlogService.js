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
        		 
        		   fetchAllPendingBlogs: function(){
        			   return $http.get(BASE_URL+'/PendingBlogList/')
        			   		.then(
        			   				
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fatching Pending BlogList.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },
        		   
        		/*   getMyBlogList: function(){
        			   return $http.post(BASE_URL+'/getMyBlogList/')
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fatching BlogList.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },
        		   
        		   fetchAllComments: function(){
        			   return $http.get(BASE_URL+'/BlogPages/getComments/')
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fatching Comments list.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },
           		   
        		   commentAdd: function(c_com,b_id){
        			   return $http.get(BASE_URL+'/BlogPages/Comments/'+c_com+'/'+b_id)
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While commenting');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },  */
        		   fetchAllBlogs: function(){
        			   return $http.get(BASE_URL+'/BlogList/')
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fetching BlogList.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   },
        			 
        	  
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
        		
        		
        	/*	getBlog: function(b_id,b_status){
     			   return $http.get(BASE_URL+'/GetBlogById/'+b_id+'/'+b_status)
     			   		.then(
     			   				function(response){
     			   					return response.data;
     			   				},
     			   				function(errResponse){
     			   					console.error('Error While Getting Blog By b_id :-'+b_id);
     			   					return $q.reject(errResponse);
     			   				}
     			   		);
     		   },
     	   	*/
        		
        	}}
        	])
        		

           
           
           
           
