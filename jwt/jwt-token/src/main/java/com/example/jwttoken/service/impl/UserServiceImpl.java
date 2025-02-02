package com.example.jwttoken.service.impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwttoken.dto.UserDto;
import com.example.jwttoken.model.User;
import com.example.jwttoken.repository.UserRepository;
import com.example.jwttoken.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	private final BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUsername(username);
		return user.orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public Optional<User> getByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public UserDto createUser(UserDto request) {
		User newUser = User.builder()
				.name(request.name())
				.username(request.username())
				.password(passwordEncoder.encode(request.password()))
				.authorities(request.authorities())
				.accountNonExpired(true)
				.accountNonLocked(true)
				.isEnabled(true)
				.credentialsNonExpired(true)
				.build();
		repository.save(newUser);
		// response
		UserDto userDto = UserDto.builder()
				.name(newUser.getName())
				.username(newUser.getUsername())
				.authorities(newUser.getAuthorities())
				.build();
		return userDto;
	}

}
