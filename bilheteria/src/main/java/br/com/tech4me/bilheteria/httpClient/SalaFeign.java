package br.com.tech4me.bilheteria.httpClient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.bilheteria.model.Sala;

@FeignClient("sala")
public interface SalaFeign {
    @RequestMapping(method = RequestMethod.GET , value = "/sala/{id}")
   Optional <Sala> obterPorNumeroDaSala(@PathVariable Optional<Sala> optional);
    
    
}
