package com.management.lmsB.modules.user.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.management.lmsB.modules.user.models.Users;


public interface UserRepository extends JpaRepository<Users, Long>  {
	Users findByEmail(String eamil);
}
