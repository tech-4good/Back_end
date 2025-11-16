package tech4good.tech4good_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.endereco.AtualizarEnderecoCommand;
import tech4good.tech4good_api.core.application.command.endereco.CadastrarEnderecoCommand;
import tech4good.tech4good_api.core.application.command.endereco.ListarEnderecoPorIdCommand;
import tech4good.tech4good_api.core.application.command.endereco.RemoverEnderecoPorIdCommand;
import tech4good.tech4good_api.core.application.exception.ConflitoEntidadeException;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.application.usecase.endereco.AtualizarEnderecoUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.CadastrarEnderecoUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.DefinirStatusInicialEnderecoUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.ListarEnderecoPorIdUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.ListarEnderecosUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.RemoverEnderecoPorIdUseCase;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes do Use Case - Endereco")
class EnderecoUseCaseTest {

    @Mock
    private EnderecoGateway gateway;

    @Mock
    private DefinirStatusInicialEnderecoUseCase definirStatusInicialUseCase;

    @InjectMocks
    private ListarEnderecoPorIdUseCase listarPorIdUseCase;

    @InjectMocks
    private ListarEnderecosUseCase listarEnderecosUseCase;

    @InjectMocks
    private AtualizarEnderecoUseCase atualizarUseCase;

    @InjectMocks
    private RemoverEnderecoPorIdUseCase removerUseCase;

    private CadastrarEnderecoUseCase cadastrarUseCase;
    private Endereco endereco;
    private CadastrarEnderecoCommand cadastrarCommand;

    @BeforeEach
    void setUp() {
        cadastrarUseCase = new CadastrarEnderecoUseCase(gateway, definirStatusInicialUseCase);
        listarPorIdUseCase = new ListarEnderecoPorIdUseCase(gateway);
        listarEnderecosUseCase = new ListarEnderecosUseCase(gateway);
        atualizarUseCase = new AtualizarEnderecoUseCase(gateway);
        removerUseCase = new RemoverEnderecoPorIdUseCase(gateway);

        endereco = new Endereco();
        endereco.setId(1);
        endereco.setLogradouro("Avenida Marechal Tito");
        endereco.setNumero("234");
        endereco.setComplemento("A");
        endereco.setBairro(Bairro.of("São Miguel Paulista"));
        endereco.setCidade(Cidade.of("São Paulo"));
        endereco.setEstado(Estado.SP);
        endereco.setCep(Cep.valueOf("01001000"));
        endereco.setTipoCesta(TipoCesta.BASICA);
        endereco.setDataEntrada(LocalDate.of(2025, 1, 10));
        endereco.setMoradia("Alugada");
        endereco.setTipoMoradia(TipoMoradia.of("Apartamento"));
        endereco.setStatus(Status.ATIVO);

        cadastrarCommand = new CadastrarEnderecoCommand(
                "Avenida Marechal Tito",
                "234",
                "A",
                Bairro.of("São Miguel Paulista"),
                Cidade.of("São Paulo"),
                Estado.SP,
                Cep.valueOf("01001000"),
                TipoCesta.BASICA,
                "Alugada",
                TipoMoradia.of("Apartamento")
        );
    }

    @Test
    @DisplayName("cadastrarEndereco() quando acionado com endereço válido, deve cadastrar corretamente")
    void cadastrarEnderecoComEnderecoValidoDeveCadastrarCorretamenteTest() {
        when(gateway.existsByCepAndNumero(anyString(), anyString())).thenReturn(false);
        when(definirStatusInicialUseCase.executar(any(Endereco.class))).thenReturn(endereco);
        when(gateway.save(any(Endereco.class))).thenReturn(endereco);

        Endereco resultado = cadastrarUseCase.executar(cadastrarCommand);

        assertNotNull(resultado);
        verify(gateway, times(1)).existsByCepAndNumero(anyString(), anyString());
        verify(definirStatusInicialUseCase, times(1)).executar(any(Endereco.class));
        verify(gateway, times(1)).save(any(Endereco.class));
    }

    @Test
    @DisplayName("cadastrarEndereco() quando endereço já existe, deve lançar ConflitoEntidadeException")
    void cadastrarEnderecoComEnderecoExistenteDeveLancarConflitoEntidadeExceptionTest() {
        when(gateway.existsByCepAndNumero(anyString(), anyString())).thenReturn(true);

        assertThrows(ConflitoEntidadeException.class, () -> cadastrarUseCase.executar(cadastrarCommand));

        verify(gateway, times(1)).existsByCepAndNumero(anyString(), anyString());
        verify(gateway, never()).save(any(Endereco.class));
    }

