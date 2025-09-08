package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.beneficiado.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoJpaAdapter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoJpaAdapter;

@Configuration
public class BeneficiadoBeanConfig {

    @Bean
    public CadastrarBeneficiadoUseCase cadastrarBeneficiadoUseCase(BeneficiadoJpaAdapter adapter, EnderecoJpaAdapter enderecoJpaAdapter, tech4good.tech4good_api.infrastructure.persistence.jpa.File.FileJpaAdapter fileJpaAdapter) {
        return new CadastrarBeneficiadoUseCase(adapter, enderecoJpaAdapter, fileJpaAdapter);
    }

    @Bean
    public AtualizarBeneficiadoUseCase atualizarBeneficiadoUseCase(BeneficiadoJpaAdapter adapter, EnderecoJpaAdapter enderecoJpaAdapter, tech4good.tech4good_api.infrastructure.persistence.jpa.File.FileJpaAdapter fileJpaAdapter) {
        return new AtualizarBeneficiadoUseCase(adapter, enderecoJpaAdapter, fileJpaAdapter);
    }

    @Bean
    public BuscarBeneficiadoPorCpfUseCase buscarBeneficiadoPorCpfUseCase(BeneficiadoJpaAdapter adapter) {
        return new BuscarBeneficiadoPorCpfUseCase(adapter);
    }

    @Bean
    public BuscarBeneficiadoPorIdUseCase buscarBeneficiadoPorIdUseCase(BeneficiadoJpaAdapter adapter) {
        return new BuscarBeneficiadoPorIdUseCase(adapter);
    }

    @Bean
    public CadastrarBeneficiadoSimplesUseCase cadastrarBeneficiadoSimplesUseCase(BeneficiadoJpaAdapter BeneficiadoAdapter, EnderecoJpaAdapter enderecoAdapter, tech4good.tech4good_api.infrastructure.persistence.jpa.File.FileJpaAdapter fileJpaAdapter) {
        return new CadastrarBeneficiadoSimplesUseCase(BeneficiadoAdapter, enderecoAdapter, fileJpaAdapter);
    }

    @Bean
    public ListarBeneficiadosUseCase listarBeneficiadosUseCase(BeneficiadoJpaAdapter adapter) {
        return new ListarBeneficiadosUseCase(adapter);
    }

    @Bean
    public RemoverBeneficiadoPorIdUseCase removerBeneficiadoPorIdUseCase(BeneficiadoJpaAdapter adapter) {
        return new RemoverBeneficiadoPorIdUseCase(adapter);
    }

    @Bean
    public SetFotoBeneficiadoUseCase setFotoBeneficiadoUseCase(BeneficiadoJpaAdapter beneficiadoAdapter, tech4good.tech4good_api.infrastructure.persistence.jpa.File.FileJpaAdapter fileAdapter) {
        return new SetFotoBeneficiadoUseCase(beneficiadoAdapter, fileAdapter);
    }
}
