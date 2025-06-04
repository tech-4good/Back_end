package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Cesta;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.CestaRepository;
import tech4good.cruds.repository.EntregaRepository;
import tech4good.cruds.entity.Entrega;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
public class CestaService {

    private final CestaRepository cestaRepository;
    private final EntregaRepository entregaRepository;

    public CestaService(CestaRepository cestaRepository, EntregaRepository entregaRepository) {
        this.cestaRepository = cestaRepository;
        this.entregaRepository = entregaRepository;
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

    public Cesta atualizarCestaPorId(Cesta cesta, Integer id){
        Cesta cestaExistente = cestaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cesta de id %d não encontrada".formatted(id)));

        if (cesta.getQuantidadeCestas() != null){
            cestaExistente.setQuantidadeCestas(cesta.getQuantidadeCestas());
        }

        return cestaRepository.save(cestaExistente);
    }

    public void removerCesta(Integer id){
        if(cestaRepository.existsById(id)){
            cestaRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Curso de id %d não encontrado".formatted(id));
        }
    }

    /*
    public List<Cesta> listarCestasEntreguesPorBeneficiadoComFiltro(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim, String tipo) {
        List<Entrega> entregas = entregaRepository.findByFiltro(idBeneficiado, dataInicio, dataFim, tipo);
        return entregas.stream()
                .map(Entrega::getCesta)
                .collect(Collectors.toList());
    }

     */

}

