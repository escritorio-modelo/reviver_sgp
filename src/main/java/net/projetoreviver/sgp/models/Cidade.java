package net.projetoreviver.sgp.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tbl_cidade")
@EqualsAndHashCode @ToString
@Getter @Setter
public class Cidade implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid_id")
    private Long id;

    @Column(name = "cid_nome", length = 45)
    @Length(max = 45, message = "Nome da cidade deve conter no máximo 45 caracteres.")
    @NotBlank(message = "Insira uma cidade.")
    private String nome;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "estado_fk")
    @Valid
    private Estado estado;
}
