package com.sms.questionservice.payload;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class QuestionLength {
	
	@NotNull
    @Max(4)
    private Integer noOfChoices;

	public Integer getNoOfChoices() {
		return noOfChoices;
	}

	public void setNoOfChoices(Integer noOfChoices) {
		this.noOfChoices = noOfChoices;
	}
	
	

}
