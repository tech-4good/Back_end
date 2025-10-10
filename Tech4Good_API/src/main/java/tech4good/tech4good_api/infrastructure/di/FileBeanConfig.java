package tech4good.tech4good_api.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech4good.tech4good_api.core.application.usecase.file.*;
import tech4good.tech4good_api.infrastructure.persistence.jpa.File.FileJpaAdapter;

@Configuration
public class FileBeanConfig {

    @Bean
    public UploadFileUseCase uploadFileUseCase(FileJpaAdapter adapter) {
        return new UploadFileUseCase(adapter);
    }

    @Bean
    public DownloadFileUseCase downloadFileUseCase(FileJpaAdapter adapter) {
        return new DownloadFileUseCase(adapter);
    }

    @Bean
    public DeleteFileUseCase deleteFileUseCase(FileJpaAdapter adapter) {
        return new DeleteFileUseCase(adapter);
    }
}
