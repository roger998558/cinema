package br.com.tech4me.bilheteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tech4me.bilheteria.httpClient.SalaFeign;
import br.com.tech4me.bilheteria.model.Bilhete;
import br.com.tech4me.bilheteria.model.Sala;
import br.com.tech4me.bilheteria.model.Status;
import br.com.tech4me.bilheteria.repository.Repository;
import br.com.tech4me.bilheteria.shared.BilheteCompletoDTO;
import br.com.tech4me.bilheteria.shared.BilheteDTO;
import br.com.tech4me.bilheteria.shared.StatusDaPoltronaDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

public class serviceImpl implements service{
    @Autowired
    private Repository repositorio;
    @Autowired
    private SalaFeign salaFeign;

    @Override
    public List<BilheteDTO> obterTodosOsBilhetes() {
        return repositorio.findAll().stream().map(B -> BilheteDTO.fromBilheteDTO(B)).toList();
    }

    @Override
    public Optional<BilheteCompletoDTO> cadastrarBilhete(BilheteCompletoDTO novoBilhete) {
       
        Bilhete bilheteAdd = new Bilhete(novoBilhete);
         Optional<Sala> sala = salaFeign.obterPorNumeroDaSala(bilheteAdd.getSala());
         if (sala.isPresent()) {
        bilheteAdd.setStatus(Status.OCUPADO);
        repositorio.save(bilheteAdd);
        return Optional.of( BilheteCompletoDTO.fromBilheteCompletoDTO(bilheteAdd,sala));
         }
         return Optional.empty(); 
        
         
       
    }
    @CircuitBreaker(name = "obterPorNumeroDaSala", fallbackMethod = "fallbackObterPorNumero")
    @Override
    public Optional<BilheteCompletoDTO> obterBilhetePorId(String id) {
        Optional<Bilhete> bilhete = repositorio.findById(id);

        if (bilhete.isPresent()) {

           Optional< Sala> sala = salaFeign.obterPorNumeroDaSala(bilhete.get().getSala());
            return Optional.of(BilheteCompletoDTO.fromBilheteCompletoDTO(bilhete.get(),sala));
        }
        return Optional.empty();   
    }

    @Override
    public Optional<BilheteCompletoDTO> atualizarBilhetePorId(String id, BilheteCompletoDTO bilheteAtualizado) {
       Optional<Bilhete> bilhete = repositorio.findById(id);
       if (bilhete.isPresent()) {
        Bilhete bilhetePut = new Bilhete(bilheteAtualizado);
        bilhetePut.setId(id);
        return Optional.of(BilheteCompletoDTO.fromBilheteCompletoDTO(bilhete.get(),salaFeign));
       }
       return Optional.empty();
    }

    @Override
    public String deletarBilhetePorId(String id) {
        Optional <Bilhete> filmeDelete= repositorio.findById(id);
        if (filmeDelete.isPresent()) {
           repositorio.deleteById(id);
           return "removido com sucesso";
        }
        return "objeto nao encontrado";
    
     }
    
    @Override
    public List<StatusDaPoltronaDTO> findAllByStatusIgnoreCase(String status) {
         return repositorio.findAllByStatusIgnoreCase(status).stream()
         .map( S -> StatusDaPoltronaDTO.fromDaPoltronaDTO(S)).toList();

    }
}

    
    
    

