package net.projetoreviver.sgp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.projetoreviver.sgp.exceptions.NegocioException;
import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;
import net.projetoreviver.sgp.models.Paciente;
import net.projetoreviver.sgp.repositories.PacienteRepository;


@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public void toPersist(Paciente paciente){
        
        Optional<Paciente> pacienteExistente = pacienteRepository.findByCpf(paciente.getCpf());

        if(pacienteExistente.isPresent() && !pacienteExistente.get().equals(paciente)){
            throw new NegocioException("CPF já cadastrado");
        }

        try{
            pacienteRepository.save(paciente);
        }catch (Exception ex){
            throw new TransacaoNaoRealizadaException("Erro ao salvar Paciente");
        }
    }

    public Paciente getPacienteById(Long id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isEmpty()) {
			throw new RegistroNaoEncontradoException("Paciente não encontrado.");
		}
		return paciente.get();
    }

    @Transactional
	public void toRemove(Paciente paciente) {
		pacienteRepository.deleteById(paciente.getId());
	}
}