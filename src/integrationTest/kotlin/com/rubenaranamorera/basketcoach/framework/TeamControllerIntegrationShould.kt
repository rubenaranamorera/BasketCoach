package com.rubenaranamorera.basketcoach.framework

import com.rubenaranamorera.basketcoach.common.BaseIntegrationTest
import io.restassured.http.Header
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class TeamControllerIntegrationShould : BaseIntegrationTest() {

  @Test
  fun `return teams without authentication`() {
    given()
      .`when`()
      .get("/teams")
      .then()
      .assertThat(status().isOk)
  }

  @Test
  fun `fail getting a team without authentication`() {
    given()
      .`when`()
      .get("/teams/0")
      .then()
      .assertThat(status().isUnauthorized)
  }

  @Test
  fun `return a team with authentication`() {
    given()
      .header(Header("Authorization", "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE1ODQ1ODAwMzEsImlhdCI6MTU4NDU2MjAzMX0.sItPj_xLfaUuFjZtfR8hsKQcunmZ-UQE4ZTGMFVjHluMG_eFK7PxjvUUlzhGUyaW56AadzVYLmKT7-G0O2RBKQ"))
      .`when`()
      .get("/teams/0")
      .then()
      .assertThat(status().isOk)
  }
}