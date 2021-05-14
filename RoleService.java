package com.example.userproject.service;

import com.example.userproject.entities.Role;

public interface RoleService {

	Role updateRole(int id, Role role, int id1);

	void deleteRole(int id);

}
