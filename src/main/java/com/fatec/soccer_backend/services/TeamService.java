package com.fatec.soccer_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fatec.soccer_backend.dto.TeamRequest;
import com.fatec.soccer_backend.entities.TeamEntity;
import com.fatec.soccer_backend.repository.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    // 🔥 SAVE
    public TeamEntity save(TeamRequest request) {

        validatePlayers(request.playerQuantity());
        validateFifaCode(request.fifaCode(), null);

        TeamEntity entity = new TeamEntity();
        entity.setCountry(request.country());
        entity.setFifaCode(request.fifaCode());
        entity.setCoach(request.coach());
        entity.setPlayerQuantity(request.playerQuantity());

        return repository.save(entity);
    }

    // 🔥 FIND ALL
    public List<TeamEntity> findAll() {
        return repository.findAll();
    }

    // 🔥 FIND BY ID
    public TeamEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team not found"));
    }

    // 🔥 DELETE
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // 🔥 UPDATE
    public TeamEntity update(Long id, TeamRequest request) {

        TeamEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team not found"));

        validatePlayers(request.playerQuantity());
        validateFifaCode(request.fifaCode(), id);

        entity.setCountry(request.country());
        entity.setFifaCode(request.fifaCode());
        entity.setCoach(request.coach());
        entity.setPlayerQuantity(request.playerQuantity());

        return repository.save(entity);
    }

    // 🔥 VALIDAÇÃO: PLAYERS
    private void validatePlayers(Integer players) {
        if (players == null || players < 7 || players > 30) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Players must be between 7 and 30"
            );
        }
    }

    // 🔥 VALIDAÇÃO: FIFA CODE
    private void validateFifaCode(String fifaCode, Long currentId) {

        boolean exists = repository.existsByFifaCode(fifaCode);

        if (exists) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "FIFA code already exists"
            );
        }
    }
}