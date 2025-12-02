package tech4good.tech4good_api.core.application.command.endereco;

import tech4good.tech4good_api.core.domain.endereco.valueobjects.*;
import tech4good.tech4good_api.core.domain.shared.valueobject.TipoCesta;

<<<<<<< HEAD
=======
 import java.time.LocalDate;

>>>>>>> main
public record CadastrarEnderecoCommand(
 String logradouro,
 String numero,
 String complemento,
 Bairro bairro,
 Cidade cidade,
 Estado estado,
 Cep cep,
 TipoCesta tipoCesta,
 String moradia,
 TipoMoradia tipoMoradia
 ) {
}
