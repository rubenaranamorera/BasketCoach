package com.rubenaranamorera.basketcoach.framework.model

import com.rubenaranamorera.basketcoach.domain.model.Team

data class TeamDto(val id: Int, val name: String, val club: String, val players: List<PlayerDto>) {
  constructor(team: Team) :
    this(
      id = team.id,
      name = team.name,
      club = team.club,
      players = team.players.map { player -> PlayerDto(player) }) {
  }
}


