package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import tech4good.tech4good_api.core.application.command.endereco.AtualizarEnderecoCommand;
import tech4good.tech4good_api.core.application.command.endereco.CadastrarEnderecoCommand;
import tech4good.tech4good_api.core.application.dto.endereco.AtualizarEnderecoRequestDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoRequestDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoResponseDto;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

public class EnderecoMapper {

    public static Endereco toDomain(CadastrarEnderecoCommand command) {
        if (command == null) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setLogradouro(command.logradouro());
        endereco.setNumero(command.numero());
        endereco.setComplemento(command.complemento());
        endereco.setBairro(command.bairro());
        endereco.setCidade(command.cidade());
        endereco.setEstado(command.estado());
        endereco.setCep(command.cep());
        endereco.setTipoCesta(command.tipoCesta());
        endereco.setDataEntrada(command.dataEntrada());
        endereco.setDataSaida(command.dataSaida());
        endereco.setMoradia(command.moradia());
        endereco.setTipoMoradia(command.tipoMoradia());
        endereco.setStatus(command.status());
        return endereco;
    }

    public static CadastrarEnderecoCommand toCommand(EnderecoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new CadastrarEnderecoCommand(
            dto.getLogradouro(),
            dto.getNumero(),
            dto.getComplemento(),
            dto.getBairro(),
            dto.getCidade(),
            dto.getEstado(),
            dto.getCep(),
            dto.getTipoCesta(),
            dto.getDataEntrada(),
            null,
            dto.getMoradia(),
            dto.getTipoMoradia(),
            dto.getStatus()
        );
    }

    public static EnderecoEntity toEntity(Endereco endereco) {
        if (endereco == null) {
            return null;
        }
        EnderecoEntity entity = new EnderecoEntity();
        entity.setIdEndereco(endereco.getId());
        entity.setLogradouro(endereco.getLogradouro());
        entity.setNumero(endereco.getNumero());
        entity.setComplemento(endereco.getComplemento());
        entity.setBairro(endereco.getBairro());
        entity.setCidade(endereco.getCidade());
        entity.setEstado(endereco.getEstado());
        entity.setCep(endereco.getCep());
        entity.setTipoCesta(endereco.getTipoCesta());
        entity.setDataEntrada(endereco.getDataEntrada());
        entity.setDataSaida(endereco.getDataSaida());
        entity.setMoradia(endereco.getMoradia());
        entity.setTipoMoradia(endereco.getTipoMoradia());
        entity.setStatus(endereco.getStatus());
        return entity;
    }

    public static Endereco toDomainFromEntity(EnderecoEntity entity) {
        if (entity == null) {
            return null;
        }
        Endereco endereco = new Endereco();
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

    public static EnderecoResponseDto toResponseDto(Endereco endereco) {
        if (endereco == null) {
            return null;
        }
        return new EnderecoResponseDto(
            endereco.getId(),
            endereco.getLogradouro(),
            endereco.getNumero(),
            endereco.getComplemento(),
            endereco.getBairro() != null ? endereco.getBairro().toString() : null,
            endereco.getCidade() != null ? endereco.getCidade().toString() : null,
            endereco.getEstado() != null ? endereco.getEstado().toString() : null,
            endereco.getCep() != null ? endereco.getCep().toString() : null,
            endereco.getTipoCesta(),
            endereco.getDataEntrada(),
            endereco.getDataSaida(),
            endereco.getMoradia(),
            endereco.getTipoMoradia(),
            endereco.getStatus()
        );
    }

    public static AtualizarEnderecoCommand toAtualizarCommand(Integer id, AtualizarEnderecoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new AtualizarEnderecoCommand(id, dto.getStatus());
    }
}
