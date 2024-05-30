package com.management.lmsB.modules.user.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserRequestDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private String dob;
	private String address;
	private String username;

	
	
	
	
}
