package br.com.tech4me.bilheteria.shared;

import br.com.tech4me.bilheteria.model.Bilhete;
import br.com.tech4me.bilheteria.model.Fila;
import br.com.tech4me.bilheteria.model.LugarDaPoltrona;
import br.com.tech4me.bilheteria.model.Status;
import br.com.tech4me.bilheteria.model.OpcaoMeiaOuInteira;

public record BilheteCompletoDTO(
    String id,
    Double Valor,
    Integer quantidade,
    OpcaoMeiaOuInteira opcao,
    LugarDaPoltrona lugar,
    Fila fila,
    Status status) {
    public static BilheteCompletoDTO fromBilheteCompletoDTO(Bilhete bilhete){
         return new BilheteCompletoDTO(
         bilhete.getId(),
         bilhete.getValor(),
         bilhete.getQuantidade(),
         bilhete.getOpcao(),
         bilhete.getLugar(),
         bilhete.getFila(),
         bilhete.getStatus());
    }
}
