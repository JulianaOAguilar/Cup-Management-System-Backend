package com.fatec.soccer_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.soccer_backend.dto.TournamentRequest;
import com.fatec.soccer_backend.entities.TeamEntity;
import com.fatec.soccer_backend.entities.TournamentEntity;
import com.fatec.soccer_backend.repository.TeamRepository;
import com.fatec.soccer_backend.repository.TournamentRepository;

@Service

public class TournamentService {
@Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    public TournamentEntity create(TournamentRequest request) {

        System.out.println("REQUEST DTO: " + request);
System.out.println("DATE: " + request.matchDateTime());

        TeamEntity team1 = teamRepository.findById(request.team1Id())
                .orElseThrow(() -> new RuntimeException("Team 1 não encontrado"));

        TeamEntity team2 = teamRepository.findById(request.team2Id())
                .orElseThrow(() -> new RuntimeException("Team 2 não encontrado"));

        TournamentEntity tournament = new TournamentEntity();

        tournament.setTeam1(team1);
        tournament.setTeam2(team2);
        tournament.setLocation(request.location());
        tournament.setMatchDateTime(request.matchDateTime());

        return tournamentRepository.save(tournament);
    }

}
