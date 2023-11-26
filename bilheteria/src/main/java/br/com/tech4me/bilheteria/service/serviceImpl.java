package br.com.tech4me.bilheteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tech4me.bilheteria.model.Bilhete;

import br.com.tech4me.bilheteria.model.Status;
import br.com.tech4me.bilheteria.repository.Repository;
import br.com.tech4me.bilheteria.shared.BilheteCompletoDTO;
import br.com.tech4me.bilheteria.shared.BilheteDTO;

public class serviceImpl implements service{
    @Autowired
    private Repository repositorio;

    @Override
    public List<BilheteDTO> obterTodosOsBilhetes() {
        return repositorio.findAll().stream().map(B -> BilheteDTO.fromBilheteDTO(B)).toList();
    }

    @Override
    public BilheteCompletoDTO cadastrarBilhete(BilheteCompletoDTO novoBilhete) {
        Bilhete bilheteAdd = new Bilhete(novoBilhete);
        bilheteAdd.setStatus(Status.OCUPADO);
        repositorio.save(bilheteAdd);
        return BilheteCompletoDTO.fromBilheteCompletoDTO(bilheteAdd);
    }

    @Override
    public Optional<BilheteCompletoDTO> obterBilhetePorId(String id) {
        Optional<Bilhete> bilhete = repositorio.findById(id);
        if (bilhete.isPresent()) {
            return Optional.of(BilheteCompletoDTO.fromBilheteCompletoDTO(bilhete.get()));
        }
        return Optional.empty();   
    }

    @Override
    public Optional<BilheteCompletoDTO> atualizarBilhetePorId(String id, BilheteCompletoDTO bilheteAtualizado) {
       Optional<Bilhete> bilhete = repositorio.findById(id);
       if (bilhete.isPresent()) {
        Bilhete bilhetePut = new Bilhete(bilheteAtualizado);
        bilhetePut.setId(id);
        return Optional.of(BilheteCompletoDTO.fromBilheteCompletoDTO(bilhete.get()));
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
    }
    

