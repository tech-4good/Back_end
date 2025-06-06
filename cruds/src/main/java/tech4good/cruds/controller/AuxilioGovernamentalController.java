package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.auxiliogovernamental.AuxilioGovernamentalRequestDto;
import tech4good.cruds.dto.auxiliogovernamental.AuxilioGovernamentalResponseDto;
import tech4good.cruds.dto.auxiliogovernamental.AuxilioGovernamentalUpdatoDto;
import tech4good.cruds.entity.AuxilioGovernamental;
import tech4good.cruds.mapper.AuxilioGovernamentalMapper;
import tech4good.cruds.service.AuxilioGovernamentalService;

import java.util.List;

@Tag(name = "Controller - Auxílio Governamental", description = "Operações relacionadas aos auxílios disponibilizados pelo governo.")
@RestController
@RequestMapping("/auxilio-governamentais")
@SecurityRequirement(name = "Bearer")
public class AuxilioGovernamentalController {

    private final AuxilioGovernamentalService auxilioGovernamentalService;

    public AuxilioGovernamentalController(AuxilioGovernamentalService auxilioGovernamentalService) {
        this.auxilioGovernamentalService = auxilioGovernamentalService;
    }

    @PostMapping
    public ResponseEntity<AuxilioGovernamentalResponseDto> cadastrar(@Valid @RequestBody AuxilioGovernamentalRequestDto dto) {
       AuxilioGovernamental auxilio = AuxilioGovernamentalMapper.toEntity(dto);
       AuxilioGovernamental salvo = auxilioGovernamentalService.cadastrarAuxilioGovernamental(auxilio);
       AuxilioGovernamentalResponseDto dtoSalvo = AuxilioGovernamentalMapper.toResponseDto(salvo);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuxilioGovernamentalResponseDto> buscarPorId(@PathVariable Integer id) {
        AuxilioGovernamental auxilio = auxilioGovernamentalService.buscarAuxilioGovernamentalPorId(id);
        AuxilioGovernamentalResponseDto auxilioDto = AuxilioGovernamentalMapper.toResponseDto(auxilio);
        return ResponseEntity.ok(auxilioDto);
    }

    @GetMapping
    public ResponseEntity<List<AuxilioGovernamentalResponseDto>> listar() {
        List<AuxilioGovernamental> auxilios = auxilioGovernamentalService.listarAuxilioGovernamentals();
        List<AuxilioGovernamentalResponseDto> auxilioListagem = auxilios.stream().map(AuxilioGovernamentalMapper::toResponseDto).toList();
        if (auxilioListagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(auxilioListagem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuxilioGovernamentalResponseDto> atualizar(@PathVariable Integer id,
                                                          @RequestBody AuxilioGovernamentalUpdatoDto dto) {
        AuxilioGovernamental auxilio = AuxilioGovernamentalMapper.toUpdate(dto, id);
        AuxilioGovernamental atualizado = auxilioGovernamentalService.atualizarAuxilioGovernamental(auxilio, id);
        AuxilioGovernamentalResponseDto auxilioDto = AuxilioGovernamentalMapper.toResponseDto(atualizado);
        return ResponseEntity.ok(auxilioDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        auxilioGovernamentalService.removerAuxilioGovernamentalPorId(id);
        return ResponseEntity.noContent().build();
    }
}
