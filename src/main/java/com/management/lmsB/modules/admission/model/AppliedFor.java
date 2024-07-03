package com.management.lmsB.modules.admission.model;

import jakarta.persistence.Entity;
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
public class AppliedFor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long afId;
	private String appliedFor;
	private String paper1;
	private String paper2;
	private String paper3;
	private String paper4;
	private String paper5;
	private String paper6;
	private String paper7;
	private String paper8;
	private String paper9;
	private String paper10;
	private Long addId;
}
