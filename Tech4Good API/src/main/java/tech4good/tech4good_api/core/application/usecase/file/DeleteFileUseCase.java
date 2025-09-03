package tech4good.tech4good_api.core.application.usecase.file;

import tech4good.tech4good_api.core.adapter.FileGateway;
import tech4good.tech4good_api.core.application.command.file.DeleteFileCommand;

public class DeleteFileUseCase {
    private final FileGateway gateway;

    public DeleteFileUseCase(FileGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(DeleteFileCommand command) {
        gateway.delete(command.id());
    }
}
