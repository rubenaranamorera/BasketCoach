package com.rubenaranamorera.basketcoach.domain.service.security

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtRequestFilter(
  private val jwtUserDetailsService: JwtUserDetailsService,
  private val jwtTokenUtil: JwtTokenUtil
) : OncePerRequestFilter() {

  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

    val jwtToken: String? = obtainJwtTokenFromRequest(request)
    val username = jwtToken?.let { obtainUserNameFromJwt(it) }

    username?.let {

      if (SecurityContextHolder.getContext().authentication == null) {
        val userDetails = jwtUserDetailsService.loadUserByUsername(it)
        if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
          val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
            userDetails,
            null,
            userDetails.authorities
          )
          usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
          SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
        }
      }
    }

    chain.doFilter(request, response)
  }

  private fun obtainUserNameFromJwt(jwtToken: String?) = jwtTokenUtil.getUsernameFromToken(jwtToken)

  private fun obtainJwtTokenFromRequest(request: HttpServletRequest): String? =
    request.getHeader("Authorization")?.let {
      if (it.startsWith("Bearer ")) {
        return it.substring(7)
      }
      return null
    }
}