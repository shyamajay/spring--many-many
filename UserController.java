package com.example.userproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userproject.entities.User;
import com.example.userproject.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/user/create",method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userservice.createUser(user);
	}
	
	@RequestMapping(value = "/user/getAll",method = RequestMethod.GET)
	public List<User> getUsers(){
		return userservice.getUsers();
	}
	
	@RequestMapping(value = "/user/getUser/{id}",method = RequestMethod.GET)
	public User getUserById(@PathVariable("id")int id) {
		return userservice.getUserById(id);
	}
	
	@RequestMapping(value = "/user/delete/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable("id")int id) {
		userservice.deleteById(id);
	}
	
	@RequestMapping(value = "/user/get",method = RequestMethod.GET)
	public User getUserByName(@RequestParam(value = "firstName")String firstName) {
		return userservice.getUserByName(firstName);
	}

}
