package com.linkedin.demo.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.linkedin.demo.springboot.entities.Role;
import com.linkedin.demo.springboot.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
	List<User> findUsersByRole(Role role);
}
