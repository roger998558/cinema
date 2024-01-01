package br.com.tech4me.sala.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.sala.shared.SalaCompletaDTO;
import br.com.tech4me.sala.shared.SalaDTO;

public interface ServiceSala {
    List<SalaDTO> listarSalas();
    Optional<SalaCompletaDTO> obterPorNumeroDaSala (Integer numeroDasala );
    SalaCompletaDTO cadastrarSala (SalaCompletaDTO novaSala);
    Optional<SalaCompletaDTO> atualizarPornumeroDaSala (Integer numeroDaSala,SalaCompletaDTO salaCompleto );
    String deletarPornumeroDaSala (Integer numeroDasala );
 


}
