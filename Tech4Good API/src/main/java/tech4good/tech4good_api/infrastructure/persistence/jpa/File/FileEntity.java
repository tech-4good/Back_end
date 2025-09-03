package tech4good.tech4good_api.infrastructure.persistence.jpa.File;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Schema(description = "Entidade de arquivo associada ao beneficiado")
@Entity
@Table(name = "foto_beneficiado")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    @Schema(description = "ID da foto", example = "1")
    private Integer idFoto;

    @Column(name = "nome_original")
    @Schema(description = "Nome original do arquivo enviado", example = "foto_perfil.png")
    private String nomeOriginal;

    @Column(name = "nome_armazenamento")
    @Schema(description = "Nome do arquivo salvo no sistema", example = "fotoBeneficiado1.png")
    private String nomeArmazenamento;

    @Schema(description = "Tamanho do arquivo em bytes", example = "204800")
    private Long tamanho;

    @Schema(description = "Formato do arquivo", example = "image/png")
    private String formato;

    @Column(name = "data_criacao")
    @CreationTimestamp
    @Schema(description = "Data e hora de envio do arquivo", example = "2025-06-07T23:08:51.639Z")
    private LocalDateTime dataCriacao;

    public FileEntity() {
    }

    public FileEntity(Integer idFoto, String nomeOriginal, String nomeArmazenamento, Long tamanho, String formato, LocalDateTime dataCriacao) {
        this.idFoto = idFoto;
        this.nomeOriginal = nomeOriginal;
        this.nomeArmazenamento = nomeArmazenamento;
        this.tamanho = tamanho;
        this.formato = formato;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public String getNomeArmazenamento() {
        return nomeArmazenamento;
    }

    public void setNomeArmazenamento(String nomeArmazenamento) {
        this.nomeArmazenamento = nomeArmazenamento;
    }

    public Long getTamanho() {
        return tamanho;
    }

    public void setTamanho(Long tamanho) {
        this.tamanho = tamanho;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
