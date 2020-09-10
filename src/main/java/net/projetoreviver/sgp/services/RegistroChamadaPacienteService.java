package net.projetoreviver.sgp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;
import net.projetoreviver.sgp.models.RegistroChamadaPaciente;
import net.projetoreviver.sgp.repositories.RegistroChamadaPacienteRepository;


@Service
public class RegistroChamadaPacienteService {
    @Autowired
    RegistroChamadaPacienteRepository registroChamadaPacienteRepository;

    @Transactional
	public void toPersist(RegistroChamadaPaciente registroChamadaPaciente) {
		if(registroChamadaPacienteRepository.save(registroChamadaPaciente) == null) {
			throw new TransacaoNaoRealizadaException("Não foi possível registrar cuidador");
		}
	}
	
	public RegistroChamadaPaciente getChamadaById(Long id) {
		Optional<RegistroChamadaPaciente> registroChamadaPaciente = registroChamadaPacienteRepository.findById(id);
		if(registroChamadaPaciente.isEmpty()) {
			throw new RegistroNaoEncontradoException("Chamada não encontrada.");
		}
		return registroChamadaPaciente.get();
	}
	
	@Transactional
	public void toRemove(RegistroChamadaPaciente registroChamadaPaciente) {
		registroChamadaPacienteRepository.deleteById(registroChamadaPaciente.getId());
	}
}
