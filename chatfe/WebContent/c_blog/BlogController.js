/**
 * 
 */
'use strict';
app.controller('BlogController',[
                                 '$scope',
                                 'BlogService',
                                 '$location',
                                 '$rootScope',
                                 '$http',
                                 
                                function($scope, BlogService, $location, $rootScope,$http){
                                	 console.log("start the blog controller");
                                     var self= this;
                                     self.blog = {
                                    b_id:'',
                                    b_title:'',
                                    b_desc:''
                                     
                                     };
                                     
                                     self.blogs = [];
                                     
                                     
                                  	self.createBlog = function(blog){
                                 		console.log("Create a new blog");
                                 		BlogService.createBlog(blog)
                                 			.then(function(d){
                                 				self.blog = d;
                                 			},
                  
                                 					function(errResponse){
                                 				console.error('(console.error)Error While Creating New blog.');
                                 			});
                                 	};

                                     self.submit = function() 
                         				{
                         					console.log('Saving new blog', self.blog);
                         					self.createBlog(self.blog);
                         				};
                         				//this.reset();
                         			
                         			
                                     
                         		
                         				//$scope.myForm.$setPristine(); // reset Form
        						
                         			                         			


                         			

                                 	
                                 	
                                 	        
                                			
                                 	
                                 }])