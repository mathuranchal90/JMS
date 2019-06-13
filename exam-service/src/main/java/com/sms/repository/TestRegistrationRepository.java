package com.sms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sms.model.TestRegistration;

@Repository
public interface TestRegistrationRepository extends JpaRepository<TestRegistration,Long> {
	
	Optional<TestRegistration> findById(Long testRegistrationId);

}
