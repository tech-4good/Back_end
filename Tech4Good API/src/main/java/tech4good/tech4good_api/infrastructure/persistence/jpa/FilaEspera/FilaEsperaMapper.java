package tech4good.tech4good_api.infrastructure.persistence.jpa.FilaEspera;

import tech4good.tech4good_api.core.application.command.filaespera.*;
import tech4good.tech4good_api.core.application.dto.filaespera.FilaEsperaRequestDto;
import tech4good.tech4good_api.core.application.dto.filaespera.FilaEsperaResponseDto;
import tech4good.tech4good_api.core.application.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

public class FilaEsperaMapper {
    public static CadastrarFilaEsperaCommand toCadastrarCommand(FilaEsperaRequestDto dto, Beneficiado beneficiado) {
        if (dto == null || beneficiado == null) return null;
        return new CadastrarFilaEsperaCommand(dto.getDataEntradaFila(), beneficiado);
    }

    public static AtualizarFilaEsperaCommand toAtualizarCommand(Integer id, FilaEsperaRequestDto dto, Beneficiado beneficiado) {
        if (dto == null || beneficiado == null) return null;
        return new AtualizarFilaEsperaCommand(id, dto.getDataEntradaFila(), null, beneficiado);
    }

    public static RemoverFilaEsperaCommand toRemoverCommand(Integer id) {
        return new RemoverFilaEsperaCommand(id);
    }

    public static BuscarFilaEsperaPorIdCommand toBuscarPorIdCommand(Integer id) {
        return new BuscarFilaEsperaPorIdCommand(id);
    }

    public static FilaEsperaResponseDto toResponseDto(FilaEspera filaEspera) {
        if (filaEspera == null) return null;
        Beneficiado beneficiado = filaEspera.getBeneficiado();
        BeneficiadoSummarizedResponseDto beneficiadoDto = beneficiado != null ?
            new BeneficiadoSummarizedResponseDto(beneficiado.getCpf(), beneficiado.getNome()) : null;
        return new FilaEsperaResponseDto(
            filaEspera.getId(),
            filaEspera.getDataEntradaFila(),
            filaEspera.getDataSaidaFila(),
            beneficiadoDto
        );
    }
}
