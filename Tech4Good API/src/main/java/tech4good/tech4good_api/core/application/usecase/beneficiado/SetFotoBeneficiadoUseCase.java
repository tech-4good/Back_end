package tech4good.tech4good_api.core.application.usecase.beneficiado;

import tech4good.tech4good_api.core.adapter.BeneficiadoGateway;
import tech4good.tech4good_api.core.application.exception.EntidadeNaoEncontradaException;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

public class SetFotoBeneficiadoUseCase {
    /*private final BeneficiadoGateway beneficiadoGateway;
    private final FileEntityGateway fileEntityGateway;

    public SetFotoBeneficiadoUseCase(BeneficiadoGateway beneficiadoGateway, FileEntityGateway fileEntityGateway) {
        this.beneficiadoGateway = beneficiadoGateway;
        this.fileEntityGateway = fileEntityGateway;
    }

    public Beneficiado executar(Integer idBeneficiado, Integer idFoto) {
        Beneficiado beneficiado = beneficiadoGateway.findById(idBeneficiado)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado".formatted(idBeneficiado)));
        FileEntity fileEntity = fileEntityGateway.findById(idFoto)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Foto de id %d não encontrada".formatted(idFoto)));
        beneficiado.setFotoBeneficiado(fileEntity);
        return beneficiadoGateway.save(beneficiado);
    }*/
}

