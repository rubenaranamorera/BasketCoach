package com.rubenaranamorera.basketcoach.framework.controller

import com.rubenaranamorera.basketcoach.domain.service.security.JwtTokenUtil
import com.rubenaranamorera.basketcoach.domain.service.security.JwtUserDetailsService
import com.rubenaranamorera.basketcoach.framework.model.JwtRequest
import com.rubenaranamorera.basketcoach.framework.model.JwtResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthenticationController(
  private val authenticationManager: AuthenticationManager,
  private val jwtTokenUtil: JwtTokenUtil,
  private val userDetailsService: JwtUserDetailsService) {


  @PostMapping("/authenticate")
  fun createAuthenticationToken(@RequestBody authRequest: JwtRequest): ResponseEntity<JwtResponse> {
    authenticate(authRequest.username, authRequest.password)
    val userDetails = userDetailsService.loadUserByUsername(authRequest.username)
    val token = jwtTokenUtil.generateToken(userDetails)
    println(token)
    return ResponseEntity.ok(JwtResponse(token))
  }

  private fun authenticate(username: String, password: String) {
    try {
      authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))
    } catch (e: DisabledException) {
      throw Exception("USER_DISABLED", e)
    } catch (e: BadCredentialsException) {
      throw Exception("INVALID_CREDENTIALS", e)
    }
  }
}
