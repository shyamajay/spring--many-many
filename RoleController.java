package com.example.userproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.userproject.entities.ProductErrorResponse;
import com.example.userproject.entities.Role;
import com.example.userproject.exception.RoleNotFoundException;
import com.example.userproject.repos.RoleRepository;
import com.example.userproject.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleservice;
	
	@Autowired
	RoleRepository repos;
	
	@RequestMapping(value = "/{id}/update/{id}",method = RequestMethod.PATCH)
	public Role updateRole(@PathVariable("id")int id,@RequestBody Role role,@PathVariable("id")int id1) throws RoleNotFoundException { 
		if(!repos.existsById(id1)) {
			throw new RoleNotFoundException("sry not found");
		}
			return roleservice.updateRole(id,role,id1);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleException(RoleNotFoundException e){
		ProductErrorResponse p = new ProductErrorResponse();
		p.setStatus(HttpStatus.NOT_FOUND);
		p.setMessage(e.getMessage());
		p.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<ProductErrorResponse>(p, null, HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(value = "/delete/{id}")
	public void deleteRole(@PathVariable("id")int id) {
		roleservice.deleteRole(id);
	}

}
