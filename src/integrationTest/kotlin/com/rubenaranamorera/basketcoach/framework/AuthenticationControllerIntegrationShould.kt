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
      .body("{\"username\":\"javainuse\",\"password\":\"password\"}")
      .`when`()
      .post("/authenticate")
      .then()
      .assertThat(status().isOk)
  }
}