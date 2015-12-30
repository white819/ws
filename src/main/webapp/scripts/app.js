
var app = angular
  .module('menjin', [
	'ngAnimate',
	'ngCookies',
	'ngResource',
	'ngRoute',
	'ngSanitize',
	'ngTouch',
	'ui.router'
  ])
  .config(function ($stateProvider) {
	  
	  $stateProvider.state('home', {
		    url: '/',
		    controller: 'HomeCtrl',
		    templateUrl: 'views/home.html',
		}).state('login', {
		    url: '/login',
		    controller: 'LoginCtrl',
		    templateUrl: 'views/login.html'
		}).state('signup', {
		    url: '/signup',
		    controller: 'SignupCtrl',
		    templateUrl: 'views/signup.html'
		});
});

app.controller('AppCtrl', function ($scope, $location) {
	/*$scope.$on('$routeChangeSuccess', function(e, nextRoute){
	    if ( nextRoute.$$route && angular.isDefined( nextRoute.$$route.pageTitle ) ) {
	      $scope.pageTitle = nextRoute.$$route.pageTitle + ' | ngEurope Sample' ;
	    }
	  });*/
    
});

app.run(function($rootScope, $state, AuthService) {
  $rootScope.$on('$stateChangeStart', function(e, to) {
    	if (!AuthService.isLogged())
        {
    		if (to.name != 'login') {
    			e.preventDefault();
    			$state.go('login');
    		} 
        } 
  });
});


