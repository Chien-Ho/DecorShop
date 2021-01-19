package com.aptech.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.aptech.model.User;
@Service
public interface IUserService extends UserDetailsService{
	User save(User user);
}
