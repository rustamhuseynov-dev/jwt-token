package com.example.jwttoken.service;

import com.example.jwttoken.dto.AuthRequest;

public interface AuthenticationService {

	String authenticationManager(AuthRequest authRequest);
}
