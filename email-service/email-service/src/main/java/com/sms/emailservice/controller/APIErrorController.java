package com.sms.emailservice.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import javax.servlet.RequestDispatcher;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class APIErrorController implements ErrorController {
	
	
	 public APIErrorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@GetMapping(value = "/error")
	    public String handleError(HttpServletRequest request) {
	        
	        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

	        if (status != null) {
	        
	            Integer statusCode = Integer.valueOf(status.toString());

	            if(statusCode == HttpStatus.NOT_FOUND.value()) {
	                return "error-404";
	            }
	            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	                return "error-500";
	            }
	        }
	        return "error";
	    }

	    @Override
	    public String getErrorPath() {
	        return "/error";
	    }


}
