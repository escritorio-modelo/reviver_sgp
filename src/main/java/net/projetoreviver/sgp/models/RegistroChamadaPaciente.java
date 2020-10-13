package net.projetoreviver.sgp.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_registro_chamada_paciente")
@Getter @Setter
@ToString @EqualsAndHashCode
public class RegistroChamadaPaciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
    private Long id;

    @Column(name = "regpac_data_registro", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Registro de Chamada deve conter uma data")
    private LocalDateTime dataRegistro; //LocalDateTime

    @ManyToOne(optional = false)
    private Chamada chamada;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToMany(mappedBy = "registroPaciente", cascade = CascadeType.ALL)
    private List<RegistroCuidador> cuidadoresList = new ArrayList<>();

    public void addCuidador(Cuidador cuidador){
        RegistroCuidador registroCuidador = new RegistroCuidador();
        registroCuidador.setCuidador(cuidador);
        this.getCuidadoresList().add(registroCuidador);
    }

    @PrePersist
    public void created(){
        dataRegistro = LocalDateTime.now();
    }
}
