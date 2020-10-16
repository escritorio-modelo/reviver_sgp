package net.projetoreviver.sgp.handlers;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(Include.NON_NULL)
public class Problema {
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
    
    @Getter @Setter
    public static class Campo{
        private String nome;
        private String mensagem;
        public Campo(String nome, String mensagem){
            this.nome = nome;
            this.mensagem = mensagem;
        }
    }
}
