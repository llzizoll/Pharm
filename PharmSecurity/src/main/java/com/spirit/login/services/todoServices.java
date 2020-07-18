/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spirit.login.services;

import com.spirit.login.entities.Users;
import com.spirit.login.repositories.UsersRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zizo
 */

@Service
@Transactional
public class todoServices {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public Users saveUser(Users user) {

		Long newID = getlastIDFromUsers();
		int lastId = (Math.toIntExact(newID)) + 1;

		user.setId(lastId);

		user.setUsername(user.getUsername());
		user.setPassword(bcryptEncoder.encode(user.getPassword()));

		return usersRepository.save(user);
	}

	public List<Users> getAlluser() {

		return usersRepository.findAll();
	}

	// delete
	public void deleteUser(Users user) {

		usersRepository.delete(user);

	}

	// delete2
	public void deleteUserbyID(Integer id) {
		usersRepository.deleteById(id);
	}

	// findbyid
	public Optional<Users> findById(Integer userId) {
		return usersRepository.findById(userId);
	}

	// getlastid
	public Long getlastIDFromUsers() {

		return usersRepository.count();

	}

	// name
	public List<Users> getusernamebyEmail(String email) {

		return usersRepository.findByEmail(email);
	}

	public Users findOne(String username) {
		return usersRepository.findByUsername(username);
	}

	// </editor-fold >

}