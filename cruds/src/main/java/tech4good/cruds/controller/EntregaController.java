package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.entrega.EntregaRequestDto;
import tech4good.cruds.dto.entrega.EntregaResponseDto;
import tech4good.cruds.dto.entrega.EntregaUpdateDto;
import tech4good.cruds.entity.Entrega;
import tech4good.cruds.mapper.EnderecoMapper;
import tech4good.cruds.mapper.EntregaMapper;
import tech4good.cruds.service.EntregaService;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Controller - Entrega", description = "Operações relacionadas as doações das cestas básicas ou kits.")
@RestController
@RequestMapping("/entregas")
@SecurityRequirement(name = "Bearer")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @PostMapping
    public ResponseEntity<EntregaResponseDto> cadastrar(@RequestBody EntregaRequestDto dto) {
        Entrega entrega = EntregaMapper.toEntity(dto);
        Entrega novaEntrega = entregaService.cadastrarEntrega(entrega, dto.getEnderecoId(),
                dto.getVoluntarioId(), dto.getCestaId(), dto.getBeneficiadoId());
        EntregaResponseDto dtoSalvo = EntregaMapper.toResponseDto(novaEntrega);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponseDto> buscarPorId(@PathVariable Integer id) {
        Entrega entrega = entregaService.buscarEntregaPorId(id);
        EntregaResponseDto entregaDto = EntregaMapper.toResponseDto(entrega);
        return ResponseEntity.ok(entregaDto);
    }

    @GetMapping
    public ResponseEntity<List<EntregaResponseDto>> listar() {
        List<Entrega> entregas = entregaService.listarEntregas();
        List<EntregaResponseDto> entregaListagem = entregas.stream().map(EntregaMapper::toResponseDto).toList();
        return entregas.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(entregaListagem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntregaResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody EntregaUpdateDto dto) {
        Entrega entrega = EntregaMapper.toUpdate(dto, id);
        Entrega entregaAtualizada = entregaService.atualizarEntrega(entrega, id);
        EntregaResponseDto entregaDto = EntregaMapper.toResponseDto(entregaAtualizada);
        return ResponseEntity.ok(entregaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        entregaService.removerEntregaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/historico/{idBeneficiado}")
    public ResponseEntity<List<EntregaResponseDto>> listarHistoricoEntregas(
            @PathVariable Integer idBeneficiado,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim
    ) {
        List<Entrega> entregas = entregaService.listarEntregasPorBeneficiadoComFiltro(idBeneficiado, dataInicio, dataFim);
        if (entregas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<EntregaResponseDto> resposta = entregas.stream()
                .map(EntregaMapper::toResponseDto)
                .toList();
        return ResponseEntity.ok(resposta);
    }

}