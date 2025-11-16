package tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.converter.BairroConverter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.converter.CepConverter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.converter.CidadeConverter;
import tech4good.tech4good_api.infrastructure.persistence.jpa.Endereco.converter.TipoMoradiaConverter;

import java.time.LocalDate;

@Schema(description = "Objeto de entidade para endereços")
@Entity
@Table(name = "endereco")
public class EnderecoEntity {

    @Schema(description = "Identificador único do endereço", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer idEndereco;
    @Schema(description = "Rua ou Avenida", example = "Avenida Marechal Tito")
    private String logradouro;
    @Schema(description = "Número da residência", example = "234")
    private String numero;
    private String complemento;
    @Schema(description = "Nome do bairro", example = "São Miguel Paulista")
    @Convert(converter = BairroConverter.class)
    private Bairro bairro;
    @Schema(description = "Nome da cidade", example = "São Paulo")
    @Convert(converter = CidadeConverter.class)
    private Cidade cidade;
    @Schema(description = "Nome do estado", example = "São Paulo")
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Schema(description = "CEP da região onde se encontra a residência", example = "08356723")
    @Convert(converter = CepConverter.class)
    private Cep cep;
    @Schema(description = "Tipo de cesta que o endereço pode receber atualmente", example = "Kit")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cesta")
    private TipoCesta tipoCesta;
    @Schema(description = "Data de entrada no projeto ASA", example = "2025/02/10")
    @Column(name = "data_entrada")
    private LocalDate dataEntrada;
    @Schema(description = "Data de saída no projeto ASA", example = "2025/06/22")
    @Column(name = "data_saida")
    private LocalDate dataSaida;
    @Schema(description = "Data de entrada na fila de espera", example = "2025/03/15")
    @Column(name = "data_entrada_fila")
    private LocalDate dataEntradaFila;
    @Schema(description = "Tipo de obtenção da moradia", example = "Alugada")
    private String moradia;
    @Schema(description = "Nome do tipo da moradia", example = "Apartamento")
    @Convert(converter = TipoMoradiaConverter.class)
    @Column(name = "tipo_moradia")
    private TipoMoradia tipoMoradia;
    @Schema(description = "Controle para saber se ainda está participando da ASA", example = "Aberto")
    @Enumerated(EnumType.STRING)
    private Status status;

    public EnderecoEntity() {}

    public EnderecoEntity(Integer idEndereco, String logradouro, String numero, String complemento, Bairro bairro, Cidade cidade, Estado estado, Cep cep, TipoCesta tipoCesta, LocalDate dataEntrada, LocalDate dataSaida, LocalDate dataEntradaFila, String moradia, TipoMoradia tipoMoradia, Status status) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.tipoCesta = tipoCesta;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.dataEntradaFila = dataEntradaFila;
        this.moradia = moradia;
        this.tipoMoradia = tipoMoradia;
        this.status = status;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public TipoCesta getTipoCesta() {
        return tipoCesta;
    }

    public void setTipoCesta(TipoCesta tipoCesta) {
        this.tipoCesta = tipoCesta;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDate getDataEntradaFila() {
        return dataEntradaFila;
    }

    public void setDataEntradaFila(LocalDate dataEntradaFila) {
        this.dataEntradaFila = dataEntradaFila;
    }

    public String getMoradia() {
        return moradia;
    }

    public void setMoradia(String moradia) {
        this.moradia = moradia;
    }

    public TipoMoradia getTipoMoradia() {
        return tipoMoradia;
    }

    public void setTipoMoradia(TipoMoradia tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
