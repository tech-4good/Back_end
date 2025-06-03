package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.entity.Entrega;
import tech4good.cruds.entity.TipoMorador;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.TipoMoradorRepository;

import java.util.List;

@Service
public class TipoMoradorService {

    private final TipoMoradorRepository tipoMoradorRepository;

    private final EnderecoService enderecoService;
    private final BeneficiadoService beneficiadoService;

    public TipoMoradorService(TipoMoradorRepository tipoMoradorRepository, EnderecoService enderecoService, BeneficiadoService beneficiadoService) {
        this.tipoMoradorRepository = tipoMoradorRepository;
        this.enderecoService = enderecoService;
        this.beneficiadoService = beneficiadoService;
    }

    public TipoMorador cadastrarTipoMorador(TipoMorador tipoMorador, Integer enderecoId, Integer beneficiadoId){
        Endereco endereco = enderecoService.listarEnderecoPorId(enderecoId);
        if (endereco == null){
            throw new EntidadeNaoEncontradaException("Endereco de id %d nao encontrada".formatted(enderecoId));
        }
        tipoMorador.setEndereco(endereco);

        Beneficiado beneficiado = beneficiadoService.buscarBeneficiadoPorId(beneficiadoId);
        if (beneficiado == null){
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d nao encontrado".formatted(beneficiadoId));
        }
        tipoMorador.setBeneficiado(beneficiado);

        return tipoMoradorRepository.save(tipoMorador);
    }

    public TipoMorador buscarTipoMoradorPorId(Integer id){
        return tipoMoradorRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(id)));
    }

    public List<TipoMorador> listarTipoMoradores(){
        return tipoMoradorRepository.findAll();
    }

    public TipoMorador atualizarTipoMorador(TipoMorador tipoMorador, Integer id){
       TipoMorador tipoMoradorExistente = tipoMoradorRepository.findById(id)
               .orElseThrow(() -> new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(id)));

       if (tipoMorador.getQuantidadeCrianca() != null){
           tipoMoradorExistente.setQuantidadeCrianca(tipoMorador.getQuantidadeCrianca());
       }
       if (tipoMorador.getQuantidadeAdolescente() != null){
           tipoMoradorExistente.setQuantidadeAdolescente(tipoMorador.getQuantidadeAdolescente());
       }
       if (tipoMorador.getQuantidadeJovem() != null){
           tipoMoradorExistente.setQuantidadeJovem(tipoMorador.getQuantidadeJovem());
       }
       if (tipoMorador.getQuantidadeIdoso() != null){
           tipoMoradorExistente.setQuantidadeIdoso(tipoMorador.getQuantidadeIdoso());
       }
       if (tipoMorador.getQuantidadeGestante() != null){
           tipoMoradorExistente.setQuantidadeGestante(tipoMorador.getQuantidadeGestante());
       }
       if (tipoMorador.getQuantidadeDeficiente() != null){
           tipoMoradorExistente.setQuantidadeDeficiente(tipoMorador.getQuantidadeDeficiente());
       }
       if (tipoMorador.getQuantidadeOutros() != null){
           tipoMoradorExistente.setQuantidadeOutros(tipoMorador.getQuantidadeOutros());
       }

       return tipoMoradorRepository.save(tipoMoradorExistente);
    }

    public void removerTipoMoradorPorId(Integer id){
        if(tipoMoradorRepository.existsById(id)){
            tipoMoradorRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("TipoMorador de id %d não encontrado".formatted(id));
        }
    }
}
