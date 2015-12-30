'use strict';

/**
 * @ngdoc overview
 * @name bimApp
 * @description
 * # bimApp
 *
 * Main module of the application.
 */
var app = angular
  .module('bimApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.router'
  ])
  .config(function ($stateProvider, $routeProvider) {
    /*$routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
        redirectTo: '/'
      });
    
    $stateProvider
    .state("index", {
        url: 'manage/index.html'
    });*/
	  
    $routeProvider.when('/', {template: '<h1>home</h1>', controller: function(){}});
    $routeProvider.when('/page1', {template: '<h1>page1</h1>', controller: function(){}});
    $routeProvider.when('/page2', {template: '<h1>page2</h1>', controller: function(){}});
    $routeProvider.when('/login', {templateUrl: 'views/login.html', controller: 'LoginCtrl'});
    $routeProvider.otherwise({redirectTo: '/'});
	  
  });


