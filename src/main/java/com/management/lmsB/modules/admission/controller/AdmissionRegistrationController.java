package com.management.lmsB.modules.admission.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.management.lmsB.modules.admission.dtos.RegisterDTO;
import com.management.lmsB.modules.admission.service.AdmissionRegistrationService;
import com.management.lmsB.modules.constants.Results;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/student")
public class AdmissionRegistrationController {
	
	@Autowired
    private AdmissionRegistrationService registrationService;

	 @PostMapping("/registration/new")
	    public ResponseEntity<String> registerNew(@RequestBody RegisterDTO dto) {
	        String result = registrationService.newRegistration(dto);
	        if (Results.SUCCESS.toString().equals(result)) {
	            return ResponseEntity.status(HttpStatus.CREATED).body("Registration successful. Please check your email to complete the process.");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed. Please try again.");
	        }
	    }
}
