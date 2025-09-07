package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoAtualizarRequestDto;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoRequestDto;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoResponseDto;
import tech4good.tech4good_api.core.application.dto.beneficiado.BeneficiadoSimplesRequestDto;
import tech4good.tech4good_api.core.application.command.beneficiado.*;
import tech4good.tech4good_api.core.application.usecase.beneficiado.*;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoMapper;

@Tag(name = "Controller - Beneficiado", description = "Operações relacionadas aos beneficiados.")
@RestController
@RequestMapping("/beneficiados")
@SecurityRequirement(name = "Bearer")
public class BeneficiadoController {

    private final CadastrarBeneficiadoUseCase cadastrarBeneficiadoUseCase;
    private final AtualizarBeneficiadoUseCase atualizarBeneficiadoUseCase;
    private final BuscarBeneficiadoPorCpfUseCase buscarBeneficiadoPorCpfUseCase;
    private final CadastrarBeneficiadoSimplesUseCase cadastrarBeneficiadoSimplesUseCase;
    private final ListarBeneficiadosUseCase listarBeneficiadosUseCase;
    private final RemoverBeneficiadoPorIdUseCase removerBeneficiadoPorIdUseCase;
    private final SetFotoBeneficiadoUseCase setFotoBeneficiadoUseCase;
    private final BuscarBeneficiadoPorIdUseCase buscarBeneficiadoPorIdUseCase;

    public BeneficiadoController(
        CadastrarBeneficiadoUseCase cadastrarBeneficiadoUseCase,
        AtualizarBeneficiadoUseCase atualizarBeneficiadoUseCase,
        BuscarBeneficiadoPorCpfUseCase buscarBeneficiadoPorCpfUseCase,
        CadastrarBeneficiadoSimplesUseCase cadastrarBeneficiadoSimplesUseCase,
        ListarBeneficiadosUseCase listarBeneficiadosUseCase,
        RemoverBeneficiadoPorIdUseCase removerBeneficiadoPorIdUseCase,
        SetFotoBeneficiadoUseCase setFotoBeneficiadoUseCase,
        BuscarBeneficiadoPorIdUseCase buscarBeneficiadoPorIdUseCase
    ) {
        this.cadastrarBeneficiadoUseCase = cadastrarBeneficiadoUseCase;
        this.atualizarBeneficiadoUseCase = atualizarBeneficiadoUseCase;
        this.buscarBeneficiadoPorCpfUseCase = buscarBeneficiadoPorCpfUseCase;
        this.cadastrarBeneficiadoSimplesUseCase = cadastrarBeneficiadoSimplesUseCase;
        this.listarBeneficiadosUseCase = listarBeneficiadosUseCase;
        this.removerBeneficiadoPorIdUseCase = removerBeneficiadoPorIdUseCase;
        this.setFotoBeneficiadoUseCase = setFotoBeneficiadoUseCase;
        this.buscarBeneficiadoPorIdUseCase = buscarBeneficiadoPorIdUseCase;
    }

    @PostMapping
    public ResponseEntity<BeneficiadoResponseDto> cadastrarBeneficiado(@RequestBody BeneficiadoRequestDto requestDto) {
        CadastrarBeneficiadoCommand command = BeneficiadoMapper.toCommand(requestDto);
        Beneficiado beneficiadoCadastrado = cadastrarBeneficiadoUseCase.executar(command);
        BeneficiadoResponseDto responseDto = BeneficiadoMapper.toResponseDto(beneficiadoCadastrado);
        return ResponseEntity.status(201).body(responseDto);
    }

    @PostMapping("/cadastro-simples")
    public ResponseEntity<BeneficiadoResponseDto> cadastrarSimples(@RequestBody BeneficiadoSimplesRequestDto dto) {
        CadastrarBeneficiadoSimplesCommand command = BeneficiadoMapper.toCommand(dto);
        Beneficiado beneficiado = cadastrarBeneficiadoSimplesUseCase.executar(command);
        BeneficiadoResponseDto responseDto = BeneficiadoMapper.toResponseDto(beneficiado);
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<BeneficiadoResponseDto>> listar() {
        List<Beneficiado> beneficiados = listarBeneficiadosUseCase.executar();
        if (beneficiados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        List<BeneficiadoResponseDto> responseList = beneficiados.stream()
                .map(BeneficiadoMapper::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiadoResponseDto> buscarPorId(@PathVariable Integer id) {
        BuscarBeneficiadoPorIdCommand command = new BuscarBeneficiadoPorIdCommand(id);
        Beneficiado beneficiado = buscarBeneficiadoPorIdUseCase.executar(command);
        BeneficiadoResponseDto responseDto = BeneficiadoMapper.toResponseDto(beneficiado);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<BeneficiadoResponseDto> buscarPorCpf(@PathVariable String cpf) {
        BuscarBeneficiadoPorCpfCommand command = new BuscarBeneficiadoPorCpfCommand(new tech4good.tech4good_api.core.domain.shared.valueobject.Cpf(cpf));
        Beneficiado beneficiado = buscarBeneficiadoPorCpfUseCase.executar(command);
        BeneficiadoResponseDto responseDto = BeneficiadoMapper.toResponseDto(beneficiado);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BeneficiadoResponseDto> atualizar(@RequestBody BeneficiadoAtualizarRequestDto dto, @PathVariable Integer id) {
        AtualizarBeneficiadoCommand command = BeneficiadoMapper.toCommand(dto);
        Beneficiado beneficiadoAtualizado = atualizarBeneficiadoUseCase.executar(id, command);
        BeneficiadoResponseDto responseDto = BeneficiadoMapper.toResponseDto(beneficiadoAtualizado);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        RemoverBeneficiadoPorIdCommand command = new RemoverBeneficiadoPorIdCommand(id);
        removerBeneficiadoPorIdUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }
}
