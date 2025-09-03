package tech4good.tech4good_api.infrastructure.integration.viacep;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech4good.tech4good_api.core.adapter.ViaCepGateway;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;

@Service
public class ViaCepAdapter implements ViaCepGateway {

    private final ViaCepClient viaCepClient;

    public ViaCepAdapter(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    @Override
    public Endereco buscarEnderecoPorCep(String cep) {
        try {
            ViaCepResponseDto response = viaCepClient.buscarCep(cep);

            if (response.getErro() != null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado");
            }

            return convertToDomain(response);

        } catch (FeignException exception) {
            int responseStatus = exception.status();
            switch(responseStatus){
                case 404:
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado");
                case 400:
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP inválido");
                case 401:
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                default:
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro na consulta do CEP");
            }
        }
    }

    private Endereco convertToDomain(ViaCepResponseDto response) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(response.getLogradouro());
        endereco.setComplemento(response.getComplemento());

        if (response.getBairro() != null) {
            endereco.setBairro(new Bairro(response.getBairro()));
        }

        if (response.getCidade() != null) {
            endereco.setCidade(new Cidade(response.getCidade()));
        }

        if (response.getUf() != null) {
            endereco.setEstado(Estado.valueOf(response.getUf().toUpperCase()));
        }

        if (response.getCep() != null) {
            endereco.setCep(new Cep(response.getCep().replaceAll("-", "")));
        }

        return endereco;
    }
}
