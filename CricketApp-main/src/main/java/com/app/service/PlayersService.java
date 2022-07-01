package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Players;
import com.app.repo.PlayersRepo;

@Service
public class PlayersService {
	
	@Autowired
	private PlayersRepo repo;
	
	public Players savePlayers(Players player) {
		
		return repo.save(player);
	}
	
    public List<Players> savePlayers(List<Players> player) {	
		return repo.saveAll(player);
	}

    public List<Players> getPlayers(){	
    	return repo.findAll();
    }
    
    public Players getPlayersById(int id){	
   	return repo.findById(id).orElse(null);
    }
    public Players getPlayersByName(String name){	
   	return repo.findByName(name).orElse(null);

   }
    
    public String deletePlayer(int id) {
    	repo.deleteById(id);
    	return "Player removed !!" + id;
    }
    
    public Players updatePlayers(Players player) {
    	Players existing_player = repo.findById(player.getId()).orElse(null);
    	existing_player.setId(player.getId());
    	existing_player.setName(player.getName());
    	existing_player.setGuardian_name(player.getGuardian_name());
    	existing_player.setDob(player.getDob());
    	existing_player.setPhoto(player.getPhoto());
    	existing_player.setTeam_name(player.getTeam_name());
    	existing_player.setAddress(player.getAddress());
    	existing_player.setPlayer_type(player.getPlayer_type());
    	existing_player.setRanking(player.getRanking());
    	
    	return repo.save(existing_player) ;
    }

	
    }


