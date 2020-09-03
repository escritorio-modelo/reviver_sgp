package net.projetoreviver.sgp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;
import net.projetoreviver.sgp.models.Cuidador;
import net.projetoreviver.sgp.repositories.CuidadorRepository;

public class CuidadorService {
    @Autowired
    private CuidadorRepository cuidadorRepository;

    @Transactional
    public void toPersist(Cuidador cuidador){
        if(cuidadorRepository.save(cuidador) == null){
            throw new TransacaoNaoRealizadaException("Não foi possível salvar essa chamada");
        }
    }

    public Cuidador getChamadaById(Long id) {
		Optional<Cuidador> cuidador = cuidadorRepository.findById(id);
		if(cuidador.isEmpty()) {
			throw new RegistroNaoEncontradoException("Chamada não encontrada.");
		}
		return cuidador.get();
	}
	
	@Transactional
	public void toRemove(Cuidador cuidador) {
		cuidadorRepository.deleteById( cuidador.getId());
	}
}
