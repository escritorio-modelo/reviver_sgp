package net.projetoreviver.sgp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_paciente_frequencia")
public class PacienteFrequencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacf_id")
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Atendimento atendimento;


    @Column(name = "pf_presente")
    private boolean presente;
}
