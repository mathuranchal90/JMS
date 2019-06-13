package com.sms.questionservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "question_category")
public class QuestionCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
	private CategoryName category;

	public QuestionCategory() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public CategoryName getCategory() {
		return category;
	}


	public void setCategory(CategoryName category) {
		this.category = category;
	}
	
	

}
