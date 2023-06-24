package com.linkedin.demo.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.linkedin.demo.springboot.entities.Role;
import com.linkedin.demo.springboot.services.RoleService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	//Create new Role
	@PostMapping(consumes =MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Role> createRole(@RequestBody Role role){
		Role newRole = roleService.createRole(role);
		return new ResponseEntity<Role>(newRole,HttpStatus.CREATED);
	}
	//Get role by id
    @GetMapping(path="/{roleId}",produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRoleById(@PathVariable String roleId) {
    	Role roleFound = roleService.getRoleById(roleId);
    	return new ResponseEntity<Role>(roleFound,HttpStatus.OK);	
    }
    //Get all roles
    @GetMapping(produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getAllRoles() {
    	List<Role> rolesList = roleService.getAllRoles();
    	return new ResponseEntity<List<Role>>(rolesList,HttpStatus.OK);	
    }
    //Update rol
    @PutMapping(consumes =MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> updateUser(@RequestBody Role role){
    	Role roleUpdated = roleService.updateRole(role);
    	return new ResponseEntity<Role>(roleUpdated,HttpStatus.ACCEPTED);	
    }
    //Delete role
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable String id) {
		roleService.deleteRole(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
