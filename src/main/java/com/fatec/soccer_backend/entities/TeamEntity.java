package com.fatec.soccer_backend.entities;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // amarrar a classe com o banco
@Table(name = "TBL_TEAM") // definir o nome da tabela no banco

public class TeamEntity implements java.io.Serializable {
// o serialize transforma numa sequencia de bits

    @Id // definir ID como PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // estratégia para o banco gerar as PK automaticamente
    private Long id;
    private String country;
    private String fifaCode;
    private String coach;
    private Integer playerQuantity;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFifaCode() {
        return fifaCode;
    }

    public void setFifaCode(String fofaCode) {
        this.fifaCode = fofaCode;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Integer getPlayerQuantity() {
        return playerQuantity;
    }

    public void setPlayerQuantity(Integer playerQuantity) {
        this.playerQuantity = playerQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TeamEntity other = (TeamEntity) obj;
        return Objects.equals(this.id, other.id);
    }
    
}