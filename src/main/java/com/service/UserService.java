package com.service;

import com.jpa.model.UserEntity;
import com.ws.bean.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

public interface UserService {

	
	
	public User addUser(User user);
	
	public User logIn(User user);


	public List<UserEntity> findAll ();

	public User findById(int id);

	public User updUser(User user);

	public void delById(int id) ;
}
