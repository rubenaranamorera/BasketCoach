package com.rubenaranamorera.basketcoach.framework

import com.rubenaranamorera.basketcoach.common.BaseIntegrationTest
import com.rubenaranamorera.basketcoach.framework.controller.TeamController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class TeamControllerIntegrationShould : BaseIntegrationTest() {

  @Autowired
  lateinit var teamController: TeamController

  @Test
  fun `return teams`() {

    teamController.obtainTeams()
    /*RestAssuredMockMvc
      .`when`()
      .get("/teams")
      .then()
      .assertThat().statusCode(SC_OK)^^/
     */

  }
}