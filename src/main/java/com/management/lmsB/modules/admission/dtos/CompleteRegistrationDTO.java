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
public class CompleteRegistrationDTO {
	private String name ;
	private String fname;
	private String mname;
	private String mobile;
	private String aadhar;
	private String email;
	private Date dob;
	private String parmanentAdd;
	private String presentAdd;
	private String gender;
	private String cwsn;
	private String nationality;
	private String category;
	private String previousSchoolName;
	private String classLastAttendent;
	private String eqOfFather;
	private String eqOfMother;
	private String poFather;
	private String poMother;
	private String aiFather;
	private String aiMother;
	private String password;
	private String appliedFor;
}
