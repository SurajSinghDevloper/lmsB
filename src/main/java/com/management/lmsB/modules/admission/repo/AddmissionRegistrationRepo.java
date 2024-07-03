package com.management.lmsB.modules.admission.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.management.lmsB.modules.admission.model.AdmissionRegistration;

public interface AddmissionRegistrationRepo extends JpaRepository<AdmissionRegistration, Long> {
	AdmissionRegistration findByEmail(String eamil);
}
