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

	.when('/register',{
	
		templateUrl : 'c_user/register.html',
		controller  : 'UserController'
		
		
	})
	
	.when('/login',{
		
		templateUrl : 'c_user/login.html',
		controller  : 'UserController'
		
		
	})
	.when('/manageUsers',{
		
		templateUrl : 'c_user/manageUsers.html',
		controller  : 'AdminController'
		
		
	})
	
})
