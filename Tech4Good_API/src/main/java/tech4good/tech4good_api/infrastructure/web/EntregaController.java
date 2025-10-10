package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.dto.common.PagedResponseDto;
import tech4good.tech4good_api.core.application.dto.common.PagedResponseMapper;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaRequestDto;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaResponseDto;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaUpdateDto;
import tech4good.tech4good_api.core.application.dto.entrega.EntregaUpdateResponseDto;
import tech4good.tech4good_api.core.application.usecase.entrega.*;
import tech4good.tech4good_api.core.domain.entrega.Entrega;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega.EntregaMapper;

import java.time.LocalDate;

@Tag(name = "Controller - Entrega", description = "Operações relacionadas às doações das cestas básicas ou kits.")
@RestController
@RequestMapping("/entregas")
@SecurityRequirement(name = "Bearer")
public class EntregaController {

    private final CadastrarEntregaUseCase cadastrarEntregaUseCase;
    private final AtualizarEntregaUseCase atualizarEntregaUseCase;
    private final BuscarEntregaPorIdUseCase buscarEntregaPorIdUseCase;
    private final RemoverEntregaPorIdUseCase removerEntregaPorIdUseCase;
    private final ListarEntregasUseCase listarEntregasUseCase;
    private final ListarHistoricoEntregasUseCase listarHistoricoEntregasUseCase;

    public EntregaController(CadastrarEntregaUseCase cadastrarEntregaUseCase,
                           AtualizarEntregaUseCase atualizarEntregaUseCase,
                           BuscarEntregaPorIdUseCase buscarEntregaPorIdUseCase,
                           RemoverEntregaPorIdUseCase removerEntregaPorIdUseCase,
                           ListarEntregasUseCase listarEntregasUseCase,
                           ListarHistoricoEntregasUseCase listarHistoricoEntregasUseCase) {
        this.cadastrarEntregaUseCase = cadastrarEntregaUseCase;
        this.atualizarEntregaUseCase = atualizarEntregaUseCase;
        this.buscarEntregaPorIdUseCase = buscarEntregaPorIdUseCase;
        this.removerEntregaPorIdUseCase = removerEntregaPorIdUseCase;
        this.listarEntregasUseCase = listarEntregasUseCase;
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
    public ResponseEntity<PagedResponseDto<EntregaResponseDto>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "dataRetirada") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDirection
    ) {
        Sort.Direction direction = sortDirection.equalsIgnoreCase("desc")
            ? Sort.Direction.DESC
            : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Entrega> entregasPage = listarEntregasUseCase.executar(pageable);

        if (entregasPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        PagedResponseDto<EntregaResponseDto> response = PagedResponseMapper.toPagedResponseDto(
            entregasPage,
            EntregaMapper::toResponseDto
        );

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntregaUpdateResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody EntregaUpdateDto dto) {
        var command = EntregaMapper.toUpdateCommand(dto);
        Entrega entregaAtualizada = atualizarEntregaUseCase.executar(id, command);
        EntregaUpdateResponseDto entregaDto = EntregaMapper.toUpdateResponseDto(entregaAtualizada);
        return ResponseEntity.ok(entregaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        var command = EntregaMapper.toRemoveCommand(id);
        removerEntregaPorIdUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/historico/{idBeneficiado}")
    public ResponseEntity<PagedResponseDto<EntregaResponseDto>> listarHistoricoEntregas(
            @PathVariable Integer idBeneficiado,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "dataRetirada") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDirection
    ) {
        Sort.Direction direction = sortDirection.equalsIgnoreCase("desc")
            ? Sort.Direction.DESC
            : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<Entrega> entregasPage = listarHistoricoEntregasUseCase.executar(
            idBeneficiado, dataInicio, dataFim, pageable
        );

        if (entregasPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        PagedResponseDto<EntregaResponseDto> response = PagedResponseMapper.toPagedResponseDto(
            entregasPage,
            EntregaMapper::toResponseDto
        );

        return ResponseEntity.ok(response);
    }
}
