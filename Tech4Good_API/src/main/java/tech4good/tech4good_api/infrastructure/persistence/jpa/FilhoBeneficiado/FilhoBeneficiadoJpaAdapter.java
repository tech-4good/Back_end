package tech4good.tech4good_api.infrastructure.persistence.jpa.FilhoBeneficiado;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.FilhoBeneficiadoGateway;
import tech4good.tech4good_api.core.domain.filhobeneficiado.FilhoBeneficiado;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoJpaRepository;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilhoBeneficiadoJpaAdapter implements FilhoBeneficiadoGateway {
    private final FilhoBeneficiadoJpaRepository repository;
    private final BeneficiadoJpaRepository beneficiadoRepository;
    private final EnderecoJpaRepository enderecoRepository;

    public FilhoBeneficiadoJpaAdapter(FilhoBeneficiadoJpaRepository repository,
                                     BeneficiadoJpaRepository beneficiadoRepository,
                                     EnderecoJpaRepository enderecoRepository) {
        this.repository = repository;
        this.beneficiadoRepository = beneficiadoRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public FilhoBeneficiado save(FilhoBeneficiado filhoBeneficiado) {
        var beneficiadoEntity = beneficiadoRepository.findById(filhoBeneficiado.getBeneficiado().getId())
                .orElseThrow(() -> new IllegalArgumentException("Beneficiado não encontrado"));
        var enderecoEntity = enderecoRepository.findById(filhoBeneficiado.getEndereco().getId())
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado"));

        var filhoEntity = FilhoBeneficiadoMapper.toEntity(filhoBeneficiado, beneficiadoEntity, enderecoEntity);
        var filhoSalvo = repository.save(filhoEntity);
        return FilhoBeneficiadoMapper.toDomain(filhoSalvo);
    }

    @Override
    public FilhoBeneficiado findById(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("FilhoBeneficiado com ID %d não encontrado".formatted(id));
        }
        return FilhoBeneficiadoMapper.toDomain(repository.findById(id).get());
    }

    @Override
    public List<FilhoBeneficiado> findAll() {
        return repository.findAll().stream()
                .map(FilhoBeneficiadoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("FilhoBeneficiado com ID %d não encontrado".formatted(id));
        }
        repository.deleteById(id);
    }
}
