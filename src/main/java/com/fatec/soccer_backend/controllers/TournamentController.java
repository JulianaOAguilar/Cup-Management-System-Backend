package com.fatec.soccer_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.soccer_backend.dto.TournamentRequest;
import com.fatec.soccer_backend.dto.TournamentResponse;
import com.fatec.soccer_backend.services.TournamentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tournaments")
@CrossOrigin("*")
public class TournamentController {

    @Autowired
    private TournamentService service;

    @GetMapping
    public ResponseEntity<List<TournamentResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TournamentResponse> save(
            @RequestBody @Valid TournamentRequest request) {

        return ResponseEntity.status(201).body(service.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TournamentResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid TournamentRequest request) {

        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

