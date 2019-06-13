package com.sms.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="students", uniqueConstraints= {
		@UniqueConstraint(columnNames= {
				"email"
		})
})
public class Student {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=40)
	private String name;
	

	@CreatedDate
    private Instant createdAt;
	
	@NaturalId
	@NotBlank
	@Size(max=40)
	@Email
	private String email;
	

	
    public Student(Long id, @NotBlank @Size(max = 40) String name, Instant createdAt,
			@NotBlank @Size(max = 40) @Email String email) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
