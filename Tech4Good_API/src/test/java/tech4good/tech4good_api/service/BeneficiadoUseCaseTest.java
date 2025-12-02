package tech4good.tech4good_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.adapter.FileGateway;
import tech4good.tech4good_api.core.application.command.beneficiado.AtualizarBeneficiadoCommand;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoCommand;
import tech4good.tech4good_api.core.application.command.beneficiado.BuscarBeneficiadoPorIdCommand;
import tech4good.tech4good_api.core.application.command.beneficiado.BuscarBeneficiadoPorCpfCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.application.usecase.beneficiado.AtualizarBeneficiadoUseCase;
import tech4good.tech4good_api.core.application.usecase.beneficiado.BuscarBeneficiadoPorCpfUseCase;
import tech4good.tech4good_api.core.application.usecase.beneficiado.BuscarBeneficiadoPorIdUseCase;
import tech4good.tech4good_api.core.application.usecase.beneficiado.CadastrarBeneficiadoUseCase;
import tech4good.tech4good_api.core.application.usecase.beneficiado.ListarBeneficiadosUseCase;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Rg;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.file.File;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes do Use Case - Beneficiado")
class BeneficiadoUseCaseTest {

    @Mock
    private BeneficiadoGateway gateway;

    @Mock
    private EnderecoGateway enderecoGateway;

    @Mock
    private FileGateway fileGateway;

    private CadastrarBeneficiadoUseCase cadastrarUseCase;
    private BuscarBeneficiadoPorIdUseCase buscarPorIdUseCase;
    private BuscarBeneficiadoPorCpfUseCase buscarPorCpfUseCase;
    private ListarBeneficiadosUseCase listarBeneficiadosUseCase;
    private AtualizarBeneficiadoUseCase atualizarUseCase;

    private Beneficiado beneficiado;
    private Endereco endereco;
    private File foto;

    @BeforeEach
    void setUp() {
        cadastrarUseCase = new CadastrarBeneficiadoUseCase(gateway, enderecoGateway, fileGateway);
        buscarPorIdUseCase = new BuscarBeneficiadoPorIdUseCase(gateway);
        buscarPorCpfUseCase = new BuscarBeneficiadoPorCpfUseCase(gateway);
        listarBeneficiadosUseCase = new ListarBeneficiadosUseCase(gateway);
        atualizarUseCase = new AtualizarBeneficiadoUseCase(gateway, enderecoGateway, fileGateway);

        beneficiado = new Beneficiado();
        beneficiado.setId(1);
        beneficiado.setCpf(Cpf.valueOf("12345678900"));
        beneficiado.setNome("Maria Silva");
        beneficiado.setTelefone(Telefone.valueOf("11999999999"));
        beneficiado.setProfissao("Professora");
        beneficiado.setDataNascimento(LocalDate.of(1990, 1, 1));

        endereco = new Endereco();
        endereco.setId(1);

        foto = new File();
        foto.setId(1);
    }

    @Test
    @DisplayName("cadastrarBeneficiado() com beneficiado válido deve salvar corretamente")
    void cadastrarBeneficiadoComBeneficiadoValidoDeveSalvarCorretamente() {
        CadastrarBeneficiadoCommand command = new CadastrarBeneficiadoCommand(
                Cpf.valueOf("12345678900"),
                "Maria Silva",
                Rg.valueOf("123456789"),
                LocalDate.of(1990, 1, 1),
                "São Paulo",
                Telefone.valueOf("11999999999"),
                EstadoCivil.SOLTEIRO,
                "Superior Completo",
                "Professora",
                Renda.valueOf(3000.0),
                "Escola ABC",
                "Professora",
                Religiao.valueOf("Católico"),
                1,
                0,
                1
        );

        when(gateway.existsByCpf(anyString())).thenReturn(false);
        when(enderecoGateway.findById(1)).thenReturn(Optional.of(endereco));
        when(fileGateway.loadEntity(1)).thenReturn(foto);
        when(gateway.save(any(Beneficiado.class))).thenReturn(beneficiado);

        Beneficiado resultado = cadastrarUseCase.executar(command);

        assertNotNull(resultado);
        verify(gateway, times(1)).existsByCpf(anyString());
        verify(enderecoGateway, times(1)).findById(1);
        verify(fileGateway, times(1)).loadEntity(1);
        verify(gateway, times(1)).save(any(Beneficiado.class));
    }

