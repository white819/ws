package com.realm;

import com.jpa.model.UserEntity;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.repository.UserRepository;

public class UserRealm extends JdbcRealm {

	@Autowired
	private UserRepository userRepository;


	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// identify account to log to
		UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
		final String username = userPassToken.getUsername();

		if (username == null) {
			System.out.println("Username is null.");
			return null;
		}

		// read password hash and salt from db
		UserEntity userRet = userRepository.findByName(username);
		if (userRet == null) {
			System.out.println("No account found for user [" + username + "]");
			return null;
		}

		// return TODO salted credentials
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userRet.getName(), userRet.getPassword(), getName());

		return info;
	}
}
