package br.com.quizGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.quizGame.model.Question;
import br.com.quizGame.service.QuizGameService;


@RestController
@Validated
@RequestMapping("/questions")
public class QuizGameController {

	@Autowired
	private QuizGameService service;	
	
	@GetMapping
	public List<Question> findQuestions() {
		return service.findQuestions();		
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAndSave() {
		service.deleteAndSave();
	}
		
}


