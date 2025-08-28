package tech4good.tech4good_api.core.domain.beneficiado;

import org.apache.http.entity.FileEntity;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.EstadoCivil;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Religiao;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Renda;
import tech4good.tech4good_api.core.domain.beneficiado.valueobject.Rg;
import tech4good.tech4good_api.core.domain.endereco.Endereco;
import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;

import java.time.LocalDate;

public class Beneficiado {
    private Integer id;
    private Cpf cpf;
    private String nome;
    private Rg rg;
    private LocalDate dataNascimento;
    private String naturalidade;
    private Telefone telefone;
    private EstadoCivil estadoCivil;
    private String escolaridade;
    private String profissao;
    private Renda rendaMensal;
    private String empresa;
    private String cargo;
    private Religiao religiao;
    private Endereco endereco;
    private Integer quantidadeDependentes;
    private FileEntity fotoBeneficiado;

}
