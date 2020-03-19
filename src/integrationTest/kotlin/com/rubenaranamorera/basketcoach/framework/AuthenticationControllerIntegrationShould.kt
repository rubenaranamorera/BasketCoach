package com.rubenaranamorera.basketcoach.framework

import com.rubenaranamorera.basketcoach.common.BaseIntegrationTest
import io.restassured.http.ContentType
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class AuthenticationControllerIntegrationShould : BaseIntegrationTest() {

  @Test
  fun `return a jwt when authenticate with valid username and password`() {

    given()
      .contentType(ContentType.JSON)
      .body("{\"username\":\"admin\",\"password\":\"admin\"}")
      .`when`()
      .post("/signup")
      .then()
      .assertThat(status().isOk)

    given()
      .contentType(ContentType.JSON)
      .body("{\"username\":\"admin\",\"password\":\"admin\"}")
      .`when`()
      .post("/authenticate")

      .then()
      .assertThat(status().isOk)
  }


  @Test
  fun `cors test`() {
    given()
      .contentType(ContentType.JSON)
      .header("Access-Control-Request-Method", "POST")
      .header("Origin", "http://localhost:3000")
      .`when`()
      .options("/authenticate")
      .then()
      .assertThat(status().isOk)
  }
}