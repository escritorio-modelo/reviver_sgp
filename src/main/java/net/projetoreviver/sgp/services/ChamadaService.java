package net.projetoreviver.sgp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;
import net.projetoreviver.sgp.models.Chamada;
import net.projetoreviver.sgp.repositories.ChamadaRepository;

@Service
@RequiredArgsConstructor
public class ChamadaService {
	
	private final ChamadaRepository chamadaRepository;
	
	@Transactional
	public Chamada toPersist(Chamada chamada) {
		if(chamadaRepository.save(chamada) == null) {
			throw new TransacaoNaoRealizadaException("Não foi possível salvar essa chamada");
		}
		return chamada;
	}
	
	public Chamada getChamadaById(Long id) {
		Optional<Chamada> chamada = chamadaRepository.findById(id);
		if(chamada.isEmpty()) {
			throw new RegistroNaoEncontradoException("Chamada não encontrada.");
		}
		return chamada.get();
	}
	
	@Transactional
	public void toRemove(Chamada chamada) {
		chamadaRepository.deleteById(chamada.getId());
	}
	
}
