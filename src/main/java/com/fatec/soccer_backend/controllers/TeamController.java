package com.fatec.soccer_backend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.soccer_backend.entities.TeamEntity;
import com.fatec.soccer_backend.services.TeamService;
@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public ResponseEntity<List<TeamEntity>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamEntity> getById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

     @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TeamEntity> save(@RequestBody TeamEntity team)
    {
        TeamEntity t = service.save(team);
       
        URI location = ServletUriComponentsBuilder
                       .fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(t.getId())
                       .toUri();
        
        return ResponseEntity.created(location).body(t);


    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id,
                                       @RequestBody TeamEntity team)
    {
            service.update(team, id);
            return ResponseEntity.noContent().build();
    }

}