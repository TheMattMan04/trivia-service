package com.myorg.triviaservice;

import com.myorg.triviaservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TriviaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriviaServiceApplication.class, args);
	}

}
