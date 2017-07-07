/**
 * 
 */
'use strict';
app.factory('EventService',[
           '$http',
           '$q',
           '$rootScope',
           function($http,$q,$rootScope){
        	   console.log("Event Service");
        	   var BASE_URL='http://localhost:8169/chatbe'
        		   return{
        		 
        		 	 
        	  
        	   addEvent: function(event){
        		   console.log(" event service");
        		   return $http.post(BASE_URL+'/AnEvent/',event)
        				          		   
        		   .then(
        				   function (response){
        					   return response.data;
        					   
        				   },
        				   function(errResponse){
			   					console.error('Error While Creating event');
			   					return $q.reject(errResponse);
			   				});
		  
        		
        	   
        	   
        	   

        		},
        		
        		
        		
        		
        	}}
        	])
        		

           
           
           
           
