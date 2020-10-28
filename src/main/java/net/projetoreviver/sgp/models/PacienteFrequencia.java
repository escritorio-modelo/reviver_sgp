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
@Table(name = "tbl_paciente_frequencia")
@Setter @Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
public class PacienteFrequencia {
    

    public PacienteFrequencia(Atendimento atendimento, Paciente paciente){
        this.atendimento = atendimento;
        this.paciente = paciente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacf_id")
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Atendimento atendimento;

    @Column(name = "pf_presente")
    private boolean presente;
}
