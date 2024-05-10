package com.example.jwttoken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwttoken.dto.AuthRequest;
import com.example.jwttoken.dto.UserDto;
import com.example.jwttoken.service.AuthenticationService;
import com.example.jwttoken.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	private final AuthenticationService authenticationService;

	@GetMapping(path = "/welcome")
	public String welcome() {
		return "Hello World!this is MyChannel";
	}

	@PostMapping(path = "/addNewUser")
	public UserDto addNewUser(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}

	@PostMapping(path = "/generateToken")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		return authenticationService.authenticationManager(authRequest);
	}

	@GetMapping(path = "/user")
	public String getUserString() {
		return "This is USER!";
	}

}
