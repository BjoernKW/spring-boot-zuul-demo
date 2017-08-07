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
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutingTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		webAppContextSetup(webApplicationContext);
	}

	@Test
	public void testCompanyManagementRouting() throws Exception {
		given()
			.contentType("application/json;charset=UTF-8")
		.when()
			.get("http://localhost:8080/company_management/country-codes")
		.then()
			.statusCode(200)
			.body("size()", equalTo(249))
			.body("get(200).key", equalTo("SXM"));
	}
	
	@Test
	public void testProductTestRouting() throws Exception {
		given()
			.contentType("application/json;charset=UTF-8")
		.when()
			.get("http://localhost:8080/product_test/test-scopes")
		.then()
			.statusCode(200)
			.body("size()", equalTo(5));
	}
}
