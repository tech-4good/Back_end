package tech4good.cruds.service;

import org.springframework.stereotype.Service;
import tech4good.cruds.entity.Voluntario;
import tech4good.cruds.exception.EntidadeNaoEncontradaException;
import tech4good.cruds.repository.VoluntarioRepository;

import java.util.List;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    public Voluntario cadastrarVoluntario(Voluntario voluntario){
        return voluntarioRepository.save(voluntario);
    }

    public Voluntario buscarVoluntarioPorId(Integer id){
        return voluntarioRepository.findById(id).
                orElseThrow(() -> new EntidadeNaoEncontradaException("Voluntário de id %d não encontrado".formatted(id)));
    }

    public List<Voluntario> listarVoluntarios(){
        return voluntarioRepository.findAll();
    }

    public Voluntario atualizarVoluntario(Voluntario voluntario){
        if(voluntarioRepository.existsById(voluntario.getIdVoluntario())){
            voluntario.setIdVoluntario(voluntario.getIdVoluntario());
            return voluntarioRepository.save(voluntario);
        } else {
            throw new EntidadeNaoEncontradaException("Voluntário de id %d não encontrado".
                    formatted(voluntario.getIdVoluntario()));
        }
    }

    public void removerVoluntarioPorId(Integer id){
        if(voluntarioRepository.existsById(id)){
            voluntarioRepository.deleteById(id);
        } else {
            throw new EntidadeNaoEncontradaException("Voluntário de id %d não encontrado".formatted(id));
        }
    }
}
