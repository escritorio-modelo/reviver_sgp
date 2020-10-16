package net.projetoreviver.sgp.controllers.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.projetoreviver.sgp.models.Paciente;
import net.projetoreviver.sgp.repositories.PacienteRepository;
import net.projetoreviver.sgp.services.PacienteService;
import net.projetoreviver.sgp.utils.PacienteItem;


@RestController
@RequestMapping("/api/pacientes")
public class PacienteRestController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
	private PacienteService pacienteService;

    @GetMapping("/")
    public Page<Paciente> listarAll(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
		@RequestParam(value = "pagina", required = false , defaultValue = "0")int pagina,
		@RequestParam(value = "tamanho", required = false, defaultValue = "10") int tamanho)
	{

		PageRequest pageRequest = PageRequest.of(pagina, tamanho, Sort.Direction.DESC, "nome");
		return pacienteRepository.findByNomeContainingIgnoreCase(nome, pageRequest);
    }
    

    @PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Paciente cadastrarAjax(@RequestBody @Valid Paciente paciente){
        pacienteService.toPersist(paciente);
        return paciente;
    }
    

    @GetMapping("/select")
    List<PacienteItem> selectPaciente(@RequestParam(value="query", required = false) String query){
        if(StringUtils.isEmpty(query)){
            List<Paciente> pacientes = pacienteRepository.findAll();
            return pacientes.stream().limit(5).map(this::mapToPacienteItem).collect(Collectors.toList());
        }

        List<Paciente> pacientes = pacienteRepository.findByNomeContainingIgnoreCase(query);
        return pacientes.stream().limit(5).map(this::mapToPacienteItem).collect(Collectors.toList());
    } 

    private PacienteItem mapToPacienteItem(Paciente paciente){
        return PacienteItem.builder().id(paciente.getId()).text(paciente.getNome()).build();
    }
}
