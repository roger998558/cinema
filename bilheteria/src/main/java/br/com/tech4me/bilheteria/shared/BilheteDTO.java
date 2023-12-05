package br.com.tech4me.bilheteria.shared;

import br.com.tech4me.bilheteria.model.Bilhete;
import br.com.tech4me.bilheteria.model.Fila;
import br.com.tech4me.bilheteria.model.LugarDaPoltrona;
import br.com.tech4me.bilheteria.model.Status;
import br.com.tech4me.bilheteria.model.OpcaoMeiaOuInteira;
import br.com.tech4me.bilheteria.model.Sala;

public record BilheteDTO(  
String id,
Double Valor, 
OpcaoMeiaOuInteira opcao,
LugarDaPoltrona lugar,
Fila fila,
Status status,
Sala sala
) {
    public static BilheteDTO fromBilheteDTO(Bilhete bilhete){
        return new BilheteDTO(
        bilhete.getId(),
        bilhete.getValor(),
        bilhete.getOpcao(),
        bilhete.getLugar(),
        bilhete.getFila(),
        bilhete.getStatus(),
        bilhete.getSala());
    }
}