    @Test
    @DisplayName("cadastrarBeneficiado() quando CPF já existe deve lançar IllegalArgumentException")
    void cadastrarBeneficiadoQuandoCpfExisteDeveLancarExcecaoTest() {
        CadastrarBeneficiadoCommand command = new CadastrarBeneficiadoCommand(
                Cpf.valueOf("12345678900"),
                "Maria Silva",
                null,
                LocalDate.of(1990, 1, 1),
                null,
                Telefone.valueOf("11999999999"),
                null,
                null,
                "Professora",
                null,
                null,
                null,
                null,
                null,
                0,
                null
        );

        when(gateway.existsByCpf(anyString())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> cadastrarUseCase.executar(command));

        verify(gateway, times(1)).existsByCpf(anyString());
        verify(gateway, never()).save(any(Beneficiado.class));
    }

    @Test
    @DisplayName("cadastrarBeneficiado() quando endereço não existe deve lançar EntidadeNaoEncontradaException")
    void cadastrarBeneficiadoQuandoEnderecoNaoExisteDeveLancarExcecaoTest() {
        CadastrarBeneficiadoCommand command = new CadastrarBeneficiadoCommand(
                Cpf.valueOf("12345678900"),
                "Maria Silva",
                null,
                LocalDate.of(1990, 1, 1),
                null,
                Telefone.valueOf("11999999999"),
                null,
                null,
                "Professora",
                null,
                null,
                null,
                null,
                999,
                0,
                null
        );

        when(gateway.existsByCpf(anyString())).thenReturn(false);
        when(enderecoGateway.findById(999)).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> cadastrarUseCase.executar(command));

