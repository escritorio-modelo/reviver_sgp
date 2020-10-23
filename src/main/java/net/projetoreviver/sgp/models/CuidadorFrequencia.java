package net.projetoreviver.sgp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_cuidador_frequencia")
public class CuidadorFrequencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cf_id")
    private Long id;

    @ManyToOne
    private Cuidador paciente;

    @ManyToOne
    private Atendimento atendimento;

    @Column(name = "cf_presente")
    private boolean presente;
}

