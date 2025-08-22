package tech4good.tech4good_api.core.domain.filhobeneficiado;

import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.endereco.Endereco;

import java.time.LocalDate;

public class FilhoBeneficiado {
    private Integer id;
    private LocalDate dataNascimento;
    private Boolean isEstudante;
    private Boolean hasCreche;
    private Beneficiado beneficiado;
    private Endereco endereco;
}
