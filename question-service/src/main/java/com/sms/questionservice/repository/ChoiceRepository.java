package com.sms.questionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.questionservice.model.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice,Long> {

	List<Choice> findByQuestionId(Long questionId);
}
