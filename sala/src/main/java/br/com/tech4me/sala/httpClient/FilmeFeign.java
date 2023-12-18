package br.com.tech4me.sala.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.sala.model.Filme;

@FeignClient("filme")
public interface FilmeFeign {
    @RequestMapping( method = RequestMethod.GET , value = "/filme/{id}"  )
    Filme obterPorId (@PathVariable String id);
    
}
