package br.com.tech4me.filme.shared;

import br.com.tech4me.filme.model.Filme;
import br.com.tech4me.filme.model.Tipo;

public record FilmeDTO(
String id,
String nomeDofilme,
Tipo tipo,
String sinopse) {
    public static FilmeDTO fromFilmeDTO(Filme filme ){
        return new FilmeDTO(
        filme.getId(),
        filme.getNomeDofilme(),
        filme.getTipo(),
        filme.getSinopse());
    }
}
