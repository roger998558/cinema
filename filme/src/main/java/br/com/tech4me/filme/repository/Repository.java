package br.com.tech4me.filme.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.tech4me.filme.model.Filme;

public interface Repository extends JpaRepository<Filme,String > {
     List<Filme> findByTipoIgnoreCase(String Tipo );
     
}
