package net.projetoreviver.sgp.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cuidador")
@PrimaryKeyJoinColumn(name = "usu_id")
public class Cuidador extends Usuario{
    private static final long serialVersionUID = 1L;
    //Vazio
}
