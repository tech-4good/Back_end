package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
import tech4good.tech4good_api.infrastructure.integration.messaging.FilaEsperaMessageProducer;

import java.util.List;

@Tag(name = "Controller - Fila de Espera", description = "Operações relacionadas à fila de espera dos beneficiados.")
@RestController
@RequestMapping("/fila-espera")
@SecurityRequirement(name = "Bearer")
@Slf4j
public class FilaEsperaController {

    private final CadastrarFilaEsperaUseCase cadastrarFilaEsperaUseCase;
    private final ListarFilaEsperaUseCase listarFilaEsperaUseCase;
    private final BuscarFilaEsperaPorIdUseCase buscarFilaEsperaPorIdUseCase;
    private final AtualizarFilaEsperaUseCase atualizarFilaEsperaUseCase;
    private final RemoverFilaEsperaUseCase removerFilaEsperaUseCase;
    private final BeneficiadoGateway beneficiadoGateway;
    private final FilaEsperaMessageProducer messageProducer;

    public FilaEsperaController(
        CadastrarFilaEsperaUseCase cadastrarFilaEsperaUseCase,
        ListarFilaEsperaUseCase listarFilaEsperaUseCase,
        BuscarFilaEsperaPorIdUseCase buscarFilaEsperaPorIdUseCase,
        AtualizarFilaEsperaUseCase atualizarFilaEsperaUseCase,
        RemoverFilaEsperaUseCase removerFilaEsperaUseCase,
        BeneficiadoGateway beneficiadoGateway,
        FilaEsperaMessageProducer messageProducer
    ) {
        this.cadastrarFilaEsperaUseCase = cadastrarFilaEsperaUseCase;
        this.listarFilaEsperaUseCase = listarFilaEsperaUseCase;
        this.buscarFilaEsperaPorIdUseCase = buscarFilaEsperaPorIdUseCase;
        this.atualizarFilaEsperaUseCase = atualizarFilaEsperaUseCase;
        this.removerFilaEsperaUseCase = removerFilaEsperaUseCase;
        this.beneficiadoGateway = beneficiadoGateway;
        this.messageProducer = messageProducer;
    }

    @Operation(summary = "Cadastrar na fila de espera", description = "Adiciona um beneficiado à fila de espera e envia mensagem para RabbitMQ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Beneficiado adicionado à fila de espera com sucesso e mensagem enviada"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<FilaEsperaResponseDto> cadastrar(@RequestBody @Valid FilaEsperaRequestDto dto) {
        log.info("Iniciando cadastro na fila de espera para beneficiado ID: {}", dto.getBeneficiadoId());

        Beneficiado beneficiado = beneficiadoGateway.findById(dto.getBeneficiadoId());
        CadastrarFilaEsperaCommand command = FilaEsperaMapper.toCadastrarCommand(dto, beneficiado);

        FilaEspera filaEsperaCadastrada = cadastrarFilaEsperaUseCase.executar(command);

        log.info("Beneficiado {} cadastrado na fila de espera com sucesso! Mensagem enviada para RabbitMQ.",
                 beneficiado.getNome());

        FilaEsperaResponseDto responseDto = FilaEsperaMapper.toResponseDto(filaEsperaCadastrada);
        return ResponseEntity.status(201).body(responseDto);
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

    @PatchMapping("/{id}")
    public ResponseEntity<FilaEsperaResponseDto> atualizar(
        @PathVariable Integer id,
        @RequestBody @Valid FilaEsperaUpdateDto dto
    ) {
        AtualizarFilaEsperaCommand command = FilaEsperaMapper.toAtualizarCommand(id, dto);
        FilaEspera filaEsperaAtualizada = atualizarFilaEsperaUseCase.executar(command);
        FilaEsperaResponseDto response = FilaEsperaMapper.toResponseDto(filaEsperaAtualizada);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Remover da fila de espera", description = "Remove um beneficiado da fila de espera e envia mensagem para RabbitMQ")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        log.info("Iniciando remoção da fila de espera para ID: {}", id);

        RemoverFilaEsperaCommand command = FilaEsperaMapper.toRemoverCommand(id);

        // Este método já envia a mensagem automaticamente através do use case
        removerFilaEsperaUseCase.executar(command);

        log.info("Beneficiado removido da fila de espera com sucesso! Mensagem enviada para RabbitMQ.");

        return ResponseEntity.noContent().build();
    }

    /**
     * Endpoint para testar o envio de mensagem manualmente (apenas para testes)
     */
    @Operation(summary = "Testar mensageria", description = "Endpoint para testar o envio de mensagens da fila de espera")
    @PostMapping("/{id}/test-message")
    public ResponseEntity<String> testarMensagem(@PathVariable Integer id) {
        try {
            BuscarFilaEsperaPorIdCommand command = FilaEsperaMapper.toBuscarPorIdCommand(id);
            FilaEspera filaEspera = buscarFilaEsperaPorIdUseCase.executar(command);

            if (filaEspera == null) {
                return ResponseEntity.status(404).body("Fila de espera não encontrada");
            }

            // Testa envio manual da mensagem
            messageProducer.enviarEventoEntradaFila(filaEspera);

            return ResponseEntity.ok(String.format(
                "Mensagem de teste enviada com sucesso para beneficiado: %s",
                filaEspera.getBeneficiado().getNome()
            ));

        } catch (Exception e) {
            log.error("Erro ao testar mensagem: {}", e.getMessage());
            return ResponseEntity.internalServerError()
                .body("Erro ao enviar mensagem de teste: " + e.getMessage());
        }
    }
}
