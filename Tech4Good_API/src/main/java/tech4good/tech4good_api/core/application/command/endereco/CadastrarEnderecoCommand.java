package tech4good.tech4good_api.core.application.command.endereco;

import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

 import java.time.LocalDate;

public record CadastrarEnderecoCommand(
 String logradouro,
 String numero,
 String complemento,
 Bairro bairro,
 Cidade cidade,
 Estado estado,
 Cep cep,
 TipoCesta tipoCesta,
 LocalDate dataEntrada,
 LocalDate dataSaida,
 String moradia,
 TipoMoradia tipoMoradia,
 Status status
 ) {
}
