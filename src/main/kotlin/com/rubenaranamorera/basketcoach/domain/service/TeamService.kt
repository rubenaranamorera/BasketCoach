package com.rubenaranamorera.basketcoach.domain.service

import com.rubenaranamorera.basketcoach.domain.model.Player
import com.rubenaranamorera.basketcoach.domain.model.Team
import com.rubenaranamorera.basketcoach.domain.repository.TeamsRepository
import java.time.Instant.now

class TeamService(private val teamsRepository: TeamsRepository) {

  fun obtainTeam(id: String): Team {
    print(id)
    return seniorAStub()
  }

  fun obtainAllTeams(): List<Team> {
    return teamsRepository.obtainAll()
  }

  private fun seniorBStub(): Team {
    return Team(
      id = 1,
      name = "Senior B Femení",
      club = "CB CIC",
      players = listOf(
        Player(id = 6, teamId = 1, name = "Ari"),
        Player(id = 7, teamId = 1, name = "Yuyu"),
        Player(id = 8, teamId = 1, name = "Maria"),
        Player(id = 9, teamId = 1, name = "Tresa"),
        Player(id = 10, teamId = 1, name = "Miralles"),
        Player(id = 11, teamId = 1, name = "Paula")
      ),
      createdAt = now(),
      updatedAt = now()
    )
  }

  private fun seniorAStub(): Team {
    return Team(
      id = 0,
      name = "Senior A Femení",
      club = "CB CIC",
      players = listOf(
        Player(id = 0, teamId = 0, name = "Bego Hervás"),
        Player(id = 1, teamId = 0, name = "Laia"),
        Player(id = 2, teamId = 0, name = "Marta"),
        Player(id = 3, teamId = 0, name = "Adri"),
        Player(id = 4, teamId = 0, name = "Núria"),
        Player(id = 5, teamId = 0, name = "Cris")
      ),
      createdAt = now(),
      updatedAt = now()
    )
  }

}
