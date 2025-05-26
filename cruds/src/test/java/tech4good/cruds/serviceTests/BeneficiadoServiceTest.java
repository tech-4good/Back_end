package tech4good.cruds.serviceTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.exception.ConflitoEntidadeException;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.BeneficiadoRepository;
import tech4good.cruds.service.BeneficiadoService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BeneficiadoServiceTest {

    @InjectMocks
    private BeneficiadoService service;

    @Mock
    private BeneficiadoRepository repository;

    @Test
    @DisplayName("cadastrarBeneficiado() quando acionado com beneficiado válido, deve cadastrar corretamente")
    void cadastrarBeneficiadoComBeneficiadoValidoDeveCadastrarCorretamenteTest() {
        Beneficiado beneficiado = new Beneficiado();
        when(repository.existsByCpf(beneficiado.getCpf())).thenReturn(false);

        service.cadastrarBeneficiado(beneficiado);

        verify(repository, times(1)).existsByCpf(beneficiado.getCpf());
    }

    @Test
    @DisplayName("cadastrarBeneficiado() quando acionado com beneficiado inválido, deve lançar ConflitoEntidadeException")
    void cadastrarBeneficiadoComBeneficiadoInvalidoDeveLancarConflitoEntidadeExceptionTest() {
        Beneficiado beneficiado = new Beneficiado();
        when(repository.existsByCpf(beneficiado.getCpf())).thenReturn(true);

        assertThrows(ConflitoEntidadeException.class, () -> service.cadastrarBeneficiado(beneficiado));

        verify(repository, times(1)).existsByCpf(beneficiado.getCpf());
    }

    @Test
    @DisplayName("buscarBeneficiadoPorCpf() quando acionado com cpf válido, deve retornar beneficiado correspondente")
    void buscarBeneficiadoPorCpfComCpfValidoDeveRetornarBeneficiadoCorrespondenteTest() {
        when(repository.existsByCpf(anyString())).thenReturn(true);

        service.buscarBeneficiadoPorCpf(anyString());

        verify(repository, times(1)).existsByCpf(anyString());
        verify(repository, times(1)).findByCpf(anyString());
    }

    @Test
    @DisplayName("buscarBeneficiadoPorCpf() quando acionado com cpf inválido, deve lançar EntidadeNaoEncontradaException")
    void buscarBeneficiadoPorCpfComCpfInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.existsByCpf(anyString())).thenReturn(false);

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.buscarBeneficiadoPorCpf(anyString()));

        verify(repository, times(1)).existsByCpf(anyString());
    }

    @Test
    @DisplayName("buscarBeneficiadoPorId() quando acionado com ID válido, deve retornar Beneficiado")
    void buscarBeneficiadoPorIdComIdValidoDeveRetornarBeneficiadoTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(new Beneficiado()));

        service.buscarBeneficiadoPorId(anyInt());

        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    @DisplayName("buscarBeneficiadoPorId() quando acionado com ID inválido, deve lançar EntidadeNaoEncontradaException")
    void buscarBeneficiadoPorIdComIdInvalidoLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.buscarBeneficiadoPorId(anyInt()));

        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    @DisplayName("listarBeneficiados() quando tiver beneficiados cadastrados, deve retornar lista de beneficiados")
    void listarBeneficiadosQuandoTiverBeneficiadosCadastradosDeveRetornarListaDeBeneficiadosTest() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Beneficiado(), new Beneficiado()));

        service.listarBeneficiados();

        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("listarBeneficiados() quando não houver beneficiados cadastrados, deve lançar EntidadeNaoEncontradaException")
    void listarBeneficiadosQuandoNaoHouverBeneficiadosCadastradosDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.listarBeneficiados());

        verify(repository, times(1)).findAll();
    }

    /*@Test
    @DisplayName("atualizarBeneficiado() quando acionado com id válido, deve lançar EntidadeNaoEncontradaException")
    void atualizarBeneficiadoQuandoAcionadoComIdValidoDeve() {
        when(repository.existsById(anyInt())).thenReturn(true);



        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("atualizarBeneficiado() quando acionado com id inválido, deve lançar EntidadeNaoEncontradaException")
    void atualizarBeneficiadoQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.existsById(anyInt())).thenReturn(false);

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.listarBeneficiados());

        verify(repository, times(1)).findAll();
    }*/
}