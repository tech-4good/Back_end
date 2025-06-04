package tech4good.cruds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech4good.cruds.entity.*;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.EnderecoRepository;
import tech4good.cruds.repository.EntregaRepository;

import java.time.LocalDate;
import java.util.List;

@Service

public class EntregaService {

    private final EntregaRepository entregaRepository;
    private final EnderecoService enderecoService;
    private final VoluntarioService voluntarioService;
    private final CestaService cestaService;
    private final BeneficiadoService beneficiadoService;

    @Autowired
    public EntregaService(EntregaRepository entregaRepository, EnderecoService enderecoService, VoluntarioService voluntarioService, CestaService cestaService, BeneficiadoService beneficiadoService) {
        this.entregaRepository = entregaRepository;
        this.enderecoService = enderecoService;
        this.voluntarioService = voluntarioService;
        this.cestaService = cestaService;
        this.beneficiadoService = beneficiadoService;
    }

    public Entrega cadastrarEntrega(Entrega entrega, Integer enderecoId, Integer voluntarioId, Integer cestaId, Integer beneficiadoId){
        Endereco endereco = enderecoService.listarEnderecoPorId(enderecoId);
        if (endereco == null){
            throw new EntidadeNaoEncontradaException("Endereco de id %d nao encontrada".formatted(enderecoId));
        }
        entrega.setEndereco(endereco);

        Voluntario voluntario = voluntarioService.buscarVoluntarioPorId(voluntarioId);
        if (voluntario == null){
            throw new EntidadeNaoEncontradaException("Voluntario de id %d nao encontrado".formatted(voluntarioId));
        }
        entrega.setVoluntario(voluntario);

        Cesta cesta = cestaService.buscarCestaPorId(cestaId);
        if (cesta == null){
            throw new EntidadeNaoEncontradaException("Cesta de id %d nao encontrada".formatted(cestaId));
        }
        entrega.setCesta(cesta);

        Beneficiado beneficiado = beneficiadoService.buscarBeneficiadoPorId(beneficiadoId);
        if (beneficiado == null){
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d nao encontrado".formatted(beneficiadoId));
        }
        entrega.setBeneficiado(beneficiado);

        return entregaRepository.save(entrega);
    }

    public Entrega buscarEntregaPorId(Integer id){
        return entregaRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega de id %d não encontrado".formatted(id)));
    }

    public List<Entrega> listarEntregas(){
        return entregaRepository.findAll();
    }

    public Entrega atualizarEntrega(Entrega entrega, Integer id){
        Entrega entregaExistente = entregaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega com id %d não encontrada".formatted(id)));

        if (entrega.getDataRetirada() != null){
            entregaExistente.setDataRetirada(entrega.getDataRetirada());
        }

        if (entrega.getProximaRetirada() != null){
            entregaExistente.setProximaRetirada(entrega.getProximaRetirada());
        }

        return entregaRepository.save(entregaExistente);
    }

    public void removerEntregaPorId(Integer id){
        if(entregaRepository.existsById(id)){
            entregaRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Entrega de id %d não encontrado".formatted(id));
        }
    }

    public List<Entrega> listarEntregasPorBeneficiadoComFiltro(Integer idBeneficiado, LocalDate dataInicio, LocalDate dataFim) {
        return entregaRepository.findByFiltro(idBeneficiado, dataInicio, dataFim);
    }

}
