/**
 * 
 */
'use strict';

app.factory('AdminService',[
           '$http',
           '$q',
           '$rootScope',
           function($http,$q,$rootScope){
        	   console.log("Admin Service...");
        	   
        	   var BASE_URL = 'http://localhost:8169/chatbe'
        	   return{

        		   SelectedapproveBlog : function(b_id,b_approvestatus){
        			   return $http.get(BASE_URL+'/ApproveBlog/'+b_id+'/'+b_approvestatus)
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
        		   
        		   SelectedapproveUser: function(u_id, u_approvestatus){
        	    		console.log("in Admin Service Approve uSer");
        			   return $http.get(BASE_URL+'/ApproveUser/'+u_id+'/'+u_approvestatus)
        			   		.then(
        			   				function(response){
        			   					return response.data;
        			   				},
        			   				function(errResponse){
        			   					console.error('Error While Fatching Pending BlogList.');
        			   					return $q.reject(errResponse);
        			   				}
        			   		);
        			   
        		   }
         }
}]);	   
        	