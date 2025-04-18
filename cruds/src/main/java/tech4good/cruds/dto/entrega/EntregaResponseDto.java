package tech4good.cruds.dto.entrega;

import tech4good.cruds.dto.auxiliares.CestaEntregaResponseDto;
import tech4good.cruds.dto.auxiliares.EnderecoBeneficiadoResponseDto;
import tech4good.cruds.dto.auxiliares.VoluntarioEntregaResponseDto;

import java.time.LocalDate;

public class EntregaResponseDto {

    private Integer idEntrega;
    private LocalDate dataRetirada;
    private LocalDate proximaRetirada;
    private EnderecoBeneficiadoResponseDto endereco;
    private CestaEntregaResponseDto cesta;
    private VoluntarioEntregaResponseDto voluntario;

    public EntregaResponseDto(Integer idEntrega, LocalDate dataRetirada, LocalDate proximaRetirada, EnderecoBeneficiadoResponseDto endereco, CestaEntregaResponseDto cesta, VoluntarioEntregaResponseDto voluntario) {
        this.idEntrega = idEntrega;
        this.dataRetirada = dataRetirada;
        this.proximaRetirada = proximaRetirada;
        this.endereco = endereco;
        this.cesta = cesta;
        this.voluntario = voluntario;
    }

    public EntregaResponseDto() {
    }

    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getProximaRetirada() {
        return proximaRetirada;
    }

    public void setProximaRetirada(LocalDate proximaRetirada) {
        this.proximaRetirada = proximaRetirada;
    }

    public EnderecoBeneficiadoResponseDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBeneficiadoResponseDto endereco) {
        this.endereco = endereco;
    }

    public CestaEntregaResponseDto getCesta() {
        return cesta;
    }

    public void setCesta(CestaEntregaResponseDto cesta) {
        this.cesta = cesta;
    }

    public VoluntarioEntregaResponseDto getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(VoluntarioEntregaResponseDto voluntario) {
        this.voluntario = voluntario;
    }
}
