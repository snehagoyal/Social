
/**
 * 
 */
'use strict';
app.factory('JobService',[
                          '$http',
                          '$q',
                          '$rootScope',
                          function($http,$q,$rootScope){

                       	   console.log("Job Service");
                       	   var BASE_URL='http://localhost:8169/chatbe';
                        	return{
                       	   addjob: function(job){
                        		console.log("job job job");
                        		  return $http.post(BASE_URL+'/Addjob/')
                   			   .then(
                   					   function( response){
                   						   return response.data;
                   					   },
                   					   function(errresponse){
                   						   console.log("error while job");
                   						   return$q.reject(errResponse);
                   					   }
                   					   );
                   			 },
                   			
                        	}  
                          
                          }
                          ])
	
