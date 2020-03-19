package com.rubenaranamorera.basketcoach.domain.service.security

import com.rubenaranamorera.basketcoach.framework.model.UserRequest
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager


class JwtUserDetailsService(
  private val inMemoryUserDetailsManager: InMemoryUserDetailsManager,
  private val passwordEncoder: PasswordEncoder
) : UserDetailsService {


  fun createUser(userRequest: UserRequest) {
    inMemoryUserDetailsManager.createUser(
      User(
        userRequest.username,
        passwordEncoder.encode(userRequest.password),
        emptyList()
      )
    )
  }

  @Throws(UsernameNotFoundException::class)
  override fun loadUserByUsername(username: String): UserDetails {
    return inMemoryUserDetailsManager.loadUserByUsername(username)
  }
}