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
                                	 console.log("start the eventcontroller");
                                     var self= this;
                                     self.event = {
                                    e_id:'',
                                    e_title:'',
                                    e_desc:''
                                     
                                     };
                                     
                                     self.events = [];
                                     
                                     self.addevent = function(event){
                                    	 console.log("Add event");
                                    	 EventService.addevent(event)
                                    	 .then(function(d){
                                    		 self.event= d;
                                    	 },
                                    	 function(errResponse){
                                    		console.error("error doing adding event"); 
                                    	 }
                                    	 )
                                     },
                                     self.submit = function(){
                                    	 console.log("saving event",self.event);
                                    	 self.addevent(self.event);
                                     }
}])