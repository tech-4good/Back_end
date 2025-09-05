package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.filhobeneficiado.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.FilhoBeneficiado.FilhoBeneficiadoJpaAdapter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoJpaAdapter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoJpaAdapter;

@Configuration
public class FilhoBeneficiadoBeanConfig {

    @Bean
    public CriarFilhoBeneficiadoUseCase criarFilhoBeneficiadoUseCase(
            FilhoBeneficiadoJpaAdapter filhoAdapter,
            BeneficiadoJpaAdapter beneficiadoAdapter,
            EnderecoJpaAdapter enderecoAdapter) {
        return new CriarFilhoBeneficiadoUseCase(filhoAdapter, beneficiadoAdapter, enderecoAdapter);
    }

    @Bean
    public BuscarFilhoBeneficiadoPorIdUseCase buscarFilhoBeneficiadoPorIdUseCase(FilhoBeneficiadoJpaAdapter adapter) {
        return new BuscarFilhoBeneficiadoPorIdUseCase(adapter);
    }

    @Bean
    public ListarFilhosBeneficiadosUseCase listarFilhosBeneficiadosUseCase(FilhoBeneficiadoJpaAdapter adapter) {
        return new ListarFilhosBeneficiadosUseCase(adapter);
    }

    @Bean
    public AtualizarFilhoBeneficiadoUseCase atualizarFilhoBeneficiadoUseCase(FilhoBeneficiadoJpaAdapter adapter) {
        return new AtualizarFilhoBeneficiadoUseCase(adapter);
    }

    @Bean
    public RemoverFilhoBeneficiadoPorIdUseCase removerFilhoBeneficiadoPorIdUseCase(FilhoBeneficiadoJpaAdapter adapter) {
        return new RemoverFilhoBeneficiadoPorIdUseCase(adapter);
    }
}
