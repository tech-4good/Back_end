package tech4good.tech4good_api.core.application.dto.filaespera;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilaEsperaEventDto {
    private Integer filaEsperaId;
    private Integer beneficiadoId;
    private String beneficiadoNome;
    private LocalDate dataEntradaFila;
    private TipoEventoFilaEspera tipoEvento;
    private String mensagem;
}
