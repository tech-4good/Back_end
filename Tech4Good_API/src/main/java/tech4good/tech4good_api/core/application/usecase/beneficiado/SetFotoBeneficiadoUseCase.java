package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.adapter.FileGateway;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;
import tech4good.tech4good_api.core.domain.file.File;

public class SetFotoBeneficiadoUseCase {
    private final BeneficiadoGateway beneficiadoGateway;
    private final FileGateway fileGateway;

    public SetFotoBeneficiadoUseCase(BeneficiadoGateway beneficiadoGateway, FileGateway fileGateway) {
        this.beneficiadoGateway = beneficiadoGateway;
        this.fileGateway = fileGateway;
    }

    public Beneficiado executar(Integer idBeneficiado, Integer idFoto) {
        Beneficiado beneficiado = beneficiadoGateway.findById(idBeneficiado);
        if (beneficiado == null) {
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado".formatted(idBeneficiado));
        }

        File file = fileGateway.loadEntity(idFoto);
        if (file == null) {
            throw new EntidadeNaoEncontradaException("Foto de id %d não encontrada".formatted(idFoto));
        }

        beneficiado.setFotoBeneficiado(file);
        return beneficiadoGateway.save(beneficiado);
    }
}
