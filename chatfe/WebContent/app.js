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
	
	
})
