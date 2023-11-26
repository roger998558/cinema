package br.com.tech4me.sala.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.sala.service.ServiceImpl;
import br.com.tech4me.sala.shared.SalaCompletaDTO;
import br.com.tech4me.sala.shared.SalaDTO;

@RestController
@RequestMapping("/sala")
public class ControllerSala {
    @Autowired
    private ServiceImpl servico;

    @GetMapping
    private ResponseEntity<List<SalaDTO>> listarSalas(){
        return new ResponseEntity<>(servico.listarSalas(),HttpStatus.OK);
    }

    @GetMapping("/{numeroDasala}")
    private ResponseEntity<SalaCompletaDTO> obterPorNumeroDaSala (@PathVariable Integer numeroDasala){
        if (servico.obterPorNumeroDaSala(numeroDasala).isPresent()) {
            return new ResponseEntity<>(servico.obterPorNumeroDaSala(numeroDasala).get(),HttpStatus.OK);
        }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    
    @PostMapping
    private ResponseEntity<SalaCompletaDTO> cadastrarSala(@RequestBody SalaCompletaDTO novaSala ){
        return new ResponseEntity<>(servico.cadastrarSala(novaSala),HttpStatus.ACCEPTED);
    }

    @PutMapping("/{numeroDasala}")
    private ResponseEntity<SalaCompletaDTO> atualizarPornumeroDaSala (@PathVariable Integer numeroDasala ,
                                                                @RequestBody SalaCompletaDTO salaCompleta ){

    Optional<SalaCompletaDTO> atualizarSala = servico.atualizarPornumeroDaSala(numeroDasala, salaCompleta);

    if(atualizarSala.isPresent()){
     return new ResponseEntity<>(atualizarSala.get(),HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping("/{numeroDasala}")
    private ResponseEntity<String> deletarPornumeroDaSala (@PathVariable Integer numeroDasala){
        return new ResponseEntity<>(servico.deletarPornumeroDaSala(numeroDasala),HttpStatus.NO_CONTENT);
    }
}
