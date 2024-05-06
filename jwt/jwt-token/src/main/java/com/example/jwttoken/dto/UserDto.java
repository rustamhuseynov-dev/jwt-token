package com.example.jwttoken.dto;

import java.util.Set;

import com.example.jwttoken.model.Role;

import lombok.Builder;

@Builder
public record UserDto(
		String name,
        String username,
        String password,
        Set<Role> authorities
) {

}
