/**
 * 
 */
'use strict';
app.controller('EventController',[
                                 '$scope',
                                 'EventService',
                                 '$location',
                                 '$rootScope',
                                 '$http',
                                 
                                function($scope, EventService, $location, $rootScope,$http){
                                	 console.log("start the event controller");
                                     var self= this;
                                     self.event = {
                                             e_id:'',
                                             e_title:'',
                                             e_desc:''
                                              
                                              };
                                              
                                              self.events = [];
                                                   
                                  	self.addEvent = function(event){
                                 		console.log("Create a new event");
                                 		EventService.addEvent(event)
                                 			.then(function(d){
                                 				self.event = d;
                                 			},
                  
                                 					function(errResponse){
                                 				console.error('(console.error)Error While Creating New event.');
                                 			});
                                 	};
                                 	  self.submit = function() 
                       				{
                       					console.log('Saving new event', self.event);
                       					self.addEvent(self.event);
                       				};
                       			

                                   	//this.reset();
                         			
                         			
                                     
                         		
                         				//$scope.myForm.$setPristine(); // reset Form
        						
                         			                         			


                         			

                                 	
                                 	
                                 	        
                                			
                                 	
                                 }])