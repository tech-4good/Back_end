package tech4good.cruds.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.BeneficiadoRepository;

import java.util.List;

@Service
public class BeneficiadoService {

    private static final Logger log = LoggerFactory.getLogger(BeneficiadoService.class);
    private final BeneficiadoRepository beneficiadoRepository;

    public BeneficiadoService(BeneficiadoRepository beneficiadoRepository) {
        this.beneficiadoRepository = beneficiadoRepository;
    }

    public Beneficiado cadastrarBeneficiado(Beneficiado beneficiado){
        return beneficiadoRepository.save(beneficiado);
    }

    public Beneficiado buscarBeneficiadoPorCpf(String cpf){
        if(beneficiadoRepository.existsByCpf(cpf)){
            return beneficiadoRepository.findByCpf(cpf);
        } else {
            throw new EntidadeNaoEncontradaException("Beneficiado com CPF %s não encontrado".formatted(cpf));
        }
    }

    public Beneficiado buscarBeneficiadoPorId(Integer id){
        return beneficiadoRepository.findById(id)
                .orElseThrow(() ->
                        new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado".formatted(id)));
    }

    public List<Beneficiado> listarBeneficiados(){
        return beneficiadoRepository.findAll();
    }

    public Beneficiado atualizarBeneficiado(Beneficiado beneficiado){
        if(beneficiadoRepository.existsById(beneficiado.getIdBeneficiado())){
            beneficiado.setIdBeneficiado(beneficiado.getIdBeneficiado());
            return beneficiadoRepository.save(beneficiado);
        } else {
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado"
                    .formatted(beneficiado.getIdBeneficiado()));
        }
    }

    public void removerBeneficiadoPorId(Integer id){
        if(beneficiadoRepository.existsById(id)){
            beneficiadoRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado"
                    .formatted(id));
        }
    }
}
