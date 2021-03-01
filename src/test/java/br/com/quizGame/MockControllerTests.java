package br.com.quizGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.quizGame.controller.QuizGameController;
import br.com.quizGame.service.QuizGameService;


@WebMvcTest(controllers = QuizGameController.class)
class MockControllerTests {
		
	@MockBean
	private QuizGameService service;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mvc;
	
	
//	@Test
//	public void sholdDeleteAndCreateQuestions() throws Exception {
//	
//		Jogador jogador = new Jogador("jogadorCriado@gmail.com"); 
//		
//		String product = objectMapper.writeValueAsString(jogador);
//		
//		mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/questions/")
//				.contentType("application/json")
//				.content(product))
//			.andExpect(MockMvcResultMatchers.status().isCreated());	
//	}
	
	private void shouldFindAllQuestions() throws Exception  {
		
		mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/questions")
				.contentType("application/json")
				.accept("application/json"))
			.andExpect(MockMvcResultMatchers.status().isOk());	
	}
	
	public void shouldDeleteQuestions() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/questions")
				.contentType("application/json")
				.accept("application/json"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());	
	}
	
}
