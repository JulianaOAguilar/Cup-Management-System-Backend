package com.fatec.soccer_backend.dto;

public record TeamResponse(
    String country,
    String fifaCode,
    String coach,
    Integer playerQuantity
) {}

