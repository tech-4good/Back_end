package tech4good.tech4good_api.infrastructure.persistence.jpa.TipoMorador;

import tech4good.tech4good_api.core.application.command.tipomorador.AtualizarTipoMoradorCommand;
import tech4good.tech4good_api.core.application.command.tipomorador.BuscarTipoMoradorPorIdCommand;
import tech4good.tech4good_api.core.application.command.tipomorador.CadastrarTipoMoradorCommand;
import tech4good.tech4good_api.core.application.command.tipomorador.RemoverTipoMoradorCommand;
import tech4good.tech4good_api.core.application.dto.auxiliares.BeneficiadoSummarizedResponseDto;
import tech4good.tech4good_api.core.application.dto.auxiliares.EnderecoSummarizedFilhoBeneficiadoResponseDto;
import tech4good.tech4good_api.core.application.dto.tipomorador.TipoMoradorRequestDto;
import tech4good.tech4good_api.core.application.dto.tipomorador.TipoMoradorResponseDto;
import tech4good.tech4good_api.core.application.dto.tipomorador.TipoMoradorUpdateDto;
import tech4good.tech4good_api.core.domain.tipomorador.TipoMorador;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoMapper;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoMapper;

public class TipoMoradorMapper {

    public static CadastrarTipoMoradorCommand toCommand(TipoMoradorRequestDto dto) {
        return new CadastrarTipoMoradorCommand(
                dto.getQuantidadeCrianca(),
                dto.getQuantidadeAdolescente(),
                dto.getQuantidadeJovem(),
                dto.getQuantidadeIdoso(),
                dto.getQuantidadeGestante(),
                dto.getQuantidadeDeficiente(),
                dto.getQuantidadeOutros(),
                dto.getBeneficiadoId(),
                dto.getEnderecoId()
        );
    }

    public static BuscarTipoMoradorPorIdCommand toIdCommand(Integer id) {
        return new BuscarTipoMoradorPorIdCommand(id);
    }

    public static RemoverTipoMoradorCommand toRemoveCommand(Integer id) {
        return new RemoverTipoMoradorCommand(id);
    }

    public static TipoMorador toDomain(CadastrarTipoMoradorCommand command) {
        return new TipoMorador(
                null,
                command.quantidadeCrianca(),
                command.quantidadeAdolescente(),
                command.quantidadeJovem(),
                command.quantidadeIdoso(),
                command.quantidadeGestante(),
                command.quantidadeDeficiente(),
                command.quantidadeOutros(),
                null, // beneficiado será setado no use case
                null  // endereco será setado no use case
        );
    }

    public static TipoMorador toDomain(AtualizarTipoMoradorCommand command) {
        return new TipoMorador(
                command.id(),
                command.quantidadeCrianca(),
                command.quantidadeAdolescente(),
                command.quantidadeJovem(),
                command.quantidadeIdoso(),
                command.quantidadeGestante(),
                command.quantidadeDeficiente(),
                command.quantidadeOutros(),
                null, // beneficiado e endereco serão mantidos do objeto existente
                null
        );
    }

    public static TipoMoradorEntity toEntity(TipoMorador tipoMorador) {
        TipoMoradorEntity entity = new TipoMoradorEntity();
        entity.setIdTipoMorador(tipoMorador.getId());
        entity.setQuantidadeCrianca(tipoMorador.getQuantidadeCrianca());
        entity.setQuantidadeAdolescente(tipoMorador.getQuantidadeAdolescente());
        entity.setQuantidadeJovem(tipoMorador.getQuantidadeJovem());
        entity.setQuantidadeIdoso(tipoMorador.getQuantidadeIdoso());
        entity.setQuantidadeGestante(tipoMorador.getQuantidadeGestante());
        entity.setQuantidadeDeficiente(tipoMorador.getQuantidadeDeficiente());
        entity.setQuantidadeOutros(tipoMorador.getQuantidadeOutros());

        // Usar os mappers existentes para converter as relações
        if (tipoMorador.getBeneficiado() != null) {
            entity.setBeneficiado(BeneficiadoMapper.toEntity(tipoMorador.getBeneficiado()));
        }

        if (tipoMorador.getEndereco() != null) {
            entity.setEndereco(EnderecoMapper.toEntity(tipoMorador.getEndereco()));
        }

        return entity;
    }

