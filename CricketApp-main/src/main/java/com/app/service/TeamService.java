package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Team;
import com.app.repo.TeamRepo;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepo repo;
	
	public Team saveTeam(Team team) {
		
		return repo.save(team);
	}
	
    public List<Team> saveTeams(List<Team> teams) {	
		return repo.saveAll(teams);
	}

    public List<Team> getTeams(){	
    	return repo.findAll();
    }
    
    public Team getTeamById(int id){	
    	return repo.findById(id).orElse(null);
    }
    
    public Team getTeamByName(String name){	
    	return repo.findByName(name).orElse(null);
    }
    
    public String deleteTeam(int id) {
    	repo.deleteById(id);
    	return "Team removed !!" + id;
    }
    
    public Team updateTeam(Team team) {
    	Team existingTeam = repo.findById(team.getId()).orElse(null);
            existingTeam.setId(team.getId());
            existingTeam.setName(team.getName());
            existingTeam.setCode(team.getCode());
            existingTeam.setDescription(team.getDescription());
            existingTeam.setJersy(team.getJersy());
            existingTeam.setFlage(team.getFlage());
            existingTeam.setCoach(team.getCoach());
            existingTeam.setPosition(team.getPosition());
            existingTeam.setRating(team.getRating());
            existingTeam.setMatches(team.getMatches());
            existingTeam.setWin(team.getWin());
            existingTeam.setLose(team.getLose());
    	return repo.save(existingTeam);
    }
    
    
    
}
