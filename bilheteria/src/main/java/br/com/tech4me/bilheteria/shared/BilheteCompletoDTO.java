package br.com.tech4me.bilheteria.shared;



import java.util.Optional;

import br.com.tech4me.bilheteria.model.Bilhete;
import br.com.tech4me.bilheteria.model.Fila;
import br.com.tech4me.bilheteria.model.LugarDaPoltrona;
import br.com.tech4me.bilheteria.model.Status;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import br.com.tech4me.bilheteria.model.OpcaoMeiaOuInteira;
import br.com.tech4me.bilheteria.model.Sala;


public record BilheteCompletoDTO(
    
     @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
    String id,
   
     @Positive(message = "Por favor insira somente numeros positivos")
     @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
    Double Valor,

     @Positive(message = "Por favor insira somente numeros positivos")
     @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
    Integer quantidade,

     @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
    OpcaoMeiaOuInteira opcao,

     @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
    LugarDaPoltrona lugar,

      @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
    Fila fila,

     @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
    Status status,

    Optional<Sala> sala 
   
    ) {
    public static BilheteCompletoDTO fromBilheteCompletoDTO(Bilhete bilhete , Optional<Sala> sala ){
         return new BilheteCompletoDTO(
         bilhete.getId(),
         bilhete.getValor(),
         bilhete.getQuantidade(),
         bilhete.getOpcao(),
         bilhete.getLugar(),
         bilhete.getFila(),
         bilhete.getStatus(),
         sala  );

    }

}
