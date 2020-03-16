package com.rubenaranamorera.basketcoach.domain.model

data class Team(val id: Int, val name: String, val club: String, val players: List<Player>)
