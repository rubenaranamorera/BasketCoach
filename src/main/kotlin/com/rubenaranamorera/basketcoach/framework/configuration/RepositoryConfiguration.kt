package com.rubenaranamorera.basketcoach.framework.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
class RepositoryConfiguration {

  @Bean
  fun inMemoryUserDetailManager(): InMemoryUserDetailsManager = InMemoryUserDetailsManager()

}