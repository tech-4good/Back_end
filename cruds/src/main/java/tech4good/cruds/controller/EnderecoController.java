package tech4good.cruds.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech4good.cruds.dto.endereco.EnderecoRequestDto;
import tech4good.cruds.dto.endereco.EnderecoResponseDto;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.mapper.EnderecoMapper;
import tech4good.cruds.service.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDto> cadastrar(
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
            @RequestBody Endereco enderecoNovo,
            @PathVariable Integer id
    ) {
        enderecoNovo.setIdEndereco(id);
        Endereco enderecoAlterado = enderecoService.atualizarEndereco(enderecoNovo);
        EnderecoResponseDto enderecoDto = EnderecoMapper.toResponseDto(enderecoAlterado);
        return ResponseEntity.status(200).body(enderecoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        enderecoService.removerEnderecoPorId(id);
        return ResponseEntity.status(204).build();
    }
}