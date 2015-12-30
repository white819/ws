app.controller('SignupCtrl', function ( $scope, $http, $state) {

  $scope.user = {};

  $scope.createUser = function() {
    $http({
      url: 'http://localhost:3001/users',
      method: 'POST',
      data: $scope.user
    }).then(function(response) {
      $state.go('home');
    }, function(error) {
      alert(error.data);
    });
  }

});