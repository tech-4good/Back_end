package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Cep;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoJpaAdapter implements EnderecoGateway {

    private final EnderecoJpaRepository repository;

    public EnderecoJpaAdapter(EnderecoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Endereco save(Endereco endereco) {
        var enderecoEntity = EnderecoMapper.toEntity(endereco);
        var enderecoSalvo = repository.save(enderecoEntity);
        return EnderecoMapper.toDomainFromEntity(enderecoSalvo);
    }

    @Override
    public Optional<Endereco> findById(Integer id) {
        var entityOpt = repository.findById(id);
        return Optional.ofNullable(EnderecoMapper.toDomainFromEntity(entityOpt.get()));
    }

    @Override
    public Optional<Endereco> findByLogradouroAndNumero(String logradouro, String numero) {
        var entityOpt = repository.findByLogradouroAndNumero(logradouro, numero);
        return entityOpt.map(EnderecoMapper::toDomainFromEntity);
    }

    @Override
    public List<Endereco> findAll() {
        return repository.findAll().stream()
            .map(EnderecoMapper::toDomainFromEntity)
            .toList();
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByCepAndNumero(String cep, String numero) {
        return repository.existsByCepAndNumero(cep, numero);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
