package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.AuxilioGovernamental;
import tech4good.cruds.entity.Entrega;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.AuxilioGovernamentalRepository;

import java.util.List;

@Service
public class AuxilioGovernamentalService {

    private final AuxilioGovernamentalRepository auxilioGovernamentalRepository;

    public AuxilioGovernamentalService(AuxilioGovernamentalRepository auxilioGovernamentalRepository) {
        this.auxilioGovernamentalRepository = auxilioGovernamentalRepository;
    }

    public AuxilioGovernamental cadastrarAuxilioGovernamental(AuxilioGovernamental auxilioGovernamental){
        return auxilioGovernamentalRepository.save(auxilioGovernamental);
    }

    public AuxilioGovernamental buscarAuxilioGovernamentalPorId(Integer id){
        return auxilioGovernamentalRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("AuxilioGovernamental de id %d não encontrado".formatted(id)));
    }

    public List<AuxilioGovernamental> listarAuxilioGovernamentals(){
        return auxilioGovernamentalRepository.findAll();
    }

    public AuxilioGovernamental atualizarAuxilioGovernamental(AuxilioGovernamental auxilioGovernamental){
        if(auxilioGovernamentalRepository.existsById(auxilioGovernamental.getIdAuxilio())){
            auxilioGovernamental.setIdAuxilio(auxilioGovernamental.getIdAuxilio());
            return auxilioGovernamentalRepository.save(auxilioGovernamental);
        } else {
            throw new EntidadeNaoEncontradaException("AuxilioGovernamental de id %d não encontrado".
                    formatted(auxilioGovernamental.getIdAuxilio()));
        }
    }

    public void removerBeneficiadoPorId(Integer id){
        if(auxilioGovernamentalRepository.existsById(id)){
            auxilioGovernamentalRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("AuxilioGovernamental de id %d não encontrado".formatted(id));
        }
    }

}
