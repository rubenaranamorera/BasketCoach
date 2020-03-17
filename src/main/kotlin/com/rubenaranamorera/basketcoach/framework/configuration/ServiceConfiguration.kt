package com.rubenaranamorera.basketcoach.framework.configuration

import com.rubenaranamorera.basketcoach.domain.service.TeamService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServiceConfiguration {

  @Bean
  fun teamService(): TeamService {
    return TeamService()
  }
}