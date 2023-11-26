package br.com.tech4me.filme.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.tech4me.filme.model.Filme;

public interface Repository extends JpaRepository<Filme,String > {
     Optional<Filme> findByTipoIgnoreCase(String Tipo );
}
