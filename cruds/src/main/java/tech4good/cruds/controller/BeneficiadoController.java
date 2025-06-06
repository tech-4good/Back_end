package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.beneficiado.BeneficiadoCadastroSimplesDto;
import tech4good.cruds.dto.beneficiado.BeneficiadoRequestDto;
import tech4good.cruds.dto.beneficiado.BeneficiadoResponseDto;
import tech4good.cruds.dto.beneficiado.BeneficiadoUpdateDto;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.mapper.BeneficiadoMapper;
import tech4good.cruds.service.BeneficiadoService;
import tech4good.cruds.repository.EnderecoRepository;

import java.util.List;

@Tag(name = "Controller - Beneficiado", description = "Operações relacionadas as pessoas beneficiadas pela ASA.")
@RestController
@RequestMapping("/beneficiados")
@SecurityRequirement(name = "Bearer")
public class BeneficiadoController {

    private final BeneficiadoService beneficiadoService;
    private final EnderecoRepository enderecoRepository;

    public BeneficiadoController(BeneficiadoService beneficiadoService, EnderecoRepository enderecoRepository) {
        this.beneficiadoService = beneficiadoService;
        this.enderecoRepository = enderecoRepository;
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

    @PostMapping("/cadastro-simples")
    public ResponseEntity<BeneficiadoResponseDto> cadastrarSimples(@RequestBody BeneficiadoCadastroSimplesDto dto) {
        Beneficiado beneficiado = beneficiadoService.cadastrarBeneficiadoSimples(dto);
        BeneficiadoResponseDto dtoSalvo = BeneficiadoMapper.toResponseDto(beneficiado);
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
            @RequestBody BeneficiadoUpdateDto dto,
            @PathVariable Integer id
    ) {
        Beneficiado beneficiado = BeneficiadoMapper.toUpdate(dto, id);
        Beneficiado beneficiadoAtualizado = beneficiadoService.atualizarBeneficiado(beneficiado, id);
        BeneficiadoResponseDto beneficiadoDto = BeneficiadoMapper.toResponseDto(beneficiadoAtualizado);
        return ResponseEntity.status(200).body(beneficiadoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        beneficiadoService.removerBeneficiadoPorId(id);
        return ResponseEntity.status(204).build();
    }
}
