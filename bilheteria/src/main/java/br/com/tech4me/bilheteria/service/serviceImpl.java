package br.com.tech4me.bilheteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.bilheteria.httpClient.SalaFeign;
import br.com.tech4me.bilheteria.model.Bilhete;
import br.com.tech4me.bilheteria.model.Sala;
import br.com.tech4me.bilheteria.model.Status;
import br.com.tech4me.bilheteria.repository.Repository;
import br.com.tech4me.bilheteria.shared.BilheteCompletoDTO;
import br.com.tech4me.bilheteria.shared.BilheteDTO;
import br.com.tech4me.bilheteria.shared.StatusDaPoltronaDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class serviceImpl implements ServiceBilheteri{
    @Autowired
    private Repository repositorio;
    @Autowired
    private SalaFeign salaFeign;
  
    @Override
    public List<BilheteDTO> obterTodosOsBilhetes() {
        return repositorio.findAll().stream().map(B -> BilheteDTO.fromBilheteDTO(B)).toList();
    }

    @Override
    public BilheteCompletoDTO cadastrarBilhete(BilheteCompletoDTO novoBilhete) {
       
        Bilhete bilheteAdd = new Bilhete(novoBilhete);
         Sala sala = salaFeign.obterPorNumeroDaSala(bilheteAdd.getSala());
       
       if (!novoBilhete.lugar().equals(bilheteAdd.getLugar())) {
        bilheteAdd.setStatus(Status.OCUPADO);
        repositorio.save(bilheteAdd);
        return  BilheteCompletoDTO.fromBilheteCompletoDTO(bilheteAdd,sala);
         }
        return  BilheteCompletoDTO.fromBilheteCompletoDTO(bilheteAdd,sala);
     
       }
       

    @CircuitBreaker(name = "obterPorNumeroDaSala", fallbackMethod = "fallbackObterBilhetePorId")
    @Override
    public Optional<BilheteCompletoDTO> obterBilhetePorId(String id) {
        Optional<Bilhete> bilhete = repositorio.findById(id);

        if (bilhete.isPresent()) {
            Sala sala = salaFeign.obterPorNumeroDaSala(bilhete.get().getSala());
            return Optional.of(BilheteCompletoDTO.fromBilheteCompletoDTO(bilhete.get(),sala));
        }
        return Optional.empty();   
    }

   
    public Optional<BilheteCompletoDTO> fallbackObterBilhetePorId( String id , Exception e){
        Optional<Bilhete> bilhete = repositorio.findById(id);

        if (bilhete.isPresent()) {
            Sala sala  = null;
            return Optional.of(BilheteCompletoDTO.fromBilheteCompletoDTO(bilhete.get(),sala ));
        }
        return Optional.empty();

    }
  
    public Optional<BilheteCompletoDTO> atualizarBilhetePorId(String id, BilheteCompletoDTO bilheteAtualizado) {
       Optional<Bilhete> bilhete = repositorio.findById(id);
       if (bilhete.isPresent()) {
         Sala sala = salaFeign.obterPorNumeroDaSala(bilhete.get().getSala());
       
             Bilhete bilhetePut = new Bilhete(bilheteAtualizado);
        bilhetePut.setId(id);
        return Optional.of(BilheteCompletoDTO.fromBilheteCompletoDTO(bilhete.get(),sala ));
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

    
    
    

