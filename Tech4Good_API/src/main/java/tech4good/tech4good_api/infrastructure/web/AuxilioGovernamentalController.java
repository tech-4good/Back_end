package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.command.auxiliogovernamental.BuscarAuxilioGovernamentalPorIdCommand;
import tech4good.tech4good_api.core.application.command.auxiliogovernamental.RemoverAuxilioGovernamentalPorIdCommand;
import tech4good.tech4good_api.core.application.dto.auxiliogovernamental.AuxilioGovernamentalAtualizarRequestDto;
import tech4good.tech4good_api.core.application.dto.auxiliogovernamental.AuxilioGovernamentalRequestDto;
import tech4good.tech4good_api.core.application.dto.auxiliogovernamental.AuxilioGovernamentalResponseDto;
import tech4good.tech4good_api.core.application.usecase.auxiliogovernamental.*;
import tech4good.tech4good_api.core.domain.auxiliogovernamental.AuxilioGovernamental;
import tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental.AuxilioGovernamentalMapper;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Controller - Auxílio Governamental", description = "Operações relacionadas aos auxílios disponibilizados pelo governo.")
@RestController
@RequestMapping("/auxilio-governamentais")
@SecurityRequirement(name = "Bearer")
public class AuxilioGovernamentalController {

    private final CadastrarAuxilioGovernamentalUseCase cadastrarAuxilioGovernamentalUseCase;
    private final AtualizarAuxilioGovernamentalUseCase atualizarAuxilioGovernamentalUseCase;
    private final BuscarAuxilioGovernamentalPorIdUseCase buscarAuxilioGovernamentalPorIdUseCase;
    private final ListarAuxilioGovernamentalUseCase listarAuxilioGovernamentalUseCase;
    private final RemoverAuxilioGovernamentalPorIdUseCase removerAuxilioGovernamentalPorIdUseCase;

    public AuxilioGovernamentalController(CadastrarAuxilioGovernamentalUseCase cadastrarAuxilioGovernamentalUseCase,
                                        AtualizarAuxilioGovernamentalUseCase atualizarAuxilioGovernamentalUseCase,
                                        BuscarAuxilioGovernamentalPorIdUseCase buscarAuxilioGovernamentalPorIdUseCase,
                                        ListarAuxilioGovernamentalUseCase listarAuxilioGovernamentalUseCase,
                                        RemoverAuxilioGovernamentalPorIdUseCase removerAuxilioGovernamentalPorIdUseCase) {
        this.cadastrarAuxilioGovernamentalUseCase = cadastrarAuxilioGovernamentalUseCase;
        this.atualizarAuxilioGovernamentalUseCase = atualizarAuxilioGovernamentalUseCase;
        this.buscarAuxilioGovernamentalPorIdUseCase = buscarAuxilioGovernamentalPorIdUseCase;
        this.listarAuxilioGovernamentalUseCase = listarAuxilioGovernamentalUseCase;
        this.removerAuxilioGovernamentalPorIdUseCase = removerAuxilioGovernamentalPorIdUseCase;
    }

    @Operation(summary = "Cadastrar auxílio governamental", description = "Cria um novo auxílio governamental no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Auxílio governamental criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<AuxilioGovernamentalResponseDto> cadastrar(@Valid @RequestBody AuxilioGovernamentalRequestDto dto) {
        var command = AuxilioGovernamentalMapper.toCommand(dto);
        AuxilioGovernamental auxilio = cadastrarAuxilioGovernamentalUseCase.executar(command);
        AuxilioGovernamentalResponseDto responseDto = AuxilioGovernamentalMapper.toResponseDto(auxilio);
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuxilioGovernamentalResponseDto> buscarPorId(@PathVariable Integer id) {
        var command = new BuscarAuxilioGovernamentalPorIdCommand(id);
        AuxilioGovernamental auxilio = buscarAuxilioGovernamentalPorIdUseCase.executar(command);
        AuxilioGovernamentalResponseDto responseDto = AuxilioGovernamentalMapper.toResponseDto(auxilio);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<AuxilioGovernamentalResponseDto>> listar() {
        List<AuxilioGovernamental> auxilios = listarAuxilioGovernamentalUseCase.executar();
        List<AuxilioGovernamentalResponseDto> auxiliosDto = auxilios.stream()
                .map(AuxilioGovernamentalMapper::toResponseDto)
                .collect(Collectors.toList());

        if (auxiliosDto.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(auxiliosDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuxilioGovernamentalResponseDto> atualizar(@PathVariable Integer id,
                                                                   @Valid @RequestBody AuxilioGovernamentalAtualizarRequestDto dto) {
        var command = AuxilioGovernamentalMapper.toUpdateCommand(dto);
        AuxilioGovernamental auxilio = atualizarAuxilioGovernamentalUseCase.executar(id, command);
        AuxilioGovernamentalResponseDto responseDto = AuxilioGovernamentalMapper.toResponseDto(auxilio);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        var command = new RemoverAuxilioGovernamentalPorIdCommand(id);
        removerAuxilioGovernamentalPorIdUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }
}
