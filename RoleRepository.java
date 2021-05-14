package com.example.userproject.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.userproject.entities.Role;


public interface RoleRepository extends CrudRepository<Role, Integer> {

}
