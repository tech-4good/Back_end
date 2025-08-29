package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.beneficiado.CadastrarBeneficiadoUseCase;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoJpaAdapter;

@Configuration
public class BeneficiadoBeanConfig {

    @Bean
    public CadastrarBeneficiadoUseCase cadastrarBeneficiadoUseCase(BeneficiadoJpaAdapter adapter) {
        return new CadastrarBeneficiadoUseCase(adapter);
    }
}
