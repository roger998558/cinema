package br.com.tech4me.sala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tech4me.sala.httpClient.FilmeFeign;
import br.com.tech4me.sala.model.Filme;
import br.com.tech4me.sala.model.Sala;
import br.com.tech4me.sala.model.Status;
import br.com.tech4me.sala.repository.Repository;
import br.com.tech4me.sala.shared.SalaCompletaDTO;
import br.com.tech4me.sala.shared.SalaDTO;

public class ServiceImpl implements Service {
    @Autowired
    private Repository repositorio;
    @Autowired
    private FilmeFeign filmeFeign;
    @Override
    public List<SalaDTO> listarSalas() {
      return repositorio.findAll().stream().map(S -> SalaDTO.fromSalaDTO(S)).toList();
    }

    @Override
    public Optional<SalaCompletaDTO> obterPorNumeroDaSala(Integer numeroDasala) {
    Optional<Sala> sala = repositorio.findById(numeroDasala);
       
    if (sala.isPresent()) {
        Filme filme  = filmeFeign.obterPorId(sala.get().getFilme());
        return Optional.of( SalaCompletaDTO.fromSalaCompletaDTO(sala.get(),filme ));
    }
    return Optional.empty();
    }

    @Override
    public SalaCompletaDTO cadastrarSala(SalaCompletaDTO novaSala) {
        Sala salaAdd = new Sala(novaSala);
        Filme filme = filmeFeign.obterPorId(salaAdd.getFilme());
       
        salaAdd.setStatus(Status.LIVRE);
       repositorio.save(salaAdd);
       return SalaCompletaDTO.fromSalaCompletaDTO(salaAdd,filme );
    }

    @Override
    public Optional<SalaCompletaDTO> atualizarPornumeroDaSala (Integer numeroDaSala, SalaCompletaDTO salaCompleto) {
        Optional<Sala> salaPut = repositorio.findById(numeroDaSala);
        if (salaPut.isPresent()) {
            Sala salaAtualizar = new Sala(salaCompleto);
            salaAtualizar.setNumeroDasala(numeroDaSala);
           
            return Optional.of(SalaCompletaDTO.fromSalaCompletaDTO(salaPut.get()));
        }
        return Optional.empty();
    }

    @Override
    public String deletarPornumeroDaSala (Integer numeroDasala) {
        Optional <Sala> salaDelete = repositorio.findById(numeroDasala);
        if (salaDelete.isPresent()) {
           repositorio.deleteById(numeroDasala);
           return "Removido com sucesso";
        }
        return "Objeto nao encontrado";
 
     }

    }
    

