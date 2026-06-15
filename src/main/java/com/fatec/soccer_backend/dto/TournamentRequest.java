package com.fatec.soccer_backend.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TournamentRequest(

        @NotNull(message = "Team 1 é obrigatório")
        Long team1Id,

        @NotNull(message = "Team 2 é obrigatório")
        Long team2Id,

        @NotBlank(message = "Local do jogo é obrigatório")
        String location,

        @NotNull(message = "Data do jogo é obrigatória")
        @Future(message = "A data do jogo deve ser no futuro")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime matchDateTime
) {}

