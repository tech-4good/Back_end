package tech4good.tech4good_api.core.application.command.endereco;

public record AtualizarEnderecoDadosCommand(
        Integer id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep,
        String moradia,
        String tipoMoradia
) {
}
