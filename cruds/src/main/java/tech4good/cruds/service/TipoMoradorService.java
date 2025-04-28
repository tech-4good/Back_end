package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Entrega;
import tech4good.cruds.entity.TipoMorador;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.TipoMoradorRepository;

import java.util.List;

@Service
public class TipoMoradorService {

    private final TipoMoradorRepository tipoMoradorRepository;

    public TipoMoradorService(TipoMoradorRepository tipoMoradorRepository) {
        this.tipoMoradorRepository = tipoMoradorRepository;
    }

    public TipoMorador cadastrarTipoMorador(TipoMorador tipoMorador){
        return tipoMoradorRepository.save(tipoMorador);
    }

    public TipoMorador buscarTipoMoradorPorId(Integer id){
        return tipoMoradorRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(id)));
    }

    public List<TipoMorador> listarTipoMoradores(){
        return tipoMoradorRepository.findAll();
    }

    public TipoMorador atualizarTipoMorador(TipoMorador tipoMorador){
        if(tipoMoradorRepository.existsById(tipoMorador.getIdTipoMorador())){
            tipoMorador.setIdTipoMorador(tipoMorador.getIdTipoMorador());
            return tipoMoradorRepository.save(tipoMorador);
        } else {
            throw new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".
                    formatted(tipoMorador.getIdTipoMorador()));
        }
    }

    //Verificar se não deveria ser removerTipoMoradorPorId
    public void removerBeneficiadoPorId(Integer id){
        if(tipoMoradorRepository.existsById(id)){
            tipoMoradorRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(id));
        }
    }
}
