package com.example.userproject.service;


import java.util.List;

import com.example.userproject.entities.User;


public interface UserService {

	User createUser(User user);

	List<User> getUsers();

	User getUserById(int id);

	void deleteById(int id);

	User getUserByName(String firstName);

}
