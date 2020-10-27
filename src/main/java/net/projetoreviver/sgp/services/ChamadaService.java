package net.projetoreviver.sgp.services;

import java.util.Optional;

import net.projetoreviver.sgp.exceptions.NegocioException;
import net.projetoreviver.sgp.models.StatusChamada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;
import net.projetoreviver.sgp.models.Chamada;
import net.projetoreviver.sgp.repositories.ChamadaRepository;

@Service
public class ChamadaService {
	
	@Autowired
	private ChamadaRepository chamadaRepository;
	
	@Transactional
	public Chamada toPersist(Chamada chamada) {
		Chamada chamadaSalva;
		try{
			chamadaSalva = chamadaRepository.save(chamada);
		}catch(Exception ex){
			throw new TransacaoNaoRealizadaException("Não foi possível salvar chamada");
		}

		return chamadaSalva;
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
		if(chamada.getStatus() != StatusChamada.ABERTA) {
			throw new TransacaoNaoRealizadaException("Somente chamadas abertas podem ser deletadas");
		}
		chamadaRepository.deleteById(chamada.getId());
	}

	public Page<Chamada> procurarPorTitulo(String titulo, int pagina, int tamanho){
		PageRequest pageRequest = PageRequest.of(pagina, tamanho, Sort.Direction.DESC, "id");
		return chamadaRepository.findByTituloContainingIgnoreCase(titulo, pageRequest);
	} 
	
}
