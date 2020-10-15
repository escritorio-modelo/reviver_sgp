package net.projetoreviver.sgp.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_paciente")
@PrimaryKeyJoinColumn(name="usu_id")
@EqualsAndHashCode @ToString(callSuper = true)
@Setter @Getter
public class Paciente extends Usuario{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "pac_alzheimer")
    private boolean alzheimer;

    @Column(name = "pac_parkinson")
    private boolean parkinson;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "paciente")
    private List<RegistroChamadaPaciente> registroChamadaPacientes;
}