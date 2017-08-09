package com.bjoernkw.demos.zuul;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilterTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		webAppContextSetup(webApplicationContext);
	}

	@Test
	public void testServletResponseHeader() throws Exception {
		given()
			.contentType("application/json;charset=UTF-8")
		.when()
			.get("http://localhost:8080/company_management/country-codes")
		.then()
			.statusCode(200)
			.header("Test-Servlet-Response-Header", "Test servlet response header");
	}

	@Test
	public void testZuulResponseHeader() throws Exception {
		given()
			.contentType("application/json;charset=UTF-8")
		.when()
			.get("http://localhost:8080/company_management/country-codes")
		.then()
			.statusCode(200)
			.header("Zuul-Test-Response-Header", "Zuul test response header");
	}
}
