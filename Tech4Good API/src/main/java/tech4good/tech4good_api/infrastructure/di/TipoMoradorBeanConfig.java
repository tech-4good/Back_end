package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.tipomorador.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.TipoMorador.TipoMoradorJpaAdapter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoJpaAdapter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoJpaAdapter;

@Configuration
public class TipoMoradorBeanConfig {

    @Bean
    public CadastrarTipoMoradorUseCase cadastrarTipoMoradorUseCase(
            TipoMoradorJpaAdapter tipoMoradorAdapter,
            EnderecoJpaAdapter enderecoAdapter,
            BeneficiadoJpaAdapter beneficiadoAdapter) {
        return new CadastrarTipoMoradorUseCase(tipoMoradorAdapter, enderecoAdapter, beneficiadoAdapter);
    }

    @Bean
    public AtualizarTipoMoradorUseCase atualizarTipoMoradorUseCase(TipoMoradorJpaAdapter adapter) {
        return new AtualizarTipoMoradorUseCase(adapter);
    }

    @Bean
    public BuscarTipoMoradorPorIdUseCase buscarTipoMoradorPorIdUseCase(TipoMoradorJpaAdapter adapter) {
        return new BuscarTipoMoradorPorIdUseCase(adapter);
    }

    @Bean
    public ListarTipoMoradoresUseCase listarTipoMoradoresUseCase(TipoMoradorJpaAdapter adapter) {
        return new ListarTipoMoradoresUseCase(adapter);
    }

    @Bean
    public RemoverTipoMoradorUseCase removerTipoMoradorUseCase(TipoMoradorJpaAdapter adapter) {
        return new RemoverTipoMoradorUseCase(adapter);
    }
}
