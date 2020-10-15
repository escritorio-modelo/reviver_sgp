package net.projetoreviver.sgp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_cuidador")
@PrimaryKeyJoinColumn(name = "usu_id")
@Setter @Getter
@ToString(callSuper = true)
public class Cuidador extends Usuario {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "cuidador")
    private List<RegistroCuidador> registros;
}
