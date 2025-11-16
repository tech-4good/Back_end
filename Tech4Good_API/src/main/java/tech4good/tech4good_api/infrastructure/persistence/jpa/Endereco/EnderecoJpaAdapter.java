package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.EnderecoGateway;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.Status;

import java.time.LocalDate;
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
        Long count = repository.countByCepAndNumero(cep, numero);
        return count != null && count > 0;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Endereco> findByStatus(Status status) {
        return repository.findByStatus(status).stream()
            .map(EnderecoMapper::toDomainFromEntity)
            .toList();
    }

    @Override
    public List<Endereco> findByStatusOrderByDataEntradaFilaAsc(Status status) {
        return repository.findByStatusOrderByDataEntradaFilaAsc(status).stream()
            .map(EnderecoMapper::toDomainFromEntity)
            .toList();
    }

    @Override
    public Long countByStatus(Status status) {
        return repository.countByStatus(status);
    }

    @Override
    public List<Endereco> findByStatusAndDataEntradaBefore(Status status, LocalDate dataLimite) {
        return repository.findByStatusAndDataEntradaBefore(status, dataLimite).stream()
            .map(EnderecoMapper::toDomainFromEntity)
            .toList();
    }
}
