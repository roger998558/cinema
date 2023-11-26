package br.com.tech4me.bilheteria.shared;

import br.com.tech4me.bilheteria.model.Bilhete;
import br.com.tech4me.bilheteria.model.LugarDaPoltrona;
import br.com.tech4me.bilheteria.model.Status;

public record StatusDaPoltronaDTO(
    LugarDaPoltrona lugar,
    Status status) {
        public static StatusDaPoltronaDTO fromDaPoltronaDTO(Bilhete bilhete) {
            return new StatusDaPoltronaDTO(
            bilhete.getLugar(),
            bilhete.getStatus());
        }
    
}
