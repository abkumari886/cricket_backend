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

import com.app.entity.Players;
import com.app.service.PlayersService;

@RestController
public class PlayersController {
	
	@Autowired
	private PlayersService service;
	
	@PostMapping("/addPlayer")
	public Players addPlayer(@RequestBody Players player) {
		return service.savePlayers(player);
	
	}
	@PostMapping("/addPlayers")
    public List<Players> addPlayers(@RequestBody List<Players> players) {
		return service.savePlayers(players);
	}
	
	@GetMapping("/players")
	public List<Players> findAllPlayersList(){	
		return service.getPlayers();
	}
	@GetMapping("/player/{id}")
	public Players findPlayersById(@PathVariable int id) {
		return service.getPlayersById(id);
	}
	@GetMapping("/playerByName/{name}")
	public Players findTeamByName(@PathVariable String name) {
		return service.getPlayersByName(name);
	}
	
	@PutMapping("/updatePlayer")
	public Players updatePlayers(@RequestBody Players player) {
		return service.updatePlayers(player);
	}
	
	@DeleteMapping("/deletePlayer/{id}")
	public String deletePlayer(@PathVariable int id) {
		return service.deletePlayer(id);
	}

}
