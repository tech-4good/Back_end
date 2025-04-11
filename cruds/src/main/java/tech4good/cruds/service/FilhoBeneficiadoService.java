package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.FilhoBeneficiado;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.FilhoBeneficiadoRepository;

import java.util.List;

@Service
public class FilhoBeneficiadoService {

    private final FilhoBeneficiadoRepository filhoBeneficiadoRepository;

    public FilhoBeneficiadoService(FilhoBeneficiadoRepository filhoBeneficiadoRepository) {
        this.filhoBeneficiadoRepository = filhoBeneficiadoRepository;
    }

    public FilhoBeneficiado cadastrarFilhoBeneficiado(FilhoBeneficiado filhoBeneficiado){
        return filhoBeneficiadoRepository.save(filhoBeneficiado);
    }

    public FilhoBeneficiado buscarFilhoBeneficiadoPorId(Integer id){
        return filhoBeneficiadoRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("FilhoBeneficiado de id %d não encontrado".formatted(id)));
    }

    public List<FilhoBeneficiado> listarFilhosBeneficiados(){
        return filhoBeneficiadoRepository.findAll();
    }

    public FilhoBeneficiado atualizarFilhoBeneficiado(FilhoBeneficiado filhoBeneficiado){
        if(filhoBeneficiadoRepository.existsById(filhoBeneficiado.getIdFilhoBeneficiado())){
            filhoBeneficiado.setIdFilhoBeneficiado(filhoBeneficiado.getIdFilhoBeneficiado());
            return filhoBeneficiadoRepository.save(filhoBeneficiado);
        } else {
            throw new EntidadeNaoEncontradaException("FilhoBeneficiado de id %d não encontrado".
                    formatted(filhoBeneficiado.getIdFilhoBeneficiado()));
        }
    }

    public void removerBeneficiadoPorId(Integer id){
        if(filhoBeneficiadoRepository.existsById(id)){
            filhoBeneficiadoRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("FilhoBeneficiado de id %d não encontrado".formatted(id));
        }
    }
}
