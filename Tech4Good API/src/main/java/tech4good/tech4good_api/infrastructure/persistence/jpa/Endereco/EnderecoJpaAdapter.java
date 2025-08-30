package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

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
        if (entityOpt.isEmpty()) {
            throw new IllegalArgumentException("Endereço com ID %d não encontrado".formatted(id));
        }
        return Optional.ofNullable(EnderecoMapper.toDomainFromEntity(entityOpt.get()));
    }

    @Override
    public boolean existsByCepAndNumero(String cep, String numero) {
        return repository.existsByCepAndNumero(cep, numero);
    }

    @Override
    public Optional<Endereco> findByLogradouroAndNumero(String logradouro, String numero) {
        var entityOpt = repository.findByLogradouroAndNumero(logradouro, numero);
        return entityOpt.map(EnderecoMapper::toDomainFromEntity);
    }
}
