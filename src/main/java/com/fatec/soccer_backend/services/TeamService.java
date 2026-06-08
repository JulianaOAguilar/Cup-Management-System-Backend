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

	public void deleteById(Long id)
    {
        if(repository.existsById(id))
            repository.deleteById(id);
        else
           throw new EntityNotFoundException("Produto não cadastrado");
    }

    public TeamEntity save(TeamEntity team)
    {
         return repository.save(team);
    }

    public void update(TeamEntity team, Long id)
    {
        TeamEntity t  = repository.findById(id)
                               .orElseThrow(() -> new EntityNotFoundException("Time não cadastrado"));

        t.setCoach(team.getCoach());                                
        t.setFifaCode(team.getFifaCode());
		t.setCountry(team.getCountry());
		t.setPlayerQuantity(team.getPlayerQuantity());
        

        repository.save(t);


    }
}