package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Team;
import com.app.service.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	private TeamService service;
	
	@PostMapping("/addTeam")
	public Team addTeam(@RequestBody Team team) {
		return service.saveTeam(team);
	
	}
	@PostMapping("/addTeams")
    public List<Team> addTeams(@RequestBody List<Team> teams) {
		return service.saveTeams(teams);
	}
	
	@GetMapping("/teams")
	public List<Team> findAllTeamsList(){	
		return service.getTeams();
	}
	@GetMapping("/team/{id}")
	public Team findTeamById(@PathVariable int id) {
		return service.getTeamById(id);
	}
	@GetMapping("/teamByName/{name}")
	public Team findTeamByName(@PathVariable String name) {
		return service.getTeamByName(name);
	}
	
	@PutMapping("/updateTeam")
	public Team updateTeam(@RequestBody Team team) {
		return service.updateTeam(team);
	}
	
	@DeleteMapping("/deleteTeam/{id}")
	public String deleteTeam(@PathVariable int id) {
		return service.deleteTeam(id);
	}
}
