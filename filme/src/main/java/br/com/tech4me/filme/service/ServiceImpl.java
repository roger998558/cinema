package br.com.tech4me.filme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.filme.model.Filme;
import br.com.tech4me.filme.repository.Repository;
import br.com.tech4me.filme.shared.FilmeCompletoDTO;
import br.com.tech4me.filme.shared.FilmeDTO;
@Service
public class ServiceImpl implements ServiceFilme {
    @Autowired 
    private Repository repositorio;

    @Override
    public List<FilmeDTO> obterTodos() {
        return repositorio.findAll().stream()
        .map(F-> FilmeDTO.fromFilmeDTO(F)).toList();
    }

    @Override
    public List<FilmeDTO> findByTipoIgnoreCase(String tipo) {
      return repositorio.findByTipoIgnoreCase(tipo).stream()
      .map(T-> FilmeDTO.fromFilmeDTO(T)).toList();
    }

    @Override
    public Optional<FilmeCompletoDTO> obterPorId(String id) {
       Optional <Filme> filme = repositorio.findById(id);

       if (filme.isPresent()) {

        return Optional.of(FilmeCompletoDTO.fromFilmeCompletoDTO(filme.get()));
        
       }

       return Optional.empty();
    }

    @Override
    public FilmeCompletoDTO cadastrarFilme(FilmeCompletoDTO novoFilme) {
       Filme filmeAdd = new Filme(novoFilme);
       repositorio.save(filmeAdd);
       return FilmeCompletoDTO.fromFilmeCompletoDTO(filmeAdd);
    }

    @Override
    public Optional<FilmeCompletoDTO> atualizarPorId(String id, FilmeCompletoDTO filmeCompleto) {
      Optional <Filme> filmePut = repositorio.findById(id);

      if (filmePut.isPresent()) {
        Filme filmeAtualizar = new Filme(filmeCompleto);
        filmeAtualizar.setId(id);
        repositorio.save(filmeAtualizar);
        return Optional.of(  FilmeCompletoDTO.fromFilmeCompletoDTO(filmePut.get()));
        
      }
      return Optional.empty();
      
    }

    @Override
    public String deletarPorId(String id) {
       Optional <Filme> filmeDelete= repositorio.findById(id);
       if (filmeDelete.isPresent()) {
          repositorio.deleteById(id);
          return "removido com sucesso";
       }
       return "objeto nao encontrado";

    }
    
}
