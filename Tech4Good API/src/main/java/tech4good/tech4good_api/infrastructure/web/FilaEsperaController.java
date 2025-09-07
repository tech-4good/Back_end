package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.command.filaespera.*;
import tech4good.tech4good_api.core.application.dto.filaespera.FilaEsperaRequestDto;
import tech4good.tech4good_api.core.application.dto.filaespera.FilaEsperaResponseDto;
import tech4good.tech4good_api.core.application.dto.filaespera.FilaEsperaUpdateDto;
import tech4good.tech4good_api.core.application.usecase.filaespera.*;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.infrastructure.persistence.jpa.FilaEspera.FilaEsperaMapper;

import java.util.List;

@Tag(name = "Controller - Fila de Espera", description = "Operações relacionadas à fila de espera dos beneficiados.")
@RestController
@RequestMapping("/fila-espera")
@SecurityRequirement(name = "Bearer")
public class FilaEsperaController {

    private final CadastrarFilaEsperaUseCase cadastrarFilaEsperaUseCase;
    private final ListarFilaEsperaUseCase listarFilaEsperaUseCase;
    private final BuscarFilaEsperaPorIdUseCase buscarFilaEsperaPorIdUseCase;
    private final AtualizarFilaEsperaUseCase atualizarFilaEsperaUseCase;
    private final RemoverFilaEsperaUseCase removerFilaEsperaUseCase;
    private final BeneficiadoGateway beneficiadoGateway;

    public FilaEsperaController(
        CadastrarFilaEsperaUseCase cadastrarFilaEsperaUseCase,
        ListarFilaEsperaUseCase listarFilaEsperaUseCase,
        BuscarFilaEsperaPorIdUseCase buscarFilaEsperaPorIdUseCase,
        AtualizarFilaEsperaUseCase atualizarFilaEsperaUseCase,
        RemoverFilaEsperaUseCase removerFilaEsperaUseCase,
        BeneficiadoGateway beneficiadoGateway
    ) {
        this.cadastrarFilaEsperaUseCase = cadastrarFilaEsperaUseCase;
        this.listarFilaEsperaUseCase = listarFilaEsperaUseCase;
        this.buscarFilaEsperaPorIdUseCase = buscarFilaEsperaPorIdUseCase;
        this.atualizarFilaEsperaUseCase = atualizarFilaEsperaUseCase;
        this.removerFilaEsperaUseCase = removerFilaEsperaUseCase;
        this.beneficiadoGateway = beneficiadoGateway;
    }

    @Operation(summary = "Cadastrar na fila de espera", description = "Adiciona um beneficiado à fila de espera")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Beneficiado adicionado à fila de espera com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid FilaEsperaRequestDto dto) {
        Beneficiado beneficiado = beneficiadoGateway.findById(dto.getBeneficiadoId());
        CadastrarFilaEsperaCommand command = FilaEsperaMapper.toCadastrarCommand(dto, beneficiado);
        cadastrarFilaEsperaUseCase.executar(command);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<FilaEsperaResponseDto>> listar() {
        List<FilaEspera> filaEsperas = listarFilaEsperaUseCase.executar();
        if (filaEsperas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        List<FilaEsperaResponseDto> responseList = filaEsperas.stream()
            .map(FilaEsperaMapper::toResponseDto)
            .toList();
        return ResponseEntity.status(200).body(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilaEsperaResponseDto> buscarPorId(@PathVariable Integer id) {
        BuscarFilaEsperaPorIdCommand command = FilaEsperaMapper.toBuscarPorIdCommand(id);
        FilaEspera filaEspera = buscarFilaEsperaPorIdUseCase.executar(command);
        if (filaEspera == null) {
            return ResponseEntity.status(404).build();
        }
        FilaEsperaResponseDto response = FilaEsperaMapper.toResponseDto(filaEspera);
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilaEsperaResponseDto> atualizar(
        @PathVariable Integer id,
        @RequestBody @Valid FilaEsperaUpdateDto dto
    ) {
        AtualizarFilaEsperaCommand command = FilaEsperaMapper.toAtualizarCommand(id, dto);
        FilaEspera filaEsperaAtualizada = atualizarFilaEsperaUseCase.executar(command);
        FilaEsperaResponseDto response = FilaEsperaMapper.toResponseDto(filaEsperaAtualizada);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        RemoverFilaEsperaCommand command = FilaEsperaMapper.toRemoverCommand(id);
        removerFilaEsperaUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }
}
