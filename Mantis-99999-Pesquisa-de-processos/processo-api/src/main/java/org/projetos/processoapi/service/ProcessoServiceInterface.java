package org.projetos.processoapi.service;

import org.projetos.processoapi.dto.CriarProcessoDTO;
import org.projetos.processoapi.model.Processo;

import java.util.List;

public interface ProcessoServiceInterface {
    List<Processo> listarTodos();
    Processo criarProcesso(CriarProcessoDTO processoDTO);
}
