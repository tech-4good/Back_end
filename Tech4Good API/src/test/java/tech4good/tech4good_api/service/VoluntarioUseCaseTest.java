package tech4good.tech4good_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.AtualizarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.CadastrarVoluntarioCommand;
import tech4good.tech4good_api.core.application.command.voluntario.ListarVoluntarioPorIdCommand;
import tech4good.tech4good_api.core.application.command.voluntario.RemoverVoluntarioPorIdCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.application.usecase.voluntario.AtualizarVoluntarioUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.CadastrarVoluntarioUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.ListarVoluntarioPorIdUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.ListarVoluntariosUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.RemoverVoluntarioPorIdUseCase;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.core.domain.voluntario.valueobject.Email;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes do Use Case - Voluntario")
class VoluntarioUseCaseTest {

    @Mock
    private VoluntarioGateway gateway;

    @Mock
    private PasswordEncoder passwordEncoder;

    private CadastrarVoluntarioUseCase cadastrarUseCase;
    private ListarVoluntarioPorIdUseCase listarPorIdUseCase;
    private ListarVoluntariosUseCase listarVoluntariosUseCase;
    private AtualizarVoluntarioUseCase atualizarUseCase;
    private RemoverVoluntarioPorIdUseCase removerUseCase;

    private Voluntario voluntario;
    private CadastrarVoluntarioCommand cadastrarCommand;

    @BeforeEach
    void setUp() {
        cadastrarUseCase = new CadastrarVoluntarioUseCase(gateway, passwordEncoder);
        listarPorIdUseCase = new ListarVoluntarioPorIdUseCase(gateway);
        listarVoluntariosUseCase = new ListarVoluntariosUseCase(gateway);
        atualizarUseCase = new AtualizarVoluntarioUseCase(gateway);
        removerUseCase = new RemoverVoluntarioPorIdUseCase(gateway);

        voluntario = new Voluntario();
        voluntario.setId(1);
        voluntario.setNome("João Silva");
        voluntario.setEmail(Email.valueOf("joao@email.com"));
        voluntario.setSenha("senha123");
        voluntario.setTelefone(Telefone.valueOf("11999999999"));
        voluntario.setCpf(Cpf.valueOf("12345678900"));

        cadastrarCommand = new CadastrarVoluntarioCommand(
                "João Silva",
                Cpf.valueOf("12345678900"),
                Telefone.valueOf("11999999999"),
                "senha123",
                Email.valueOf("joao@email.com"),
                0
        );
    }

    @Test
    @DisplayName("cadastrarVoluntario() quando acionado com voluntário válido deve cadastrar corretamente")
    void cadastrarVoluntarioQuandoAcionadoComVoluntarioValidoDeveCadastrarCorretamenteTest() {
        String senhaCriptografada = "senhaCriptografada123";

        when(passwordEncoder.encode("senha123")).thenReturn(senhaCriptografada);
        when(gateway.salvar(any(Voluntario.class))).thenReturn(voluntario);

        Voluntario resultado = cadastrarUseCase.execute(cadastrarCommand);

        assertNotNull(resultado);
        verify(passwordEncoder, times(1)).encode("senha123");
        verify(gateway, times(1)).salvar(any(Voluntario.class));
    }

    @Test
    @DisplayName("cadastrarVoluntario() quando email é nulo deve lançar EntidadeNaoEncontradaException")
    void cadastrarVoluntarioQuandoEmailNuloDeveLancarExcecaoTest() {
        CadastrarVoluntarioCommand commandInvalido = new CadastrarVoluntarioCommand(
                "João Silva",
                Cpf.valueOf("12345678900"),
                Telefone.valueOf("11999999999"),
                "senha123",
                null,
                0
        );

        assertThrows(EntidadeNaoEncontradaException.class, () -> cadastrarUseCase.execute(commandInvalido));

        verify(gateway, never()).salvar(any(Voluntario.class));
    }

    @Test
    @DisplayName("cadastrarVoluntario() quando senha é nula deve lançar EntidadeNaoEncontradaException")
    void cadastrarVoluntarioQuandoSenhaNulaDeveLancarExcecaoTest() {
        CadastrarVoluntarioCommand commandInvalido = new CadastrarVoluntarioCommand(
                "João Silva",
                Cpf.valueOf("12345678900"),
                Telefone.valueOf("11999999999"),
                null,
                Email.valueOf("joao@email.com"),
                0
        );

        assertThrows(EntidadeNaoEncontradaException.class, () -> cadastrarUseCase.execute(commandInvalido));

        verify(gateway, never()).salvar(any(Voluntario.class));
    }

