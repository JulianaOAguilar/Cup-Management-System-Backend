package com.fatec.soccer_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.soccer_backend.dto.TournamentRequest;
import com.fatec.soccer_backend.entities.TournamentEntity;
import com.fatec.soccer_backend.services.TournamentService;


@RestController
@RequestMapping("/tournaments")
@CrossOrigin("*")
public class TournamentController {

    @Autowired
    private TournamentService service;

    @PostMapping
    public TournamentEntity create(@RequestBody TournamentRequest request) {
        return service.create(request);
    }
}
