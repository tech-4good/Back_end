package tech4good.tech4good_api.core.domain.file;

import java.time.LocalDateTime;

public class File {
    private Integer id;
    private String nomeOriginal;
    private String nomeArmazenamento;
    private Long tamanho;
    private String formato;
    private LocalDateTime dataCriacao;

    public File() {
    }

    public File(Integer id, String nomeOriginal, String nomeArmazenamento, Long tamanho, String formato, LocalDateTime dataCriacao) {
        this.id = id;
        this.nomeOriginal = nomeOriginal;
        this.nomeArmazenamento = nomeArmazenamento;
        this.tamanho = tamanho;
        this.formato = formato;
        this.dataCriacao = dataCriacao;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
