package tech4good.tech4good_api.infrastructure.web;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoRequestDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoResponseDto;
import tech4good.tech4good_api.core.application.usecase.endereco.CadastrarEnderecoUseCase;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final CadastrarEnderecoUseCase cadastrarEnderecoUseCase;

    public EnderecoController(CadastrarEnderecoUseCase cadastrarEnderecoUseCase) {
        this.cadastrarEnderecoUseCase = cadastrarEnderecoUseCase;
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDto> cadastrar(@Valid @RequestBody EnderecoRequestDto requestDto) {
        var command = EnderecoMapper.toCommand(requestDto);
        var enderecoCadastrado = cadastrarEnderecoUseCase.executar(command);
        var responseDto = EnderecoMapper.toResponseDto(enderecoCadastrado);
        return ResponseEntity.status(201).body(responseDto);
    }


}
