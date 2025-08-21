package com.akaenrico.dslist.services;

import com.akaenrico.dslist.dto.GameDTO;
import com.akaenrico.dslist.dto.GameMinDTO;
import com.akaenrico.dslist.entities.Game;
import com.akaenrico.dslist.projections.GameMinProjection;
import com.akaenrico.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long gameListId) {
        List<GameMinProjection> result = gameRepository.searchByList(gameListId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
