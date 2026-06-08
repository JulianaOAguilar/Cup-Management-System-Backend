package com.fatec.soccer_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.soccer_backend.entities.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long>{
    
}

