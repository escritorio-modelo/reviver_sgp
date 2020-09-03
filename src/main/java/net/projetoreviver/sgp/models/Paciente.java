package net.projetoreviver.sgp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_paciente")
@PrimaryKeyJoinColumn(name="usu_id")
public class Paciente extends Usuario{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "pac_alzheimer")
    private boolean alzheimer;

    @Column(name = "pac_parkinson")
    private boolean parkinson;

    @OneToMany(mappedBy = "paciente")
    private List<RegistroChamadaPaciente> registroChamadaPacientes;


    public boolean isAlzheimer() {
        return alzheimer;
    }


    public void setAlzheimer(boolean alzheimer) {
        this.alzheimer = alzheimer;
    }


    public boolean isParkinson() {
        return parkinson;
    }


    public void setParkinson(boolean parkinson) {
        this.parkinson = parkinson;
    }


    public List<RegistroChamadaPaciente> getRegistroChamadaPacientes() {
        return registroChamadaPacientes;
    }

    
    public void setRegistroChamadaPacientes(List<RegistroChamadaPaciente> registroChamadaPacientes) {
        this.registroChamadaPacientes = registroChamadaPacientes;
    }

}