package com.sms.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sms.model.TestRegistration;
import com.sms.payload.TestRegistrationRequest;
import com.sms.service.RegisterService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/exams")
@Api(value="exams", description = "Data service operations on Exams", tags=("exam"))
public class ExamController {
	
	  private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	
	RegisterService registerService;
	
	
	
	public ExamController() {
		super();
		this.registerService=registerService;
	}



	@PostMapping("/register")
    public ResponseEntity<?> createTestRegistration(@Valid @RequestBody TestRegistrationRequest request) {
        TestRegistration tr = registerService.createTestRegistration(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{testRegistrationId}")
                .buildAndExpand(tr.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new com.sms.payload.ApiResponse(true, "Registration done Successfully"));
    }
	
	
	
	
	
	@GetMapping("/register/{TestRegistrationById}")
    public TestRegistration getTestRegistrationById(@RequestParam Long TestRegistrationById) {
        TestRegistration tr = registerService.getTestRegistrationById(TestRegistrationById);

        return tr;
    }

}
