package com.jpa.repository;

import com.jpa.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	UserEntity findByName(String username);

	List<UserEntity> findAll() ;

}
