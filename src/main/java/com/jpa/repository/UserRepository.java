package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	UserEntity findByName(String username);


}
