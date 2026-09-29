package org.projetos.processoapi.service;

import org.projetos.processoapi.dto.CriarProcessoDTO;
import org.projetos.processoapi.dto.EditarProcessoDTO;
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
    public Processo criarProcesso(CriarProcessoDTO processoDTO) {
        Processo processo = new Processo();

        processo.setProtocolo(processoDTO.getProtocolo());
        processo.setCnae(processoDTO.getCnae());
        processo.setCnpj(processoDTO.getCnpj());
        processo.setCodigoEvento(processoDTO.getCodigoEvento());
        processo.setDescricao(processoDTO.getDescricao());

        return processoRepository.save(processo);

    }

    @Override
    public Processo editarProcesso(Long id, EditarProcessoDTO dto) {
        Processo processo = processoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Processo não encontrado.")
        );
        processo.setDescricao(dto.descricao());
        processo.setCnae(dto.cnae());
        return processoRepository.save(processo);
    }

    @Override
    public Processo removeProcesso(Long id) {
        Processo processo = processoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Nenhum processo encontrado.")
        );
        processoRepository.delete(processo);
        return processo;
    }

    @Override
    public List<Processo> listarTodos() {
        List<Processo>processos = processoRepository.findAll();
        if(processos.isEmpty()){
            throw new RuntimeException("Não há processos cadastrados");
        }
        return processos;
    }

}
