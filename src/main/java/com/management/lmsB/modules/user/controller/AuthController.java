package com.management.lmsB.modules.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.management.lmsB.modules.user.models.Users;
import com.management.lmsB.modules.user.security.AuthService;
import com.management.lmsB.modules.user.security.JwtAuthResponse;
import com.management.lmsB.modules.user.security.LoginDto;
import com.management.lmsB.modules.user.security.UserRequestDTO;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	private AuthService authService;

	// Build Login REST API
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		JwtAuthResponse response = authService.login(loginDto);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid Crendentals ..... ", HttpStatus.BAD_REQUEST);
		}

	}

	// Building Post API
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UserRequestDTO userRequestdto) {
		String successMessage = "";
		try {
			successMessage = authService.save(userRequestdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(successMessage, HttpStatus.OK);

	}

}
