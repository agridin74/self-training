package com.example.simpleapp;





import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.simpleapp.model.Book;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


 

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootBootstrapLiveTest {
	
	@LocalServerPort
	private int port;
	private String API_ROOT;
	
	@BeforeEach
	public void setUp() {
		API_ROOT ="http://localhost:" + port + "/api/books";
		RestAssured.port = port;
		
	}
	
	private Book createRandomBook() {
		final Book book = new Book();
		book.setTitle( RandomStringUtils.secure().next(10));
		book.setAuthor(RandomStringUtils.secure().next(15));
        return book;
		
	}
	
	 private String createBookAsUri(Book book) {
	        final Response response = RestAssured.given()
	          .contentType(MediaType.APPLICATION_JSON_VALUE)
	          .body(book)
	          .post(API_ROOT);
	        return API_ROOT + "/" + response.jsonPath().get("id");
	    }

	 @Test
	 public void whenGetAllBooks_thenOK() {
		 Response response = RestAssured.get(API_ROOT);
		 assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	 }
	 
	 @Test
	 public void whenGetBooksByTitle_thenOK() {
		 Book book = createRandomBook();
		 createBookAsUri(book);
		 Response response = RestAssured.get(API_ROOT + "/title/"+book.getTitle());
		 assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		System.out.println("Response : " + response.asString());
		System.out.println("Status Code : " + response.getStatusCode());
		
		//Создание объекта JsonPath  
		JsonPath jsonPathValidator = response.jsonPath();
		//1.Печать списка из ответа  response
		System.out.println("ID : \n" + jsonPathValidator.get("id"));
		//кол-во записей в ответе
		List<String> jsonResponseRoot = jsonPathValidator.getList("$");
		System.out.println("Количество книг : " + jsonResponseRoot.size());
		// получить список наименований
		List<String> allTitles = jsonPathValidator.getList("title");
		System.out.println("\n all Title : \n");
		for(String i : allTitles ) {
			System.out.println(i);
		}
		
		System.out.println("INT " + Integer.parseInt(jsonPathValidator.getString("id[0]"))   );
		  
		
	 }
	 
	 @Test
	 public void whenGetCreatedBookId_thenOK() {
		 Book book = createRandomBook();
		 String location = createBookAsUri(book);
		 Response response = RestAssured.get(location);
		 
		 assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		 assertEquals(book.getTitle(), response.jsonPath().get("title"));
	 }
	 
	 @Test
	 public void whenGetNotExistBookById_thenNotFound() {
		 Response response = RestAssured.get(API_ROOT + "/" + new Random().nextInt(4));
		 
		 assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	 }
	 
	 @Test
	 public void whenCreteNewBook_thenCreated() {
		 Book book = createRandomBook();
		 Response response = RestAssured.given()
				 .contentType(MediaType.APPLICATION_JSON_VALUE)
				 .body(book)
				 .post(API_ROOT);
		 assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
	 }
	 
	 @Test
	 public void whenInvalidBook_thenError() {
		 Book book = createRandomBook();
		 book.setAuthor(null);
		 Response response = RestAssured.given()
				 .contentType(MediaType.APPLICATION_JSON_VALUE)
				 .body(book)
				 .post(API_ROOT);
		 assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());

	 }
	 
	 @Test
	 public void whenUpdateCreatedBook_thenUpdated() {
		 Book book = createRandomBook();
		 String location = createBookAsUri(book);
		 book.setId(Long.parseLong(location.split("api/books/")[1]));
		    book.setAuthor("newAuthor");
		    Response response = RestAssured.given()
		      .contentType(MediaType.APPLICATION_JSON_VALUE)
		      .body(book)
		      .put(location);
		    System.out.println("--- "+response.getStatusCode());
		    assertEquals(HttpStatus.OK.value(), response.getStatusCode());

		    response = RestAssured.get(location);
		    
		    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		    assertEquals("newAuthor", response.jsonPath()
		      .get("author"));
		}
	 
	 @Test
	 public void whenDeleteCreatedBook_thenOk() {
	     Book book = createRandomBook();
	     String location = createBookAsUri(book);
	     Response response = RestAssured.delete(location);
	     
	     assertEquals(HttpStatus.OK.value(), response.getStatusCode());

	     response = RestAssured.get(location);
	     assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	 }
}
