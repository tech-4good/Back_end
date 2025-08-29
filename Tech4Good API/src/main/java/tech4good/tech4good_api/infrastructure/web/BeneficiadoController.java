package tech4good.tech4good_api.infrastructure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech4good.tech4good_api.core.application.command.beneficiado.CadastrarBeneficiadoCommand;
import tech4good.tech4good_api.core.application.usecase.beneficiado.CadastrarBeneficiadoUseCase;
import tech4good.tech4good_api.core.domain.beneficiado.Beneficiado;

@RestController
@RequestMapping("/beneficiados")
public class BeneficiadoController {

    private final CadastrarBeneficiadoUseCase cadastrarBeneficiadoUseCase;

    public BeneficiadoController(CadastrarBeneficiadoUseCase cadastrarBeneficiadoUseCase) {
        this.cadastrarBeneficiadoUseCase = cadastrarBeneficiadoUseCase;
    }

    @PostMapping
    public ResponseEntity<Beneficiado> cadastrarBeneficiado(@RequestBody CadastrarBeneficiadoCommand command) {
        Beneficiado executar = cadastrarBeneficiadoUseCase.executar(command);
        return ResponseEntity.status(201).body(executar);
    }
}