    @Test
    @DisplayName("listarEnderecos() quando houver endereços cadastrados, deve retornar lista de endereços")
    void listarEnderecosQuandoTiverEnderecosCadastradosDeveRetornarListaDeEnderecosTest() {
        List<Endereco> enderecos = Arrays.asList(endereco, endereco, endereco);
        when(gateway.findAll()).thenReturn(enderecos);

        List<Endereco> resultado = listarEnderecosUseCase.executar();

        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        verify(gateway, times(1)).findAll();
    }

    @Test
    @DisplayName("listarEnderecos() quando não houver endereços, deve retornar lista vazia")
    void listarEnderecosQuandoNaoTiverEnderecosCadastradosDeveRetornarListaVaziaTest() {
        when(gateway.findAll()).thenReturn(Collections.emptyList());

        List<Endereco> resultado = listarEnderecosUseCase.executar();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(gateway, times(1)).findAll();
    }

    @Test
    @DisplayName("listarEnderecoPorId() quando acionado com ID válido, deve retornar endereço")
    void listarEnderecoPorIdQuandoAcionadoComIdValidoDeveRetornarEnderecoTest() {
        ListarEnderecoPorIdCommand command = new ListarEnderecoPorIdCommand(1);
        when(gateway.findById(1)).thenReturn(Optional.of(endereco));

        Endereco resultado = listarPorIdUseCase.executar(command);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        verify(gateway, times(1)).findById(1);
    }

    @Test
    @DisplayName("listarEnderecoPorId() quando acionado com ID inválido, deve lançar EntidadeNaoEncontradaException")
    void listarEnderecoPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        ListarEnderecoPorIdCommand command = new ListarEnderecoPorIdCommand(999);
        when(gateway.findById(999)).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> listarPorIdUseCase.executar(command));

        verify(gateway, times(1)).findById(999);
    }

    @Test
    @DisplayName("atualizarEndereco() quando acionado com ID válido, deve atualizar endereço")
    void atualizarEnderecoQuandoAcionadoComIdValidoDeveAtualizarEnderecoTest() {
        AtualizarEnderecoCommand command = new AtualizarEnderecoCommand(1, Status.INATIVO);
        when(gateway.findById(1)).thenReturn(Optional.of(endereco));
        when(gateway.save(any(Endereco.class))).thenReturn(endereco);

        Endereco resultado = atualizarUseCase.executar(command);

        assertNotNull(resultado);
        verify(gateway, times(1)).findById(1);
        verify(gateway, times(1)).save(any(Endereco.class));
    }

    @Test
    @DisplayName("atualizarEndereco() quando acionado com ID inválido, deve lançar EntidadeNaoEncontradaException")
    void atualizarEnderecoQuandoAcionadoComIdInvalidoDeveLancarExcecaoTest() {
        AtualizarEnderecoCommand command = new AtualizarEnderecoCommand(999, Status.INATIVO);
        when(gateway.findById(999)).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> atualizarUseCase.executar(command));

        verify(gateway, times(1)).findById(999);
        verify(gateway, never()).save(any(Endereco.class));
    }

    @Test
    @DisplayName("removerEnderecoPorId() quando acionado com ID válido, deve remover corretamente")
    void removerEnderecoPorIdQuandoAcionadoComIdValidoDeveRemoverCorretamenteTest() {
        RemoverEnderecoPorIdCommand command = new RemoverEnderecoPorIdCommand(1);
        when(gateway.existsById(1)).thenReturn(true);
        doNothing().when(gateway).deleteById(1);

        removerUseCase.executar(command);

        verify(gateway, times(1)).existsById(1);
        verify(gateway, times(1)).deleteById(1);
    }

    @Test
    @DisplayName("removerEnderecoPorId() quando acionado com ID inválido, deve lançar EntidadeNaoEncontradaException")
    void removerEnderecoPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        RemoverEnderecoPorIdCommand command = new RemoverEnderecoPorIdCommand(999);
        when(gateway.existsById(999)).thenReturn(false);

        assertThrows(EntidadeNaoEncontradaException.class, () -> removerUseCase.executar(command));

        verify(gateway, times(1)).existsById(999);
        verify(gateway, never()).deleteById(anyInt());
    }
}
