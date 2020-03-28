package com.rubenaranamorera.basketcoach.domain.service.security

import com.rubenaranamorera.basketcoach.domain.model.Role
import com.rubenaranamorera.basketcoach.domain.model.Role.COACH
import com.rubenaranamorera.basketcoach.framework.model.UserRequest
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager


class JwtUserDetailsService(
  private val userDetailsManager: JdbcUserDetailsManager,
  private val passwordEncoder: PasswordEncoder
) : UserDetailsService {


  fun createUser(userRequest: UserRequest) {
    userDetailsManager.createUser(
      User(
        userRequest.username,
        passwordEncoder.encode(userRequest.password),
        mutableListOf(SimpleGrantedAuthority("COACH"))
      )
    )
  }

  @Throws(UsernameNotFoundException::class)
  override fun loadUserByUsername(username: String): UserDetails {
    return userDetailsManager.loadUserByUsername(username)
  }
}