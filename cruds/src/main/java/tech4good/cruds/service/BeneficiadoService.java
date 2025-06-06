package tech4good.cruds.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech4good.cruds.dto.beneficiado.BeneficiadoCadastroSimplesDto;
import tech4good.cruds.entity.Beneficiado;
import tech4good.cruds.entity.Endereco;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.BeneficiadoRepository;
import tech4good.cruds.repository.EnderecoRepository;

import java.util.List;

@Service
public class BeneficiadoService {

    private static final Logger log = LoggerFactory.getLogger(BeneficiadoService.class);
    private final BeneficiadoRepository beneficiadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public BeneficiadoService(BeneficiadoRepository beneficiadoRepository) {
        this.beneficiadoRepository = beneficiadoRepository;
    }

    public Beneficiado cadastrarBeneficiado(Beneficiado beneficiado){
        return beneficiadoRepository.save(beneficiado);
    }

    public Beneficiado buscarBeneficiadoPorCpf(String cpf){
        if(beneficiadoRepository.existsByCpf(cpf)){
            return beneficiadoRepository.findByCpf(cpf);
        } else {
            throw new EntidadeNaoEncontradaException("Beneficiado com CPF %s não encontrado".formatted(cpf));
        }
    }

    public Beneficiado buscarBeneficiadoPorId(Integer id){
        return beneficiadoRepository.findById(id)
                .orElseThrow(() ->
                        new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado".formatted(id)));
    }

    public List<Beneficiado> listarBeneficiados(){
        return beneficiadoRepository.findAll();
    }

    public Beneficiado atualizarBeneficiado(Beneficiado beneficiado, Integer idBeneficiado){
        Beneficiado beneficiadoExistente = beneficiadoRepository.findById(idBeneficiado)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado".formatted(idBeneficiado)));

        if (beneficiado.getNaturalidade() != null) {
            beneficiadoExistente.setNaturalidade(beneficiado.getNaturalidade());
        }
        if (beneficiado.getTelefone() != null) {
            beneficiadoExistente.setTelefone(beneficiado.getTelefone());
        }
        if (beneficiado.getEstadoCivil() != null) {
            beneficiadoExistente.setEstadoCivil(beneficiado.getEstadoCivil());
        }
        if (beneficiado.getEscolaridade() != null) {
            beneficiadoExistente.setEscolaridade(beneficiado.getEscolaridade());
        }
        if (beneficiado.getProfissao() != null) {
            beneficiadoExistente.setProfissao(beneficiado.getProfissao());
        }
        if (beneficiado.getRendaMensal() != null) {
            beneficiadoExistente.setRendaMensal(beneficiado.getRendaMensal());
        }
        if (beneficiado.getEmpresa() != null) {
            beneficiadoExistente.setEmpresa(beneficiado.getEmpresa());
        }
        if (beneficiado.getCargo() != null) {
            beneficiadoExistente.setCargo(beneficiado.getCargo());
        }
        if (beneficiado.getReligiao() != null) {
            beneficiadoExistente.setReligiao(beneficiado.getReligiao());
        }
        if (beneficiado.getEndereco() != null) {
            beneficiadoExistente.setEndereco(beneficiado.getEndereco());
        }

        return beneficiadoRepository.save(beneficiadoExistente);
    }

    public void removerBeneficiadoPorId(Integer id){
        if(beneficiadoRepository.existsById(id)){
            beneficiadoRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Beneficiado de id %d não encontrado"
                    .formatted(id));
        }
    }

    public Beneficiado cadastrarBeneficiadoSimples(BeneficiadoCadastroSimplesDto dto) {
        Endereco endereco = enderecoRepository.findAll().stream()
            .filter(e -> e.getLogradouro() != null && e.getNumero() != null)
            .filter(e -> e.getLogradouro().equalsIgnoreCase(dto.getLogradouro()))
            .filter(e -> e.getNumero().equals(dto.getNumero()))
            .findFirst()
            .orElse(null);

        if (endereco == null) {
            endereco = new Endereco();
            endereco.setLogradouro(dto.getLogradouro());
            endereco.setNumero(dto.getNumero());
            endereco.setComplemento(dto.getComplemento());
            endereco.setBairro(dto.getBairro());
            endereco.setCidade(dto.getCidade());
            endereco.setEstado(dto.getEstado());
            endereco.setCep(dto.getCep());
            endereco.setTipoCesta(dto.getTipoCesta());
            endereco.setDataEntrada(dto.getDataEntrada());
            endereco.setDataSaida(dto.getDataSaida());
            endereco.setMoradia(dto.getMoradia());
            endereco.setTipoMoradia(dto.getTipoMoradia());
            endereco.setStatus(dto.getStatus());
            endereco = enderecoRepository.save(endereco);
        }
        Beneficiado beneficiado = new Beneficiado();
        beneficiado.setNome(dto.getNome());
        beneficiado.setCpf(dto.getCpf());
        beneficiado.setDataNascimento(dto.getDataNascimento());
        beneficiado.setEndereco(endereco);
        return beneficiadoRepository.save(beneficiado);
    }
}
