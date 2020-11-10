package net.projetoreviver.sgp.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.projetoreviver.sgp.groups.ValidationGroups;

@Entity
@Table(name = "tbl_atendimento")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter @Setter
public class Atendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atend_id")
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(optional = false)
    @NotNull(message = "Atendimento deve conter uma chamada.")
    @ConvertGroup(from = Default.class, to = ValidationGroups.ChamadaId.class)
    @Valid
    private Chamada chamada;

    @ManyToOne(optional = false)
    @NotNull(message = "Atendimento deve conter uma Area.")
    @ConvertGroup(from = Default.class, to = ValidationGroups.AreaId.class)
    @Valid
    private Area area;

    @Column(name = "atend_data_hora", nullable = false)
    @NotNull(message = "Atendimento deve ter uma data e um horário")
    //@JsonFormat(pattern="yyyy-MM-dd@HH:mm")
    private LocalDateTime dataHora;

}
