package net.projetoreviver.sgp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;
import net.projetoreviver.sgp.models.RegistroCuidador;
import net.projetoreviver.sgp.repositories.RegistroCuidadorRepository;

@Service
public class RegistroCuidadorService {
    @Autowired
    RegistroCuidadorRepository registroCuidadorRepository;

    @Transactional
	public void toPersist(RegistroCuidador registroCuidador) {
		if(registroCuidadorRepository.save(registroCuidador) == null) {
			throw new TransacaoNaoRealizadaException("Não foi possível registrar cuidador");
		}
	}
	
	public RegistroCuidador getChamadaById(Long id) {
		Optional<RegistroCuidador> registroCuidador = registroCuidadorRepository.findById(id);
		if(registroCuidador.isEmpty()) {
			throw new RegistroNaoEncontradoException("Chamada não encontrada.");
		}
		return registroCuidador.get();
	}
	
	@Transactional
	public void toRemove(RegistroCuidador registroCuidador) {
		registroCuidadorRepository.deleteById(registroCuidador.getId());
	}
}
