package org.acme;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.acme.entity.Person;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
class ExampleResourceTest {

  @Test
  void testHelloEndpoint() {
    given().when().get("/hello").then().statusCode(200).body(is("Hello RESTEasy"));
  }

  @Test
  void testGreetingEndpoint() {
    given().when().get("/hello/greeting/{name}", "Dp").then().statusCode(200).body(is("hello Dp"));
  }

  /*@Test
  void testSavePersonEndpoint() {

    Person person = new Person();
    person.setId(1L);

    given().contentType(ContentType.JSON).body(person).when().post("/hello/person").then().statusCode(204);
  }*/

}