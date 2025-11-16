package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.endereco.*;
import tech4good.tech4good_api.core.adapter.ViaCepGateway;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoJpaAdapter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta.CestaJpaAdapter;

@Configuration
public class EnderecoBeanConfig {

    @Bean
    public DefinirStatusInicialEnderecoUseCase definirStatusInicialEnderecoUseCase(
            EnderecoJpaAdapter enderecoAdapter,
            CestaJpaAdapter cestaAdapter) {
        return new DefinirStatusInicialEnderecoUseCase(enderecoAdapter, cestaAdapter);
    }

    @Bean
    public ProcessarFilaEsperaAoCadastrarCestaUseCase processarFilaEsperaAoCadastrarCestaUseCase(
            EnderecoJpaAdapter enderecoAdapter,
            CestaJpaAdapter cestaAdapter) {
        return new ProcessarFilaEsperaAoCadastrarCestaUseCase(enderecoAdapter, cestaAdapter);
    }

    @Bean
    public VerificarEnderecosInativosUseCase verificarEnderecosInativosUseCase(
            EnderecoJpaAdapter enderecoAdapter,
            ProcessarFilaEsperaAoCadastrarCestaUseCase processarFilaUseCase) {
        return new VerificarEnderecosInativosUseCase(enderecoAdapter, processarFilaUseCase);
    }

    @Bean
    public CadastrarEnderecoUseCase cadastrarEnderecoUseCase(
            EnderecoJpaAdapter adapter,
            DefinirStatusInicialEnderecoUseCase definirStatusUseCase) {
        return new CadastrarEnderecoUseCase(adapter, definirStatusUseCase);
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

    @Bean
    public BuscarApiCepEnderecoUseCase buscarApiCepEnderecoUseCase(ViaCepGateway viaCepGateway) {
        return new BuscarApiCepEnderecoUseCase(viaCepGateway);
    }
}
