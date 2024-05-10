package com.example.jwttoken.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

	String generateToken(String username);

	Boolean validateToken(String token, UserDetails userDetails);

	String extractUser(String token);
}
