package br.com.quizGame;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.quizGame.controller.QuizGameController;
import br.com.quizGame.service.QuizGameService;


@WebMvcTest(controllers = QuizGameController.class)
class MockControllerTests {
		
	@MockBean
	private QuizGameService service;
	
	@Autowired
	private MockMvc mvc;
	

	@Test
	@Order(4)
	private void shouldFindAllQuestions() throws Exception  {
		
		mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/questions")
				.contentType("application/json")
				.accept("application/json"))
			.andExpect(MockMvcResultMatchers.status().isOk());	
	}
	
	@Test
	@Order(5)
	public void shouldDeleteQuestions() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/questions")
				.contentType("application/json")
				.accept("application/json"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());	
	}
	
}
