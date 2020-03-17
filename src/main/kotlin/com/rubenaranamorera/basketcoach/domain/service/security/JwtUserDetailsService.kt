package com.rubenaranamorera.basketcoach.domain.service.security

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException


class JwtUserDetailsService : UserDetailsService {

  @Throws(UsernameNotFoundException::class)
  override fun loadUserByUsername(username: String): UserDetails {
    return if ("javainuse" == username) {
      User("javainuse", "$2a$10\$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", emptyList())
    } else {
      throw UsernameNotFoundException("User not found with username: $username")
    }
  }
}