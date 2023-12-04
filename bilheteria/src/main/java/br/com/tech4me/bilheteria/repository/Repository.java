package br.com.tech4me.bilheteria.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tech4me.bilheteria.model.Bilhete;


public interface Repository extends JpaRepository <Bilhete,String> {
    List <Bilhete> findAllByStatusIgnoreCase(String status);
}
