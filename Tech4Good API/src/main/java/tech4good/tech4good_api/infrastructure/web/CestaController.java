package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.command.cesta.AtualizarCestaCommand;
import tech4good.tech4good_api.core.application.command.cesta.CadastrarCestaCommand;
import tech4good.tech4good_api.core.application.command.cesta.ListarCestaPorIdCommand;
import tech4good.tech4good_api.core.application.command.cesta.RemoverCestaPorIdCommand;
import tech4good.tech4good_api.core.application.dto.cesta.CestaRequestDto;
import tech4good.tech4good_api.core.application.dto.cesta.CestaResponseDto;
import tech4good.tech4good_api.core.application.dto.cesta.CestaUpdateDto;
import tech4good.tech4good_api.core.application.usecase.cesta.*;
import tech4good.tech4good_api.core.domain.cesta.Cesta;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta.CestaMapper;

import java.util.List;

@Tag(name = "Controller - Cesta", description = "Operações relacionadas as cestas básicas e kits.")
@RestController
@RequestMapping("/cestas")
@SecurityRequirement(name = "Bearer")
public class CestaController {

    private final CadastrarCestaUseCase cadastrarCestaUseCase;
    private final BuscarCestaPorIdUseCase buscarCestaPorIdUseCase;
    private final ListarCestasUseCase listarCestasUseCase;
    private final AtualizarCestaUseCase atualizarCestaUseCase;
    private final RemoverCestaUseCase removerCestaUseCase;

    public CestaController(CadastrarCestaUseCase cadastrarCestaUseCase,
                          BuscarCestaPorIdUseCase buscarCestaPorIdUseCase,
                          ListarCestasUseCase listarCestasUseCase,
                          AtualizarCestaUseCase atualizarCestaUseCase,
                          RemoverCestaUseCase removerCestaUseCase) {
        this.cadastrarCestaUseCase = cadastrarCestaUseCase;
        this.buscarCestaPorIdUseCase = buscarCestaPorIdUseCase;
        this.listarCestasUseCase = listarCestasUseCase;
        this.atualizarCestaUseCase = atualizarCestaUseCase;
        this.removerCestaUseCase = removerCestaUseCase;
    }

    @Operation(summary = "Cadastrar cesta", description = "Cria uma nova cesta básica ou kit no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cesta criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<CestaResponseDto> cadastrar(@Valid @RequestBody CestaRequestDto dto) {
        CadastrarCestaCommand command = CestaMapper.toCommand(dto);
        Cesta cestaRegistrada = cadastrarCestaUseCase.executar(command);
        CestaResponseDto responseDto = CestaMapper.toResponseDto(cestaRegistrada);
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<CestaResponseDto>> listar() {
        List<Cesta> cestas = listarCestasUseCase.executar();
        List<CestaResponseDto> cestaListagem = cestas.stream()
                .map(CestaMapper::toResponseDto)
                .toList();

        if (cestas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cestaListagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CestaResponseDto> buscarPorId(@PathVariable Integer id) {
        ListarCestaPorIdCommand command = new ListarCestaPorIdCommand(id);
        Cesta cestaEncontrada = buscarCestaPorIdUseCase.executar(command);
        CestaResponseDto cestaDto = CestaMapper.toResponseDto(cestaEncontrada);
        return ResponseEntity.ok(cestaDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CestaResponseDto> atualizar(
            @Valid @RequestBody CestaUpdateDto dto,
            @PathVariable Integer id) {
        AtualizarCestaCommand command = CestaMapper.toAtualizarCommand(id, dto);
        Cesta cestaAlterada = atualizarCestaUseCase.executar(command);
        CestaResponseDto responseDto = CestaMapper.toResponseDto(cestaAlterada);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        RemoverCestaPorIdCommand command = new RemoverCestaPorIdCommand(id);
        removerCestaUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }
}
