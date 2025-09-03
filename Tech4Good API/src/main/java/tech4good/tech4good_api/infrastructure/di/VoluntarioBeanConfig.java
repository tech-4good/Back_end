package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech4good.tech4good_api.config.jwt.GerenciadorTokenJwt;
import tech4good.tech4good_api.core.application.usecase.voluntario.AtualizarVoluntarioUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.AutenticarVoluntarioUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.BuscarVoluntarioPorEmailUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.CadastrarVoluntarioUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.ListarVoluntarioPorIdUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.ListarVoluntariosUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.RedefinirSenhaVoluntarioUseCase;
import tech4good.tech4good_api.core.application.usecase.voluntario.RemoverVoluntarioPorIdUseCase;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario.VoluntarioJpaAdapter;

@Configuration
public class VoluntarioBeanConfig {

    @Bean
    public CadastrarVoluntarioUseCase cadastrarVoluntarioUseCase(VoluntarioJpaAdapter adapter, PasswordEncoder passwordEncoder) {
        return new CadastrarVoluntarioUseCase(adapter, passwordEncoder);
    }

    @Bean
    public AutenticarVoluntarioUseCase autenticarVoluntarioUseCase(VoluntarioJpaAdapter adapter,
                                                                 GerenciadorTokenJwt gerenciadorTokenJwt,
                                                                 AuthenticationManager authenticationManager) {
        return new AutenticarVoluntarioUseCase(adapter, gerenciadorTokenJwt, authenticationManager);
    }

    @Bean
    public ListarVoluntarioPorIdUseCase listarVoluntarioPorIdUseCase(VoluntarioJpaAdapter adapter) {
        return new ListarVoluntarioPorIdUseCase(adapter);
    }

    @Bean
    public ListarVoluntariosUseCase listarVoluntariosUseCase(VoluntarioJpaAdapter adapter) {
        return new ListarVoluntariosUseCase(adapter);
    }

    @Bean
    public AtualizarVoluntarioUseCase atualizarVoluntarioUseCase(VoluntarioJpaAdapter adapter) {
        return new AtualizarVoluntarioUseCase(adapter);
    }

    @Bean
    public RemoverVoluntarioPorIdUseCase removerVoluntarioPorIdUseCase(VoluntarioJpaAdapter adapter) {
        return new RemoverVoluntarioPorIdUseCase(adapter);
    }

    @Bean
    public BuscarVoluntarioPorEmailUseCase buscarVoluntarioPorEmailUseCase(VoluntarioJpaAdapter adapter) {
        return new BuscarVoluntarioPorEmailUseCase(adapter);
    }

    @Bean
    public RedefinirSenhaVoluntarioUseCase redefinirSenhaVoluntarioUseCase(VoluntarioJpaAdapter adapter, PasswordEncoder passwordEncoder) {
        return new RedefinirSenhaVoluntarioUseCase(adapter, passwordEncoder);
    }
}
