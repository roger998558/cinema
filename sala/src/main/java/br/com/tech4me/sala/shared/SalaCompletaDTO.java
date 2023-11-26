package br.com.tech4me.sala.shared;


import br.com.tech4me.sala.model.Imagem;
import br.com.tech4me.sala.model.Sala;
import br.com.tech4me.sala.model.Status;

public record SalaCompletaDTO (
 Integer numeroDasala,
 Status status,
 Imagem imagemDoFilme
 ) {

    public static SalaCompletaDTO fromSalaCompletaDTO (Sala sala ){
    return new SalaCompletaDTO(
    sala.getNumeroDasala(),
    sala.getStatus(),
    sala.getImagemDoFilme());

}
}
