package br.com.quizGame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.quizGame.model.Question;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GameStoreApplicationTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	@Order(1)
	public void mainTest() {
	    QuizGameApiApplication.main(new String[] {});
	}	
	
	
	@Test
	@Order(2)
    public void shouldFindAllQuestions() {
				
		List<Question> list = getQuestions();
		assertEquals(list.size(), 5);
	}
	
	@Test
	@Order(3)
    public void shouldDeleteQuestions() {
			
		List<Question> list = getQuestions();
		
		this.restTemplate
			.delete("http://localhost:" + port + "/questions");
		
		List<Question> list2 = getQuestions();
		
		assertNotEquals(list, list2);
	}

	private List<Question> getQuestions() {

		return this.restTemplate
				.getForEntity("http://localhost:" + port + "/questions", List.class)
				.getBody();		 
	}
	
	
}
