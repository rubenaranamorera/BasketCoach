package com.rubenaranamorera.basketcoach.framework.repository

import com.rubenaranamorera.basketcoach.domain.model.Team
import com.rubenaranamorera.basketcoach.domain.repository.TeamsRepository
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import java.sql.ResultSet

class PostgresTeamsRepository(
  private val jdbcTemplate: NamedParameterJdbcTemplate,
  private val teamMapper: RowMapper<Team>
) : TeamsRepository {


  override fun obtainAll(): List<Team> {
    return jdbcTemplate.query("select * from teams", emptyMap<String, String>(), teamMapper)
  }

}


class TeamRowMapper : RowMapper<Team> {

  override fun mapRow(rs: ResultSet, rowNum: Int) =
    Team(
      id = rs.getInt("id"),
      name = rs.getString("name"),
      club = rs.getString("club_name"),
      players = emptyList(),
      createdAt = rs.getTimestamp("created_at")?.toInstant(),
      updatedAt = rs.getTimestamp("updated_at")?.toInstant()
    )
}
