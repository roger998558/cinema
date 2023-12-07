package br.com.tech4me.sala.httpClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("filme")
public interface FilmeFeign {
    
}
