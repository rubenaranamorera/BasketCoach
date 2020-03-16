package com.rubenaranamorera.basketcoach.framework.model

import com.rubenaranamorera.basketcoach.domain.model.Player

class PlayerDto(val id: Int, val name: String, val teamId: Int) {
  constructor(player: Player) : this(
    id = player.id,
    name = player.name,
    teamId = player.teamId
  )
}
