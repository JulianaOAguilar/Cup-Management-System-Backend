package com.fatec.soccer_backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record TeamRequest(

    @NotBlank
    String country,

    @NotBlank
    @Size(min=3, max=3)
    String fifaCode,

    @NotBlank
    String coach,

    @Min(value = 3)
    @Max(value=32)
    Integer playerQuantity

) {
    
}

