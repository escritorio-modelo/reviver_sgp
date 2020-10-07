package net.projetoreviver.sgp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "tbl_registro_cuidador")
public class RegistroCuidador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "regpac_data_registro", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Cuidador deve uma data de registro")
    private Date dataRegistro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cuidador_id")
    private Cuidador cuidador;

    @ManyToOne
    @JoinColumn(name = "registro_paciente_id")
    private RegistroChamadaPaciente registroPaciente;

    //,private String termoDeCompromisso;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

 
    public Date getDataRegistro() {
        return dataRegistro;
    }


    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }


    public Cuidador getCuidador() {
        return cuidador;
    }


    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }


    public RegistroChamadaPaciente getRegistroPaciente() {
        return registroPaciente;
    }

 
    public void setRegistroPaciente(RegistroChamadaPaciente registroPaciente) {
        this.registroPaciente = registroPaciente;
    }

}
