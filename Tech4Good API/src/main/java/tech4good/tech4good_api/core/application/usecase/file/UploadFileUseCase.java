package tech4good.tech4good_api.core.application.usecase.file;

import tech4good.tech4good_api.core.adapter.FileGateway;
import tech4good.tech4good_api.core.application.command.file.UploadFileCommand;
import tech4good.tech4good_api.core.domain.file.File;

public class UploadFileUseCase {
    private final FileGateway gateway;

    public UploadFileUseCase(FileGateway gateway) {
        this.gateway = gateway;
    }

    public File executar(UploadFileCommand command) {
        return gateway.save(command.file());
    }
}
