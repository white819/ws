'use strict';

/**
 * @ngdoc function
 * @name bimApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the bimApp
 */
/*var ser = angular.module('test', ['ngResource']);
ser.factory('User', ['$resource', function($resource){
	return $resource('/manage/index.html', {name:'@name'});
}]);
*/
app.controller('MainCtrl', function ($scope, $http, AuthService) {
      $scope.todos = ['Item 1', 'Item 2', 'Item 3'];
      $scope.userName = 'macx';
      $scope.passWord = 'macx';
      $scope.login = AuthService.login;
      
  });

app.controller('NavCtrl', function($scope, $window, $location, AuthService) {
    $scope.$watch(
        function(){ return AuthService.getUser() },
        function(newVal, oldVal){ $scope.user = newVal }
    );
    $scope.logout = function () {
        AuthService.logout();
    };
});

app.controller('LoginCtrl', function($scope, $location, AuthService){
	$scope.userName = "macx";
	$scope.passWord = "macx";
    $scope.login = function(){
       // $scope.disabled = true;
        AuthService.login($scope.userName, $scope.passWord)
            .then(function(){
                $location.path('/');
            },function(){
            	 $scope.alert = {msg: "Login failed"};
            })
    };
});