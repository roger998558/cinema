package br.com.tech4me.bilheteria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.tech4me.bilheteria.service.serviceImpl;
import br.com.tech4me.bilheteria.shared.BilheteCompletoDTO;
import br.com.tech4me.bilheteria.shared.BilheteDTO;
import br.com.tech4me.bilheteria.shared.StatusDaPoltronaDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/bilheteria")
public class ControllerBilhete {
@Autowired
private serviceImpl servico;

@GetMapping
private ResponseEntity<List<BilheteDTO>> obterTodosOsBilhetes(){
return new ResponseEntity<>(servico.obterTodosOsBilhetes(),HttpStatus.OK);
}

@PostMapping
private ResponseEntity<BilheteCompletoDTO> cadastrarBilhete (@RequestBody BilheteCompletoDTO bilhete ){
    if () {
        
    }
return new ResponseEntity<>(servico.cadastrarBilhete(bilhete),HttpStatus.CREATED);
}
@GetMapping("/{id}")
private ResponseEntity<BilheteCompletoDTO> obterBilhetePorId(@PathVariable String id){
    if (servico.obterBilhetePorId(id).isPresent()) {
        return  new ResponseEntity<>(servico.obterBilhetePorId(id).get(),HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@PostMapping("/{id}")
private ResponseEntity<BilheteCompletoDTO> atualizarBilhetePorId(@PathVariable String id ,
                                                    @RequestBody BilheteCompletoDTO bilhete){
Optional<BilheteCompletoDTO> atualizar = servico.atualizarBilhetePorId(id, bilhete);
if (atualizar.isPresent()) {
    return new ResponseEntity<>(servico.atualizarBilhetePorId(id, bilhete).get(),HttpStatus.OK);
}
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }
@GetMapping("/{status}")
private ResponseEntity<List<StatusDaPoltronaDTO>> findAllByStatusIgnoreCase(@PathVariable String status){
    return new ResponseEntity<>(servico.findAllByStatusIgnoreCase(status),HttpStatus.OK);
}
}

