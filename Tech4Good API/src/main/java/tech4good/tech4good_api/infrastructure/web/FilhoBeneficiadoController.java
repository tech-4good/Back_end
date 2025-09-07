package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.dto.filhobeneficiado.FilhoBeneficiadoAtualizarRequestDto;
import tech4good.tech4good_api.core.application.dto.filhobeneficiado.FilhoBeneficiadoRequestDto;
import tech4good.tech4good_api.core.application.dto.filhobeneficiado.FilhoBeneficiadoResponseDto;
import tech4good.tech4good_api.core.application.command.filhobeneficiado.BuscarFilhoBeneficiadoPorIdCommand;
import tech4good.tech4good_api.core.application.command.filhobeneficiado.RemoverFilhoBeneficiadoPorIdCommand;
import tech4good.tech4good_api.core.application.usecase.filhobeneficiado.*;
import tech4good.tech4good_api.core.domain.filhobeneficiado.FilhoBeneficiado;
import tech4good.tech4good_api.infrastructure.persistence.jpa.FilhoBeneficiado.FilhoBeneficiadoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Controller - Filho Beneficiado", description = "Operações relacionadas aos filhos dos beneficiados pela ASA.")
@RestController
@RequestMapping("/filhos-beneficiados")
@SecurityRequirement(name = "Bearer")
public class FilhoBeneficiadoController {

    private final CriarFilhoBeneficiadoUseCase criarFilhoBeneficiadoUseCase;
    private final BuscarFilhoBeneficiadoPorIdUseCase buscarFilhoBeneficiadoPorIdUseCase;
    private final ListarFilhosBeneficiadosUseCase listarFilhosBeneficiadosUseCase;
    private final AtualizarFilhoBeneficiadoUseCase atualizarFilhoBeneficiadoUseCase;
    private final RemoverFilhoBeneficiadoPorIdUseCase removerFilhoBeneficiadoPorIdUseCase;

    public FilhoBeneficiadoController(CriarFilhoBeneficiadoUseCase criarFilhoBeneficiadoUseCase,
                                     BuscarFilhoBeneficiadoPorIdUseCase buscarFilhoBeneficiadoPorIdUseCase,
                                     ListarFilhosBeneficiadosUseCase listarFilhosBeneficiadosUseCase,
                                     AtualizarFilhoBeneficiadoUseCase atualizarFilhoBeneficiadoUseCase,
                                     RemoverFilhoBeneficiadoPorIdUseCase removerFilhoBeneficiadoPorIdUseCase) {
        this.criarFilhoBeneficiadoUseCase = criarFilhoBeneficiadoUseCase;
        this.buscarFilhoBeneficiadoPorIdUseCase = buscarFilhoBeneficiadoPorIdUseCase;
        this.listarFilhosBeneficiadosUseCase = listarFilhosBeneficiadosUseCase;
        this.atualizarFilhoBeneficiadoUseCase = atualizarFilhoBeneficiadoUseCase;
        this.removerFilhoBeneficiadoPorIdUseCase = removerFilhoBeneficiadoPorIdUseCase;
    }

    @Operation(summary = "Cadastrar filho de beneficiado", description = "Cria um novo registro de filho de beneficiado no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Filho de beneficiado criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<FilhoBeneficiadoResponseDto> cadastrar(@RequestBody FilhoBeneficiadoRequestDto dto) {
        var command = FilhoBeneficiadoMapper.toCommand(dto);
        FilhoBeneficiado filhoCriado = criarFilhoBeneficiadoUseCase.executar(command);
        FilhoBeneficiadoResponseDto dtoSalvo = FilhoBeneficiadoMapper.toResponseDto(filhoCriado);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilhoBeneficiadoResponseDto> buscarPorId(@PathVariable Integer id) {
        var command = new BuscarFilhoBeneficiadoPorIdCommand(id);
        FilhoBeneficiado filho = buscarFilhoBeneficiadoPorIdUseCase.executar(command);
        FilhoBeneficiadoResponseDto filhoDto = FilhoBeneficiadoMapper.toResponseDto(filho);
        return ResponseEntity.ok(filhoDto);
    }

    @GetMapping
    public ResponseEntity<List<FilhoBeneficiadoResponseDto>> listar() {
        List<FilhoBeneficiado> filhos = listarFilhosBeneficiadosUseCase.executar();
        List<FilhoBeneficiadoResponseDto> filhoListagem = filhos.stream()
                .map(FilhoBeneficiadoMapper::toResponseDto)
                .collect(Collectors.toList());

        return filhos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(filhoListagem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FilhoBeneficiadoResponseDto> atualizar(@PathVariable Integer id,
                                                               @RequestBody FilhoBeneficiadoAtualizarRequestDto dto) {
        var command = FilhoBeneficiadoMapper.toCommand(dto, id);
        FilhoBeneficiado filhoAtualizado = atualizarFilhoBeneficiadoUseCase.executar(command);
        FilhoBeneficiadoResponseDto filhoDto = FilhoBeneficiadoMapper.toResponseDto(filhoAtualizado);
        return ResponseEntity.ok(filhoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        var command = new RemoverFilhoBeneficiadoPorIdCommand(id);
        removerFilhoBeneficiadoPorIdUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }
}
