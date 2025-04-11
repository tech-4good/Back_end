package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.EnderecoRepository;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
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

}
