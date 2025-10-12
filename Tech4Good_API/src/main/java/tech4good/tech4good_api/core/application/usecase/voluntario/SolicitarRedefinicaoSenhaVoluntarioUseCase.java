package tech4good.tech4good_api.core.application.usecase.voluntario;

import lombok.extern.slf4j.Slf4j;
import tech4good.tech4good_api.core.adapter.VoluntarioGateway;
import tech4good.tech4good_api.core.application.command.voluntario.SolicitarRedefinicaoSenhaVoluntarioCommand;
import tech4good.tech4good_api.core.domain.voluntario.Voluntario;
import tech4good.tech4good_api.infrastructure.integration.messaging.VoluntarioMessageProducer;

import java.util.UUID;

@Slf4j
public class SolicitarRedefinicaoSenhaVoluntarioUseCase {

    private final VoluntarioGateway voluntarioGateway;
    private final VoluntarioMessageProducer messageProducer;

    public SolicitarRedefinicaoSenhaVoluntarioUseCase(
            VoluntarioGateway voluntarioGateway,
            VoluntarioMessageProducer messageProducer) {
        this.voluntarioGateway = voluntarioGateway;
        this.messageProducer = messageProducer;
    }

    public void execute(SolicitarRedefinicaoSenhaVoluntarioCommand command) {
        log.info("Solicitação de redefinição de senha para: {}", command.email());

        Voluntario voluntario = voluntarioGateway.buscarPorEmail(command.email());

        String tokenRedefinicao = UUID.randomUUID().toString();

        messageProducer.enviarSolicitacaoRedefinicaoSenha(voluntario, tokenRedefinicao);

        log.info("Mensagem enviada para fila com sucesso!");
    }
}
