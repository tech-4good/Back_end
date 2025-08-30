package tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeneficiadoJpaAdapter implements BeneficiadoGateway {
    private final BeneficiadoJpaRepository repository;

    public BeneficiadoJpaAdapter(BeneficiadoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Beneficiado save(Beneficiado beneficiado) {
        var beneficiadoEntity = BeneficiadoMapper.toEntity(beneficiado);
        var beneficiadoSalvo = repository.save(beneficiadoEntity);
        return BeneficiadoMapper.toDomain(beneficiadoSalvo);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return repository.existsByCpf(cpf);
    }

    @Override
    public Beneficiado findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public Beneficiado findById(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Beneficiado com ID %d não encontrado".formatted(id));
        }
        return BeneficiadoMapper.toDomain(repository.findById(id).get());
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public List<Beneficiado> findAll() {
        return repository.findAll().stream().map(BeneficiadoMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
