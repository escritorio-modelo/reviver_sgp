package net.projetoreviver.sgp.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_registro_chamada_paciente")
public class RegistroChamadaPaciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
    private Long id;

    @Column(name = "regpac_data_registro", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Registro de Chamada deve conter uma data")
    private Date dataRegistro;

    @ManyToOne(optional = false)
    private Chamada chamada;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToMany(mappedBy = "registroPaciente")
    private List<RegistroCuidador> cuidador;

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


    public Chamada getChamada() {
        return chamada;
    }


    public void setChamada(Chamada chamada) {
        this.chamada = chamada;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    public List<RegistroCuidador> getCuidador() {
        return cuidador;
    }


    public void setCuidador(List<RegistroCuidador> cuidador) {
        this.cuidador = cuidador;
    }

}
