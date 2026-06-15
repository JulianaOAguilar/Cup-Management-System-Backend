package com.fatec.soccer_backend.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TournamentRequest(

        Long team1Id,
        Long team2Id,
        String location,

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime matchDateTime
) {}