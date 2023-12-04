package br.com.tech4me.filme.shared;

import br.com.tech4me.filme.model.Filme;
import br.com.tech4me.filme.model.Tipo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;


public record FilmeCompletoDTO(
String id,

@NotEmpty(message = "O elemento anotado não deve ser nulo ou vazio.")
String nomeDofilme,

@NotEmpty(message = "O elemento anotado não deve ser nulo ou vazio.")
String autorDoFilme,

@Positive(message = "Por favor insira somente numeros positivos")
@NotEmpty(message = "O elemento anotado não deve ser nulo ou vazio.")
String tempoDoFilme,

@NotEmpty(message = "O elemento anotado não deve ser nulo ou vazio.")
Tipo tipo,

@NotEmpty(message = "O elemento anotado não deve ser nulo ou vazio.")
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
