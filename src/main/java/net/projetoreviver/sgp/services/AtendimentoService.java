package net.projetoreviver.sgp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projetoreviver.sgp.exceptions.NegocioException;
import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.models.Atendimento;
import net.projetoreviver.sgp.models.Chamada;
import net.projetoreviver.sgp.models.Cuidador;
import net.projetoreviver.sgp.models.CuidadorFrequencia;
import net.projetoreviver.sgp.models.Paciente;
import net.projetoreviver.sgp.models.PacienteFrequencia;
import net.projetoreviver.sgp.models.RegistroChamadaPaciente;
import net.projetoreviver.sgp.models.RegistroCuidador;
import net.projetoreviver.sgp.models.StatusChamada;
import net.projetoreviver.sgp.repositories.AtendimentoRepository;
import net.projetoreviver.sgp.repositories.CuidadorFrequenciaRepository;
import net.projetoreviver.sgp.repositories.PacienteFrequenciaRepository;

@Service
public class AtendimentoService {
    
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private PacienteFrequenciaRepository pacienteFrequenciaRepository;

    @Autowired
    private CuidadorFrequenciaRepository cuidadorFrequenciaRepository;

    @Transactional
    public Atendimento toPersist(Atendimento atendimento){
        return atendimentoRepository.save(atendimento);
    }

    

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
