package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Cesta;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.CestaRepository;

import java.util.List;

@Service
public class CestaService {

    private final CestaRepository cestaRepository;

    public CestaService(CestaRepository cestaRepository) {
        this.cestaRepository = cestaRepository;
    }

    public Cesta cadastrarCesta(Cesta cesta){
        return cestaRepository.save(cesta);
    }

    public Cesta buscarCestaPorId(Integer id){
        return cestaRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Cesta de id %d não encontrada".formatted(id)));
    }

    public List<Cesta> listarCestas(){
        return cestaRepository.findAll();
    }

    public Cesta atualizarCestaPorId(Cesta cesta){
        if(cestaRepository.existsById(cesta.getIdCesta())){
            cesta.setIdCesta(cesta.getIdCesta());
            return cestaRepository.save(cesta);
        } else {
            throw new EntidadeNaoEncontradaException("Curso de id %d não encontrado"
                    .formatted(cesta.getIdCesta()));
        }
    }

    public void removerCesta(Integer id){
        if(cestaRepository.existsById(id)){
            cestaRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Curso de id %d não encontrado".formatted(id));
        }
    }

}
