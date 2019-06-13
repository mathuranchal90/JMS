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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="questionCategory_id", nullable=false)
	private QuestionCategory questionCategory;
	
	@NotBlank
	@Size(max=40)
	private String questionType;
	
	
	@NotBlank
	@Size(max=400)
	private String questionText;
	
	@NotNull
	private Long points;
	
	
	private Boolean isActive;
	
	
	
	

	public Question(Long id, QuestionCategory questionCategory, @NotBlank @Size(max = 40) String questionType,
			@NotBlank @Size(max = 400) String questionText, @NotNull Long points, Boolean isActive) {
		super();
		this.id = id;
		this.questionCategory = questionCategory;
		this.questionType = questionType;
		this.questionText = questionText;
		this.points = points;
		this.isActive = isActive;
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}


	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}


	public String getQuestionType() {
		return questionType;
	}


	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}


	public String getQuestionText() {
		return questionText;
	}


	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}


	public Long getPoints() {
		return points;
	}


	public void setPoints(Long points) {
		this.points = points;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
