package com.rubenaranamorera.basketcoach.domain.model

import java.time.Instant

data class Team(
  val id: Int,
  val name: String,
  val club: String,
  val players: List<Player>,
  val createdAt: Instant?,
  val updatedAt: Instant?
)
