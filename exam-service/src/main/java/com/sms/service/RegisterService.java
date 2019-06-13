package com.sms.service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.sms.model.Student;
import com.sms.model.Test;
import com.sms.model.TestRegistration;
import com.sms.payload.TestRegistrationRequest;
import com.sms.repository.StudentRepository;
import com.sms.repository.TestRegistrationRepository;
import com.sms.repository.TestRepository;

public class RegisterService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	TestRegistrationRepository testRegistrationRepository;
	
	public TestRegistration createTestRegistration(TestRegistrationRequest testRegistrationRequest){
		
		
		TestRegistration tr = new TestRegistration();
		Optional<Student> s=studentRepository.findById(testRegistrationRequest.getStudent_id());
		Optional<Test>t= testRepository.findById(testRegistrationRequest.getTest_id());
		        tr.setStudent(s);
		        tr.setTest(t);
		        Instant now = Instant.now();
		        tr.setRegistrationDate(now);
		        Instant expirationDateTime = now.plus(Duration.ofMinutes(30));
		        tr.setTokenExpireTime(expirationDateTime);
		        UUID uuid= UUID.randomUUID();
		        tr.setToken(uuid);
		        
		        return testRegistrationRepository.save(tr);
		       
		
	}
	
	 public TestRegistration getTestRegistrationById(Long testRegistrationId) {
		 TestRegistration tr = testRegistrationRepository.findById(testRegistrationId).orElseThrow(
	                () -> new com.sms.exception.ResourceNotFoundException("TestRegistration", "id", testRegistrationId));
		return tr;

	       
	    }


}
