package br.com.tech4me.bilheteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tech4me.bilheteria.model.Bilhete;

public interface Repository extends JpaRepository <Bilhete,String> {
    
    
}
