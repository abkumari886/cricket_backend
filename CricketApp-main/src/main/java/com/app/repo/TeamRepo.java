package com.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {

	Optional<Team> findByName(String name);

}
