package br.com.tech4me.sala.shared;




import br.com.tech4me.sala.model.Filme;
import br.com.tech4me.sala.model.Imagem;
import br.com.tech4me.sala.model.Sala;
import br.com.tech4me.sala.model.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record SalaCompletaDTO (
 @Positive(message = "Por favor insira somente numeros positivos")
 @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
 Integer numeroDasala,
 @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
 Status status,
 @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
 Imagem imagemDoFilme,
 @NotEmpty(message = "O campo nao pode ser nulo ou vazio.")
 Filme filme 
 ) {

    public static SalaCompletaDTO fromSalaCompletaDTO (Sala sala , Filme filme ){
    return new SalaCompletaDTO(
    sala.getNumeroDasala(),
    sala.getStatus(),
    sala.getImagemDoFilme(),
   filme );

}
}
