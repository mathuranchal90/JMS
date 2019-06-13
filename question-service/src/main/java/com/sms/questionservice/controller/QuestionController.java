package com.sms.questionservice.controller;


import com.sms.questionservice.exception.ResourceNotFoundException;
import com.sms.questionservice.model.Answer;
import com.sms.questionservice.model.Question;
import com.sms.questionservice.payload.QuestionRequest;
import com.sms.questionservice.repository.AnswerRepository;
import com.sms.questionservice.repository.ChoiceRepository;
import com.sms.questionservice.repository.QuestionRepository;
import com.sms.questionservice.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class QuestionController {
	
	 	@Autowired
	    private QuestionRepository questionRepository;
	 	
	 	private QuestionService questionService;
	 	
	 	private ChoiceRepository choiceRepository;

	    @GetMapping("/questions")
	    public Page<Question> getQuestions(Pageable pageable) {
	        return questionRepository.findAll(pageable);
	    }
	    
	    
	    @PostMapping("/questions")
	    public Question createQuestion(@Valid @RequestBody QuestionRequest questionRequest) {
	        return questionService.createQuestion(questionRequest);
	    }

	   /** @PutMapping("/questions/{questionId}")
	    public Question updateQuestion(@PathVariable Long questionId,
	                                   @Valid @RequestBody Question questionRequest) {
	    	if (questionRequest.getQuestionType().getType()==TYPE_SINGLE_CHOICE)
	    	{
	    		
	    		return questionRepository.findById(questionId).map(question ->{question.setQuestionCategory(questionRequest.getQuestionCategory());
	    		question.setQuestionType(questionRequest.getQuestionType());
	    		
	    		})
	    	}
	    	
	        return questionRepository.findById(questionId)
	                .map(question -> {
	                    question.setTitle(questionRequest.getTitle());
	                    question.setDescription(questionRequest.getDescription());
	                    return questionRepository.save(question);
	                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	    }**/


	    @DeleteMapping("/questions/{questionId}")
	    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
	        return questionRepository.findById(questionId)
	                .map(question -> {
	                    questionRepository.delete(question);
	                    return ResponseEntity.ok().build();
	                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
	    }

}

   
