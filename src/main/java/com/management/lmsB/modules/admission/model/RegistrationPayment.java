package com.management.lmsB.modules.admission.model;

import java.sql.Timestamp;

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
public class RegistrationPayment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rpId;
	private Long addId;
	private String transID;
	private String paymentStatus;
	private String amt;
	private Timestamp stamp;
}
