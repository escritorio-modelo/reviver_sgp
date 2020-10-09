package net.projetoreviver.sgp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import net.projetoreviver.sgp.models.Cuidador;
import net.projetoreviver.sgp.repositories.CuidadorRepository;
import net.projetoreviver.sgp.services.CuidadorService;

@Controller
@RequestMapping("/cuidadores")
public class CuidadorController {
    
    @Autowired
    CuidadorRepository cuidadorRepository;

    @Autowired
    CuidadorService cuidadorService;


    @GetMapping("/listar")
    public ModelAndView listar() {
        return new ModelAndView();
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(Cuidador cuidador){
        return new ModelAndView();
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(@Valid Cuidador cuidador, BindingResult result){
        if(result.hasErrors()){
            return this.cadastrar(cuidador);
        }
        cuidadorService.toPersist(cuidador);
        return new ModelAndView();
    }

    @GetMapping("/{id}/alterar")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cuidador", cuidadorService.getCuidadorById(id));
        return mv;
    }
    
    @PostMapping("/alterar")
    public ModelAndView alterar(@Valid Cuidador cuidador, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView().addObject("cuidador", cuidador);
        }
        cuidadorService.toPersist(cuidador);
        return new ModelAndView();
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable("id") Long id){
        Cuidador cuidador = cuidadorService.getCuidadorById(id);
        cuidadorService.toRemove(cuidador);
        return new ModelAndView();
    }


    @GetMapping("/")
    @ResponseBody()
    public Page<Cuidador> listarAll(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
        @RequestParam(value = "pagina", required = false , defaultValue = "0")int pagina,
        @RequestParam(value = "tamanho", required = false, defaultValue = "10") int tamanho){

        PageRequest pageRequest = PageRequest.of(pagina, tamanho, Sort.Direction.DESC, "nome");
		return cuidadorRepository.findByNomeContainingIgnoreCase(nome, pageRequest);
    }

    @PostMapping("/api/cadastrar")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void cadastrarAjax(@RequestBody @Valid Cuidador cuidador){
        cuidadorService.toPersist(cuidador);
    }
}
