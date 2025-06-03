package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.entity.FilhoBeneficiado;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.FilhoBeneficiadoRepository;

import java.util.List;

@Service
public class FilhoBeneficiadoService {

    private final FilhoBeneficiadoRepository filhoBeneficiadoRepository;
    private final BeneficiadoService beneficiadoService;
    private final EnderecoService enderecoService;


    public FilhoBeneficiadoService(FilhoBeneficiadoRepository filhoBeneficiadoRepository, BeneficiadoService beneficiadoService, EnderecoService enderecoService) {
        this.filhoBeneficiadoRepository = filhoBeneficiadoRepository;
        this.beneficiadoService = beneficiadoService;
        this.enderecoService = enderecoService;
    }

    public FilhoBeneficiado cadastrarFilhoBeneficiado(FilhoBeneficiado filhoBeneficiado, Integer enderecoId, Integer beneficiadoId){
        Endereco endereco = enderecoService.listarEnderecoPorId(enderecoId);
        if (endereco == null){
            throw new EntidadeNaoEncontradaException("Endereco de id %d nao encontrada".formatted(enderecoId));
        }
        filhoBeneficiado.setEndereco(endereco);

        Beneficiado beneficiado = beneficiadoService.buscarBeneficiadoPorId(beneficiadoId);
        if (beneficiado == null){
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d nao encontrado".formatted(beneficiadoId));
        }
        filhoBeneficiado.setBeneficiado(beneficiado);

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

    public void removerFilhoBeneficiadoPorId(Integer id){
        if(filhoBeneficiadoRepository.existsById(id)){
            filhoBeneficiadoRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("FilhoBeneficiado de id %d não encontrado".formatted(id));
        }
    }
}
