package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.filaespera.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.FilaEspera.FilaEsperaJpaAdapter;

@Configuration
public class FilaEsperaBeanConfig {

    @Bean
    public CadastrarFilaEsperaUseCase cadastrarFilaEsperaUseCase(FilaEsperaJpaAdapter adapter) {
        return new CadastrarFilaEsperaUseCase(adapter);
    }

    @Bean
    public ListarFilaEsperaUseCase listarFilaEsperaUseCase(FilaEsperaJpaAdapter adapter) {
        return new ListarFilaEsperaUseCase(adapter);
    }

    @Bean
    public BuscarFilaEsperaPorIdUseCase buscarFilaEsperaPorIdUseCase(FilaEsperaJpaAdapter adapter) {
        return new BuscarFilaEsperaPorIdUseCase(adapter);
    }

    @Bean
    public AtualizarFilaEsperaUseCase atualizarFilaEsperaUseCase(FilaEsperaJpaAdapter adapter) {
        return new AtualizarFilaEsperaUseCase(adapter);
    }

    @Bean
    public RemoverFilaEsperaUseCase removerFilaEsperaUseCase(FilaEsperaJpaAdapter adapter) {
        return new RemoverFilaEsperaUseCase(adapter);
    }
}
