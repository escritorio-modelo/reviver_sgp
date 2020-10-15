package net.projetoreviver.sgp.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "tbl_registro_cuidador")
@ToString @Getter @Setter
@EqualsAndHashCode
public class RegistroCuidador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "regpac_data_registro", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Cuidador deve uma data de registro")
    private LocalDateTime dataRegistro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cuidador_id")
    private Cuidador cuidador;

    @ManyToOne
    @JoinColumn(name = "registro_paciente_id")
    private RegistroChamadaPaciente registroPaciente;

    //,private String termoDeCompromisso;

    @PrePersist
    public void created(){
        dataRegistro = LocalDateTime.now();
    }
}
