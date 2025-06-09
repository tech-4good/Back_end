package tech4good.cruds.serviceTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.exception.ConflitoEntidadeException;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.EnderecoRepository;
import tech4good.cruds.service.EnderecoService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService service;

    @Mock
    private EnderecoRepository repository;

    @Test
    @DisplayName("cadastrarEndereco() quando acionado com endereço válido, deve cadastrar corretamente")
    void cadastrarEnderecoComEnderecoValidoDeveCadastrarCorretamenteTest() {
        Endereco endereco = new Endereco();

        service.cadastrarEndereco(endereco);

        verify(repository, times(1)).save(endereco);
    }

    @Test
    @DisplayName("cadastrarEndereco() quando acionado com endereço inválido, deve lançar ConflitoEntidadeException")
    void cadastrarEnderecoComEnderecoInvalidoDeveLancarConflitoEntidadeExceptionTest() {
        Endereco endereco = new Endereco();
        endereco.setCep("12345678");
        endereco.setNumero(100);

        when(repository.existsByCepAndNumero(endereco.getCep(), endereco.getNumero())).thenReturn(true);

        assertThrows(ConflitoEntidadeException.class, () -> service.cadastrarEndereco(endereco));

        verify(repository, never()).save(any(Endereco.class));
        verify(repository, times(1)).existsByCepAndNumero(endereco.getCep(), endereco.getNumero());
    }

    @Test
    @DisplayName("listarEnderecos() quando houver endereços cadastrados, deve retornar lista de endereços")
    void listarEnderecoQuandoTiverEnderecosCadastradosDeveRetornarListaDeEnderecosTest() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Endereco(), new Endereco(), new Endereco()));

        service.listarEnderecos();

        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("listarEnderecos() quando não houver endereços cadastrados, deve lançar EntidadeNaoEncontradaException")
    void listarEnderecoQuandoNaoTiverEnderecosCadastradosDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.listarEnderecos());

        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("listarEnderecoPorId() quando acionado com ID inválido, deve lançar EntidadeNaoEncontradaException")
    void listarEnderecoPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.listarEnderecoPorId(anyInt()));

        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    @DisplayName("listarEnderecoPorId() quando acionado com ID válido e não houver resultados, deve lançar EntidadeNaoEncontradaException")
    void listarEnderecoPorIdQuandoAcionadoComIdValidoENaoHouverResultadoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.listarEnderecoPorId(anyInt()));

        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    @DisplayName("listarEnderecoPorId() quando acionado com ID válido e houver resultados, deve retornar lista de endereços")
    void listarEnderecoPorIdQuandoAcionadoComValidoEHouverResultadoDeveRetornarListaDeEnderecosTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(new Endereco()));

        service.listarEnderecoPorId(anyInt());

        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    @DisplayName("removerEnderecoPorId() quando acionado com ID válido, deve remover corretamente")
    void removerEnderecoPorIdQuandoAcionadoComIdValidoDeveRemoverCorretamenteTest() {
        when(repository.existsById(anyInt())).thenReturn(true);

        service.removerEnderecoPorId(anyInt());

        verify(repository, times(1)).existsById(anyInt());
        verify(repository, times(1)).deleteById(anyInt());
    }

    @Test
    @DisplayName("removerEnderecoPorId() quando acionado com ID inválido, deve lançar EntidadeNaoEncontradaException")
    void removerEnderecoPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.existsById(anyInt())).thenReturn(false);

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.removerEnderecoPorId(anyInt()));

        verify(repository, times(1)).existsById(anyInt());
    }

}