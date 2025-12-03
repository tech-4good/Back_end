package tech4good.tech4good_api.infrastructure.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.tech4good_api.core.application.command.endereco.*;
import tech4good.tech4good_api.core.application.dto.endereco.AtualizarEnderecoRequestDto;
import tech4good.tech4good_api.core.application.dto.endereco.AtualizarEnderecoDadosRequestDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoRequestDto;
import tech4good.tech4good_api.core.application.dto.endereco.CepResponseDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoResponseDto;
import tech4good.tech4good_api.core.application.usecase.endereco.AtualizarEnderecoUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.AtualizarEnderecoDadosUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.CadastrarEnderecoUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.ListarEnderecoPorIdUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.ListarEnderecosUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.RemoverEnderecoPorIdUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.BuscarApiCepEnderecoUseCase;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cep;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;

import java.util.List;

@Tag(name = "Controller - Endereço", description = "Operações relacionadas aos endereços dos beneficiados.")
@RestController
@RequestMapping("/enderecos")
@SecurityRequirement(name = "Bearer")
public class EnderecoController {

    private final CadastrarEnderecoUseCase cadastrarEnderecoUseCase;
    private final ListarEnderecoPorIdUseCase listarEnderecoPorIdUseCase;
    private final ListarEnderecosUseCase listarEnderecosUseCase;
    private final AtualizarEnderecoUseCase atualizarEnderecoUseCase;
    private final AtualizarEnderecoDadosUseCase atualizarEnderecoDadosUseCase;
    private final RemoverEnderecoPorIdUseCase removerEnderecoPorIdUseCase;
    private final BuscarApiCepEnderecoUseCase buscarApiCepEnderecoUseCase;

    public EnderecoController(
        CadastrarEnderecoUseCase cadastrarEnderecoUseCase,
        ListarEnderecoPorIdUseCase listarEnderecoPorIdUseCase,
        ListarEnderecosUseCase listarEnderecosUseCase,
        AtualizarEnderecoUseCase atualizarEnderecoUseCase,
        AtualizarEnderecoDadosUseCase atualizarEnderecoDadosUseCase,
        RemoverEnderecoPorIdUseCase removerEnderecoPorIdUseCase,
        BuscarApiCepEnderecoUseCase buscarApiCepEnderecoUseCase
    ) {
        this.cadastrarEnderecoUseCase = cadastrarEnderecoUseCase;
        this.listarEnderecoPorIdUseCase = listarEnderecoPorIdUseCase;
        this.listarEnderecosUseCase = listarEnderecosUseCase;
        this.atualizarEnderecoUseCase = atualizarEnderecoUseCase;
        this.atualizarEnderecoDadosUseCase = atualizarEnderecoDadosUseCase;
        this.removerEnderecoPorIdUseCase = removerEnderecoPorIdUseCase;
        this.buscarApiCepEnderecoUseCase = buscarApiCepEnderecoUseCase;
    }

    @Operation(summary = "Cadastrar endereço", description = "Cria um novo endereço no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PostMapping
    public ResponseEntity<EnderecoResponseDto> cadastrar(@RequestBody EnderecoRequestDto requestDto) {
        CadastrarEnderecoCommand command = EnderecoMapper.toCommand(requestDto);
        Endereco enderecoCadastrado = cadastrarEnderecoUseCase.executar(command);
        EnderecoResponseDto responseDto = EnderecoMapper.toResponseDto(enderecoCadastrado);
        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDto> buscarPorId(@PathVariable Integer id) {
        ListarEnderecoPorIdCommand command = new ListarEnderecoPorIdCommand(id);
        Endereco endereco = listarEnderecoPorIdUseCase.executar(command);
        EnderecoResponseDto responseDto = EnderecoMapper.toResponseDto(endereco);
        return ResponseEntity.status(200).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDto>> listarEnderecos() {
        List<Endereco> enderecos = listarEnderecosUseCase.executar();
        if (enderecos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        List<EnderecoResponseDto> response = enderecos.stream()
            .map(EnderecoMapper::toResponseDto)
            .toList();
        return ResponseEntity.status(200).body(response);
    }

    @Operation(summary = "Atualizar dados do endereço", description = "Atualiza os dados físicos do endereço (logradouro, número, complemento, etc.)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDto> atualizarDados(@PathVariable Integer id, @RequestBody AtualizarEnderecoDadosRequestDto requestDto) {
        AtualizarEnderecoDadosCommand command = EnderecoMapper.toAtualizarDadosCommand(id, requestDto);
        Endereco enderecoAtualizado = atualizarEnderecoDadosUseCase.executar(command);
        EnderecoResponseDto responseDto = EnderecoMapper.toResponseDto(enderecoAtualizado);
        return ResponseEntity.status(200).body(responseDto);
    }

    @Operation(summary = "Atualizar status do endereço", description = "Atualiza apenas o status do endereço (para gerenciamento da fila de espera)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
        @ApiResponse(responseCode = "401", description = "Não autorizado")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<EnderecoResponseDto> atualizar(@PathVariable Integer id, @RequestBody AtualizarEnderecoRequestDto requestDto) {
        AtualizarEnderecoCommand command = EnderecoMapper.toAtualizarCommand(id, requestDto);
        Endereco enderecoAtualizado = atualizarEnderecoUseCase.executar(command);
        EnderecoResponseDto responseDto = EnderecoMapper.toResponseDto(enderecoAtualizado);
        return ResponseEntity.status(200).body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        RemoverEnderecoPorIdCommand command = new RemoverEnderecoPorIdCommand(id);
        removerEnderecoPorIdUseCase.executar(command);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepResponseDto> buscarPorCep(@PathVariable String cep) {
        Cep cepValue = Cep.valueOf(cep);
        BuscarApiCepEnderecoCommand command = new BuscarApiCepEnderecoCommand(cepValue);
        Endereco endereco = buscarApiCepEnderecoUseCase.executar(command);
        CepResponseDto responseDto = EnderecoMapper.toCepResponseDto(endereco);
        return ResponseEntity.ok(responseDto);
    }

}
