package br.com.tech4me.bilheteria.httpClient;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.bilheteria.model.Sala;

@FeignClient("sala")
public interface SalaFeign {
    @GetMapping("/sala/{id}")
    Sala obterPorNumeroDaSala(@PathVariable Integer  sala );
    
    
}
