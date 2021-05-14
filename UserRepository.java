package com.example.userproject.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.userproject.entities.User;


public interface UserRepository extends CrudRepository<User, Integer> {

	User findByfirstName(String firstName);

}
