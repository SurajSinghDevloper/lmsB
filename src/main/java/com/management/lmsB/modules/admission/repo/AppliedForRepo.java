package com.management.lmsB.modules.admission.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.lmsB.modules.admission.model.AppliedFor;

public interface AppliedForRepo extends JpaRepository<AppliedFor, Long> {

}
