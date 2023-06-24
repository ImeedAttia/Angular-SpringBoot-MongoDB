package com.linkedin.demo.springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.linkedin.demo.springboot.entities.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role,String>{

}
