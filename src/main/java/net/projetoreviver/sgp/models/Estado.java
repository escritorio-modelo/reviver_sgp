package net.projetoreviver.sgp.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tbl_estado")
@EqualsAndHashCode @ToString
@Setter @Getter
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
    private Long id;

    @Column(name = "est_nome", length = 20)
    @Length(max = 20, message = "Nome do estado deve conter no máximo 20 caracteres.")
    @NotBlank(message = "Insira um estado.")
    private String nome;

}
