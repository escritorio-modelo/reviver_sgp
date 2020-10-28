package net.projetoreviver.sgp.services;

import java.util.Optional;

import javax.transaction.Transactional;

import net.projetoreviver.sgp.exceptions.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.projetoreviver.sgp.exceptions.RegistroNaoEncontradoException;
import net.projetoreviver.sgp.exceptions.TransacaoNaoRealizadaException;
import net.projetoreviver.sgp.models.Cuidador;
import net.projetoreviver.sgp.repositories.CuidadorRepository;

@Service
public class CuidadorService {
    @Autowired
    private CuidadorRepository cuidadorRepository;

    @Transactional
    public void toPersist(Cuidador cuidador){
    	Optional<Cuidador> cuidadorExistente = cuidadorRepository.findByCpf(cuidador.getCpf());

		if(cuidadorExistente.isPresent() && !cuidadorExistente.get().equals(cuidador)){
			throw new NegocioException("CPF já cadastrado");
		}

		try{cuidadorRepository.save(cuidador);}
		catch (Exception ex){
			throw new TransacaoNaoRealizadaException("Erro ao salvar cuidador");
		}

    }

    public Cuidador getCuidadorById (Long id) {
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
