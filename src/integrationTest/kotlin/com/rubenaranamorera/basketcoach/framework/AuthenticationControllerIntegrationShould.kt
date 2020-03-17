package com.rubenaranamorera.basketcoach.framework

import com.rubenaranamorera.basketcoach.common.BaseIntegrationTest
import com.rubenaranamorera.basketcoach.framework.model.JwtRequest
import com.rubenaranamorera.basketcoach.framework.controller.AuthenticationController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class AuthenticationControllerIntegrationShould : BaseIntegrationTest() {

  @Autowired
  lateinit var authenticationController: AuthenticationController

  @Test
  fun `authenticate`() {

    authenticationController.createAuthenticationToken(JwtRequest("javainuse", "password"))
    // given().`when`().post("/auhtenticate").then().assertThat().statusCode(SC_OK)

  }
}