package net.projetoreviver.sgp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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


    /**
     * @return boolean return the alzheimer
     */
    public boolean isAlzheimer() {
        return alzheimer;
    }

    /**
     * @param alzheimer the alzheimer to set
     */
    public void setAlzheimer(boolean alzheimer) {
        this.alzheimer = alzheimer;
    }

    /**
     * @return boolean return the parkinson
     */
    public boolean isParkinson() {
        return parkinson;
    }

    /**
     * @param parkinson the parkinson to set
     */
    public void setParkinson(boolean parkinson) {
        this.parkinson = parkinson;
    }

}