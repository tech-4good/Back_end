package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.dto.tipomorador.TipoMoradorRequestDto;
import tech4good.tech4good_api.core.application.dto.tipomorador.TipoMoradorResponseDto;
import tech4good.tech4good_api.core.application.dto.tipomorador.TipoMoradorUpdateDto;
import tech4good.tech4good_api.core.application.usecase.tipomorador.*;
import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;
import tech4good.tech4good_api.infrastructure.persistence.jpa.TipoMorador.TipoMoradorMapper;

import java.util.List;

@Tag(name = "Controller - Tipo de Morador", description = "Operações relacionadas aos tipos de moradores que residem nos endereços.")
@RestController
@RequestMapping("/tipo-moradores")
@SecurityRequirement(name = "Bearer")
public class TipoMoradorController {

    private final CadastrarTipoMoradorUseCase cadastrarTipoMoradorUseCase;
    private final AtualizarTipoMoradorUseCase atualizarTipoMoradorUseCase;
    private final BuscarTipoMoradorPorIdUseCase buscarTipoMoradorPorIdUseCase;
    private final ListarTipoMoradoresUseCase listarTipoMoradoresUseCase;
    private final RemoverTipoMoradorUseCase removerTipoMoradorUseCase;

    public TipoMoradorController(
            CadastrarTipoMoradorUseCase cadastrarTipoMoradorUseCase,
            AtualizarTipoMoradorUseCase atualizarTipoMoradorUseCase,
            BuscarTipoMoradorPorIdUseCase buscarTipoMoradorPorIdUseCase,
            ListarTipoMoradoresUseCase listarTipoMoradoresUseCase,
            RemoverTipoMoradorUseCase removerTipoMoradorUseCase) {
        this.cadastrarTipoMoradorUseCase = cadastrarTipoMoradorUseCase;
        this.atualizarTipoMoradorUseCase = atualizarTipoMoradorUseCase;
        this.buscarTipoMoradorPorIdUseCase = buscarTipoMoradorPorIdUseCase;
        this.listarTipoMoradoresUseCase = listarTipoMoradoresUseCase;
        this.removerTipoMoradorUseCase = removerTipoMoradorUseCase;
    }

    @PostMapping
    public ResponseEntity<TipoMoradorResponseDto> cadastrar(@RequestBody TipoMoradorRequestDto dto) {
        var command = TipoMoradorMapper.toCommand(dto);
        TipoMorador novoTipoMorador = cadastrarTipoMoradorUseCase.execute(command);
        TipoMoradorResponseDto dtoSalvo = TipoMoradorMapper.toResponseDto(novoTipoMorador);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMoradorResponseDto> buscarPorId(@PathVariable Integer id) {
        var command = TipoMoradorMapper.toIdCommand(id);
        TipoMorador tipoMorador = buscarTipoMoradorPorIdUseCase.execute(command);
        TipoMoradorResponseDto moradorDto = TipoMoradorMapper.toResponseDto(tipoMorador);
        return ResponseEntity.ok(moradorDto);
    }

    @GetMapping
    public ResponseEntity<List<TipoMoradorResponseDto>> listar() {
        List<TipoMorador> tiposMoradores = listarTipoMoradoresUseCase.execute();
        List<TipoMoradorResponseDto> tiposMoradoresListagem = tiposMoradores.stream().map(TipoMoradorMapper::toResponseDto).toList();
        return tiposMoradores.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(tiposMoradoresListagem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoMoradorResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody TipoMoradorUpdateDto dto) {
        var command = TipoMoradorMapper.toCommand(dto, id);
        TipoMorador tipoMoradorAtualizado = atualizarTipoMoradorUseCase.execute(command);
        TipoMoradorResponseDto tipoMoradorDto = TipoMoradorMapper.toResponseDto(tipoMoradorAtualizado);
        return ResponseEntity.ok(tipoMoradorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        var command = TipoMoradorMapper.toRemoveCommand(id);
        removerTipoMoradorUseCase.execute(command);
        return ResponseEntity.noContent().build();
    }
}
