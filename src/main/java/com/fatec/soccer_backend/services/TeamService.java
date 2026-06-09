package com.fatec.soccer_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.soccer_backend.dto.TeamRequest;
import com.fatec.soccer_backend.entities.TeamEntity;
import com.fatec.soccer_backend.repository.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public TeamEntity save(TeamRequest request) {

        TeamEntity entity = new TeamEntity();
        entity.setCountry(request.country());
        entity.setFifaCode(request.fifaCode());
        entity.setCoach(request.coach());
        entity.setPlayerQuantity(request.playerQuantity());

        return repository.save(entity);
    }

    public List<TeamEntity> findAll() {
        return repository.findAll();
    }

    public TeamEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Time não encontrado"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public TeamEntity update(Long id, TeamRequest request) {

        TeamEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Time não encontrado"));

        entity.setCountry(request.country());
        entity.setFifaCode(request.fifaCode());
        entity.setCoach(request.coach());
        entity.setPlayerQuantity(request.playerQuantity());

        return repository.save(entity);
    }
}