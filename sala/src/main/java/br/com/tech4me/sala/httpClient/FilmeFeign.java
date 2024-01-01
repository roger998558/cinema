package br.com.tech4me.sala.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.sala.model.Filme;

@FeignClient("filme")
public interface FilmeFeign {
    @GetMapping("/filme/{id}")
    Filme obterPorId (@PathVariable String id);
    
}
