package org.projetos.processoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CriarProcessoDTO {

    private String protocolo;

    private String cnpj;

    private String cnae;

    private String codigoEvento;

    private String status;

    private String descricao;


}
