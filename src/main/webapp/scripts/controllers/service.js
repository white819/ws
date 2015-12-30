'use strict';

app.factory('AuthService', function($http, $q, $state, $cookieStore){
	var authService = {};
    var _user = null;
    
    var setUser = function(user) {
		_user = user;
        if (_user == null) {
        	$cookieStore.remove('user');
        }
        else {
        	$cookieStore.put('user', _user);
        }
	}
    return {
    	setUser: setUser,
        isLogged: function(){ 
        	if (_user == null) {
        		_user = $cookieStore.get('user');
            }
            return (_user != null);
        	},
        getUser: function(){ return _user; },
        login: function(user){
	       	 return $http.post('http://localhost:18080/menjin/unauth/login', user
	       	  ).success(function(data, status, headers, config) {  
	       	      //加载成功之后做一些事  
	       		  _user = data;
	       		setUser(_user);
	       		$q.resolve(data);
	       		
	       	  }).error(function(data, status, headers, config) {  
	       	      //处理错误  
	       		  console.log(headers);
	       		_user = null;
	       		setUser(_user);
	       		return $q.reject(data);
	       	  }); 
        },
        logout: function(){
            _user = null;
            setUser(_user);
            $state.go();
        }
    };
});

