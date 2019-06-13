package com.sms.questionservice.service;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.questionservice.model.Choice;
import com.sms.questionservice.model.Question;
import com.sms.questionservice.payload.ChoiceRequest;
import com.sms.questionservice.payload.QuestionRequest;
import com.sms.questionservice.repository.QuestionRepository;

@Service
public class QuestionService {
	
	 @Autowired
	    private QuestionRepository questionRepository;
	 
	 	ChoiceRequest choiceRequest;

	 
	 		public Question createQuestion(QuestionRequest questionRequest) {
	 			
	 		Question question= new Question();
	 		question.setQuestionText(questionRequest.getQuestionText());
	 		
	 		questionRequest.getChoices().forEach(choiceRequest-> {
	 			question.addChoice(new Choice(choiceRequest.getLabel(),choiceRequest.getPoints()));
	 		});		

	        return questionRepository.save(question);
	    }

}
