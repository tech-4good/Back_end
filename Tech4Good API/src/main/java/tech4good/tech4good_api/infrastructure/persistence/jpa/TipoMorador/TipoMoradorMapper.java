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
        // As relações serão setadas pelo JPA Adapter
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
                entity.getBeneficiado() != null ? convertBeneficiadoEntityToDomain(entity.getBeneficiado()) : null,
                entity.getEndereco() != null ? convertEnderecoEntityToDomain(entity.getEndereco()) : null
        );
    }

    // Domain → Response DTO
    public static TipoMoradorResponseDto toResponseDto(TipoMorador tipoMorador) {
        EnderecoSummarizedFilhoBeneficiadoResponseDto enderecoDto = tipoMorador.getEndereco() != null
                ? new EnderecoSummarizedFilhoBeneficiadoResponseDto(
                tipoMorador.getEndereco().getId(),
                tipoMorador.getEndereco().getLogradouro(),
                Integer.valueOf(tipoMorador.getEndereco().getNumero()),
                tipoMorador.getEndereco().getComplemento(),
                tipoMorador.getEndereco().getBairro(),
                tipoMorador.getEndereco().getCidade(),
                tipoMorador.getEndereco().getEstado(),
                tipoMorador.getEndereco().getCep()
        ) : null;

        BeneficiadoSummarizedResponseDto beneficiadoDto = tipoMorador.getBeneficiado() != null
                ? new BeneficiadoSummarizedResponseDto(
                tipoMorador.getBeneficiado().getCpf(),
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

    // Métodos auxiliares para conversão das entidades relacionadas
    private static tech4good.tech4good_api.core.domain.beneficiado.Beneficiado convertBeneficiadoEntityToDomain(tech4good.tech4good_api.infrastructure.persistence.jpa.Beneficiado.BeneficiadoEntity entity) {
        // Conversão simplificada para evitar dependência circular
        return new tech4good.tech4good_api.core.domain.beneficiado.Beneficiado(
                entity.getId(),
                entity.getCpf() != null ? tech4good.tech4good_api.core.domain.shared.valueobject.Cpf.valueOf(entity.getCpf()) : null,
                entity.getNome(),
                entity.getRg() != null ? tech4good.tech4good_api.core.domain.beneficiado.valueobject.Rg.valueOf(entity.getRg()) : null,
                entity.getDataNascimento(),
                entity.getNaturalidade(),
                entity.getTelefone() != null ? tech4good.tech4good_api.core.domain.shared.valueobject.Telefone.valueOf(entity.getTelefone()) : null,
                entity.getEstadoCivil(),
                entity.getEscolaridade(),
                entity.getProfissao(),
                entity.getRendaMensal() != null ? tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda.valueOf(entity.getRendaMensal()) : null,
                entity.getEmpresa(),
                entity.getCargo(),
                entity.getReligiao() != null ? tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao.valueOf(entity.getReligiao()) : null,
                null, // Evitar referência circular
                entity.getQuantidadeDependentes(),
                null  // Simplificar por enquanto
        );
    }

    private static tech4good.tech4good_api.core.domain.endereco.Endereco convertEnderecoEntityToDomain(tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.EnderecoEntity entity) {
        var endereco = new tech4good.tech4good_api.core.domain.endereco.Endereco();
        endereco.setId(entity.getIdEndereco());
        endereco.setLogradouro(entity.getLogradouro());
        endereco.setNumero(entity.getNumero());
        endereco.setComplemento(entity.getComplemento());
        endereco.setBairro(entity.getBairro());
        endereco.setCidade(entity.getCidade());
        endereco.setEstado(entity.getEstado());
        endereco.setCep(entity.getCep());
        endereco.setTipoCesta(entity.getTipoCesta());
        endereco.setDataEntrada(entity.getDataEntrada());
        endereco.setDataSaida(entity.getDataSaida());
        endereco.setMoradia(entity.getMoradia());
        endereco.setTipoMoradia(entity.getTipoMoradia());
        endereco.setStatus(entity.getStatus());
        return endereco;
    }
}
