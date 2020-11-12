package com.csl.bmsri.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csl.bmsri.Models.Role;


@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findModuleById(int role_id);
	Role findByRole(String role);
}