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
                                     self.com={
                                         	c_com : '',	
                                                 };
                                         
                                     
                                     self.blogs = [];
                              /*       self.comments=[];
                                     self.AddComment = commentAdd
                                 	
                                	function commentAdd(c_com,b_id){
                                 		console.log("->->Add comment  with :-"+b_id+" "+c_com);
                                 		BlogService.commentAdd(c_com,b_id)
                                 			.then(
                                 					self.fetchAllComments,
                                 					function(errResponse){
                                 						console.error('Error While Commenting.');
                                 					});
                                 	};     
                                     */
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
                                /* 	self.fetchAllComments = function(){
                                    	console.log("fetching comments")
                                		BlogService.fetchAllComments()
                                			.then(function(d){
                                						self.comments = d;
                                				},function(errResponse){
                                					console.error('Error While Fatching Comments.');
                                			});
                                	};
                                    
                                    self.fetchAllComments();*/
                                    
                               /*  	self.getSelectedBlog = getBlog
                                	
                                	function getBlog(b_id,b_status){
                                		console.log("->->Getting Blog with ID :-"+b_id+"AND Status :-"+b_status);
                                		BlogService.getBlog(b_id,b_status)
                                			.then(
                                					function(d){
                                						self.blog = d;
                                						$rootScope.selectedBlog = d;
                                    				//	$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.selectedBlog;
                                    				//	$cookieStore.put('selectedBlog',$rootScope.selectedBlog);
                                						console.log("Blog found with Id :-"+b_id+"Navigate to View Blog Page."+self.blog.b_title)
                                						$location.path('/createblog');
                                					},
                                					function(errResponse){
                                						console.error('Error While fetching Blogs.');
                                					});
                                	};*/
                                	
                                	self.fetchAllBlogs = function(){
                                		BlogService.fetchAllBlogs()
                                			.then(function(d){
                                						self.blogs = d;
                                				},function(errResponse){
                                					console.error('Error While Fetching Blogs.');
                                			});
                                	};
                                	
                                /*     self.submit = function() 
                         				{
                         					console.log('Saving new blog', self.blog);
                         					self.createBlog(self.blog);
                         				};
                         				
                         			self.getMyBlogList = function(){
                         		    		BlogService.getMyBlogList()
                         		    		.then(function(d){
                         		    			self.myblogs = d;
                         		    		},function(errResponse){
                         		    			console.error('Error While getMyBlogList.');
                         		    		});
                         		    	}
                         		    	    	
                         		    	
                         	   	self.updateBlog = function(blog,b_id){
                         		    		BlogService.updateBlog(blog,b_id)
                         		    			.then(
                         		    					self.fetchAllBlogs,
                         		    					function(errResponse){
                         		    					console.error('Error While Updating Blog.');
                         		    			});
                         		    	};
                         		    	
                         		    	self.deleteBlog = function(b_id){
                         		    		BlogService.deleteBlog(b_id)
                         		    			.then(
                         		    					self.fetchAllBlogs,
                         		    					function(errResponse){
                         		    					console.error('Error While Deleting Blog.');
                         		    			});
                         		    	};
                         	*/	    	
                         		    	//calling the Method
                         		    	self.fetchAllBlogs();
                         		    //	self.getMyBlogList();
                         		    	
                         		    	
                         		    	self.submit = function()
                         		    		{
                         		    			console.log('Saving New Blog',self.blog);
                         		    			self.blog.u_id = $rootScope.currentUser.u_id;
                         		    			self.createBlog(self.blog);           			
                         		    		}
                         				//this.reset();
                         			
                         			
                                     
                         		
                         				//$scope.myForm.$setPristine(); // reset Form
        						
                         			                         			


                         			

                                 	
                                 	
                                 	        
                                			
                                 	
                                 }  ]);