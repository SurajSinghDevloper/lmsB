package com.management.lmsB.modules.user.security;

public interface AuthService {
	JwtAuthResponse login(LoginDto loginDto);
    String save(UserRequestDTO userRequestDto) throws Exception;
}
