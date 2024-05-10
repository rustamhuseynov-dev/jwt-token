package com.example.jwttoken.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwttoken.dto.AuthRequest;
import com.example.jwttoken.service.AuthenticationService;
import com.example.jwttoken.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	private final AuthenticationManager authenticationManager;

	private final JwtService jwtService;

	@Override
	public String authenticationManager(AuthRequest authRequest) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.username());
		}
		throw new UsernameNotFoundException("invalid username " + authRequest.username());
	}

}
