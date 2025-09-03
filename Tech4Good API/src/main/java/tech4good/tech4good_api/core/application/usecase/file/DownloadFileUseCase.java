package tech4good.tech4good_api.core.application.usecase.file;

import tech4good.tech4good_api.core.adapter.FileGateway;
import tech4good.tech4good_api.core.application.command.file.DownloadFileCommand;
import tech4good.tech4good_api.core.domain.file.FileModel;

public class DownloadFileUseCase {
    private final FileGateway gateway;

    public DownloadFileUseCase(FileGateway gateway) {
        this.gateway = gateway;
    }

    public FileModel executar(DownloadFileCommand command) {
        return gateway.load(command.id());
    }
}
