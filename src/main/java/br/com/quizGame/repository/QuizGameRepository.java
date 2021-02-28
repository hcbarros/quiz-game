package br.com.quizGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quizGame.model.Question;

public interface QuizGameRepository extends JpaRepository<Question, Long> {
	
}