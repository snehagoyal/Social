/**
 * 
 */
'use strict';
app.controller('JobController',[
                                 '$scope',
                                 'JobService',
                                 '$location',
                                 '$rootScope',
                                 '$http',
                                 
                                function($scope, JobService, $location, $rootScope,$http){
                                	 console.log("start the job controller");
                                     var self= this;
                                     self.job = {
                                    		 j_id :'',
                                    		 j_title :'',
                                    			 j_desc :'',
                                    			 j_exp :'',
                                    			 j_loctn :''
                                    				 }
                                     self.jobs= [];
                                     self.addjob = function(job){
                                    	 console.log("add job ");
                                    	 JobService.addjob(job)
                                    	 .then( function(d){
                                    		 self.job=d;
                                    	 },
                                    	 function(errResponse){
                                    		 console.error("error occured during adding a job");
                                    		 
                                    	 }
                                    	 ),
                                    	  self.submit = function() 
                           				{
                           					console.log('Saving job', self.job);
                           					self.addjob(self.job);
                           				};
                           			
                                     }
                                     }	 ])