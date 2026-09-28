package org.projetos.processoapi.controller;

import org.projetos.processoapi.dto.CriarProcessoDTO;
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

    @GetMapping
    public ResponseEntity<List<Processo>>listarTodos(){
        return ResponseEntity.ok(processoServiceInterface.listarTodos());
    }

    @PostMapping ("/novoProcesso")
    public ResponseEntity novoProcesso(@RequestBody CriarProcessoDTO processoDTO){
                Processo processo = processoServiceInterface.criarProcesso(processoDTO);
           return ResponseEntity.ok(processo);
    }
}
