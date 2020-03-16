package com.rubenaranamorera.basketcoach

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
  scanBasePackages = [
    "com.rubenaranamorera.basketcoach.framework.controller",
    "com.rubenaranamorera.basketcoach.framework.configuration"
  ]
)
class BasketCoachApplication

fun main(args: Array<String>) {
  runApplication<BasketCoachApplication>(*args)
}
