package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.auxiliogovernamental.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.AuxilioGovernamental.AuxilioGovernamentalJpaAdapter;

@Configuration
public class AuxilioGovernamentalBeanConfig {

    @Bean
    public CadastrarAuxilioGovernamentalUseCase cadastrarAuxilioGovernamentalUseCase(AuxilioGovernamentalJpaAdapter adapter) {
        return new CadastrarAuxilioGovernamentalUseCase(adapter);
    }

    @Bean
    public AtualizarAuxilioGovernamentalUseCase atualizarAuxilioGovernamentalUseCase(AuxilioGovernamentalJpaAdapter adapter) {
        return new AtualizarAuxilioGovernamentalUseCase(adapter);
    }

    @Bean
    public BuscarAuxilioGovernamentalPorIdUseCase buscarAuxilioGovernamentalPorIdUseCase(AuxilioGovernamentalJpaAdapter adapter) {
        return new BuscarAuxilioGovernamentalPorIdUseCase(adapter);
    }

    @Bean
    public ListarAuxilioGovernamentalUseCase listarAuxilioGovernamentalUseCase(AuxilioGovernamentalJpaAdapter adapter) {
        return new ListarAuxilioGovernamentalUseCase(adapter);
    }

    @Bean
    public RemoverAuxilioGovernamentalPorIdUseCase removerAuxilioGovernamentalPorIdUseCase(AuxilioGovernamentalJpaAdapter adapter) {
        return new RemoverAuxilioGovernamentalPorIdUseCase(adapter);
    }
}
