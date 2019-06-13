package com.sms.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="tests", uniqueConstraints= {
		@UniqueConstraint(columnNames= {
				"name"
		})
})
public class Test {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=40)
	private String name;
	
	@NotBlank
	@Size(max=40)
	private String description;
	
	private Boolean isActive;
	
	private long durationInMin;
	
	
	

	public Test(Long id, @NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 40) String description,
			Boolean isActive, long durationInMin) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
		this.durationInMin = durationInMin;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public long getDurationInMin() {
		return durationInMin;
	}

	public void setDurationInMin(long durationInMin) {
		this.durationInMin = durationInMin;
	} 
	
	
	

}
