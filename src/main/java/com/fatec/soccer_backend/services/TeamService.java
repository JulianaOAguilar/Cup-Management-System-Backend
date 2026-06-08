package com.fatec.soccer_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.soccer_backend.entities.TeamEntity;
import com.fatec.soccer_backend.repository.TeamRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository repository;
	
	public List<TeamEntity> findAll() {
	    return repository.findAll();
	}
	
	public TeamEntity findById(Long id) {
	    return repository.findById(id)
	                     .orElseThrow(() -> new EntityNotFoundException());
	}
}