package org.projetos.processoapi.controller;

import org.projetos.processoapi.dto.CriarProcessoDTO;
import org.projetos.processoapi.dto.EditarProcessoDTO;
import org.projetos.processoapi.dto.ProcessoResponseDTO;
import org.projetos.processoapi.model.Processo;
import org.projetos.processoapi.service.ProcessoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processos")
public class ProcessoController {

    @Autowired
    private ProcessoServiceInterface processoServiceInterface;

    @PostMapping ("/novoProcesso")
    public ResponseEntity novoProcesso(@RequestBody CriarProcessoDTO dto){
                Processo processo = processoServiceInterface.criarProcesso(dto);
           return ResponseEntity.ok(processo);
    }

    @PutMapping("/editarProcesso/{id}")
    public ResponseEntity editarProcesso(@PathVariable Long id, EditarProcessoDTO dto){
            Processo processoAtualizado = processoServiceInterface.editarProcesso(id, dto);
            return ResponseEntity.ok(new RuntimeException(
                "Processo editado com sucesso!"
            ));
    }

    @PutMapping("/updateProcesso/{id}")
    public ResponseEntity<ProcessoResponseDTO>updateProcesso(@PathVariable Long id, @RequestBody EditarProcessoDTO dto){

        Processo processo = processoServiceInterface.editarProcesso(id, dto);

        return ResponseEntity.ok(new ProcessoResponseDTO(
           "Processo editado com sucesso!",
                processo.getId(),
                processo.getDescricao(),
                processo.getCnae()
        ));
    }

    @DeleteMapping("/deleteProcesso/{id}")
    public ResponseEntity<ProcessoResponseDTO>removeProcesso(@PathVariable Long id){
        Processo processo = processoServiceInterface.removeProcesso(id);
        return ResponseEntity.ok(new ProcessoResponseDTO(
                "Processo removido com sucesso!",
                processo.getId(),
                processo.getDescricao(),
                processo.getCnae()
        ));


    }

    @GetMapping
    public ResponseEntity<List<Processo>>listarTodos(){
        return ResponseEntity.ok(processoServiceInterface.listarTodos());
    }
}
