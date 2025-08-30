package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.beneficiado.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoJpaAdapter;

@Configuration
public class BeneficiadoBeanConfig {

    @Bean
    public CadastrarBeneficiadoUseCase cadastrarBeneficiadoUseCase(BeneficiadoJpaAdapter adapter) {
        return new CadastrarBeneficiadoUseCase(adapter);
    }

    @Bean
    public AtualizarBeneficiadoUseCase atualizarBeneficiadoUseCase(BeneficiadoJpaAdapter adapter) {
        return new AtualizarBeneficiadoUseCase(adapter);
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
    public CadastrarBeneficiadoSimplesUseCase cadastrarBeneficiadoSimplesUseCase(BeneficiadoJpaAdapter adapter) {
        return new CadastrarBeneficiadoSimplesUseCase(adapter);
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
    public SetFotoBeneficiadoUseCase setFotoBeneficiadoUseCase(BeneficiadoJpaAdapter adapter) {
        return new SetFotoBeneficiadoUseCase(adapter);
    }
}
