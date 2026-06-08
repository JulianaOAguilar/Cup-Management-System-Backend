package com.fatec.soccer_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.soccer_backend.entities.TeamEntity;
import com.fatec.soccer_backend.services.TeamService;

@RestController
@RequestMapping("/teams") // define a rota base da API 
// (localhost:8080/products)
public class TeamController {

    @Autowired
    private TeamService service;
    
    @GetMapping
    public ResponseEntity<List<TeamEntity>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamEntity> getById(@PathVariable long id){
        return ResponseEntity.ok(service.findById(id));
    } // dtos
}