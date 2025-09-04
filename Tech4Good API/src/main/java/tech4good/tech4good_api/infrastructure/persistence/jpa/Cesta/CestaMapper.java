package tech4good.tech4good_api.infrastructure.persistence.jpa.Cesta;

import tech4good.tech4good_api.core.application.command.cesta.AtualizarCestaCommand;
import tech4good.tech4good_api.core.application.command.cesta.CadastrarCestaCommand;
import tech4good.tech4good_api.core.application.dto.cesta.CestaRequestDto;
import tech4good.tech4good_api.core.application.dto.cesta.CestaResponseDto;
import tech4good.tech4good_api.core.application.dto.cesta.CestaUpdateDto;
import tech4good.tech4good_api.core.domain.cesta.Cesta;
import tech4good.tech4good_api.core.domain.cesta.valueobject.Peso;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

public class CestaMapper {

    public static Cesta toDomain(CadastrarCestaCommand command) {
        if (command == null) {
            return null;
        }

        Cesta cesta = new Cesta();
        cesta.setTipo(TipoCesta.fromString(command.tipo()));
        cesta.setPeso(Peso.valueOf(command.pesoKg()));
        cesta.setDataEntradaEstoque(command.dataEntradaEstoque());
        cesta.setQuantidadeCestas(command.quantidadeCestas());

        return cesta;
    }

    public static CadastrarCestaCommand toCommand(CestaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new CadastrarCestaCommand(
            dto.getTipo(),
            dto.getPesoKg(),
            dto.getDataEntradaEstoque(),
            dto.getQuantidadeCestas()
        );
    }

    public static CestaEntity toEntity(Cesta cesta) {
        if (cesta == null) {
            return null;
        }

        CestaEntity entity = new CestaEntity();
        entity.setIdCesta(cesta.getId());
        entity.setTipo(cesta.getTipo());
        entity.setPeso(cesta.getPeso());
        entity.setDataEntradaEstoque(cesta.getDataEntradaEstoque());
        entity.setQuantidadeCestas(cesta.getQuantidadeCestas());

        return entity;
    }

    public static Cesta toDomainFromEntity(CestaEntity entity) {
        if (entity == null) {
            return null;
        }

        Cesta cesta = new Cesta();
        cesta.setId(entity.getIdCesta());
        cesta.setTipo(entity.getTipo());
        cesta.setPeso(entity.getPeso());
        cesta.setDataEntradaEstoque(entity.getDataEntradaEstoque());
        cesta.setQuantidadeCestas(entity.getQuantidadeCestas());

        return cesta;
    }

    public static CestaResponseDto toResponseDto(Cesta cesta) {
        if (cesta == null) {
            return null;
        }
        return new CestaResponseDto(
            cesta.getId(),
            cesta.getTipo().name(),
            cesta.getPeso().getValue(),
            cesta.getDataEntradaEstoque(),
            cesta.getQuantidadeCestas()
        );
    }

    public static AtualizarCestaCommand toAtualizarCommand(Integer id, CestaUpdateDto dto) {
        if (dto == null) {
            return null;
        }
        return new AtualizarCestaCommand(id, dto.getQuantidadeCestas());
    }

    public static Cesta toDomain(CestaEntity entity) {
        return toDomainFromEntity(entity);
    }
}
