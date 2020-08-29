package net.projetoreviver.sgp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
@PrimaryKeyJoinColumn(name="usu_id")
public class Paciente extends Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "pac_alzheimer")
    private boolean alzheimer;

    @Column(name = "pac_parkinson")
    private boolean parkinson;

}