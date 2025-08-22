package tech4good.tech4good_api.core.domain.voluntario;

import tech4good.tech4good_api.core.domain.shared.valueobject.Cpf;
import tech4good.tech4good_api.core.domain.shared.valueobject.Telefone;
import tech4good.tech4good_api.core.domain.voluntario.valueobject.Email;

public class Voluntario {
    private Integer id;
    private String nome;
    private Cpf cpf;
    private Telefone telefone;
    private String senha;
    private Email email;
    private Integer administrador;
}
