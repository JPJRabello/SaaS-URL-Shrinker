package org.jpjr.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest

public class GetUrlResourceTest {
  @Test
  void testGetShortenedEndpoint() {
    given()
        .redirects().follow(false)
      .when().get("/01")
      .then()
        .statusCode(302);
  }
}
