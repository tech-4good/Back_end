package tech4good.cruds.dto.beneficiado;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Schema(description = "DTO para cadastro simples de beneficiado")
public class BeneficiadoCadastroSimplesDto {
    @Schema(description = "Nome completo do beneficiado", example = "Lucas Alves Matos")
    @NotBlank
    private String nome;

    @Schema(description = "CPF do beneficiado (somente números)", example = "12345678901")
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @Schema(description = "Data de nascimento do beneficiado", example = "1978-03-21")
    @NotBlank
    private LocalDate dataNascimento;

    @Schema(description = "Rua ou Avenida", example = "Avenida Marechal Tito")
    private String logradouro;
    @Schema(description = "Número da residência", example = "234")
    private Integer numero;
    @Schema(description = "Complemento do número da residência", example = "A")
    private String complemento;
    @Schema(description = "Nome do bairro", example = "São Miguel Paulista")
    private String bairro;
    @Schema(description = "Nome da cidade", example = "São Paulo")
    private String cidade;
    @Schema(description = "Nome do estado", example = "São Paulo")
    private String estado;
    @Schema(description = "CEP da região onde se encontra a residência", example = "08356723")
    private String cep;

    @Schema(description = "ID do endereço já cadastrado para vínculo", example = "1")
    private Integer idEndereco;
    @Schema(description = "Tipo de cesta que o endereço pode receber atualmente", example = "Kit")
    private String tipoCesta;
    @Schema(description = "Data de entrada no projeto ASA", example = "2025-02-10")
    private LocalDate dataEntrada;
    @Schema(description = "Data de saída no projeto ASA", example = "2025-06-22")
    private LocalDate dataSaida;
    @Schema(description = "Tipo de obtenção da moradia", example = "Alugada")
    private String moradia;
    @Schema(description = "Nome do tipo da moradia", example = "Apartamento")
    private String tipoMoradia;
    @Schema(description = "Controle para saber se ainda está participando da ASA", example = "Aberto")
    private String status;

    // Getters e setters
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getLogradouro() { return logradouro; }

    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public Integer getNumero() { return numero; }

    public void setNumero(Integer numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }

    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }

    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public Integer getIdEndereco() { return idEndereco; }

    public void setIdEndereco(Integer idEndereco) { this.idEndereco = idEndereco; }

    public String getTipoCesta() { return tipoCesta; }

    public void setTipoCesta(String tipoCesta) { this.tipoCesta = tipoCesta; }

    public LocalDate getDataEntrada() { return dataEntrada; }

    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

    public LocalDate getDataSaida() { return dataSaida; }

    public void setDataSaida(LocalDate dataSaida) { this.dataSaida = dataSaida; }

    public String getMoradia() { return moradia; }

    public void setMoradia(String moradia) { this.moradia = moradia; }

    public String getTipoMoradia() { return tipoMoradia; }

    public void setTipoMoradia(String tipoMoradia) { this.tipoMoradia = tipoMoradia; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
