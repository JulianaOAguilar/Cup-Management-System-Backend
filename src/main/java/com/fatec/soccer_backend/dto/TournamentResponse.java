package com.fatec.soccer_backend.dto;

import java.time.LocalDateTime;

public record TournamentResponse(
    Long id,
    Long team1Id,
    Long team2Id,
    String team1Name,
    String team2Name,
    String location,
    LocalDateTime matchDateTime
) {}
