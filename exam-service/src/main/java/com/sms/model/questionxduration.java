package com.sms.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="questionxduration")
public class questionxduration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="registration_id", nullable=false)
	private TestRegistration testRegistration;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="testxquestion_id", nullable=false)
	private testxquestion testxquestion;
	
    private Instant requestTime;
    
    private Instant leaveTime;
    
    private Instant answeredTime;
    
    
    

	public questionxduration(Long id, TestRegistration testRegistration, com.sms.model.testxquestion testxquestion,
			Instant requestTime, Instant leaveTime, Instant answeredTime) {
		super();
		this.id = id;
		this.testRegistration = testRegistration;
		this.testxquestion = testxquestion;
		this.requestTime = requestTime;
		this.leaveTime = leaveTime;
		this.answeredTime = answeredTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TestRegistration getTestRegistration() {
		return testRegistration;
	}

	public void setTestRegistration(TestRegistration testRegistration) {
		this.testRegistration = testRegistration;
	}

	public testxquestion getTestxquestion() {
		return testxquestion;
	}

	public void setTestxquestion(testxquestion testxquestion) {
		this.testxquestion = testxquestion;
	}

	public Instant getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Instant requestTime) {
		this.requestTime = requestTime;
	}

	public Instant getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Instant leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Instant getAnsweredTime() {
		return answeredTime;
	}

	public void setAnsweredTime(Instant answeredTime) {
		this.answeredTime = answeredTime;
	}
    
    
    
	
	
}