        verify(gateway, times(1)).existsByCpf(anyString());
        verify(enderecoGateway, times(1)).findById(999);
        verify(gateway, never()).save(any(Beneficiado.class));
    }

    @Test
    @DisplayName("buscarBeneficiadoPorCpf() quando acionado com cpf válido, deve retornar beneficiado correspondente")
    void buscarBeneficiadoPorCpfComCpfValidoDeveRetornarBeneficiadoCorrespondenteTest() {
        BuscarBeneficiadoPorCpfCommand command = new BuscarBeneficiadoPorCpfCommand(Cpf.valueOf("12345678900"));
        // O CPF.toString() retorna formatado: "123.456.789-00"
        when(gateway.existsByCpf("123.456.789-00")).thenReturn(true);
        when(gateway.findByCpf("123.456.789-00")).thenReturn(beneficiado);

        Beneficiado resultado = buscarPorCpfUseCase.executar(command);

        assertNotNull(resultado);
        verify(gateway, times(1)).existsByCpf("123.456.789-00");
        verify(gateway, times(1)).findByCpf("123.456.789-00");
    }

    @Test
    @DisplayName("buscarBeneficiadoPorCpf() quando acionado com cpf inválido, deve lançar EntidadeNaoEncontradaException")
    void buscarBeneficiadoPorCpfComCpfInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        BuscarBeneficiadoPorCpfCommand command = new BuscarBeneficiadoPorCpfCommand(Cpf.valueOf("99999999999"));
        // O CPF.toString() retorna formatado: "999.999.999-99"
        when(gateway.existsByCpf("999.999.999-99")).thenReturn(false);

        assertThrows(EntidadeNaoEncontradaException.class, () -> buscarPorCpfUseCase.executar(command));

        verify(gateway, times(1)).existsByCpf("999.999.999-99");
        verify(gateway, never()).findByCpf(anyString());
    }

    @Test
    @DisplayName("buscarBeneficiadoPorId() quando acionado com ID válido, deve retornar Beneficiado")
    void buscarBeneficiadoPorIdComIdValidoDeveRetornarBeneficiadoTest() {
        BuscarBeneficiadoPorIdCommand command = new BuscarBeneficiadoPorIdCommand(1);
        when(gateway.findById(1)).thenReturn(beneficiado);

        Beneficiado resultado = buscarPorIdUseCase.executar(command);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        verify(gateway, times(1)).findById(1);
    }

    @Test
    @DisplayName("buscarBeneficiadoPorId() quando acionado com ID inválido, deve retornar null")
    void buscarBeneficiadoPorIdComIdInvalidoDeveRetornarNullTest() {
        BuscarBeneficiadoPorIdCommand command = new BuscarBeneficiadoPorIdCommand(999);
        when(gateway.findById(999)).thenReturn(null);

        Beneficiado resultado = buscarPorIdUseCase.executar(command);

        assertNull(resultado);
        verify(gateway, times(1)).findById(999);
    }

    @Test
    @DisplayName("listarBeneficiados() quando tiver beneficiados cadastrados, deve retornar lista de beneficiados")
    void listarBeneficiadosQuandoTiverBeneficiadosCadastradosDeveRetornarListaDeBeneficiadosTest() {
        List<Beneficiado> beneficiados = Arrays.asList(beneficiado, beneficiado);
        when(gateway.findAll()).thenReturn(beneficiados);

        List<Beneficiado> resultado = listarBeneficiadosUseCase.executar();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(gateway, times(1)).findAll();
    }

    @Test
    @DisplayName("listarBeneficiados() quando não houver beneficiados, deve retornar lista vazia")
    void listarBeneficiadosSemRegistrosDeveRetornarListaVazia() {
        when(gateway.findAll()).thenReturn(Collections.emptyList());

        List<Beneficiado> resultado = listarBeneficiadosUseCase.executar();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(gateway, times(1)).findAll();
    }

    @Test
    @DisplayName("atualizarBeneficiado() quando acionado com id válido, deve atualizar beneficiado")
    void atualizarBeneficiadoQuandoAcionadoComIdValidoDeveAtualizarBeneficiadoTest() {
        AtualizarBeneficiadoCommand command = new AtualizarBeneficiadoCommand(
                "São Paulo",
                Telefone.valueOf("11987654321").getValue(),
                EstadoCivil.CASADO.toString(),
                "Superior Completo",
                "Engenheira",
                Renda.valueOf(5000.0).getValue(),
                "Empresa XYZ",
                "Engenheira Civil",
                Religiao.valueOf("Evangélico").getValue(),
                2,
                null,
                null
        );

        Beneficiado beneficiadoAtualizado = new Beneficiado();
        beneficiadoAtualizado.setId(1);
        beneficiadoAtualizado.setNome("Maria Silva Atualizada");
        beneficiadoAtualizado.setTelefone(Telefone.valueOf("11987654321"));
        beneficiadoAtualizado.setProfissao("Engenheira");

        when(gateway.existsById(1)).thenReturn(true);
        when(gateway.findById(1)).thenReturn(beneficiado);
        when(gateway.save(any(Beneficiado.class))).thenReturn(beneficiadoAtualizado);

        Beneficiado resultado = atualizarUseCase.executar(1, command);

        assertNotNull(resultado);
        verify(gateway, times(1)).existsById(1);
        verify(gateway, times(1)).findById(1);
        verify(gateway, times(1)).save(any(Beneficiado.class));
    }

    @Test
    @DisplayName("atualizarBeneficiado() quando acionado com id inválido, deve lançar EntidadeNaoEncontradaException")
    void atualizarBeneficiadoQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        AtualizarBeneficiadoCommand command = new AtualizarBeneficiadoCommand(
                null,
                Telefone.valueOf("11999999999").getValue(),
                null,
                null,
                "Professora",
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        when(gateway.existsById(999)).thenReturn(false);

        assertThrows(EntidadeNaoEncontradaException.class, () -> atualizarUseCase.executar(999, command));

        verify(gateway, times(1)).existsById(999);
        verify(gateway, never()).save(any(Beneficiado.class));
    }
}
