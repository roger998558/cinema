package br.com.tech4me.bilheteria.httpClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("sala")
public interface SalaFeign {
    
}
