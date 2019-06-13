package com.sms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="testxpaper")
public class testxpaper {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="registration_id", nullable=false)
	private TestRegistration testRegistration;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="testxquestion_id", nullable=false)
	private testxquestion testxquestion;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="choice_id", nullable=false)
	private Choice choice;
	
	@NotBlank
	private String Answer;
	
	private Long MarkScored;
	
	
	

	public testxpaper(Long id, TestRegistration testRegistration, com.sms.model.testxquestion testxquestion,
			Choice choice, String answer, Long markScored) {
		super();
		this.id = id;
		this.testRegistration = testRegistration;
		this.testxquestion = testxquestion;
		this.choice = choice;
		Answer = answer;
		MarkScored = markScored;
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

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public Long getMarkScored() {
		return MarkScored;
	}

	public void setMarkScored(Long markScored) {
		MarkScored = markScored;
	}
	
	
	
	
	
}
