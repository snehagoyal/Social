/**
 * 
 */
var app = angular.module("myApp",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	
	/*.when('/',{
		templateUrl : 'c_home/home.html',
		controller : 'HomeController'
	})
	*/
	.when('/register',{
	
		templateUrl : 'c_user/register.html',
		controller  : 'UserController'
		
		
	})
	
	
})
