package com.sms.questionservice.payload;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.questionservice.model.QuestionCategory;
import com.sms.questionservice.model.QuestionType;
import com.sms.questionservice.payload.ChoiceRequest;
import com.sms.questionservice.payload.QuestionLength;

public class QuestionRequest {
	
    private String QuestionText;
	

 
    private List<ChoiceRequest> choices;


    private int questionLength;
    
    private String questionCategory;
    
    private String questionType;
    
    private int points;
    
    private boolean isActive;

	public String getQuestionText() {
		return QuestionText;
	}

	public void setQuestionText(String questionText) {
		QuestionText = questionText;
	}

	public List<ChoiceRequest> getChoices() {
		return choices;
	}

	public void setChoices(List<ChoiceRequest> choices) {
		this.choices = choices;
	}

	

	public int getQuestionLength() {
		return questionLength;
	}

	public void setQuestionLength(int questionLength) {
		this.questionLength = questionLength;
	}

	public String getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
    
    
    
    

}
