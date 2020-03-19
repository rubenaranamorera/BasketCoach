package com.rubenaranamorera.basketcoach.framework.configuration

import com.rubenaranamorera.basketcoach.domain.service.TeamService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class ServiceConfiguration {

  @Bean
  fun teamService(): TeamService {
    return TeamService()
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}