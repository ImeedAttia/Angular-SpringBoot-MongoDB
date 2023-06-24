package com.linkedin.demo.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.demo.springboot.entities.User;
import com.linkedin.demo.springboot.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	// function to create a new user
	public User createUser(User user) {
        return userRepository.save(user);
    }
	// function return a user by id or null in case it doesn't exist
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
    // function that retrieve all users from database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // function that update an existing user in database
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    // function that remove a user from database by it's id
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

