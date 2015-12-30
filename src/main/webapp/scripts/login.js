app.controller('LoginCtrl', function ( $scope, $http, $state, AuthService) {

  $scope.user = {};

  $scope.login = function() {
    /*$http({
      url: 'http://localhost:18080/menjin/unauth/login',
      method: 'POST',
      data: $scope.user
    }).then(function(response) {
      AuthService.setUser(response.data);
      $state.go('home');
    }, function(error) {
      alert(error.data);
    });*/
	  AuthService.login($scope.user).then(function(){$state.go('home')}, function(){$state.go('login')});
  }

});