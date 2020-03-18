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


  @Test
  fun `cors test2`() {
    given()
      .contentType(ContentType.JSON)
      .header("Access-Control-Request-Method", "POST")
      .header("Origin", "http://localhost:3000")
      .header("Referer", "http://localhost:3000/login")
      .header("Sec-Fetch-Dest", "empty")
      .header("Sec-Fetch-Mode", "cors")
      .header("Sec-Fetch-Site", "same-site")
      .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36")
      .header("Accept-Encoding", "gzip, deflate, br")
      .header("Accept-Language", "es-ES,es;q=0.9,en;q=0.8")
      .header("Connection", "keep-alive")
      .body("{\"username\":\"javainuse\",\"password\":\"password\"}")
      .`when`()
      .post("/authenticate")
      .then()
      .assertThat(status().isOk)
  }
}