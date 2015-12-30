package com.service;

import com.jpa.model.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.bean.User;
import com.jpa.repository.UserRepository;

import java.util.List;

@Service
public  class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public User logIn(User user) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByName(user.getName());

		UsernamePasswordToken token = new UsernamePasswordToken(userEntity.getName(), userEntity.getPassword());

		//token.setRememberMe(false); 
		
		Subject currentUser = SecurityUtils.getSubject();
		//currentUser.getSession();
	    try {  
	        currentUser.login(token);  
	    } catch ( UnknownAccountException uae ) {  
	    } catch ( IncorrectCredentialsException ice ) { 
	    } catch ( LockedAccountException lae ) { 
	    } catch ( ExcessiveAttemptsException eae ) { 
	    } catch ( AuthenticationException ae ) {  
	        //unexpected error?  
	    }
		User userRet = new User();

		BeanUtils.copyProperties(userEntity,userRet);

		return userRet;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<UserEntity> findAll () {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return (User)userRepository.findOne(id);
	}

	@Override
	public User updUser(User user) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findOne(user.getId());
		BeanUtils.copyProperties(user, userEntity);
		return (User)userRepository.save(userEntity);
	}

	public void delById(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}


}
