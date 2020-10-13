package net.projetoreviver.sgp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_cuidador")
@PrimaryKeyJoinColumn(name = "usu_id")
@Setter
@Getter
public class Cuidador extends Usuario {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "cuidador")
    private List<RegistroCuidador> registros;
}
