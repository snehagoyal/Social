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
                                    		
                                    		 j_title :'',
                                    			 j_desc :'',
                                    			 j_Role :'',
                                    			 j_loctn :'',
                                    			 email:'',
                                    			 contact:''
                                    				 }
                                     self.jobs= [];
                                     self.fetchAllJobs = function(){
                                 		JobService.fetchAllJobs()
                                 			.then(function(d){
                                 						self.jobs = d;
                                 				},function(errResponse){
                                 					console.error('Error While Fetching Jobs.');
                                 			});
                                 	};
                                 	
                                 	self.fetchMyJobs = function(){
                                 		JobService.fetchMyJobs()
                                 			.then(function(d){
                                 						self.myjobs = d;
                                 						console.log('Get list of myjobs'+self.myjobs.length)
                                 				},function(errResponse){
                                 					console.error('Error While Fatching MyJobs.');
                                 			});
                                 	};
                                 	    	    	
                                 	self.createJob = function(job){
                                 		JobService.createJob(job)
                                 			.then(
                                 					function(d){
                                 				self.job = d;
                                 			},
                                 					function(errResponse){
                                 					console.error('Error While Creating Job.');
                                 			});
                                 	};

                                 	self.ApplyForJob = applyForJob
                                 	
                                 	function applyForJob(j_id){
                                 		console.log("->->applyForJob with J_iD :-"+j_id);
                                 		JobService.applyForJob(j_id)
                                 			.then(
                                 					self.fetchAllJobs,
                                 					function(errResponse){
                                 						console.error('Error While applyForJob .');
                                 					});
                                 	};
                                 	//calling the Method
                                 	self.fetchAllJobs();
                                 	self.fetchMyJobs();
                                 	
                                 	self.submit = function(){
                                 		{
                                 			console.log('Post a New Job',self.job);
                                 			self.createJob(self.job);           			
                                 		}
                                 	//	self.reset();
                                 	}
                                 	
                                 /*	self.reset = function(){
                                 		self.job  = {
                                 				jobId : '',
                                     			jobTitle : '',
                                     			jobDescription : '',
                                     			jobLocation : '',
                                     			contact : '',
                                     			email : '',
                                     			jobStatus : '',
                                     			errorCode : '',
                                     			errorMessage : ''
                                 		};
                                 		$scope.form.$setPristine();
                                 	}*/
                                    }
                                     	 ])