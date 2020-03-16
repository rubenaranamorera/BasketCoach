package com.rubenaranamorera.basketcoach.domain.service

import com.rubenaranamorera.basketcoach.domain.model.Player
import com.rubenaranamorera.basketcoach.domain.model.Team

class TeamService {

  fun obtainTeam(id: String): Team {
    return Team(id = 0, name = "test", club = "cic", players = listOf(Player(id = 0, teamId = 0, name = "myplayer")))
  }

  fun obtainAllTeams(): List<Team> {
    return listOf(Team(id = 0, name = "test", club = "cic", players = listOf(Player(id = 0, teamId = 0, name = "myplayer"))))
  }

}
