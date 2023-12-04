package br.com.tech4me.filme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.filme.service.ServiceImpl;
import br.com.tech4me.filme.shared.FilmeCompletoDTO;
import br.com.tech4me.filme.shared.FilmeDTO;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/filme")

public class ControllerFilme {


    @Autowired
    private ServiceImpl service;

@GetMapping
private ResponseEntity<List<FilmeDTO>>obterTodos(){
    return new ResponseEntity<>(service.obterTodos(),HttpStatus.OK);
}
@GetMapping("/{id}")
private ResponseEntity<FilmeCompletoDTO> obterPorId (@PathVariable String id){
    
    if (service.obterPorId(id).isPresent()) {
        return new ResponseEntity<>(service.obterPorId(id).get(),HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
@GetMapping("/{tipo}")
private ResponseEntity<List<FilmeDTO>> obterPorTipo (@PathVariable String tipo ){
        return new ResponseEntity<>(service.findByTipoIgnoreCase(tipo),HttpStatus.OK);
    }
  

@PostMapping
private ResponseEntity<FilmeCompletoDTO>cadastrarFilme(@Valid @RequestBody FilmeCompletoDTO filmeComleto) {
    return new ResponseEntity<>(service.cadastrarFilme(filmeComleto),HttpStatus.ACCEPTED);
}

@PutMapping("/{id}")
private ResponseEntity<FilmeCompletoDTO> atualizarPorId (@Valid @PathVariable String id , @RequestBody FilmeCompletoDTO filmeComleto){
    Optional <FilmeCompletoDTO> atualizarFilmePorId = service.atualizarPorId(id,filmeComleto);
    if (atualizarFilmePorId.isPresent()) {
        return new ResponseEntity<>(atualizarFilmePorId.get(),HttpStatus.OK);
        
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@DeleteMapping("/{id}")
private ResponseEntity <String> deletarPorId(@PathVariable String id ){

   return new ResponseEntity<>(service.deletarPorId(id),HttpStatus.NO_CONTENT);
}

}