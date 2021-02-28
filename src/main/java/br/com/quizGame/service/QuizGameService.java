package br.com.quizGame.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quizGame.model.Question;
import br.com.quizGame.repository.QuizGameRepository;


@Service
public class QuizGameService {

	@Autowired
	private QuizGameRepository repository;
			
	
	public List<Question> save() {
				
		List<Question> listQuestions = Arrays.asList(
				new Question(1),new Question(2),new Question(3),new Question(4),new Question(5)
				);
		Collections.shuffle(listQuestions);
		return repository.saveAll(listQuestions);
	}
	
	
	public List<Question> findQuestions() {
		
		return repository.findAll();
	}
		
	public Question findQuestionById(Long id) {
		
		return repository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
	}		
		
	public void deleteAll() {
		repository.deleteAll();
		save();
	}
	
}
