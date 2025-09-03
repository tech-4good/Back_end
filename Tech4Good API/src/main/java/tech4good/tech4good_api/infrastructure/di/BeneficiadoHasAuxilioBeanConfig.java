package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.adapter.AuxilioGovernamentalGateway;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.application.usecase.beneficiadohasauxilio.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.BeneficiadoHasAuxilio.BeneficiadoHasAuxilioJpaAdapter;

@Configuration
public class BeneficiadoHasAuxilioBeanConfig {

    @Bean
    public CadastrarBeneficiadoHasAuxilioUseCase cadastrarBeneficiadoHasAuxilioUseCase(
            BeneficiadoHasAuxilioJpaAdapter adapter,
            BeneficiadoGateway beneficiadoGateway,
            AuxilioGovernamentalGateway auxilioGovernamentalGateway) {
        return new CadastrarBeneficiadoHasAuxilioUseCase(adapter, beneficiadoGateway, auxilioGovernamentalGateway);
    }

    @Bean
    public AtualizarBeneficiadoHasAuxilioUseCase atualizarBeneficiadoHasAuxilioUseCase(
            BeneficiadoHasAuxilioJpaAdapter adapter,
            BeneficiadoGateway beneficiadoGateway,
            AuxilioGovernamentalGateway auxilioGovernamentalGateway) {
        return new AtualizarBeneficiadoHasAuxilioUseCase(adapter, beneficiadoGateway, auxilioGovernamentalGateway);
    }

    @Bean
    public BuscarBeneficiadoHasAuxilioPorIdUseCase buscarBeneficiadoHasAuxilioPorIdUseCase(BeneficiadoHasAuxilioJpaAdapter adapter) {
        return new BuscarBeneficiadoHasAuxilioPorIdUseCase(adapter);
    }

    @Bean
    public ListarBeneficiadoHasAuxilioUseCase listarBeneficiadoHasAuxilioUseCase(BeneficiadoHasAuxilioJpaAdapter adapter) {
        return new ListarBeneficiadoHasAuxilioUseCase(adapter);
    }

    @Bean
    public RemoverBeneficiadoHasAuxilioPorIdUseCase removerBeneficiadoHasAuxilioPorIdUseCase(BeneficiadoHasAuxilioJpaAdapter adapter) {
        return new RemoverBeneficiadoHasAuxilioPorIdUseCase(adapter);
    }
}
