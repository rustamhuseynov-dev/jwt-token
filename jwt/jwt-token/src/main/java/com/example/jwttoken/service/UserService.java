package com.example.jwttoken.service;

import java.util.Optional;

import com.example.jwttoken.dto.UserDto;
import com.example.jwttoken.model.User;

public interface UserService {

	Optional<User> getByUsername(String username);

	UserDto createUser(UserDto request);
}
