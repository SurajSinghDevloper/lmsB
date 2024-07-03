package com.management.lmsB.modules.admission.model;

import java.sql.Date;
import java.sql.Timestamp;

import com.management.lmsB.modules.constants.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionRegistration {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private Long addId;
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
	@Enumerated(EnumType.STRING)
	private Status paymentStatus;
	@Enumerated(EnumType.STRING)
	private Status approvalStatus;
	private Long approvedBy;
	@Enumerated(EnumType.STRING)
	private Status prevApplied;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Timestamp stamp; 
}
