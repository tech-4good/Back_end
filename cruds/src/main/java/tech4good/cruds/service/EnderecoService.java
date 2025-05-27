package tech4good.cruds.service;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech4good.cruds.dto.endereco.EnderecoApiCepDto;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.integration.LogradouroIntegration;
import tech4good.cruds.repository.EnderecoRepository;

import java.util.List;

@Service
public class EnderecoService {

    private final LogradouroIntegration integration;

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(LogradouroIntegration integration, EnderecoRepository enderecoRepository) {
        this.integration = integration;
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco cadastrarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco listarEnderecoPorId(Integer id){
        return enderecoRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Endereço de id %d não encontrado"
                        .formatted(id)));
    }

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    public Endereco atualizarEndereco(Endereco endereco){
        if(enderecoRepository.existsById(endereco.getIdEndereco())){
            endereco.setIdEndereco(endereco.getIdEndereco());
            return enderecoRepository.save(endereco);
        } else {
            throw new EntidadeNaoEncontradaException("Endereço de id %d não encontrado"
                    .formatted(endereco.getIdEndereco()));
        }
    }

    public void removerEnderecoPorId(Integer id){
        if(enderecoRepository.existsById(id)){
            enderecoRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Endereço de id %d não encontrado"
                    .formatted(id));
        }
    }

    public EnderecoApiCepDto buscarPorCep(String cep){
        try{
            EnderecoApiCepDto enderecoDto = integration.buscarLogradouro(cep);
            return enderecoDto;
        } catch (FeignException exception){
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
