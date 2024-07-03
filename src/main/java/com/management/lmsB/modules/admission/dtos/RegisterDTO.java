package com.management.lmsB.modules.admission.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
	private String name ;
	private String email;
	private String mobile;
	private String presentAdd;
	private String appliedFor;
}
