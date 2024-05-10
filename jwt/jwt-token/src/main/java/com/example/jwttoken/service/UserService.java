package com.example.jwttoken.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.jwttoken.dto.UserDto;
import com.example.jwttoken.model.User;

public interface UserService extends UserDetailsService {

	Optional<User> getByUsername(String username);

	UserDto createUser(UserDto request);
}
