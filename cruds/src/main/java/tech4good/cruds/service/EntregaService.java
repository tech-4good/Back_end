package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Entrega;
import tech4good.cruds.entity.Voluntario;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.EntregaRepository;

import java.util.List;

@Service
public class EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    public Entrega cadastrarEntrega(Entrega entrega){
        return entregaRepository.save(entrega);
    }

    public Entrega buscarEntregaPorId(Integer id){
        return entregaRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega de id %d não encontrado".formatted(id)));
    }

    public List<Entrega> listarEntregas(){
        return entregaRepository.findAll();
    }

    public Entrega atualizarEntrega(Entrega entrega){
        if(entregaRepository.existsById(entrega.getIdEntrega())){
            entrega.setIdEntrega(entrega.getIdEntrega());
            return entregaRepository.save(entrega);
        } else {
            throw new EntidadeNaoEncontradaException("Entrega de id %d não encontrado".
                    formatted(entrega.getIdEntrega()));
        }
    }

    public void removerEntregaPorId(Integer id){
        if(entregaRepository.existsById(id)){
            entregaRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Entrega de id %d não encontrado".formatted(id));
        }
    }
}
