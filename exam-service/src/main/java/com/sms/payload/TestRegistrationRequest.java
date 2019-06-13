package com.sms.payload;



import javax.validation.constraints.NotBlank;


public class TestRegistrationRequest {
	
	@NotBlank
	private Long student_id;
	
	@NotBlank
	private Long test_id;
	
	

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
	}

	
	
	
	

}
