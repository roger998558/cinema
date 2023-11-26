package br.com.tech4me.sala.shared;


import br.com.tech4me.sala.model.Imagem;
import br.com.tech4me.sala.model.Sala;


public record SalaDTO(
 Integer numeroDasala,
  Imagem imagemDoFilme
 
 ) {
    public static SalaDTO fromSalaDTO (Sala sala ){
    return new SalaDTO (
    sala.getNumeroDasala(),
    sala.getImagemDoFilme());
}
   
    }

