package com.rubenaranamorera.basketcoach.framework.configuration

import com.rubenaranamorera.basketcoach.domain.service.security.JwtAuthenticationEntryPoint
import com.rubenaranamorera.basketcoach.domain.service.security.JwtRequestFilter
import com.rubenaranamorera.basketcoach.domain.service.security.JwtTokenUtil
import com.rubenaranamorera.basketcoach.domain.service.security.JwtUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager

@Configuration
class SecurityConfiguration {

  @Bean
  fun jwtTokenUtil(): JwtTokenUtil = JwtTokenUtil()

  @Bean
  fun jwtUserDetailsService(
    jdbcUserDetailsManager: JdbcUserDetailsManager,
    passwordEncoder: PasswordEncoder
  ): JwtUserDetailsService = JwtUserDetailsService(jdbcUserDetailsManager, passwordEncoder)

  @Bean
  fun jwtRequestFilter(jwtUserDetailsService: JwtUserDetailsService, jwtTokenUtil: JwtTokenUtil): JwtRequestFilter =
    JwtRequestFilter(jwtUserDetailsService, jwtTokenUtil)

  @Bean
  fun jwtAuthenticationEntryPoint(): JwtAuthenticationEntryPoint = JwtAuthenticationEntryPoint()


}