package org.projetos.processoapi.service;

import org.projetos.processoapi.dto.CriarProcessoDTO;
import org.projetos.processoapi.model.Processo;
import org.projetos.processoapi.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoServiceImpl implements ProcessoServiceInterface {

    @Autowired
    ProcessoRepository processoRepository;

    @Override
    public List<Processo> listarTodos() {
        return processoRepository.findAll();
    }

    @Override
    public Processo criarProcesso(CriarProcessoDTO processoDTO) {
        Processo processo = new Processo();

        processo.setProtocolo(processoDTO.getProtocolo());
        processo.setCnae(processoDTO.getCnae());
        processo.setCnpj(processoDTO.getCnpj());
        processo.setCodigoEvento(processoDTO.getCodigoEvento());
        processo.setDescricao(processoDTO.getDescricao());

        return processoRepository.save(processo);

    }
}
