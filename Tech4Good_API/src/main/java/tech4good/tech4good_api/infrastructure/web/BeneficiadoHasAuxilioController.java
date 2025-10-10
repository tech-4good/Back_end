package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.tech4good_api.core.application.command.beneficiadohasauxilio.BuscarBeneficiadoHasAuxilioPorIdCommand;
import tech4good.tech4good_api.core.application.command.beneficiadohasauxilio.RemoverBeneficiadoHasAuxilioPorIdCommand;
import tech4good.tech4good_api.core.application.dto.beneficiadohasauxilio.BeneficiadoHasAuxilioAtualizarRequestDto;
import tech4good.tech4good_api.core.application.dto.beneficiadohasauxilio.BeneficiadoHasAuxilioRequestDto;
import tech4good.tech4good_api.core.application.dto.beneficiadohasauxilio.BeneficiadoHasAuxilioResponseDto;
import tech4good.tech4good_api.core.application.usecase.beneficiadohasauxilio.*;
import tech4good.tech4good_api.core.domain.beneficiadohasauxilio.BeneficiadoHasAuxilio;
import tech4good.tech4good_api.infrastructure.persistence.jpa.BeneficiadoHasAuxilio.BeneficiadoHasAuxilioMapper;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Controller - Beneficiado Has Auxílio", description = "Operações relacionadas à associação entre beneficiados e auxílios governamentais.")
@RestController
@RequestMapping("/beneficiado-has-auxilios")
@SecurityRequirement(name = "Bearer")
public class BeneficiadoHasAuxilioController {

    private final CadastrarBeneficiadoHasAuxilioUseCase cadastrarBeneficiadoHasAuxilioUseCase;
    private final AtualizarBeneficiadoHasAuxilioUseCase atualizarBeneficiadoHasAuxilioUseCase;
    private final BuscarBeneficiadoHasAuxilioPorIdUseCase buscarBeneficiadoHasAuxilioPorIdUseCase;
    private final ListarBeneficiadoHasAuxilioUseCase listarBeneficiadoHasAuxilioUseCase;
    private final RemoverBeneficiadoHasAuxilioPorIdUseCase removerBeneficiadoHasAuxilioPorIdUseCase;

    public BeneficiadoHasAuxilioController(CadastrarBeneficiadoHasAuxilioUseCase cadastrarBeneficiadoHasAuxilioUseCase,
                                        AtualizarBeneficiadoHasAuxilioUseCase atualizarBeneficiadoHasAuxilioUseCase,
                                        BuscarBeneficiadoHasAuxilioPorIdUseCase buscarBeneficiadoHasAuxilioPorIdUseCase,
                                        ListarBeneficiadoHasAuxilioUseCase listarBeneficiadoHasAuxilioUseCase,
                                        RemoverBeneficiadoHasAuxilioPorIdUseCase removerBeneficiadoHasAuxilioPorIdUseCase) {
        this.cadastrarBeneficiadoHasAuxilioUseCase = cadastrarBeneficiadoHasAuxilioUseCase;
        this.atualizarBeneficiadoHasAuxilioUseCase = atualizarBeneficiadoHasAuxilioUseCase;
        this.buscarBeneficiadoHasAuxilioPorIdUseCase = buscarBeneficiadoHasAuxilioPorIdUseCase;
        this.listarBeneficiadoHasAuxilioUseCase = listarBeneficiadoHasAuxilioUseCase;
        this.removerBeneficiadoHasAuxilioPorIdUseCase = removerBeneficiadoHasAuxilioPorIdUseCase;
    }

    @PostMapping
    public ResponseEntity<BeneficiadoHasAuxilioResponseDto> cadastrar(@Valid @RequestBody BeneficiadoHasAuxilioRequestDto dto) {
        var command = BeneficiadoHasAuxilioMapper.toCommand(dto);
        BeneficiadoHasAuxilio beneficiadoHasAuxilio = cadastrarBeneficiadoHasAuxilioUseCase.executar(command);
        BeneficiadoHasAuxilioResponseDto responseDto = BeneficiadoHasAuxilioMapper.toResponseDto(beneficiadoHasAuxilio);
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiadoHasAuxilioResponseDto> buscarPorId(@PathVariable Integer id) {
        var command = new BuscarBeneficiadoHasAuxilioPorIdCommand(id);
        BeneficiadoHasAuxilio beneficiadoHasAuxilio = buscarBeneficiadoHasAuxilioPorIdUseCase.executar(command);
        BeneficiadoHasAuxilioResponseDto responseDto = BeneficiadoHasAuxilioMapper.toResponseDto(beneficiadoHasAuxilio);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<BeneficiadoHasAuxilioResponseDto>> listar() {
        List<BeneficiadoHasAuxilio> beneficiadoHasAuxilios = listarBeneficiadoHasAuxilioUseCase.executar();
        List<BeneficiadoHasAuxilioResponseDto> beneficiadoHasAuxiliosDto = beneficiadoHasAuxilios.stream()
                .map(BeneficiadoHasAuxilioMapper::toResponseDto)
                .collect(Collectors.toList());

        if (beneficiadoHasAuxiliosDto.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(beneficiadoHasAuxiliosDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiadoHasAuxilioResponseDto> atualizar(@PathVariable Integer id,
                                                                   @Valid @RequestBody BeneficiadoHasAuxilioAtualizarRequestDto dto) {
        var command = BeneficiadoHasAuxilioMapper.toUpdateCommand(dto);
        BeneficiadoHasAuxilio beneficiadoHasAuxilio = atualizarBeneficiadoHasAuxilioUseCase.executar(id, command);
        BeneficiadoHasAuxilioResponseDto responseDto = BeneficiadoHasAuxilioMapper.toResponseDto(beneficiadoHasAuxilio);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        var command = new RemoverBeneficiadoHasAuxilioPorIdCommand(id);
        removerBeneficiadoHasAuxilioPorIdUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }
}
