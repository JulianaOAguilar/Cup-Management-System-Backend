package com.fatec.soccer_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.soccer_backend.dto.TournamentRequest;
import com.fatec.soccer_backend.dto.TournamentResponse;
import com.fatec.soccer_backend.entities.TeamEntity;
import com.fatec.soccer_backend.entities.TournamentEntity;
import com.fatec.soccer_backend.repository.TeamRepository;
import com.fatec.soccer_backend.repository.TournamentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    // -------------------------
    // mapper Entity -> Response
    // -------------------------
    private TournamentResponse toResponse(TournamentEntity entity) {
        return new TournamentResponse(
                entity.getId(),
                entity.getTeam1().getCountry(), // ou getName()
                entity.getTeam2().getCountry(),
                entity.getLocation(),
                entity.getMatchDateTime()
        );
    }

    // -------------------------
    // CREATE
    // -------------------------
    public TournamentResponse save(TournamentRequest request) {

        TeamEntity team1 = teamRepository.findById(request.team1Id())
                .orElseThrow(() -> new RuntimeException("Team 1 não encontrado"));

        TeamEntity team2 = teamRepository.findById(request.team2Id())
                .orElseThrow(() -> new RuntimeException("Team 2 não encontrado"));

        TournamentEntity tournament = new TournamentEntity();

        tournament.setTeam1(team1);
        tournament.setTeam2(team2);
        tournament.setLocation(request.location());
        tournament.setMatchDateTime(request.matchDateTime());

        TournamentEntity saved = tournamentRepository.save(tournament);

        return toResponse(saved);
    }

    // -------------------------
    // GET ALL
    // -------------------------
    public List<TournamentResponse> findAll() {
        return tournamentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // -------------------------
    // GET BY ID
    // -------------------------
    public TournamentResponse findById(Long id) {

        TournamentEntity entity = tournamentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournament não encontrado"));

        return toResponse(entity);
    }

    // -------------------------
    // DELETE
    // -------------------------
    public void deleteById(Long id) {
        tournamentRepository.deleteById(id);
    }

    // -------------------------
    // UPDATE
    // -------------------------
    public TournamentResponse update(Long id, TournamentRequest request) {

        TournamentEntity tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournament não encontrado"));

        TeamEntity team1 = teamRepository.findById(request.team1Id())
                .orElseThrow(() -> new RuntimeException("Team 1 não encontrado"));

        TeamEntity team2 = teamRepository.findById(request.team2Id())
                .orElseThrow(() -> new RuntimeException("Team 2 não encontrado"));

        tournament.setTeam1(team1);
        tournament.setTeam2(team2);
        tournament.setLocation(request.location());
        tournament.setMatchDateTime(request.matchDateTime());

        TournamentEntity updated = tournamentRepository.save(tournament);

        return toResponse(updated);
    }
}