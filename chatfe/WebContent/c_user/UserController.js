  /**
 * 
 */
'use strict';
app.controller('UserController',[
                                 '$scope',
                                 'UserService',
                                 '$location',
                                 '$rootScope',
                                 '$http',
                                 
                                function($scope, UserService, $location, $rootScope,$http){
                                	 console.log("start the user controller");
                                     var self= this;
                                     self.user = {
                                    		 u_id:'',
                                    	u_firstname: '' ,
                                    	u_lastname: '',
                                     	u_email: '' ,
                                     	u_address: '',
                                     	u_userRole:'',
                                     	u_contact:'',
                                     	u_accountstatus:'',
                                     	u_approvestatus:'',
                                     	is_online:''
                                     	 }
                                     
                                     self.users = [];
                                     
                                  /*   self.fetchAllUsers = function(){
                                  		console.log("Fetch user");
                                  		UserService.fetchAllUsers()
                                  			.then(function(d){
                                  				self.users = d;
                                  			},
                                  			function(errResponse){
                                  				console.error('Error occured during  fetching Users');
                                  			});
                                  	};
                                      
                                  	self.fetchAllUsers();*/
                                 	
                                 	self.createUser = function(user){
                                 		console.log("Create a new User");
                                 		UserService.createUser(user)
                                 			.then(function(d){
                                 				self.user = d;
                                 			},
                  
                                 					function(errResponse){
                                 				console.error('(console.error)Error While Creating New User.');
                                 			});
                                 	};
                                 	self.authenticate= function (user){
                                 		console.log("login started");
                                 		UserService.authenticate(user)
                                 	.then (function(d)
                                 		{
                                 		self.user= d;
                                 			},
                                 			function(errResponse){
                                 				console.error("error doing login user");
                                 			}
                                 	)
                                 	}
                                 	 self.login = function() 
                      				{
                      					console.log('login  user', self.user);
                      					self.authenticate(self.user);
                      				};
                      			

                                     self.submit = function() 
                         				{
                         					console.log('Saving new user', self.user);
                         					self.createUser(self.user);
                         				};
                         				//this.reset();
                         			
                         			
                                     
                         		
                         				//$scope.myForm.$setPristine(); // reset Form
        						 }])