    // Entity JPA → Domain
    public static TipoMorador toDomain(TipoMoradorEntity entity) {
        return new TipoMorador(
                entity.getIdTipoMorador(),
                entity.getQuantidadeCrianca(),
                entity.getQuantidadeAdolescente(),
                entity.getQuantidadeJovem(),
                entity.getQuantidadeIdoso(),
                entity.getQuantidadeGestante(),
                entity.getQuantidadeDeficiente(),
                entity.getQuantidadeOutros(),
                entity.getBeneficiado() != null ? BeneficiadoMapper.toDomain(entity.getBeneficiado()) : null,
                entity.getEndereco() != null ? EnderecoMapper.toDomainFromEntity(entity.getEndereco()) : null
        );
    }

    // Domain → Response DTO
    public static TipoMoradorResponseDto toResponseDto(TipoMorador tipoMorador) {
        EnderecoSummarizedFilhoBeneficiadoResponseDto enderecoDto = tipoMorador.getEndereco() != null
                ? new EnderecoSummarizedFilhoBeneficiadoResponseDto(
                tipoMorador.getEndereco().getId(),
                tipoMorador.getEndereco().getLogradouro(),
                tipoMorador.getEndereco().getNumero(),
                tipoMorador.getEndereco().getComplemento(),
                tipoMorador.getEndereco().getBairro() != null ? tipoMorador.getEndereco().getBairro().getValue() : null,
                tipoMorador.getEndereco().getCidade() != null ? tipoMorador.getEndereco().getCidade().getValue() : null,
                tipoMorador.getEndereco().getEstado() != null ? tipoMorador.getEndereco().getEstado().name() : null,
                tipoMorador.getEndereco().getCep() != null ? tipoMorador.getEndereco().getCep().getValue() : null
        ) : null;

        BeneficiadoSummarizedResponseDto beneficiadoDto = tipoMorador.getBeneficiado() != null
                ? new BeneficiadoSummarizedResponseDto(
                tipoMorador.getBeneficiado().getCpf() != null ? tipoMorador.getBeneficiado().getCpf().toString() : null,
                tipoMorador.getBeneficiado().getNome()
        ) : null;

        return new TipoMoradorResponseDto(
                tipoMorador.getId(),
                tipoMorador.getQuantidadeCrianca(),
                tipoMorador.getQuantidadeAdolescente(),
                tipoMorador.getQuantidadeJovem(),
                tipoMorador.getQuantidadeIdoso(),
                tipoMorador.getQuantidadeGestante(),
                tipoMorador.getQuantidadeDeficiente(),
                tipoMorador.getQuantidadeOutros(),
                enderecoDto,
                beneficiadoDto
        );
    }

    // DTO → Command (para atualização)
    public static AtualizarTipoMoradorCommand toCommand(TipoMoradorUpdateDto dto) {
        return new AtualizarTipoMoradorCommand(
                null, // ID será setado no controller
                dto.getQuantidadeCrianca(),
                dto.getQuantidadeAdolescente(),
                dto.getQuantidadeJovem(),
                dto.getQuantidadeIdoso(),
                dto.getQuantidadeGestante(),
                dto.getQuantidadeDeficiente(),
                dto.getQuantidadeOutros()
        );
    }

    // DTO → Command (para atualização com ID)
    public static AtualizarTipoMoradorCommand toCommand(TipoMoradorUpdateDto dto, Integer id) {
        return new AtualizarTipoMoradorCommand(
                id,
                dto.getQuantidadeCrianca(),
                dto.getQuantidadeAdolescente(),
                dto.getQuantidadeJovem(),
                dto.getQuantidadeIdoso(),
                dto.getQuantidadeGestante(),
                dto.getQuantidadeDeficiente(),
                dto.getQuantidadeOutros()
        );
    }
}
