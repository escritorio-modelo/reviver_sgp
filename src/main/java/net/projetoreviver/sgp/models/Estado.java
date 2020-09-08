package net.projetoreviver.sgp.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_estado")
public class Estado {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
    private Long id;

    @Column(name = "est_nome")
    private String nome;
}
