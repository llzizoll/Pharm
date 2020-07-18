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
import com.spirit.login.entities.CustomUser;
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

@Service(value = "userService")
@Transactional
public class userServices implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;


	@Override
	public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = usersRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Invalid username or password.");
		else
			return new CustomUser(user.getUsername(), user.getPassword(), true, true, true, true, getAuthority(user),
					user.getFirstName(), user.getLastName(), user.getEmail());

	}

	private Set<SimpleGrantedAuthority> getAuthority(Users user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRolesList().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

}