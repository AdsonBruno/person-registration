package com.api.personregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PersonRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonRegistrationApplication.class, args);
	}


	public String index() {
		return "Olá, mundo!";
	}

}
