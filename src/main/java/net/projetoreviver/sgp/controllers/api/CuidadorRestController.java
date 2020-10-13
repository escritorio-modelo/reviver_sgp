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
import org.springframework.web.bind.annotation.*;

import net.projetoreviver.sgp.models.Cuidador;
import net.projetoreviver.sgp.repositories.CuidadorRepository;
import net.projetoreviver.sgp.services.CuidadorService;
import net.projetoreviver.sgp.utils.PacienteItem;

@RestController
@RequestMapping("/api/cuidadores")
public class CuidadorRestController {

    @Autowired
    CuidadorRepository cuidadorRepository;

    @Autowired
    CuidadorService cuidadorService;

    @GetMapping("/")
    public Page<Cuidador> listarAll(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
        @RequestParam(value = "pagina", required = false , defaultValue = "0")int pagina,
        @RequestParam(value = "tamanho", required = false, defaultValue = "10") int tamanho){

        PageRequest pageRequest = PageRequest.of(pagina, tamanho, Sort.Direction.DESC, "nome");
		return cuidadorRepository.findByNomeContainingIgnoreCase(nome, pageRequest);
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cuidador cadastrarAjax(@RequestBody @Valid Cuidador cuidador) {
        cuidadorService.toPersist(cuidador);
        return cuidador;
    }


    @GetMapping("/select")
    List<PacienteItem> selectCuidador(@RequestParam(value="query", required = false) String query){
        if(StringUtils.isEmpty(query)){
            List<Cuidador> cuidadores = cuidadorRepository.findAll();
            return cuidadores.stream().limit(5).map(this::mapToPacienteItem).collect(Collectors.toList());
        }

        List<Cuidador> cuidadores = cuidadorRepository.findByNomeContainingIgnoreCase(query);
        return cuidadores.stream().limit(5).map(this::mapToPacienteItem).collect(Collectors.toList());
    } 

    private PacienteItem mapToPacienteItem(Cuidador cuidador){
        return PacienteItem.builder().id(cuidador.getId()).text(cuidador.getNome()).build();
    }
}
