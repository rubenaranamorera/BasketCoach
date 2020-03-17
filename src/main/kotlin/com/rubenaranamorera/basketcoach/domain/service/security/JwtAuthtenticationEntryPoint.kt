package com.rubenaranamorera.basketcoach.domain.service.security

import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import java.io.Serializable
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JwtAuthenticationEntryPoint : AuthenticationEntryPoint, Serializable {

  override fun commence(
    request: HttpServletRequest,
    response: HttpServletResponse,
    authException: AuthenticationException
  ) {
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
  }
}
