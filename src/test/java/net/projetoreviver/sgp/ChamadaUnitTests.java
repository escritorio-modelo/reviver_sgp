package net.projetoreviver.sgp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import net.projetoreviver.sgp.models.Chamada;
import net.projetoreviver.sgp.models.RegistroChamadaPaciente;
import net.projetoreviver.sgp.repositories.ChamadaRepository;
import net.projetoreviver.sgp.services.ChamadaService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.AdditionalAnswers.returnsFirstArg;


public class ChamadaUnitTests {

    private ChamadaRepository chamadaRepository =  Mockito.mock(ChamadaRepository.class);
    private ChamadaService chamadaService;
    private Chamada chamada;

    @BeforeEach
    void initUseCase() {
        chamadaService = new ChamadaService(chamadaRepository);
        Long id = Long.valueOf(1);
        String descricao = "Chamada de teste";
        LocalDate dataDeInicio = LocalDate.now();
        LocalDate dataDeTermino = dataDeInicio.plusDays(1);
        List<RegistroChamadaPaciente> registroChamadaPacientes =  new ArrayList<>();
        chamada = new Chamada(id, descricao, dataDeInicio, dataDeTermino, registroChamadaPacientes);
    }
    @Test
    void savedChamadaHasDescricao(){
        when(chamadaRepository.save(any(Chamada.class))).then(returnsFirstArg());
        Chamada savedChamada = chamadaService.toPersist(chamada);
        assertThat(savedChamada.getDescricao()).isNotNull();
    }   

    @Test
    void savedChamadaHasDataDeInicio(){
        when(chamadaRepository.save(any(Chamada.class))).then(returnsFirstArg());
        Chamada savedChamada = chamadaService.toPersist(chamada);
        assertThat(savedChamada.getDataInicio()).isNotNull();
    }

    @Test
    void savedChamadaHasDataDeTermino(){
        when(chamadaRepository.save(any(Chamada.class))).then(returnsFirstArg());
        Chamada savedChamada = chamadaService.toPersist(chamada);
        assertThat(savedChamada.getDataTermino()).isNotNull();
    }
}
