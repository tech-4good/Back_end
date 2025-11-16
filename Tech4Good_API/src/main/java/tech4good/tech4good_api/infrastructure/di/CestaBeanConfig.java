package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.adapter.CestaGateway;
import tech4good.tech4good_api.core.application.usecase.cesta.*;
import tech4good.tech4good_api.core.application.usecase.endereco.ProcessarFilaEsperaAoCadastrarCestaUseCase;
import tech4good.tech4good_api.core.application.usecase.endereco.VerificarEnderecosInativosUseCase;

@Configuration
public class CestaBeanConfig {

    @Bean
    public CadastrarCestaUseCase cadastrarCestaUseCase(
            CestaGateway cestaGateway,
            ProcessarFilaEsperaAoCadastrarCestaUseCase processarFilaUseCase,
            VerificarEnderecosInativosUseCase verificarInativosUseCase) {
        return new CadastrarCestaUseCase(cestaGateway, processarFilaUseCase, verificarInativosUseCase);
    }

    @Bean
    public BuscarCestaPorIdUseCase buscarCestaPorIdUseCase(CestaGateway cestaGateway) {
        return new BuscarCestaPorIdUseCase(cestaGateway);
    }

    @Bean
    public ListarCestasUseCase listarCestasUseCase(CestaGateway cestaGateway) {
        return new ListarCestasUseCase(cestaGateway);
    }

    @Bean
    public AtualizarCestaUseCase atualizarCestaUseCase(CestaGateway cestaGateway) {
        return new AtualizarCestaUseCase(cestaGateway);
    }

    @Bean
    public RemoverCestaUseCase removerCestaUseCase(CestaGateway cestaGateway) {
        return new RemoverCestaUseCase(cestaGateway);
    }
}
