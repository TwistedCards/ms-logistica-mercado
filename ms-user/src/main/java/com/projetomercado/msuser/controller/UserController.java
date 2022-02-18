package com.projetomercado.msuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetomercado.msuser.model.Role;
import com.projetomercado.msuser.model.User;
import com.projetomercado.msuser.repositories.RoleRepository;
import com.projetomercado.msuser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <User> findById(@PathVariable Long id) {
		User user = repository.findById(id).get();
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity <User> findByEmail(@RequestParam String email) {
		User user = repository.findByEmail(email);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping(value = "/saveUser")
	public ResponseEntity <User> saveUser(@RequestBody User user) {
		user.getRoles().add(roleRepository.findByRoleName("ROLE_OPERATOR"));
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		User objUser = repository.save(user);
		return ResponseEntity.ok(objUser);
	}
	
	@PostMapping(value = "/saveRole", consumes = "application/json")
	public ResponseEntity <Role> saveRole(@RequestBody Role role) {
		Role objRole = roleRepository.save(role);
		return ResponseEntity.ok(objRole);
	}
	
	
}
