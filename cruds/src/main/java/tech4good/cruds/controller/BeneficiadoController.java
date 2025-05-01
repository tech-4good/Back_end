package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.beneficiado.BeneficiadoRequestDto;
import tech4good.cruds.dto.beneficiado.BeneficiadoResponseDto;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.mapper.BeneficiadoMapper;
import tech4good.cruds.service.BeneficiadoService;

import java.util.List;

@RestController
@RequestMapping("/beneficiados")
public class BeneficiadoController {

    private final BeneficiadoService beneficiadoService;

    public BeneficiadoController(BeneficiadoService beneficiadoService) {
        this.beneficiadoService = beneficiadoService;
    }

    @PostMapping
    public ResponseEntity<BeneficiadoResponseDto> cadastrar(
            @RequestBody BeneficiadoRequestDto dto
            ) {
        Beneficiado beneficiado = BeneficiadoMapper.toEntity(dto);
        Beneficiado beneficiadoRegistrado = beneficiadoService.cadastrarBeneficiado(beneficiado);
        BeneficiadoResponseDto  dtoSalvo = BeneficiadoMapper.toResponseDto(beneficiadoRegistrado);

        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<BeneficiadoResponseDto>> listar() {
        List<Beneficiado> beneficiados = beneficiadoService.listarBeneficiados();
        List<BeneficiadoResponseDto> beneficiadoListagem = beneficiados.stream().map(BeneficiadoMapper::toResponseDto).toList();
        if (beneficiados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(beneficiadoListagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiadoResponseDto> buscarPorId(@PathVariable Integer id) {
        Beneficiado beneficiadoEncontrado = beneficiadoService.buscarBeneficiadoPorId(id);
        BeneficiadoResponseDto beneficiadoDto = BeneficiadoMapper.toResponseDto(beneficiadoEncontrado);
        return ResponseEntity.status(200).body(beneficiadoDto);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<BeneficiadoResponseDto> buscarPorCpf(@PathVariable String cpf) {
        Beneficiado beneficiadoEncontrado = beneficiadoService.buscarBeneficiadoPorCpf(cpf);
        BeneficiadoResponseDto beneficiadoDto = BeneficiadoMapper.toResponseDto(beneficiadoEncontrado);
        return ResponseEntity.status(200).body(beneficiadoDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BeneficiadoResponseDto> atualizar(
            @RequestBody Beneficiado beneficiadoNovo, @PathVariable Integer id) {
        beneficiadoNovo.getId().setIdBeneficiado(id);
        Beneficiado beneficiadoAlterado = beneficiadoService.atualizarBeneficiado(beneficiadoNovo);
        BeneficiadoResponseDto beneficiadoDto = BeneficiadoMapper.toResponseDto(beneficiadoAlterado);
        return ResponseEntity.status(200).body(beneficiadoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        beneficiadoService.removerBeneficiadoPorId(id);
        return ResponseEntity.status(204).build();
    }
}
