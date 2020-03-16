package com.rubenaranamorera.basketcoach.framework.controller

import com.rubenaranamorera.basketcoach.domain.service.TeamService
import com.rubenaranamorera.basketcoach.framework.model.TeamDto
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class TeamController(private val teamService: TeamService) {

  @GetMapping("/teams/{id}")
  @CrossOrigin
  fun obtainTeam(@PathVariable id: String): TeamDto {
    return TeamDto(teamService.obtainTeam(id))
  }

  @GetMapping("/teams")
  @CrossOrigin
  fun obtainTeams(): List<TeamDto> {
    return teamService.obtainAllTeams().map { team -> TeamDto(team) }
  }
}
