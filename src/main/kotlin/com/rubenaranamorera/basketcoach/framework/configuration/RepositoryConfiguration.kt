package com.rubenaranamorera.basketcoach.framework.configuration

import com.rubenaranamorera.basketcoach.framework.repository.PostgresTeamsRepository
import com.rubenaranamorera.basketcoach.framework.repository.TeamRowMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.security.provisioning.JdbcUserDetailsManager
import javax.sql.DataSource

@Configuration
class RepositoryConfiguration(
  private val template: NamedParameterJdbcTemplate
) {

  @Bean
  fun jdbcUserDetailsManager(dataSource: DataSource): JdbcUserDetailsManager = JdbcUserDetailsManager(dataSource)

  @Bean
  fun teamRowMapper() = TeamRowMapper()

  @Bean
  fun teamsRepository(teamRowMapper: TeamRowMapper): PostgresTeamsRepository =
    PostgresTeamsRepository(template, teamRowMapper)
}