package com.sms.questionservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sms.questionservice.model.audit.AuditModel;

@Entity
@Table(name = "questions")
public class Question extends AuditModel {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;
    
    /**@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private QuestionCategory questionCategory;**/
    
    /**@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private QuestionType questionType;**/
    private String question_Category;
    
    private String question_Type;

    @NotBlank
    @Size(max = 140)
    private String QuestionText;
    
    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Size(min = 2, max = 6)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 30)
    private List<Choice> choices = new ArrayList<>();
    
    private int points;
    
    private boolean isActive;
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion_Category() {
		return question_Category;
	}

	public void setQuestion_Category(String question_Category) {
		this.question_Category = question_Category;
	}

	public String getQuestion_Type() {
		return question_Type;
	}

	public void setQuestion_Type(String question_Type) {
		this.question_Type = question_Type;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public String getQuestionText() {
		return QuestionText;
	}

	public void setQuestionText(String questionText) {
		QuestionText = questionText;
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
    
    
	public void addChoice(Choice choice) {
        choices.add(choice);
        choice.setQuestion(this);
    }

    public void removeChoice(Choice choice) {
        choices.remove(choice);
        choice.setQuestion(null);
    }
   

	

    // Getters and Setters (Omitted for brevity)
}
