package com.projetomercado.msuser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetomercado.msuser.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
