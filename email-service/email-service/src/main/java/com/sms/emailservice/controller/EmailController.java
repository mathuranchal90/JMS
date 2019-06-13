package com.sms.emailservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmailController {
	
	@GetMapping("/Greeting")
	public String getMessage() {
		try {
			return "Hello World";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
	}
	
	@GetMapping("/Meeting")
	public String getMessage1() {
		try {
			return "Hello Meeting";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
	}

}
