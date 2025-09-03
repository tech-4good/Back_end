package tech4good.tech4good_api.infrastructure.persistence.jpa.Voluntario;

import org.springframework.stereotype.Service;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.AtualizarVoluntarioCommand;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntarioJpaAdapter implements VoluntarioGateway {

    private final VoluntarioJpaRepository repository;

    public VoluntarioJpaAdapter(VoluntarioJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Voluntario salvar(Voluntario voluntario) {
        VoluntarioEntity entity = VoluntarioMapper.toEntity(voluntario);
        VoluntarioEntity savedEntity = repository.save(entity);
        return VoluntarioMapper.toDomainFromEntity(savedEntity);
    }

    @Override
    public Voluntario buscarPorId(Integer id) {
        Optional<VoluntarioEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Voluntário não encontrado");
        }
        return VoluntarioMapper.toDomainFromEntity(entity.get());
    }

    @Override
    public List<Voluntario> listarTodos() {
        List<VoluntarioEntity> entities = repository.findAll();
        return entities.stream()
                .map(VoluntarioMapper::toDomainFromEntity)
                .toList();
    }

    @Override
    public Voluntario atualizar(AtualizarVoluntarioCommand command) {
        Optional<VoluntarioEntity> entity = repository.findById(command.id());
        if (entity.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Voluntário não encontrado");
        }

        VoluntarioEntity voluntarioEntity = entity.get();
        voluntarioEntity.setTelefone(command.telefone());
        voluntarioEntity.setEmail(command.email());

        VoluntarioEntity updatedEntity = repository.save(voluntarioEntity);
        return VoluntarioMapper.toDomainFromEntity(updatedEntity);
    }

    @Override
    public void deletarPorId(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Voluntário não encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public Voluntario buscarPorEmail(String email) {
        Optional<VoluntarioEntity> entity = repository.findByEmail(email);
        if (entity.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Voluntário com email %s não encontrado".formatted(email));
        }
        return VoluntarioMapper.toDomainFromEntity(entity.get());
    }
}
