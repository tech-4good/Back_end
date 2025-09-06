package tech4good.tech4good_api.infrastructure.persistence.jpa.FilaEspera;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.FilaEsperaGateway;
import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.domain.filaespera.FilaEspera;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilaEsperaJpaAdapter implements FilaEsperaGateway {

    private final FilaEsperaJpaRepository repository;
    private final BeneficiadoGateway beneficiadoGateway;

    public FilaEsperaJpaAdapter(FilaEsperaJpaRepository repository, BeneficiadoGateway beneficiadoGateway) {
        this.repository = repository;
        this.beneficiadoGateway = beneficiadoGateway;
    }

    @Override
    public FilaEspera salvar(FilaEspera filaEspera) {
        var filaEsperaEntity = FilaEsperaMapper.toEntity(filaEspera);
        var filaEsperaSalva = repository.save(filaEsperaEntity);
        return FilaEsperaMapper.toDomainFromEntity(filaEsperaSalva, filaEspera.getBeneficiado());
    }

    @Override
    public List<FilaEspera> listarTodos() {
        return repository.findAll().stream()
                .map(entity -> {
                    Beneficiado beneficiado = beneficiadoGateway.findById(entity.getBeneficiadoId());
                    return FilaEsperaMapper.toDomainFromEntity(entity, beneficiado);
                })
                .collect(Collectors.toList());
    }

    @Override
    public FilaEspera buscarPorId(Integer id) {
        var entityOpt = repository.findById(id);
        if (entityOpt.isPresent()) {
            var entity = entityOpt.get();
            Beneficiado beneficiado = beneficiadoGateway.findById(entity.getBeneficiadoId());
            return FilaEsperaMapper.toDomainFromEntity(entity, beneficiado);
        }
        return null;
    }

    @Override
    public FilaEspera atualizar(FilaEspera filaEspera) {
        var filaEsperaEntity = FilaEsperaMapper.toEntity(filaEspera);
        var filaEsperaAtualizada = repository.save(filaEsperaEntity);
        return FilaEsperaMapper.toDomainFromEntity(filaEsperaAtualizada, filaEspera.getBeneficiado());
    }

    @Override
    public void remover(Integer id) {
        repository.deleteById(id);
    }
}
