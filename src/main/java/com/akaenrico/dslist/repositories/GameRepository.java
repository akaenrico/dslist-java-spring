package com.akaenrico.dslist.repositories;

import com.akaenrico.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
