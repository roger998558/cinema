package br.com.tech4me.sala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tech4me.sala.model.Sala;

public interface Repository extends JpaRepository<Sala, Integer> {
    
}
