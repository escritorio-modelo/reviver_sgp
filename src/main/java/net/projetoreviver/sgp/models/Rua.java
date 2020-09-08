package net.projetoreviver.sgp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_rua")
public class Rua {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rua_id")
    private Long id;
    
    @Column(name = "rua_nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "bairro_fk")
    private Bairro bairro;
}
