package com.example.userproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userproject.entities.Role;
import com.example.userproject.entities.User;
import com.example.userproject.repos.UserRepository;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repos;
	
	public User createUser(User user) {
		Role role = new Role();
		List<Role> roles = user.getRoles();
		for (Role role2 : roles) {
			role.setName(role2.getName());
			role.setDescription(role2.getDescription());
		}
		User user2 = new User();
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
		user2.setMobile(user.getMobile());
		return repos.save(user);
	}

	public List<User> getUsers() {
		return (List<User>) repos.findAll();
	}

	public User getUserById(int id) {
		if(repos.existsById(id)) {
			return repos.findById(id).get();
		}
		return null;
	}
	
	public void deleteById(int id) {
		if(repos.existsById(id)) {
			 repos.deleteById(id);
		}
	}
	
	public User getUserByName(String firstName) {
		return repos.findByfirstName(firstName);
	}

}
