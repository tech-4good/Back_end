package tech4good.cruds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech4good.cruds.config.GerenciadorTokenJwt;
import tech4good.cruds.dto.voluntario.VoluntarioListarDto;
import tech4good.cruds.dto.voluntario.VoluntarioTokenDto;
import tech4good.cruds.entity.Voluntario;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.mapper.VoluntarioMapper;
import tech4good.cruds.repository.VoluntarioRepository;

import java.util.List;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    private AuthenticationManager authenticationManager;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public void cadastrarVoluntario(Voluntario voluntario){
        String senhaCriptografada = passwordEncoder.encode(voluntario.getSenha());
        voluntario.setSenha(senhaCriptografada);

         this.voluntarioRepository.save(voluntario);
    }

    public VoluntarioTokenDto autenticar(Voluntario voluntario) {
        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                voluntario.getEmail(), voluntario.getSenha()
        );

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Voluntario voluntarioAutenticado = voluntarioRepository.findByEmail(voluntario.getEmail())
                .orElseThrow(
                        () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return VoluntarioMapper.toVoluntarioTokenDto(voluntarioAutenticado, token);
    }


    public Voluntario buscarVoluntarioPorId(Integer id){
        return voluntarioRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Voluntário de id %d não encontrado".formatted(id)));
    }


    public List<VoluntarioListarDto> listarVoluntarios(){
        List<Voluntario> voluntariosEncontrados = voluntarioRepository.findAll();
        return voluntariosEncontrados.stream().map(VoluntarioMapper::toVoluntarioListarDto).toList();
    }

    public Voluntario atualizarVoluntario(Voluntario voluntario, Integer id){
        Voluntario voluntarioExistente = voluntarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Voluntario de id %d não encontrado".formatted(id)));

        if (voluntario.getTelefone() != null){
            voluntarioExistente.setTelefone(voluntario.getTelefone());
        }

        if (voluntario.getEmail() != null){
            voluntarioExistente.setEmail(voluntario.getEmail());
        }

       return voluntarioRepository.save(voluntarioExistente);
    }

    public void removerVoluntarioPorId(Integer id){
        if(voluntarioRepository.existsById(id)){
            voluntarioRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Voluntário de id %d não encontrado".formatted(id));
        }
    }

    public void redefinirSenha(String email, String senhaAtual, String novaSenha) {
        Voluntario voluntario = voluntarioRepository.findByEmail(email)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Voluntário com e-mail %s não encontrado".formatted(email)));

        System.out.println("Senha criptografada no banco: " + voluntario.getSenha());

        if (!passwordEncoder.matches(senhaAtual, voluntario.getSenha())) {
            throw new RuntimeException("Senha atual incorreta");
        }
        voluntario.setSenha(passwordEncoder.encode(novaSenha));
        voluntarioRepository.save(voluntario);
    }
}
