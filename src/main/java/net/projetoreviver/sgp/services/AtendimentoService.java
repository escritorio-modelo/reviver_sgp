package net.projetoreviver.sgp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import net.projetoreviver.sgp.models.*;
import net.projetoreviver.sgp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projetoreviver.sgp.exceptions.NegocioException;
import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;

@Service
public class AtendimentoService {
    
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private ChamadaRepository chamadaRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Transactional
    public Atendimento toPersist(Atendimento atendimento){
        Chamada chamada = chamadaRepository.findById(atendimento.getChamada().getId())
                .orElseThrow(() -> new NegocioException("Chamada não encontrada."));

        if(chamada.getStatus() != StatusChamada.EMANDAMENTO){
            throw new NegocioException("Atendimento só podem ser marcados para chamadas em andamento.");
        }

        Area area = areaRepository.findById(atendimento.getArea().getId())
                .orElseThrow(() -> new NegocioException("Area não encontrada."));

        atendimento.setArea(area);
        atendimento.setChamada(chamada);

        return atendimentoRepository.save(atendimento);
    }

    
/*
    public void toPersist(Atendimento atendimento, Chamada chamada) {
        
        if(chamada.getStatus() != StatusChamada.EMANDAMENTO){
            throw new NegocioException("Atendimento só podem ser marcados para chamadas em andamento.");
        }

        atendimento.setChamada(chamada);
        List<PacienteFrequencia> pacienteFrequenciaList = new ArrayList<>();
        List<CuidadorFrequencia> cuidadorFrequenciaList = new ArrayList<>();

        for(RegistroChamadaPaciente registroPaciente : chamada.getRegistrosPacientes()){
            Paciente paciente = registroPaciente.getPaciente();
            pacienteFrequenciaList.add(new PacienteFrequencia(atendimento, paciente));
            for(RegistroCuidador registroCuidador : registroPaciente.getCuidadoresList()){
                Cuidador cuidador = registroCuidador.getCuidador();
                cuidadorFrequenciaList.add(new CuidadorFrequencia(atendimento, cuidador));
            }
        }
        atendimentoRepository.save(atendimento);
        pacienteFrequenciaRepository.saveAll(pacienteFrequenciaList);
        cuidadorFrequenciaRepository.saveAll(cuidadorFrequenciaList);
        
    }
*/

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
