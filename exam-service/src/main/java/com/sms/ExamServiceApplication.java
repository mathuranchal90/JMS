package com.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;


@EnableSwagger2
@SpringBootApplication
public class ExamServiceApplication {
	
	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Exam").select()
                .apis(RequestHandlerSelectors.basePackage("com.sms"))
                .paths(any()).build().apiInfo(new ApiInfo("Exam Services",
                        "A set of services to provide data access to rooms", "1.0.0", null,
                        new Contact("Anchal Mathur", "https://www.linkedin.com/in/anchal-mathur-1007931b/", null),null, null));
    }

	public static void main(String[] args) {
		SpringApplication.run(ExamServiceApplication.class, args);
	}

}
