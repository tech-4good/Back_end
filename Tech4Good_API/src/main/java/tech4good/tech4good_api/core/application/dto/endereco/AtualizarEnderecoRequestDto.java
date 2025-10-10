package tech4good.tech4good_api.core.application.dto.endereco;

import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;

public class AtualizarEnderecoRequestDto {
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

