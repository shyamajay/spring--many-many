package com.example.userproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userproject.entities.Role;
import com.example.userproject.repos.RoleRepository;
import com.example.userproject.repos.UserRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository repos;
	@Autowired
	UserRepository repos1;

	public Role updateRole(int id, Role role, int id1){
		Role role2 = repos.findById(id1).get();
		role2.setName(role.getName());
		role2.setDescription(role.getDescription());
		return repos.save(role2);
	}
	
	public void deleteRole(int id){
		if(repos.existsById(id)) {
			repos.deleteById(id);
		}
	}
}
