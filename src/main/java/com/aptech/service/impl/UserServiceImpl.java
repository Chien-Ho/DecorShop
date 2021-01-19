package com.aptech.service.impl;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aptech.repository.UserRepository;
import com.aptech.service.IUserService;
import com.aptech.model.Role;
import com.aptech.model.User;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),  getAuthorities(user));
	}
	private Collection<GrantedAuthority> getAuthorities(User user){
		Set<GrantedAuthority> auth = new HashSet<>();
		for(Role role :  user.getRoles()) {
			auth.add(new SimpleGrantedAuthority(role.getCode()));
		}
	return auth;
	}
	@Override
	public User save(User user) {
		
		return userRepository.save(user);
	}

}
