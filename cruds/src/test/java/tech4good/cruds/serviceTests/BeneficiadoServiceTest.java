package tech4good.cruds.serviceTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.entity.FileEntity;
import tech4good.cruds.exception.ConflitoEntidadeException;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.BeneficiadoRepository;
import tech4good.cruds.service.BeneficiadoService;
import tech4good.cruds.service.EnderecoService;
import tech4good.cruds.service.FileService;

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

    @Mock
    private FileService fileService;

    @Mock
    private EnderecoService enderecoService;

    @Test
    @DisplayName("cadastrarBeneficiado() com beneficiado válido deve salvar corretamente")
    void cadastrarBeneficiadoComBeneficiadoValidoDeveSalvarCorretamente() {
        Beneficiado beneficiado = new Beneficiado();
        beneficiado.setCpf("12345678900");

        Integer fotoId = 1;
        Integer enderecoId = 2;

        FileEntity fileMock = new FileEntity();
        Endereco enderecoMock = new Endereco();

        when(fileService.loadEntity(fotoId)).thenReturn(fileMock);
        when(enderecoService.listarEnderecoPorId(enderecoId)).thenReturn(enderecoMock);
        when(repository.save(any(Beneficiado.class))).thenReturn(beneficiado);

        Beneficiado resultado = service.cadastrarBeneficiado(beneficiado, fotoId, enderecoId);

        verify(fileService, times(1)).loadEntity(fotoId);
        verify(enderecoService, times(1)).listarEnderecoPorId(enderecoId);
        verify(repository, times(1)).save(beneficiado);

        assertNotNull(resultado);
        assertEquals(fileMock, beneficiado.getFotoBeneficiado());
        assertEquals(enderecoMock, beneficiado.getEndereco());
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
    @DisplayName("listarBeneficiados() quando não houver beneficiados, deve retornar lista vazia")
    void listarBeneficiadosSemRegistrosDeveRetornarListaVazia() {

        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<Beneficiado> resultado = service.listarBeneficiados();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
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