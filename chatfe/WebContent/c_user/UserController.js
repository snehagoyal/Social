  /**
 * 
 */
'use strict';
app.controller('UserController',['$scope',
                                 'UserService',
                                 '$location',
                                 '$cookieStore',
                                 '$rootScope',
                                 '$http',
                                 
                                 
                                function($scope, UserService, $location,$cookieStore, $rootScope,$http){
                                	 console.log("start the user controller");
                                     var self= this;
                                     self.user = {
                                    		 u_id:'',
                                    	u_name: '' ,
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
                                 	self.authenticate = function(user){
                                		console.log("In Authenticate...");
                                		UserService.authenticate(user)
                                			.then(function(d){
                                				self.user = d;
                                				/*console.log("Get Data from Service"+self.user);
                                				if($rootScope.currentUser){
                                					console.log("Valid Credentials. Navigating to home Page.")
                                					$location.path('/register');
                                				}else{
                                					console.log("Invalid Credentials. Staying On the Same Page.")
                                				}*/
                                				
                                				console.log("--->user.errorCode :- " + self.user.errorCode)
                                				if(self.user.errorCode == "404"){
                                					self.user.emailId = "";
                                					self.user.password = "";
                                				}else{
                                					console.log("Valid Credentials. Navigating to Home Page.")
                           			   				$rootScope.currentUser = {
                       			   						u_name : self.user.u_name,
                       			   					
                       			   						u_id : self.user.u_id,
                       			   						u_userRole : self.user.u_userRole
                       			   				};
                                				$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser;
                                					$cookieStore.put('currentUser',$rootScope.currentUser);
                                					$location.path('/');
                                				}
                                			},
                                			function(errResponse){
                                				console.error('Error While Authenticate Users.');
                                			});
                                	};
                             /*    	self.logout = function(){
                                		$rootScope.currentUser = {};
                                		$cookieStore.put('currentUser');
                                		$cookieStore.remove('currentUser');
                                		console.log("Clear Cookies :- "+ $cookieStore.get('currentUser'));
                                		UserService.logout()
                                			.then(function(d){
                                				console.error('Logout And Navigate IndexPage.');
                                				$location.path('/');
                                				console.error('Not Logout And Navigate IndexPage.');
                                			},
                                			function(errResponse){
                                            	console.error('Error While Logout Users.');
                                            });
                                	
                                	}*/
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