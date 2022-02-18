package com.projetomercado.msuser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetomercado.msuser.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRoleName(String roleName);
	
}
