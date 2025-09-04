package tech4good.tech4good_api.core.application.usecase.voluntario;

import org.springframework.security.crypto.password.PasswordEncoder;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.CadastrarVoluntarioCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioMapper;

public class CadastrarVoluntarioUseCase {

    private final VoluntarioGateway voluntarioGateway;
    private final PasswordEncoder passwordEncoder;

    public CadastrarVoluntarioUseCase(VoluntarioGateway voluntarioGateway, PasswordEncoder passwordEncoder) {
        this.voluntarioGateway = voluntarioGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public Voluntario execute(CadastrarVoluntarioCommand command) {
        if (command.email() == null || command.senha() == null) {
            throw new EntidadeNaoEncontradaException("Dados do voluntário são inválidos");
        }

        Voluntario voluntario = VoluntarioMapper.toDomain(command);

        String senhaCriptografada = passwordEncoder.encode(voluntario.getSenha());
        voluntario.setSenha(senhaCriptografada);

        return voluntarioGateway.salvar(voluntario);
    }
}
