/**
 * 
 */
var app= angular.module("myApp",["ngRoute","ngCookies"]);
app.config(function($routeProvider){
	$routeProvider
	
	.when("/",{
		templateUrl: 'c_user/login.html',
		controller:'UserController'
	})
	.when("/register" ,{
		templateurl: 'c_user/register.html',
		controller: 'UserController'
	})
	
	
	.when("/profile" ,{
		templateurl: 'c_user/profile.html',
		controller: 'UserController'
	})
	.when("/blog",{
		templateurl:'c_user/blog.html',
		controller: 'BlogController'
	})
})