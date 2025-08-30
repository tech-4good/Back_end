package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.endereco.AtualizarEnderecoUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.CadastrarEnderecoUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.ListarEnderecoPorIdUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.ListarEnderecosUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.RemoverEnderecoPorIdUseCase;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoJpaAdapter;

@Configuration
public class EnderecoBeanConfig {

    @Bean
    public CadastrarEnderecoUseCase cadastrarEnderecoUseCase(EnderecoJpaAdapter adapter) {
        return new CadastrarEnderecoUseCase(adapter);
    }

    @Bean
    public ListarEnderecoPorIdUseCase listarEnderecoPorIdUseCase(EnderecoJpaAdapter adapter) {
        return new ListarEnderecoPorIdUseCase(adapter);
    }

    @Bean
    public ListarEnderecosUseCase listarEnderecosUseCase(EnderecoJpaAdapter adapter) {
        return new ListarEnderecosUseCase(adapter);
    }

    @Bean
    public AtualizarEnderecoUseCase atualizarEnderecoUseCase(EnderecoJpaAdapter adapter) {
        return new AtualizarEnderecoUseCase(adapter);
    }

    @Bean
    public RemoverEnderecoPorIdUseCase removerEnderecoPorIdUseCase(EnderecoJpaAdapter adapter) {
        return new RemoverEnderecoPorIdUseCase(adapter);
    }
}
