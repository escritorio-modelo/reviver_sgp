package net.projetoreviver.sgp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.projetoreviver.sgp.groups.ValidationGroups;

@Entity
@Table(name = "tbl_area")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter @Getter
public class Area implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(groups = ValidationGroups.AreaId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="area_id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "area_desc")
    @NotBlank(message = "Insira uma descrição")
    private String descricao;
}
