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
@Table(name="tbl_endereco")
public class Endereco {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "end_id")
    private Long id;
    
    @Column(name = "end_numero")
    private String numero;

    @Column(name = "end_cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "rua_fk")
    private Rua rua;
    
    @Column(name = "end_complemento")
    private String complemento;
}