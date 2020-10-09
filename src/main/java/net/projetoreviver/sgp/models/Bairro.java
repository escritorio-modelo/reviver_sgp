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
@Table(name = "tbl_bairro")
@EqualsAndHashCode @ToString
@Setter @Getter
public class Bairro implements Serializable{

    private static final long serialVersionUID = -5236964460701247009L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bairro_id")
    private Long id;
    
    @Column(name = "bairro_nome", length = 45)
    @Length(max = 45, message = "Nome do bairro deve conter no máximo 45 caracteres.")
    @NotBlank(message = "Insira um bairro.")
    private String nome;

    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "cidade_fk")
    @Valid
    private Cidade cidade;
}
