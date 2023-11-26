package br.com.tech4me.bilheteria.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.bilheteria.shared.BilheteCompletoDTO;
import br.com.tech4me.bilheteria.shared.BilheteDTO;

public interface service {
    List<BilheteDTO> obterTodosOsBilhetes();
    BilheteCompletoDTO cadastrarBilhete(BilheteCompletoDTO novoBilhete);
    Optional<BilheteCompletoDTO> obterBilhetePorId (String id);
    Optional<BilheteCompletoDTO> atualizarBilhetePorId(String id, BilheteCompletoDTO bilheteAtualizado );
    String deletarBilhetePorId(String id );
}
