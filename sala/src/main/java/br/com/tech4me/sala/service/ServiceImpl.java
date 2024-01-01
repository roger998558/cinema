package br.com.tech4me.sala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.sala.httpClient.FilmeFeign;
import br.com.tech4me.sala.model.Filme;
import br.com.tech4me.sala.model.Sala;
import br.com.tech4me.sala.model.Status;
import br.com.tech4me.sala.repository.Repository;
import br.com.tech4me.sala.shared.SalaCompletaDTO;
import br.com.tech4me.sala.shared.SalaDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceImpl implements ServiceSala {
    @Autowired
    private Repository repositorio;
    @Autowired
    private FilmeFeign filmeFeign;
    @Override
    public List<SalaDTO> listarSalas() {
      return repositorio.findAll().stream().map(S -> SalaDTO.fromSalaDTO(S)).toList();
    }
    @CircuitBreaker(name = "obterPorId",fallbackMethod = "fallbackObterPorNumeroDaSala")
    @Override
    public Optional<SalaCompletaDTO> obterPorNumeroDaSala(Integer numeroDasala) {
    Optional<Sala> sala = repositorio.findById(numeroDasala);
       
    if (sala.isPresent()) {
        Filme filme  = filmeFeign.obterPorId(sala.get().getFilme());
        return Optional.of( SalaCompletaDTO.fromSalaCompletaDTO(sala.get(),filme ));
    }
    return Optional.empty();
    }
    public Optional<SalaCompletaDTO> fallbackObterPorNumeroDaSala (Integer id , Exception e ){
        Optional<Sala> sala  = repositorio.findById(id);

        if (sala.isPresent()) {
            Filme filme  = null;
            return Optional.of(SalaCompletaDTO.fromSalaCompletaDTO(sala.get(),filme ));
        }
        return Optional.empty();
    }
    
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
        Filme filme = filmeFeign.obterPorId(salaPut.get().getFilme());
        if (salaPut.isPresent()) {

            Sala salaAtualizar = new Sala(salaCompleto);
            salaAtualizar.setNumeroDasala(numeroDaSala);
           
            return Optional.of(SalaCompletaDTO.fromSalaCompletaDTO(salaPut.get(),filme));
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
    

