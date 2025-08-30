package tech4good.tech4good_api.core.application.usecase.endereco;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.application.command.endereco.BuscarApiCepEnderecoCommand;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoApiCepDto;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cep;
import tech4good.tech4good_api.infrastructure.integration.LogradouroIntegration;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;
import feign.FeignException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

public class BuscarApiCepEnderecoUseCase {
    private final EnderecoGateway gateway;
    private final LogradouroIntegration integration;

    public BuscarApiCepEnderecoUseCase(EnderecoGateway gateway, LogradouroIntegration integration) {
        this.gateway = gateway;
        this.integration = integration;
    }

    public Endereco executar(BuscarApiCepEnderecoCommand command) {
        if (command == null || command.cep() == null) {
            throw new IllegalArgumentException("CEP inválido.");
        }

        EnderecoApiCepDto cepApi = EnderecoMapper.toApiCepDto(command);

        try {
            EnderecoApiCepDto dto = integration.buscarLogradouro(cepApi.getCep().toString());
            return EnderecoMapper.toDomainFromApiCepDto(dto);
        } catch (FeignException exception) {
            int responseStatus = exception.status();
            switch(responseStatus){
                case 404:
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                case 400:
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                case 401:
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                default:
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

}
