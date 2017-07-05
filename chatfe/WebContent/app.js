/**
 * 
 */
var app = angular.module("myApp",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	
	.when('/blog',{
		templateUrl : 'c_blog/blog.html',
		controller : 'BlogController'
	})
.when('/showblog',{
		templateUrl : 'c_blog/showblog.html',
		controller : 'BlogController'
	})

	.when('/register',{
	
		templateUrl : 'c_user/register.html',
		controller  : 'UserController'
		
		
	}).when('/event',{
		templateUrl : 'c_event/event.html',
		controller : 'EventController'
	})

	
	.when('/login',{
		
		templateUrl : 'c_user/login.html',
		controller  : 'UserController'
		
		
	})
	.when('/manageUsers',{
		
		templateUrl : 'c_user/manageUsers.html',
		controller  : 'AdminController'
		
		
	})
	.when('/manageblogs',{
		
		templateUrl : 'c_blog/manageblogs.html',
		controller  : 'AdminController'
		
		
	})
	
	.when('/job',{
		templateUrl : 'c_job/job.html',
		controller  : 'JobController'
		
	})
	
})
