package com.rubenaranamorera.basketcoach.common

import com.rubenaranamorera.basketcoach.BasketCoachApplication
import io.restassured.RestAssured
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = [BasketCoachApplication::class])
@ExtendWith(SpringExtension::class, RestAssuredExtension::class)
@ActiveProfiles("test")
abstract class BaseIntegrationTest

class RestAssuredExtension : BeforeAllCallback {
  override fun beforeAll(context: ExtensionContext) {
    val appContext = SpringExtension.getApplicationContext(context)
    RestAssured.port = appContext.environment.getProperty("local.server.port")
      ?.toInt()
      ?: throw IllegalArgumentException("No 'local.server.port' property was found")
  }
}
