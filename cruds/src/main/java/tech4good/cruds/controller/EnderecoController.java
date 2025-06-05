package tech4good.cruds.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.endereco.EnderecoApiCepDto;
import tech4good.cruds.dto.endereco.EnderecoRequestDto;
import tech4good.cruds.dto.endereco.EnderecoResponseDto;
import tech4good.cruds.dto.endereco.EnderecoUpdateDto;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.mapper.EnderecoMapper;
import tech4good.cruds.service.EnderecoService;

import java.util.List;

@Tag(name = "Controller - Endereço", description = "Operações relacionadas aos endereços dos beneficiados pela ASA.")
@RestController
@RequestMapping("/enderecos")
@SecurityRequirement(name = "Bearer")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDto> cadastrar(
            @Valid
            @RequestBody EnderecoRequestDto dto
    ) {
        Endereco endereco = EnderecoMapper.toEntity(dto);
        Endereco enderecoRegistrado = enderecoService.cadastrarEndereco(endereco);
        EnderecoResponseDto dtoSalvo = EnderecoMapper.toResponseDto(enderecoRegistrado);
        return ResponseEntity.status(201).body(dtoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDto>> listar() {
        List<Endereco> enderecos = enderecoService.listarEnderecos();
        List<EnderecoResponseDto> enderecoListagem = enderecos.stream().map(EnderecoMapper::toResponseDto).toList();
        if (enderecos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(enderecoListagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDto> buscarPorId(@PathVariable Integer id) {
        Endereco enderecoEncontrado = enderecoService.listarEnderecoPorId(id);
        EnderecoResponseDto enderecoDto = EnderecoMapper.toResponseDto(enderecoEncontrado);
        return ResponseEntity.status(200).body(enderecoDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EnderecoResponseDto> atualizar(
            @Valid
            @RequestBody EnderecoUpdateDto dto,
            @PathVariable Integer id
    ) {
       Endereco endereco = EnderecoMapper.toUpdate(dto, id);
       Endereco enderecoAtualizado = enderecoService.atualizarEndereco(endereco, id);
       EnderecoResponseDto enderecoDto = EnderecoMapper.toResponseDto(enderecoAtualizado);
       return ResponseEntity.status(200).body(enderecoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        enderecoService.removerEnderecoPorId(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<EnderecoApiCepDto> buscarPorCep(@PathVariable String cep){
        EnderecoApiCepDto enderecoDto = enderecoService.buscarPorCep(cep);
        return ResponseEntity.ok(enderecoDto);
    }
}