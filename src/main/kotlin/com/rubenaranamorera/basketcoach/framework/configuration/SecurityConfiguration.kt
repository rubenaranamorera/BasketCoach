package com.rubenaranamorera.basketcoach.framework.configuration

import com.rubenaranamorera.basketcoach.domain.service.security.JwtAuthenticationEntryPoint
import com.rubenaranamorera.basketcoach.domain.service.security.JwtRequestFilter
import com.rubenaranamorera.basketcoach.domain.service.security.JwtTokenUtil
import com.rubenaranamorera.basketcoach.domain.service.security.JwtUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SecurityConfiguration {

  @Bean
  fun jwtTokenUtil(): JwtTokenUtil = JwtTokenUtil()

  @Bean
  fun jwtUserDetailsService(): JwtUserDetailsService = JwtUserDetailsService()

  @Bean
  fun jwtRequestFilter(jwtUserDetailsService: JwtUserDetailsService, jwtTokenUtil: JwtTokenUtil): JwtRequestFilter =
    JwtRequestFilter(jwtUserDetailsService, jwtTokenUtil)

  @Bean
  fun jwtAuthenticationEntryPoint(): JwtAuthenticationEntryPoint = JwtAuthenticationEntryPoint()

}