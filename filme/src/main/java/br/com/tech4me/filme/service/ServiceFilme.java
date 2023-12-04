package br.com.tech4me.filme.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.filme.shared.FilmeCompletoDTO;
import br.com.tech4me.filme.shared.FilmeDTO;


public interface ServiceFilme {

    List<FilmeDTO> obterTodos();
    List<FilmeDTO>findByTipoIgnoreCase(String tipo );
    Optional<FilmeCompletoDTO> obterPorId (String id );
    FilmeCompletoDTO cadastrarFilme (FilmeCompletoDTO novoFilme);
    Optional<FilmeCompletoDTO> atualizarPorId (String id,FilmeCompletoDTO filmeCompleto );
    String deletarPorId (String id );
 


}
