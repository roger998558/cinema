package br.com.tech4me.filme.shared;

import br.com.tech4me.filme.model.Filme;
import br.com.tech4me.filme.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record FilmeCompletoDTO(
String id,
@NotNull
@NotBlank(message = "Ola o campo deve ser preechido")
@NotEmpty(message = "Ola o nome do filme nao foi informado")
String nomeDofilme,
@NotNull
@NotBlank(message = "Ola o campo deve ser preechido")
@NotEmpty(message = "Ola o nome do autor nao foi informado")
String autorDoFilme,
@NotNull
@NotBlank(message = "Ola o campo deve ser preechido")
@NotEmpty(message = "Ola o tempo do filme nao foi estimado ")
String tempoDoFilme,
@NotNull
@NotBlank(message = "Ola o campo deve ser preechido")
@NotEmpty(message = "Ola o tipo do filme nao foi informado")
Tipo tipo,
@NotNull
@NotBlank(message = "Ola o campo deve ser preechido")
@NotEmpty(message = "Ola a sinopse do filme nao foi informado")
String sinopse
) {

    public static FilmeCompletoDTO fromFilmeCompletoDTO(Filme filme){
    return new FilmeCompletoDTO(
    filme.getId(),
    filme.getNomeDofilme(),
    filme.getAutorDoFilme(),
    filme.getTempoDoFilme(),
    filme.getTipo(),
    filme.getSinopse());
}
}
