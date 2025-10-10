package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.usecase.entrega.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Entrega.EntregaJpaAdapter;

@Configuration
public class EntregaBeanConfig {

    @Bean
    public CadastrarEntregaUseCase cadastrarEntregaUseCase(
            EntregaJpaAdapter adapter,
            EnderecoGateway enderecoGateway,
            BeneficiadoGateway beneficiadoGateway,
            CestaGateway cestaGateway,
            VoluntarioGateway voluntarioGateway) {
        return new CadastrarEntregaUseCase(adapter, enderecoGateway, beneficiadoGateway, cestaGateway, voluntarioGateway);
    }

    @Bean
    public AtualizarEntregaUseCase atualizarEntregaUseCase(EntregaJpaAdapter adapter) {
        return new AtualizarEntregaUseCase(adapter);
    }

    @Bean
    public BuscarEntregaPorIdUseCase buscarEntregaPorIdUseCase(EntregaJpaAdapter adapter) {
        return new BuscarEntregaPorIdUseCase(adapter);
    }

    @Bean
    public ListarEntregasUseCase listarEntregasUseCase(EntregaJpaAdapter adapter) {
        return new ListarEntregasUseCase(adapter);
    }

    @Bean
    public RemoverEntregaPorIdUseCase removerEntregaPorIdUseCase(EntregaJpaAdapter adapter) {
        return new RemoverEntregaPorIdUseCase(adapter);
    }

    @Bean
    public ListarHistoricoEntregasUseCase listarHistoricoEntregasUseCase(EntregaJpaAdapter adapter) {
        return new ListarHistoricoEntregasUseCase(adapter);
    }
}
