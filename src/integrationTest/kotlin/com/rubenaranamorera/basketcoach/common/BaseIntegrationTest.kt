package com.rubenaranamorera.basketcoach.common

import com.rubenaranamorera.basketcoach.BasketCoachApplication
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = [BasketCoachApplication::class])
@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
abstract class BaseIntegrationTest{


  @Autowired
  private lateinit var mvc: MockMvc

  @BeforeEach
  fun setUp() {
    RestAssuredMockMvc.mockMvc(mvc)
  }

}
