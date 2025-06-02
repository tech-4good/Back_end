package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.cesta.CestaRequestDto;
import tech4good.cruds.dto.cesta.CestaResponseDto;
import tech4good.cruds.entity.Cesta;
import tech4good.cruds.mapper.CestaMapper;
import tech4good.cruds.service.CestaService;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Tag(name = "Controller - Cesta", description = "Operações relacionadas as cestas básicas e kits.")
@RestController
@RequestMapping("/cestas")
@SecurityRequirement(name = "Bearer")
public class CestaController {

    private final CestaService cestaService;

    public CestaController(CestaService cestaService) {
        this.cestaService = cestaService;
    }

    @PostMapping
    public ResponseEntity<CestaResponseDto> cadastrar(
            @RequestBody CestaRequestDto dto
    ) {
        Cesta cesta = CestaMapper.toEntity(dto);
        Cesta cestaRegistrada = cestaService.cadastrarCesta(cesta);
        CestaResponseDto dtoSalvo = CestaMapper.toResponseDto(cestaRegistrada);

        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<CestaResponseDto>> listar() {
        List<Cesta> cestas = cestaService.listarCestas();
        List<CestaResponseDto> cestaListagem = cestas.stream().map(CestaMapper::toResponseDto).toList();
        if (cestas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(cestaListagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CestaResponseDto> buscarPorId(@PathVariable Integer id) {
        Cesta cestaEncontrada = cestaService.buscarCestaPorId(id);
        CestaResponseDto cestaDto = CestaMapper.toResponseDto(cestaEncontrada);
        return ResponseEntity.status(200).body(cestaDto);
    }

    @GetMapping("/historico/{idBeneficiado}")
    public ResponseEntity<List<CestaResponseDto>> listarHistoricoCestasPorBeneficiado(
            @PathVariable Integer idBeneficiado,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.time.LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.time.LocalDate dataFim,
            @RequestParam(required = false) String tipo
    ) {
        List<Cesta> cestas = cestaService.listarCestasEntreguesPorBeneficiadoComFiltro(idBeneficiado, dataInicio, dataFim, tipo);
        if (cestas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        List<CestaResponseDto> resposta = cestas.stream().map(CestaMapper::toResponseDto).toList();
        return ResponseEntity.status(200).body(resposta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CestaResponseDto> atualizar(
            @RequestBody Cesta cestaNova,
            @PathVariable Integer id
    ) {
        cestaNova.setIdCesta(id);
        Cesta cestaAlterada = cestaService.atualizarCestaPorId(cestaNova);
        CestaResponseDto cestoDto = CestaMapper.toResponseDto(cestaAlterada);
        return ResponseEntity.status(200).body(cestoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cestaService.removerCesta(id);
        return ResponseEntity.status(204).build();
    }
}

