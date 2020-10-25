package net.projetoreviver.sgp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "tbl_cuidador_frequencia")
@Setter @Getter @EqualsAndHashCode @ToString
@NoArgsConstructor
public class CuidadorFrequencia {
    
    public CuidadorFrequencia(Atendimento atendimento, Cuidador cuidador){
        this.atendimento = atendimento;
        this.cuidador = cuidador;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cf_id")
    private Long id;

    @ManyToOne
    private Cuidador cuidador;

    @ManyToOne
    private Atendimento atendimento;

    @Column(name = "cf_presente")
    private boolean presente;
}

