package net.projetoreviver.sgp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.models.Atendimento;
import net.projetoreviver.sgp.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {
    private AtendimentoRepository atendimentoRepository;


    @Transactional
    public Atendimento toPersist(Atendimento atendimento){
        return atendimentoRepository.save(atendimento);
    }


    public Atendimento getAtendimentoById(Long id){
        Optional<Atendimento> atendimentoOptional = atendimentoRepository.findById(id);
        if(atendimentoOptional.isEmpty()){
            throw new RegistroNaoEncontradoException("Atendimento não encontrado");
        }
        return atendimentoOptional.get();
    }

    @Transactional
    public void toRemove(Atendimento atendimento){
        atendimentoRepository.delete(atendimento);
    }

    @Transactional
    public void toRemove(Long id){
        atendimentoRepository.deleteById(id);
    }

}
