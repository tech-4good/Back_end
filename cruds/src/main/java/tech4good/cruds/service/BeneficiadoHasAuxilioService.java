package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.BeneficiadoHasAuxilio;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.BeneficiadoHasAuxilioRepository;

import java.util.List;

@Service
public class BeneficiadoHasAuxilioService {

    private final BeneficiadoHasAuxilioRepository beneficiadoHasAuxilioRepository;

    public BeneficiadoHasAuxilioService(BeneficiadoHasAuxilioRepository beneficiadoHasAuxilioRepository) {
        this.beneficiadoHasAuxilioRepository = beneficiadoHasAuxilioRepository;
    }

    public BeneficiadoHasAuxilio cadastrarBeneficiadoHasAuxilio(BeneficiadoHasAuxilio beneficiadoHasAuxilio){
        return beneficiadoHasAuxilioRepository.save(beneficiadoHasAuxilio);
    }

    public BeneficiadoHasAuxilio buscarBeneficiadoHasAuxilioPorId(Integer id){
        return beneficiadoHasAuxilioRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("BeneficiadoHasAuxilio de id %d não encontrado".formatted(id)));
    }

    public List<BeneficiadoHasAuxilio> listarBeneficiadoHasAuxilios(){
        return beneficiadoHasAuxilioRepository.findAll();
    }

    public BeneficiadoHasAuxilio atualizarBeneficiadoHasAuxilio(BeneficiadoHasAuxilio beneficiadoHasAuxilio){
        if(beneficiadoHasAuxilioRepository.existsById(beneficiadoHasAuxilio.getIdBeneficiadoHasAuxilio())){
            beneficiadoHasAuxilio.setIdBeneficiadoHasAuxilio(beneficiadoHasAuxilio.getIdBeneficiadoHasAuxilio());
            return beneficiadoHasAuxilioRepository.save(beneficiadoHasAuxilio);
        } else {
            throw new EntidadeNaoEncontradaException("BeneficiadoHasAuxilio de id %d não encontrado".
                    formatted(beneficiadoHasAuxilio.getIdBeneficiadoHasAuxilio()));
        }
    }

    public void removerBeneficiadoPorId(Integer id){
        if(beneficiadoHasAuxilioRepository.existsById(id)){
            beneficiadoHasAuxilioRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("BeneficiadoHasAuxilio de id %d não encontrado".formatted(id));
        }
    }
}
