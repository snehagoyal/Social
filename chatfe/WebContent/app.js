/**
 * 
 */
var app = angular.module("myApp",["ngRoute","ngCookies"]);

app.config(function($routeProvider){
	$routeProvider
	
	.when('/login',{
		
		templateUrl : 'c_user/login.html',
		controller  : 'UserController'
		
		
	})
	

	

	
	.when('/createblog',{
		templateUrl : 'c_blog/createblog.html',
		controller : 'BlogController'
	})

	
	.when('/register',{
	
		templateUrl : 'c_user/register.html',
		controller  : 'UserController'
		
		
	}).when('/event',{
		templateUrl : 'c_event/event.html',
		controller : 'EventController'
	})

	
	.when('/manageUsers',{
		
		templateUrl : 'c_user/manageUsers.html',
		controller  : 'AdminController'
		
		
	})
	.when('/managejobs',{
		
		templateUrl : 'c_job/managejobs.html',
		controller  : 'JobController'
		
		
	})
	.when('/ListofJobs',{
		
		templateUrl : 'c_job/ListofJobs.html',
		controller  : 'JobController'
		
		
	})
	
	
	.when('/MyAppliedJobs',{
		
		templateUrl : 'c_job/MyAppliedJobs.html',
		controller  : 'JobController'
		
		
	})
	.when('/postedjob',{
		
		templateUrl : 'c_job/postedjob.html',
		controller  : 'JobController'
		
		
	})
	
	.when('/manageblogs',{
		
		templateUrl : 'c_blog/manageblogs.html',
		controller  : 'AdminController'
		
		
	})
	
	
})
