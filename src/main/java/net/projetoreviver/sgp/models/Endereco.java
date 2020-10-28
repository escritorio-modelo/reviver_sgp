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
import javax.validation.constraints.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="tbl_endereco")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString @Getter @Setter
public class Endereco implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "end_id")
    @EqualsAndHashCode.Include
    private Long id;
    
    @Column(name = "end_numero", length = 10)
    @NotBlank(message = "Número é obrigatório.")
    private String numero;

    @Column(name = "end_cep", length = 8)
    @Length(min = 8, max = 8, message = "CEP deve conter 8 caracteres.")
    @NotBlank(message = "Insira um CEP.")
    @Pattern(regexp = "\\d{8}", message = "CEP inválido.")
    private String cep;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "rua_fk")
    @Valid
    private Rua rua;
    
    @Column(name = "end_complemento", length = 75)
    @Length(max = 75, message = "Complemento deve conter no máximo 75 caracteres.")
    private String complemento;


}