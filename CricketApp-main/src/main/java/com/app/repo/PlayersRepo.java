package com.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Players;


public interface PlayersRepo extends JpaRepository<Players, Integer> {

	Optional<Players> findByName(String name);

}
