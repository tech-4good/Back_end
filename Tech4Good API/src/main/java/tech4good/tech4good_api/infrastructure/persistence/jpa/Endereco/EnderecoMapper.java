package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import tech4good.tech4good_api.core.application.command.endereco.AtualizarEnderecoCommand;
import tech4good.tech4good_api.core.application.command.endereco.BuscarApiCepEnderecoCommand;
import tech4good.tech4good_api.core.application.command.endereco.CadastrarEnderecoCommand;
import tech4good.tech4good_api.core.application.dto.endereco.AtualizarEnderecoRequestDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoApiCepDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoRequestDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoResponseDto;
import tech4good.tech4good_api.core.application.dto.endereco.CepResponseDto;
import tech4good.tech4good_api.core.application.dto.endereco.EnderecoSummarizedDto;
import tech4good.tech4good_api.core.application.dto.auxiliares.EnderecoSummarizedFilhoBeneficiadoResponseDto;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

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

        // Convertendo as strings para value objects primeiro
        Bairro bairro = Bairro.of(dto.getBairro());
        Cidade cidade = Cidade.of(dto.getCidade());
        Estado estado = Estado.valueOf(dto.getEstado());
        Cep cep = Cep.valueOf(dto.getCep());
        TipoCesta tipoCesta = TipoCesta.fromString(dto.getTipoCesta());
        TipoMoradia tipoMoradia = TipoMoradia.of(dto.getTipoMoradia());
        Status status = Status.fromString(dto.getStatus());

        return new CadastrarEnderecoCommand(
            dto.getLogradouro(),      // String
            dto.getNumero(),          // String
            dto.getComplemento(),     // String
            bairro,                   // Bairro
            cidade,                   // Cidade
            estado,                   // Estado
            cep,                      // Cep
            tipoCesta,                // TipoCesta
            dto.getDataEntrada(),     // LocalDate
            null,                     // LocalDate (dataSaida)
            dto.getMoradia(),         // String
            tipoMoradia,              // TipoMoradia
            status                    // Status
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
            endereco.getTipoMoradia(),  // Mantém como value object
            endereco.getStatus()        // Mantém como value object
        );
    }

    public static CepResponseDto toCepResponseDto(Endereco endereco) {
        if (endereco == null) {
            return null;
        }
        return new CepResponseDto(
            endereco.getLogradouro(),
            endereco.getComplemento(),
            endereco.getBairro() != null ? endereco.getBairro().toString() : null,
            endereco.getCidade() != null ? endereco.getCidade().toString() : null,
            endereco.getEstado() != null ? endereco.getEstado().toString() : null,
            endereco.getCep() != null ? endereco.getCep().toString() : null
        );
    }

    public static EnderecoApiCepDto toApiCepDto(BuscarApiCepEnderecoCommand command){
        if (command == null){
            return null;
        }
        return new EnderecoApiCepDto();
    }

    public static AtualizarEnderecoCommand toAtualizarCommand(Integer id, AtualizarEnderecoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new AtualizarEnderecoCommand(id, dto.getStatus());
    }

    public static Endereco toDomainFromApiCepDto(EnderecoApiCepDto dto){
        if (dto == null){
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setCep(dto.getCep());
        return endereco;
    }

    public static EnderecoSummarizedFilhoBeneficiadoResponseDto toSummarizedResponseDto(Endereco endereco) {
        if (endereco == null) {
            return null;
        }
        return new EnderecoSummarizedFilhoBeneficiadoResponseDto(
            endereco.getId(),
            endereco.getLogradouro(),
            endereco.getNumero(),
            endereco.getComplemento(),
            endereco.getBairro() != null ? endereco.getBairro().getValue() : null,
            endereco.getCidade() != null ? endereco.getCidade().getValue() : null,
            endereco.getEstado() != null ? endereco.getEstado().name() : null,
            endereco.getCep() != null ? endereco.getCep().getValue() : null
        );
    }

    public static EnderecoSummarizedDto toSummarizedDto(Endereco endereco) {
        if (endereco == null) {
            return null;
        }
        return new EnderecoSummarizedDto(
            endereco.getId(),
            endereco.getLogradouro(),
            endereco.getNumero(),
            endereco.getComplemento(),
            endereco.getBairro() != null ? endereco.getBairro().toString() : null,
            endereco.getCidade() != null ? endereco.getCidade().toString() : null,
            endereco.getEstado() != null ? endereco.getEstado().toString() : null,
            endereco.getCep() != null ? endereco.getCep().toString() : null,
            endereco.getTipoCesta() != null ? endereco.getTipoCesta().toString() : null,
            endereco.getDataEntrada(),
            endereco.getDataSaida(),
            endereco.getMoradia(),
            endereco.getTipoMoradia() != null ? endereco.getTipoMoradia().toString() : null,
            endereco.getStatus() != null ? endereco.getStatus().toString() : null
        );
    }
}
