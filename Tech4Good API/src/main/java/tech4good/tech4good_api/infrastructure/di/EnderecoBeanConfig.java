package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.endereco.CadastrarEnderecoUseCase;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoJpaAdapter;

@Configuration
public class EnderecoBeanConfig {

    @Bean
    public CadastrarEnderecoUseCase cadastrarEnderecoUseCase(EnderecoJpaAdapter adapter) {
        return new CadastrarEnderecoUseCase(adapter);
    }
}
