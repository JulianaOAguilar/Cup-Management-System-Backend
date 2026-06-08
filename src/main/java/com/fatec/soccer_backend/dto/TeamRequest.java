package com.fatec.soccer_backend.dto;


public record TeamRequest(

    String country,
    String fifaCode,
    String coach,
    Integer playerQuantity

) {
    
}

