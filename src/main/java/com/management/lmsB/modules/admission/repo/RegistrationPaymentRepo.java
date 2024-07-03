package com.management.lmsB.modules.admission.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.lmsB.modules.admission.model.RegistrationPayment;

public interface RegistrationPaymentRepo extends JpaRepository<RegistrationPayment, Long> {

}
