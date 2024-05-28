package com.management.lmsB.modules.user.security;

import com.management.lmsB.modules.user.models.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {
	  private Users user;
	private String accessToken;
  
  
}