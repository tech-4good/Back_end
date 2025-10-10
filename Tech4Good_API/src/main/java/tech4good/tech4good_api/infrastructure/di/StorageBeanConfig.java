package tech4good.tech4good_api.infrastructure.di;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tech4good.tech4good_api.core.adapter.StorageService;
import tech4good.tech4good_api.infrastructure.storage.LocalStorageImpl;

@Configuration
public class StorageBeanConfig {

    @Bean
    @Profile("!s3") // Só cria quando o profile s3 NÃO estiver ativo
    @ConditionalOnMissingBean(StorageService.class)
    public StorageService storageService() {
        return new LocalStorageImpl();
    }
}
