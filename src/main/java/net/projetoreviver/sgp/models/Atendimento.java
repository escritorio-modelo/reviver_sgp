package net.projetoreviver.sgp.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_atendimento")
@EqualsAndHashCode
@ToString
@Getter @Setter
public class Atendimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atend_id")
    private Long id;

    @ManyToOne(optional = false)
    private Chamada chamada;

    @ManyToOne(optional = false)
    private Area area;

    @Column(name = "atend_data_hora", nullable = false)
    private LocalDateTime dataHora;

}