    @Test
    @DisplayName("buscarVoluntarioPorId() quando acionado com Id válido deve retornar Voluntario")
    void buscarVoluntarioPorIdQuandoAcionadoComIdValidoDeveRetornarVoluntarioTest() {
        ListarVoluntarioPorIdCommand command = new ListarVoluntarioPorIdCommand(1);
        when(gateway.buscarPorId(1)).thenReturn(voluntario);

        Voluntario resultado = listarPorIdUseCase.execute(command);

        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        verify(gateway, times(1)).buscarPorId(1);
    }

    @Test
    @DisplayName("buscarVoluntarioPorId() quando acionado com Id inválido deve lançar EntidadeNaoEncontradaException")
    void buscarVoluntarioPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        ListarVoluntarioPorIdCommand command = new ListarVoluntarioPorIdCommand(999);
        when(gateway.buscarPorId(999)).thenReturn(null);

        Voluntario resultado = listarPorIdUseCase.execute(command);

        assertNull(resultado);
        verify(gateway, times(1)).buscarPorId(999);
    }

    @Test
    @DisplayName("listarVoluntarios() quando houver voluntários cadastrados deve retornar lista de voluntários")
    void listarVoluntariosQuandoHouverVoluntariosCadastradosDeveRetornarListaDeVoluntariosTest() {
        List<Voluntario> voluntarios = Arrays.asList(voluntario, voluntario, voluntario);
        when(gateway.listarTodos()).thenReturn(voluntarios);

        // O método retorna VoluntarioListarDto, então ajustamos o teste
        var resultado = listarVoluntariosUseCase.execute();

        assertNotNull(resultado);
        assertEquals(3, resultado.size());
        verify(gateway, times(1)).listarTodos();
    }

    @Test
    @DisplayName("listarVoluntarios() quando não houver voluntários cadastrados deve retornar lista vazia")
    void listarVoluntariosQuandoNaoHouverVoluntariosCadastradosDeveRetornarListaVaziaTest() {
        when(gateway.listarTodos()).thenReturn(Collections.emptyList());

        var resultado = listarVoluntariosUseCase.execute();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(gateway, times(1)).listarTodos();
    }

    @Test
    @DisplayName("atualizarVoluntarioPorId() quando acionado com Id válido deve atualizar voluntário")
    void atualizarVoluntarioPorIdQuandoAcionadoComIdValidoDeveAtualizarVoluntarioTest() {
        AtualizarVoluntarioCommand command = new AtualizarVoluntarioCommand(
                1,
                Telefone.valueOf("11987654321"),
                Email.valueOf("novo@email.com")
        );

        Voluntario voluntarioAtualizado = new Voluntario();
        voluntarioAtualizado.setId(1);
        voluntarioAtualizado.setNome("João Silva Atualizado");
        voluntarioAtualizado.setEmail(Email.valueOf("novo@email.com"));
        voluntarioAtualizado.setTelefone(Telefone.valueOf("11987654321"));

        when(gateway.atualizar(command)).thenReturn(voluntarioAtualizado);

        Voluntario resultado = atualizarUseCase.execute(command);

        assertNotNull(resultado);
        verify(gateway, times(1)).atualizar(command);
    }

    @Test
    @DisplayName("atualizarVoluntarioPorId() quando acionado com Id inválido deve lançar EntidadeNaoEncontradaException")
    void atualizarVoluntarioPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        AtualizarVoluntarioCommand command = new AtualizarVoluntarioCommand(
                999,
                Telefone.valueOf("11999999999"),
                Email.valueOf("joao@email.com")
        );

        when(gateway.atualizar(command)).thenThrow(new EntidadeNaoEncontradaException("Voluntário não encontrado"));

        assertThrows(EntidadeNaoEncontradaException.class, () -> atualizarUseCase.execute(command));

        verify(gateway, times(1)).atualizar(command);
    }

    @Test
    @DisplayName("removerVoluntarioPorId() quando acionado com Id válido deve remover voluntário")
    void removerVoluntarioPorIdQuandoAcionadoComIdValidoDeveRemoverVoluntarioTest() {
        RemoverVoluntarioPorIdCommand command = new RemoverVoluntarioPorIdCommand(1);
        doNothing().when(gateway).deletarPorId(1);

        removerUseCase.execute(command);

        verify(gateway, times(1)).deletarPorId(1);
    }

    @Test
    @DisplayName("removerVoluntarioPorId() quando acionado com Id inválido deve lançar EntidadeNaoEncontradaException")
    void removerVoluntarioPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        RemoverVoluntarioPorIdCommand command = new RemoverVoluntarioPorIdCommand(999);
        doNothing().when(gateway).deletarPorId(999);

        removerUseCase.execute(command);

        verify(gateway, times(1)).deletarPorId(999);
    }
}
