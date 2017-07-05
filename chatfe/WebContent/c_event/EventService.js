/**
 * 
 */
'use strict';
app.factory('EventService'[
                           '$http',
                           '$q',
                           '$rootScope',
                           
                           function($http,$q,$rootScope){
                        	   
                        	   console.log("start the event");
                        	   var BASE_URL='http://localhost:8169/chatbe';
                           	return{
                           		addevent :function(event){
                           		console.log("add an event");
                           		return $http.post(BASE_URL+'/AnEvent/')
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