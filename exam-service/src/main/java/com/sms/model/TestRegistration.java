package com.sms.model;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="registration")
public class TestRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false, targetEntity = Student.class)
	@JoinColumn(name="student_id", nullable=false)
	private Optional<Student> student;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false, targetEntity = Test.class)
	@JoinColumn(name="test_id", nullable=false)
	private Optional<Test> test;
	
	@CreatedDate
    private Instant registrationDate;
	
	
	@NotNull
	private UUID token;
	
	private Instant tokenExpireTime;
	
	
	
	

	public TestRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TestRegistration(Optional<Student> student, Optional<Test> test, Instant registrationDate, @NotNull UUID token,
			Instant tokenExpireTime) {
		super();
		this.student = student;
		this.test = test;
		this.registrationDate = registrationDate;
		this.token = token;
		this.tokenExpireTime = tokenExpireTime;
	}


	public Optional<Test> getTest() {
		return test;
	}


	public void setTest(Optional<Test> t) {
		this.test = t;
	}


	public Instant getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Instant registrationDate) {
		this.registrationDate = registrationDate;
	}


	public UUID getToken() {
		return token;
	}


	public void setToken(UUID token) {
		this.token = token;
	}


	public Instant getTokenExpireTime() {
		return tokenExpireTime;
	}


	public void setTokenExpireTime(Instant tokenExpireTime) {
		this.tokenExpireTime = tokenExpireTime;
	}


	public TestRegistration(Long id, Optional<Student> student) {
		super();
		this.id = id;
		this.student = student;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Optional<Student> getStudent() {
		return student;
	}

	public void setStudent(Optional<Student> s) {
		this.student = s;
	}
	
	
	
	
	
	
	

}
