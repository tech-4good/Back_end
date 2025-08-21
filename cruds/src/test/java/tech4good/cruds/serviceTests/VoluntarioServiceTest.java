package tech4good.cruds.serviceTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech4good.cruds.entity.Voluntario;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.VoluntarioRepository;
import tech4good.cruds.service.VoluntarioService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VoluntarioServiceTest {

    @InjectMocks
    private VoluntarioService service;

    @Mock
    private VoluntarioRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("cadastrarVoluntario() quando acionado com voluntário válido deve cadastrar corretamente")
    void cadastrarVoluntarioQuandoAcionadoComVoluntarioValidoDeveCadastrarCorretamenteTest() {
        Voluntario voluntario = new Voluntario();
        voluntario.setSenha("senha123");
        voluntario.setEmail("email@email.com");

        String senhaCriptografada = "senhaCriptografada123";

        when(passwordEncoder.encode("senha123")).thenReturn(senhaCriptografada);

        service.cadastrarVoluntario(voluntario);

        assertEquals(senhaCriptografada, voluntario.getSenha());
        verify(repository, times(1)).save(voluntario);
    }

    @Test
    @DisplayName("cadastrarVoluntario() quando acionado com voluntário inválido deve retornar EntidadeNaoEncontradaException")
    void cadastrarVoluntarioQuandoACionadoComVoluntarioInvalidoDeveRetornarEntidadeNaoEncontradaExceptionTest() {
        Voluntario voluntario = new Voluntario();

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.cadastrarVoluntario(voluntario));

        verify(repository, never()).save(voluntario);
    }

    @Test
    @DisplayName("buscarVoluntarioPorId() quando acionado com Id válido deve retornar Voluntario")
    void buscarVoluntarioPorIdQuandoAcionadoComIdValidoDeveRetornarVoluntarioTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(new Voluntario()));

        service.buscarVoluntarioPorId(anyInt());

        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    @DisplayName("buscarVoluntarioPorId() quando acionado com Id inválido deve lançar EntidadeNaoEncontradaException")
    void buscarVoluntarioPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.buscarVoluntarioPorId(anyInt()));

        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    @DisplayName("listarVoluntarios() quando não houver voluntarios cadastrados deve retornar lista vazia")
    void listarVoluntariosQuandoNaoHouverVoluntariosCadastradosDeveRetornarListaVaziaTest() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        service.listarVoluntarios();

        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("listarVoluntarios() quando não houver voluntarios cadastrados deve retornar lista vazia")
    void listarVoluntariosQuandoHouverVoluntariosCadastradosDeveRetornarListaDeVoluntariosTest() {
        when(repository.findAll()).thenReturn(List.of(new Voluntario(), new Voluntario(), new Voluntario()));

        service.listarVoluntarios();

        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("atualizarVoluntarioPorId() quando acionado com Id válido deve atualizar voluntario")
    void atualizarVoluntarioPorIdQuandoAcionadoComIdValidoDeveAtualizarVoluntarioTest() {
        Integer id = 1;

        Voluntario voluntarioAtualizacao = new Voluntario();
        voluntarioAtualizacao.setEmail("novo@email.com");
        voluntarioAtualizacao.setTelefone("123456789");

        Voluntario voluntarioExistente = new Voluntario();
        voluntarioExistente.setEmail("antigo@email.com");
        voluntarioExistente.setTelefone("000000000");

        when(repository.findById(id)).thenReturn(Optional.of(voluntarioExistente));
        when(repository.save(any(Voluntario.class))).thenReturn(voluntarioExistente);

        Voluntario atualizado = service.atualizarVoluntario(voluntarioAtualizacao, id);

        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(voluntarioExistente);

        assertEquals("novo@email.com", atualizado.getEmail());
        assertEquals("123456789", atualizado.getTelefone());
    }

    @Test
    @DisplayName("atualizarVoluntarioPorId() quando acionado com Id inválido deve lançar EntidadeNaoEncontradaException")
    void atualizarVoluntarioPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.atualizarVoluntario(new Voluntario(), anyInt()));

        verify(repository, times(1)).findById(anyInt());
    }

    @Test
    @DisplayName("removerVoluntarioPorId() quando acionado com Id inválido deve lançar EntidadeNaoEncontradaException")
    void removerVoluntarioPorIdQuandoAcionadoComIdInvalidoDeveLancarEntidadeNaoEncontradaExceptionTest() {
        when(repository.existsById(anyInt())).thenReturn(false);

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.removerVoluntarioPorId(anyInt()));

        verify(repository, times(1)).existsById(anyInt());
        verify(repository, times(0)).deleteById(anyInt());
    }

    @Test
    @DisplayName("removerVoluntarioPorId() quando acionado com Id válido deve remover voluntario")
    void removerVoluntarioPorIdQuandoAcionadoComIdValidoDeveRemoverVoluntarioTest() {
        when(repository.existsById(anyInt())).thenReturn(true);

        service.removerVoluntarioPorId(anyInt());

        verify(repository, times(1)).existsById(anyInt());
        verify(repository, times(1)).deleteById(anyInt());
    }
}