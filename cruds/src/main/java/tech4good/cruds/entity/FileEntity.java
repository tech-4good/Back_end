package tech4good.cruds.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "foto_beneficiado")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Integer idFoto;

    @Column(name = "nome_original")
    private String nomeOriginal;

    @Column(name = "nome_armazenamento")
    private String nomeArmazenamento;

    private Long tamanho;

    private String formato;

    @Column(name = "data_criacao")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public FileEntity(Integer idFoto, String nomeOriginal, String nomeArmazenamento, Long tamanho, String formato, LocalDateTime dataCriacao) {
        this.idFoto = idFoto;
        this.nomeOriginal = nomeOriginal;
        this.nomeArmazenamento = nomeArmazenamento;
        this.tamanho = tamanho;
        this.formato = formato;
        this.dataCriacao = dataCriacao;
    }

    public FileEntity() {
    }

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