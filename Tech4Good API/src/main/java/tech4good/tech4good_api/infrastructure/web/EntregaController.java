package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaRequestDto;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaResponseDto;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaUpdateDto;
import tech4good.tech4good_api.core.application.usecase.entrega.*;
import tech4good.tech4good_api.core.domain.entrega.Entrega;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega.EntregaMapper;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Controller - Entrega", description = "Operações relacionadas às doações das cestas básicas ou kits.")
@RestController
@RequestMapping("/entregas")
@SecurityRequirement(name = "Bearer")
public class EntregaController {

    private final CadastrarEntregaUseCase cadastrarEntregaUseCase;
    private final AtualizarEntregaUseCase atualizarEntregaUseCase;
    private final BuscarEntregaPorIdUseCase buscarEntregaPorIdUseCase;
    private final ListarEntregasUseCase listarEntregasUseCase;
    private final RemoverEntregaPorIdUseCase removerEntregaPorIdUseCase;
    private final ListarHistoricoEntregasUseCase listarHistoricoEntregasUseCase;

    public EntregaController(CadastrarEntregaUseCase cadastrarEntregaUseCase,
                           AtualizarEntregaUseCase atualizarEntregaUseCase,
                           BuscarEntregaPorIdUseCase buscarEntregaPorIdUseCase,
                           ListarEntregasUseCase listarEntregasUseCase,
                           RemoverEntregaPorIdUseCase removerEntregaPorIdUseCase,
                           ListarHistoricoEntregasUseCase listarHistoricoEntregasUseCase) {
        this.cadastrarEntregaUseCase = cadastrarEntregaUseCase;
        this.atualizarEntregaUseCase = atualizarEntregaUseCase;
        this.buscarEntregaPorIdUseCase = buscarEntregaPorIdUseCase;
        this.listarEntregasUseCase = listarEntregasUseCase;
        this.removerEntregaPorIdUseCase = removerEntregaPorIdUseCase;
        this.listarHistoricoEntregasUseCase = listarHistoricoEntregasUseCase;
    }

    @PostMapping
    public ResponseEntity<EntregaResponseDto> cadastrar(@RequestBody EntregaRequestDto dto) {
        var command = EntregaMapper.toCommand(dto);
        Entrega novaEntrega = cadastrarEntregaUseCase.executar(command);
        EntregaResponseDto dtoSalvo = EntregaMapper.toResponseDto(novaEntrega);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponseDto> buscarPorId(@PathVariable Integer id) {
        var command = EntregaMapper.toIdCommand(id);
        Entrega entrega = buscarEntregaPorIdUseCase.executar(command);
        EntregaResponseDto entregaDto = EntregaMapper.toResponseDto(entrega);
        return ResponseEntity.ok(entregaDto);
    }

    @GetMapping
    public ResponseEntity<List<EntregaResponseDto>> listar() {
        List<Entrega> entregas = listarEntregasUseCase.executar();
        List<EntregaResponseDto> entregaListagem = entregas.stream().map(EntregaMapper::toResponseDto).toList();
        return entregas.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(entregaListagem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntregaResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody EntregaUpdateDto dto) {
        var command = EntregaMapper.toUpdateCommand(dto);
        Entrega entregaAtualizada = atualizarEntregaUseCase.executar(id, command);
        EntregaResponseDto entregaDto = EntregaMapper.toResponseDto(entregaAtualizada);
        return ResponseEntity.ok(entregaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        var command = EntregaMapper.toRemoveCommand(id);
        removerEntregaPorIdUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/historico/{idBeneficiado}")
    public ResponseEntity<List<EntregaResponseDto>> listarHistoricoEntregas(
            @PathVariable Integer idBeneficiado,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim
    ) {
        var command = EntregaMapper.toHistoricoCommand(idBeneficiado, dataInicio, dataFim);
        List<Entrega> entregas = listarHistoricoEntregasUseCase.executar(command);
        if (entregas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<EntregaResponseDto> resposta = entregas.stream()
                .map(EntregaMapper::toResponseDto)
                .toList();
        return ResponseEntity.ok(resposta);
    }
}
