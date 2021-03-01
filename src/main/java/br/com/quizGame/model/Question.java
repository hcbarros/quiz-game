package br.com.quizGame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Question {

	@Id
	@GeneratedValue
	private Long id;
			
	@ElementCollection
	private List<String> answers;
	
	private String question;
	
	private String result_answer;
	

	public Question() {
		answers = new ArrayList<>();
	}
	
	public Question(int index) {
		
		answers = new ArrayList<>();
		
		switch (index) {
		case 1:
			answers.addAll(
					Arrays.asList("Set guarda somente valores únicos",
						"Set guarda valores repetidos",
						"Set possui chaves e o Map, não",
						"Map possui o metodo 'add'",
						"Não é possível ordenar valores usando Map")
					);
			question = "Em javascript, qual a diferença entre Set e Map?";
			result_answer = "Set guarda somente valores únicos";
			break;
			
		case 2:
			answers.addAll(
					Arrays.asList("função que se lembra do ambiente — ou escopo léxico — em que ela foi criada.",
						"um framework",
						"uma biblioteca",
						"uma classe",
						"Método estático usado apenas para incrementar números")
					);
			question = "O que é closure em javascript?";
			result_answer = "função que se lembra do ambiente — ou escopo léxico — em que ela foi criada.";
			break;
			
		case 3:
			answers.addAll(
					Arrays.asList("Uma pseudo-classe especifica um estado especial do elemento selecionado.",
						"Um pseudo-elemento especifica um estado especial do elemento selecionado.",
						"Um Uma pseudo-classe permite estilizar uma parte específica do elemento selecionado.",
						"As pseudo-classes são sempre antecedidas por ::",
						"Os pseudo-elementos são sempre antecedidos por :")
					);
			question = "No CSS, qual a diferença entre pseudo-classes e pseudo-elementos?";
			result_answer = "Uma pseudo-classe especifica um estado especial do elemento selecionado.";
			break;
			
		case 4:
			answers.addAll(
					Arrays.asList("<table>, <thead>, <tbody>, <tfoot>, <tr>, <th>, <td>",
						"<table>, <div>, <p>, <a>",
						"<table>, <b>, <span>, <tfoot>",
						"<table>, <tr>, <div>, <p>",
						"<table>, <th>, <a>, <span>")
					);
			question = "Quais tags HTML são usadas para exibir os dados na forma tabular?";
			result_answer = "<table>, <thead>, <tbody>, <tfoot>, <tr>, <th>, <td>";
			break;
			
		case 5:
			answers.addAll(
					Arrays.asList("Flexbox é unidimensional, ou seja, linha ou coluna.",
						"CSS Grid é unidimensional, ou seja, linha ou coluna.",
						"Flexbox é multidimensional, ou seja, linhas E colunas",
						"Não é possível centralizar elementos usando Flexbox",
						"Não é possível adicionar espaços entre elementos usando Flexbox")
					);
			question = "Qual a principal diferença entre CSS Grid e Flexbox?";
			result_answer = "Flexbox é unidimensional, ou seja, linha ou coluna.";
			break;	

		default:
			break;
		}
		
		Collections.shuffle(answers);
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<String> getAnswers() {
		return answers;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setResultAnswer(String result_answer) {
		this.result_answer = result_answer;
	}
	
	public String getResultAnswer() {
		return result_answer;
	}
	
}
