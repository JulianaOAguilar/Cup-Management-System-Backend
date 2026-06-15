package com.fatec.soccer_backend.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TournamentRequest(

        @NotNull(message = "Data e hora do jogo são obrigatórias")
        LocalDateTime matchDateTime,

        @NotNull(message = "Team 1 é obrigatório")
        Long team1Id,

        @NotNull(message = "Team 2 é obrigatório")
        Long team2Id,

        @NotBlank(message = "Local do jogo é obrigatório")
        String location

) {}