/**
 * 
 */
app.controller('UserController',[
                                 '$scope',
                                 'UserService',
                                 '$location',
                                 '$rootscope',
                                 '$http',
                                 '$cookieStore',
                                function($scope, UserService, $location, $rootscope, $cookieStore, $http){
                                	 console.log("start the user controller");
                                     var self= this;
                                     self.user = {
                                    		 id:'',
                                    	firstname: '' ,
                                    	lastname: '',
                                     	email: '' ,
                                     	address: '',
                                     	password: '',
                                     	errorCode:'',
                                     	errorMessage:'',
                                     	contactNo:''
                                     	 }
                                     
                                     self.users = [];
                                     
                                    /* self.fetchAllUsers = function(){
                                  		console.log("Fetch user");
                                  		UserService.fetchAllUsers()
                                  			.then(function(d){
                                  				self.users = d;
                                  			},
                                  			function(errResponse){
                                  				console.error('Error occured during  fetching Users');
                                  			});
                                  	};
                                      
                                  	self.fetchAllUsers();
                                 	*/
                                 	self.createUser = function(user){
                                 		console.log("Create a new User");
                                 		UserService.createUser(user)
                                 			.then(function(d){
                                 				self.user = d;
                                 			},
                  
                                 					function(errResponse){
                                 				console.error('Error While Creating New User.');
                                 			});
                                 	};

                                     self.submit = function() {
                         				{
                         					console.log('Saving new user', self.user);
                         					self.createUser(self.user);
                         				}
                         				this.reset();
                         			};
                         			
                         			this.reset=function(){ 
                         				self.user = {
                                   		 id:'',
                                     	firstname: '' ,
                                     	lastname: '',
                                      	email: '' ,
                                      	address: '',
                                      	password: '',
                                      	errorCode:'',
                                      	errorMessage:'',
                                      	contactNo:''
                                      	 }
                                     
                         		
                         				$scope.myForm.$setPristine(); // reset Form
        						
                         			};
                         			


                         			

                                 	
                                 	
                                 	        
                                			
                                 	
                                 }])