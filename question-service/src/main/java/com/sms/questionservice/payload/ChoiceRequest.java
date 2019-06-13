package com.sms.questionservice.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChoiceRequest {
	
	  @NotBlank
	    @Size(max = 40)
	    private String label;
	    
	    private int points;
		
		private boolean isActive;

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
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
