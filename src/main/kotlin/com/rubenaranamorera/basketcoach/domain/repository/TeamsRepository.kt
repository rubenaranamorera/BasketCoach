package com.rubenaranamorera.basketcoach.domain.repository

import com.rubenaranamorera.basketcoach.domain.model.Team

interface TeamsRepository {
  fun obtainAll(): List<Team>
}