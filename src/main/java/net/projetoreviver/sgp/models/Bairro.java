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
@Table(name = "tbl_bairro")
public class Bairro {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bairro_id")
    private Long id;
    
    @Column(name = "bairro_nome")
    private String nome;

    
    @ManyToOne
    @JoinColumn(name = "cidade_fk")
    private Cidade cidade;
}
