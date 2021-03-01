package br.com.quizGame.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.quizGame.service.QuizGameService;

@Configuration
@Profile("prod")
public class DataLoader {
	
	@Autowired
	private QuizGameService service;
		
	@Bean
	CommandLineRunner baseLoad() {
		 
		return args -> {
			
			service.save();					
		};
	}

}
